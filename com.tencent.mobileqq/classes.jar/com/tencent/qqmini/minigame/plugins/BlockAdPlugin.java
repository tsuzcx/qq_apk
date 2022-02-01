package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.minigame.model.BlockAdInfo;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class BlockAdPlugin
  extends BaseJsPlugin
{
  private static final HashMap<Integer, String> AD_ERROR_MSG = MiniSDKConst.AdConst.CODE_MSG_MAP;
  public static final String API_AD_CREATE_BLOCK_AD = "createBlockAd";
  public static final String API_AD_OPERATE_BLOCK_AD = "operateBlockAd";
  public static final String API_AD_UPDATE_BLOCK_AD = "updateBlockAdSize";
  public static final String EVENT_BLOCK_AD_SHOW_DONE = "onBlockAdShowDone";
  public static final String EVENT_BLOCK_AD_STATE_CHANGE = "onBlockAdStateChange";
  private static final String ORIENTATION_LANDSCAPE = "landscape";
  private static final String ORIENTATION_VERTICAL = "vertical";
  private static final String TAG = "BlockAdPlugin";
  private HashMap<Integer, BlockAdInfo> mBlockAdInfoMap = new HashMap();
  private HashMap<Integer, AdProxy.AbsBlockAdView> mBlockAdViewMap = new HashMap();
  private float mGameDensity = -1.0F;
  
  private void blockErrorStateCallbackDelay(RequestEvent paramRequestEvent, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.8(this, paramInt2, paramString, paramInt1, paramRequestEvent), paramInt3);
  }
  
  private void callbackUpdateSuccess(RequestEvent paramRequestEvent, int paramInt, BlockAdInfo paramBlockAdInfo)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.6(this, paramInt, paramBlockAdInfo, paramRequestEvent), 0L);
  }
  
  private void createAdBlockView(BlockAdInfo paramBlockAdInfo, String paramString, RequestEvent paramRequestEvent, Bundle paramBundle)
  {
    if (((AdProxy)ProxyManager.get(AdProxy.class) == null) || (paramBlockAdInfo == null)) {
      QMLog.i("BlockAdPlugin", "start create, null");
    }
    do
    {
      return;
      paramString = ((AdProxy)ProxyManager.get(AdProxy.class)).createBlockAdView(this.mMiniAppContext.getAttachedActivity(), paramString, paramBlockAdInfo.getAdUnitId(), paramBlockAdInfo.getLeft(), paramBlockAdInfo.getTop(), paramBlockAdInfo.getSize(), paramBlockAdInfo.getOri(), paramBlockAdInfo.getCompId(), new BlockAdPlugin.2(this, paramRequestEvent, paramBlockAdInfo), paramBundle);
    } while (paramString == null);
    try
    {
      paramString.loadAD();
      this.mBlockAdViewMap.put(Integer.valueOf(paramBlockAdInfo.getCompId()), paramString);
      this.mBlockAdInfoMap.put(Integer.valueOf(paramBlockAdInfo.getCompId()), paramBlockAdInfo);
      return;
    }
    catch (Throwable paramBlockAdInfo)
    {
      QMLog.i("BlockAdPlugin", "loadAd error", paramBlockAdInfo);
    }
  }
  
  private void destroyBlockAd(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.mBlockAdViewMap == null) || (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) == null) || (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
          return;
        }
        if ((this.mBlockAdInfoMap == null) || (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
          continue;
        }
        localAbsBlockAdView = (AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt));
      }
      finally {}
      AdProxy.AbsBlockAdView localAbsBlockAdView;
      ViewGroup localViewGroup = (ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView();
      if (localViewGroup == null)
      {
        QMLog.e("BlockAdPlugin", "showBlockAd, root view is null");
      }
      else
      {
        localViewGroup.removeView(localAbsBlockAdView.getView());
        this.mBlockAdInfoMap.remove(Integer.valueOf(paramInt));
        this.mBlockAdViewMap.remove(Integer.valueOf(paramInt));
        localAbsBlockAdView.clearBlockAdAnimation(localAbsBlockAdView);
      }
    }
  }
  
  private int gameDpTopx(float paramFloat)
  {
    return Math.round(this.mGameDensity * paramFloat);
  }
  
  private boolean handleBlockAdType(int paramInt1, int paramInt2, BlockAdInfo paramBlockAdInfo, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      return paramBoolean;
    case 1: 
      if (paramBlockAdInfo.getLeft() != paramInt2) {}
      for (bool = true;; bool = false)
      {
        paramBoolean = bool;
        if (!bool) {
          break;
        }
        paramBlockAdInfo.setLeft(paramInt2);
        return bool;
      }
    }
    if (paramBlockAdInfo.getTop() != paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      paramBoolean = bool;
      if (!bool) {
        break;
      }
      paramBlockAdInfo.setTop(paramInt2);
      return bool;
    }
  }
  
  private void informJs(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    paramRequestEvent.jsService.evaluateSubscribeJS(paramString, paramJSONObject.toString(), 0);
  }
  
  private BlockAdInfo parseBlockAdInfoFromJson(String paramString)
  {
    int n = -1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      for (;;)
      {
        Object localObject2;
        int m;
        int k;
        int j;
        int i;
        label103:
        Object localObject1;
        try
        {
          localObject2 = new JSONObject(paramString);
          str1 = ((JSONObject)localObject2).getString("adUnitId");
        }
        catch (Exception localException1)
        {
          String str1;
          String str2;
          boolean bool;
          int i1;
          j = -1;
          k = -1;
          i = -1;
          localObject2 = "";
          m = -1;
          QMLog.i("BlockAdPlugin", "parseBannerAdPosInfoFromJson error " + paramString, localException1);
          localObject1 = localObject2;
          continue;
        }
        try
        {
          m = ((JSONObject)localObject2).getJSONObject("style").getInt("left");
        }
        catch (Exception localException2)
        {
          j = -1;
          k = -1;
          i = -1;
          m = -1;
          localObject2 = localObject1;
          localObject1 = localException2;
          continue;
        }
        try
        {
          k = ((JSONObject)localObject2).getJSONObject("style").getInt("top");
        }
        catch (Exception localException3)
        {
          j = -1;
          i = -1;
          k = -1;
          localObject2 = localObject1;
          localObject1 = localException3;
          continue;
        }
        try
        {
          j = ((JSONObject)localObject2).optInt("size", 1);
        }
        catch (Exception localException4)
        {
          i = -1;
          j = -1;
          localObject2 = localObject1;
          localObject1 = localException4;
          continue;
        }
        for (;;)
        {
          try
          {
            str2 = ((JSONObject)localObject2).optString("orientation", "landscape");
            bool = "landscape".equals(str2);
            if (bool) {
              i = 90;
            }
          }
          catch (Exception localException5)
          {
            i = -1;
            localObject2 = localObject1;
            localObject1 = localException5;
            break label198;
            break label103;
          }
          try
          {
            i1 = ((JSONObject)localObject2).getInt("compId");
            n = i1;
            if ((TextUtils.isEmpty(str1)) || (m < 0) || (k < 0) || (n < 0) || (i < 0)) {
              break;
            }
            return new BlockAdInfo(str1, m, k, j, i, n);
          }
          catch (Exception localException6)
          {
            localObject2 = localObject1;
            localObject1 = localException6;
            break label198;
            i = -1;
          }
        }
      }
      bool = "vertical".equals(str2);
      if (!bool) {
        break label320;
      }
      i = 0;
    }
  }
  
  private void reportBlockAd(String paramString)
  {
    QMLog.i("BlockAdPlugin", "reportBlockAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetworkIOThreadPool(new BlockAdPlugin.7(this, paramString));
  }
  
  private boolean showBlockAd(int paramInt)
  {
    for (;;)
    {
      BlockAdInfo localBlockAdInfo;
      View localView;
      ViewGroup localViewGroup;
      try
      {
        if ((this.mBlockAdViewMap == null) || (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) == null) || (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
          bool = false;
          return bool;
        }
        if ((this.mBlockAdInfoMap == null) || (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
          bool = false;
          continue;
        }
        Object localObject1 = (AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt));
        localBlockAdInfo = (BlockAdInfo)this.mBlockAdInfoMap.get(Integer.valueOf(paramInt));
        localView = ((AdProxy.AbsBlockAdView)localObject1).getView();
        if (localView == null)
        {
          bool = false;
          continue;
        }
        localView.setVisibility(0);
        if (localView.getParent() != null)
        {
          bool = true;
          continue;
        }
        localViewGroup = (ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView();
        if ((localViewGroup instanceof FrameLayout))
        {
          localObject3 = new FrameLayout.LayoutParams(-2, -2);
          ((FrameLayout.LayoutParams)localObject3).leftMargin = gameDpTopx(localBlockAdInfo.getLeft());
          ((FrameLayout.LayoutParams)localObject3).topMargin = gameDpTopx(localBlockAdInfo.getTop());
          localViewGroup.addView(localView, (ViewGroup.LayoutParams)localObject3);
          ((AdProxy.AbsBlockAdView)localObject1).showBlockAdAnimation((AdProxy.AbsBlockAdView)localObject1);
          localObject1 = ((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getReportUrl();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
            break label367;
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label367;
          }
          reportBlockAd((String)((Iterator)localObject1).next());
          continue;
        }
        if (!(localViewGroup instanceof RelativeLayout)) {
          continue;
        }
      }
      finally {}
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = gameDpTopx(localBlockAdInfo.getLeft());
      ((RelativeLayout.LayoutParams)localObject3).topMargin = gameDpTopx(localBlockAdInfo.getTop());
      localViewGroup.addView(localView, (ViewGroup.LayoutParams)localObject3);
      continue;
      label367:
      boolean bool = true;
    }
  }
  
  private boolean updateBlockAd(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.mBlockAdViewMap == null) || (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) == null) || (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
          bool = false;
          return bool;
        }
        if ((this.mBlockAdInfoMap == null) || (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) == null))
        {
          QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
          bool = false;
          continue;
        }
        if ((ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView() == null)
        {
          QMLog.e("BlockAdPlugin", "showBlockAd, root view is null");
          bool = false;
          continue;
        }
        BlockAdInfo localBlockAdInfo = (BlockAdInfo)this.mBlockAdInfoMap.get(Integer.valueOf(paramInt));
        if (localBlockAdInfo == null)
        {
          bool = false;
          continue;
        }
        Object localObject2 = (AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt));
        View localView = ((AdProxy.AbsBlockAdView)localObject2).updateAdInfo(localBlockAdInfo.getLeft(), localBlockAdInfo.getTop());
        if (localView == null)
        {
          bool = false;
          continue;
        }
        ((AdProxy.AbsBlockAdView)localObject2).showBlockAdAnimation((AdProxy.AbsBlockAdView)localObject2);
        if ((localView.getLayoutParams() instanceof FrameLayout.LayoutParams))
        {
          localObject2 = (FrameLayout.LayoutParams)localView.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject2).leftMargin = gameDpTopx(localBlockAdInfo.getLeft());
          ((FrameLayout.LayoutParams)localObject2).topMargin = gameDpTopx(localBlockAdInfo.getTop());
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        else if ((localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
        {
          localObject2 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = gameDpTopx(localBlockAdInfo.getLeft());
          ((RelativeLayout.LayoutParams)localObject2).topMargin = gameDpTopx(localBlockAdInfo.getTop());
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  @JsEvent({"createBlockAd"})
  public String createBlockAd(RequestEvent paramRequestEvent)
  {
    QMLog.i("BlockAdPlugin", "receive createBlockAd event");
    if (paramRequestEvent == null)
    {
      QMLog.i("BlockAdPlugin", "handle createBlockAd event, req == null");
      return "";
    }
    int i = -1;
    try
    {
      int j = new JSONObject(paramRequestEvent.jsonParams).getInt("compId");
      i = j;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.i("BlockAdPlugin", "handle createBlockAd,", localJSONException);
      }
      localObject3 = this.mMiniAppInfo;
      if (localObject3 == null) {
        break label421;
      }
    }
    BlockAdInfo localBlockAdInfo = parseBlockAdInfoFromJson(paramRequestEvent.jsonParams);
    if (localBlockAdInfo == null)
    {
      blockErrorStateCallbackDelay(paramRequestEvent, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), i, 300);
      return "";
    }
    Object localObject3;
    String str1;
    label165:
    String str2;
    Object localObject2;
    if (((MiniAppInfo)localObject3).launchParam != null) {
      if (((MiniAppInfo)localObject3).launchParam.entryPath != null)
      {
        localObject1 = ((MiniAppInfo)localObject3).launchParam.entryPath;
        if (((MiniAppInfo)localObject3).launchParam == null) {
          break label400;
        }
        str1 = ((MiniAppInfo)localObject3).launchParam.reportData;
        str2 = String.valueOf(((MiniAppInfo)localObject3).launchParam.scene);
        localObject2 = localObject1;
      }
    }
    for (Object localObject1 = str2;; localObject1 = "")
    {
      label206:
      Object localObject4;
      String str3;
      Bundle localBundle;
      if ((localObject3 != null) && (((MiniAppInfo)localObject3).via != null))
      {
        str2 = ((MiniAppInfo)localObject3).via;
        localObject3 = this.mApkgInfo.appId;
        i = 1;
        localObject4 = this.mMiniAppContext.getAttachedActivity();
        if (localObject4 != null)
        {
          i = MiniAppEnv.g().getContext().getResources().getConfiguration().orientation;
          initActivitySize((Activity)localObject4);
        }
        str3 = LoginManager.getInstance().getAccount();
        localObject4 = AdUtil.getSpAdGdtCookie(13);
        localBundle = new Bundle();
        localBundle.putString(AdProxy.KEY_ACCOUNT, str3);
        localBundle.putInt(AdProxy.KEY_AD_TYPE, 13);
        str3 = AdProxy.KEY_ORIENTATION;
        if (i != 2) {
          break label416;
        }
      }
      label400:
      label416:
      for (i = 90;; i = 0)
      {
        localBundle.putInt(str3, i);
        localBundle.putString(AdProxy.KEY_GDT_COOKIE, (String)localObject4);
        localBundle.putString(AdProxy.KEY_ENTRY_PATH, (String)localObject2);
        localBundle.putString(AdProxy.KEY_REPORT_DATA, str1);
        localBundle.putString(AdProxy.KEY_REFER, (String)localObject1);
        localBundle.putString(AdProxy.KEY_VIA, str2);
        AppBrandTask.runTaskOnUiThread(new BlockAdPlugin.1(this, localBlockAdInfo, (String)localObject3, paramRequestEvent, localBundle));
        return "";
        localObject1 = "";
        break;
        str1 = "";
        break label165;
        str2 = "";
        break label206;
      }
      label421:
      str1 = "";
      localObject2 = "";
    }
  }
  
  /* Error */
  public boolean hideBlockAd(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdViewMap	Ljava/util/HashMap;
    //   6: ifnull +37 -> 43
    //   9: aload_0
    //   10: getfield 57	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdViewMap	Ljava/util/HashMap;
    //   13: iload_1
    //   14: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokevirtual 198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: ifnull +23 -> 43
    //   23: aload_0
    //   24: getfield 57	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdViewMap	Ljava/util/HashMap;
    //   27: iload_1
    //   28: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: invokevirtual 198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast 177	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView
    //   37: invokevirtual 202	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView:getView	()Landroid/view/View;
    //   40: ifnonnull +16 -> 56
    //   43: ldc 33
    //   45: ldc 204
    //   47: invokestatic 207	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: iconst_0
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: aload_0
    //   57: getfield 59	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdInfoMap	Ljava/util/HashMap;
    //   60: ifnull +17 -> 77
    //   63: aload_0
    //   64: getfield 59	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdInfoMap	Ljava/util/HashMap;
    //   67: iload_1
    //   68: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: ifnonnull +15 -> 89
    //   77: ldc 33
    //   79: ldc 209
    //   81: invokestatic 207	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: iconst_0
    //   85: istore_2
    //   86: goto -34 -> 52
    //   89: aload_0
    //   90: getfield 57	com/tencent/qqmini/minigame/plugins/BlockAdPlugin:mBlockAdViewMap	Ljava/util/HashMap;
    //   93: iload_1
    //   94: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokevirtual 198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 177	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView
    //   103: astore_3
    //   104: aload_3
    //   105: invokevirtual 202	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView:getView	()Landroid/view/View;
    //   108: astore 4
    //   110: aload 4
    //   112: ifnonnull +8 -> 120
    //   115: iconst_0
    //   116: istore_2
    //   117: goto -65 -> 52
    //   120: aload 4
    //   122: bipush 8
    //   124: invokevirtual 360	android/view/View:setVisibility	(I)V
    //   127: aload_3
    //   128: aload_3
    //   129: invokevirtual 235	com/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView:clearBlockAdAnimation	(Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$AbsBlockAdView;)V
    //   132: iconst_1
    //   133: istore_2
    //   134: goto -82 -> 52
    //   137: astore_3
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_3
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	BlockAdPlugin
    //   0	142	1	paramInt	int
    //   51	83	2	bool	boolean
    //   103	26	3	localAbsBlockAdView	AdProxy.AbsBlockAdView
    //   137	4	3	localObject	Object
    //   108	13	4	localView	View
    // Exception table:
    //   from	to	target	type
    //   2	43	137	finally
    //   43	50	137	finally
    //   56	77	137	finally
    //   77	84	137	finally
    //   89	110	137	finally
    //   120	132	137	finally
  }
  
  public void initActivitySize(Activity paramActivity)
  {
    if (this.mGameDensity > 0.0F) {}
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
      if (Build.VERSION.SDK_INT >= 17)
      {
        localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      }
      this.mGameDensity = localDisplayMetrics.density;
      QMLog.i("BlockAdPlugin", "density = " + localDisplayMetrics.density + ", ViewUtils.density = " + ViewUtils.getDensity());
    } while (this.mGameDensity != -1.0F);
    this.mGameDensity = ViewUtils.getDensity();
  }
  
  @JsEvent({"operateBlockAd"})
  public String operateBlockAd(RequestEvent paramRequestEvent)
  {
    QMLog.i("BlockAdPlugin", "receive operateBlockAd event");
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      str = localJSONObject.getString("type");
      i = localJSONObject.getInt("compId");
      QMLog.i("BlockAdPlugin", "handle operateBlockAd type = " + str);
      if ("show".equals(str)) {
        AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.3(this, i, paramRequestEvent), 300L);
      }
      for (;;)
      {
        return "";
        if (!"hide".equals(str)) {
          break;
        }
        AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.4(this, i), 300L);
      }
    }
    catch (JSONException paramRequestEvent)
    {
      for (;;)
      {
        String str;
        int i;
        QMLog.i("BlockAdPlugin", "handle operateBlockAd parse json error", paramRequestEvent);
        continue;
        if ("destroy".equals(str)) {
          AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.5(this, i), 300L);
        } else {
          QMLog.i("BlockAdPlugin", "handle operateBlockAd not define type = " + str);
        }
      }
    }
  }
  
  @JsEvent({"updateBlockAdSize"})
  public String updateBlockAdSize(RequestEvent paramRequestEvent)
  {
    QMLog.i("BlockAdPlugin", "receive updateBlockAdSize event");
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramRequestEvent.jsonParams);
        k = ((JSONObject)localObject).getInt("compId");
        if (!((JSONObject)localObject).has("left")) {
          continue;
        }
        i = ((JSONObject)localObject).getInt("left");
        j = 1;
      }
      catch (JSONException paramRequestEvent)
      {
        Object localObject;
        int k;
        QMLog.i("BlockAdPlugin", "handle updateBlockAdSize parse json error", paramRequestEvent);
        continue;
        int i = -1;
        int j = -1;
        continue;
      }
      if (j == -1) {
        continue;
      }
      localObject = (BlockAdInfo)this.mBlockAdInfoMap.get(Integer.valueOf(k));
      if (localObject == null) {
        continue;
      }
      if (handleBlockAdType(j, i, (BlockAdInfo)localObject, true)) {
        continue;
      }
      QMLog.e("BlockAdPlugin", "updateBlockAd no need to resize");
      return "";
      if (!((JSONObject)localObject).has("top")) {
        continue;
      }
      i = ((JSONObject)localObject).getInt("top");
      j = 2;
    }
    callbackUpdateSuccess(paramRequestEvent, k, (BlockAdInfo)localObject);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin
 * JD-Core Version:    0.7.0.1
 */