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
    if (((AdProxy)ProxyManager.get(AdProxy.class) != null) && (paramBlockAdInfo != null))
    {
      paramString = ((AdProxy)ProxyManager.get(AdProxy.class)).createBlockAdView(this.mMiniAppContext.getAttachedActivity(), paramString, paramBlockAdInfo.getAdUnitId(), paramBlockAdInfo.getLeft(), paramBlockAdInfo.getTop(), paramBlockAdInfo.getSize(), paramBlockAdInfo.getOri(), paramBlockAdInfo.getCompId(), new BlockAdPlugin.2(this, paramRequestEvent, paramBlockAdInfo), paramBundle);
      if (paramString != null) {
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
      return;
    }
    QMLog.i("BlockAdPlugin", "start create, null");
  }
  
  private void destroyBlockAd(int paramInt)
  {
    try
    {
      if ((this.mBlockAdViewMap != null) && (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) != null) && (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() != null))
      {
        if ((this.mBlockAdInfoMap != null) && (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) != null))
        {
          AdProxy.AbsBlockAdView localAbsBlockAdView = (AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt));
          ViewGroup localViewGroup = (ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView();
          if (localViewGroup == null)
          {
            QMLog.e("BlockAdPlugin", "showBlockAd, root view is null");
            return;
          }
          localViewGroup.removeView(localAbsBlockAdView.getView());
          this.mBlockAdInfoMap.remove(Integer.valueOf(paramInt));
          this.mBlockAdViewMap.remove(Integer.valueOf(paramInt));
          localAbsBlockAdView.clearBlockAdAnimation(localAbsBlockAdView);
          return;
        }
        QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
        return;
      }
      QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
      return;
    }
    finally {}
  }
  
  private int gameDpTopx(float paramFloat)
  {
    return Math.round(paramFloat * this.mGameDensity);
  }
  
  private boolean handleBlockAdType(int paramInt1, int paramInt2, BlockAdInfo paramBlockAdInfo, boolean paramBoolean)
  {
    boolean bool;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return paramBoolean;
      }
      if (paramBlockAdInfo.getTop() != paramInt2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      bool = paramBoolean;
      if (paramBoolean)
      {
        paramBlockAdInfo.setTop(paramInt2);
        return paramBoolean;
      }
    }
    else
    {
      if (paramBlockAdInfo.getLeft() != paramInt2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      bool = paramBoolean;
      if (paramBoolean)
      {
        paramBlockAdInfo.setLeft(paramInt2);
        bool = paramBoolean;
      }
    }
    return bool;
  }
  
  private void informJs(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    paramRequestEvent.jsService.evaluateSubscribeJS(paramString, paramJSONObject.toString(), 0);
  }
  
  /* Error */
  private BlockAdInfo parseBlockAdInfoFromJson(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: ldc_w 279
    //   12: astore 9
    //   14: aload 9
    //   16: astore 10
    //   18: new 258	org/json/JSONObject
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 282	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   26: astore 11
    //   28: aload 9
    //   30: astore 10
    //   32: aload 11
    //   34: ldc_w 284
    //   37: invokevirtual 288	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 9
    //   42: aload 9
    //   44: astore 10
    //   46: aload 11
    //   48: ldc_w 290
    //   51: invokevirtual 294	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   54: ldc_w 296
    //   57: invokevirtual 300	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: istore_3
    //   61: aload 11
    //   63: ldc_w 290
    //   66: invokevirtual 294	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   69: ldc_w 302
    //   72: invokevirtual 300	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   75: istore 4
    //   77: aload 11
    //   79: ldc_w 304
    //   82: iconst_1
    //   83: invokevirtual 308	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   86: istore 5
    //   88: aload 11
    //   90: ldc_w 310
    //   93: ldc 27
    //   95: invokevirtual 314	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 10
    //   100: ldc 27
    //   102: aload 10
    //   104: invokevirtual 320	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +9 -> 116
    //   110: bipush 90
    //   112: istore_2
    //   113: goto +24 -> 137
    //   116: ldc 30
    //   118: aload 10
    //   120: invokevirtual 320	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: istore 8
    //   125: iload 8
    //   127: ifeq +8 -> 135
    //   130: iconst_0
    //   131: istore_2
    //   132: goto +5 -> 137
    //   135: iconst_m1
    //   136: istore_2
    //   137: aload 11
    //   139: ldc_w 322
    //   142: invokevirtual 300	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   145: istore 7
    //   147: iload 4
    //   149: istore 6
    //   151: iload 7
    //   153: istore 4
    //   155: iload_2
    //   156: istore 7
    //   158: iload 5
    //   160: istore_2
    //   161: iload 7
    //   163: istore 5
    //   165: iload 4
    //   167: istore 7
    //   169: goto +100 -> 269
    //   172: astore 10
    //   174: goto +41 -> 215
    //   177: astore 10
    //   179: goto +34 -> 213
    //   182: astore 10
    //   184: goto +26 -> 210
    //   187: astore 10
    //   189: iconst_m1
    //   190: istore 4
    //   192: goto +18 -> 210
    //   195: astore 11
    //   197: iconst_m1
    //   198: istore 4
    //   200: iconst_m1
    //   201: istore_3
    //   202: aload 10
    //   204: astore 9
    //   206: aload 11
    //   208: astore 10
    //   210: iconst_m1
    //   211: istore 5
    //   213: iconst_m1
    //   214: istore_2
    //   215: new 324	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   222: astore 11
    //   224: aload 11
    //   226: ldc_w 327
    //   229: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 11
    //   235: aload_1
    //   236: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc 33
    //   242: aload 11
    //   244: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: aload 10
    //   249: invokestatic 190	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: iload 5
    //   254: istore 6
    //   256: iconst_m1
    //   257: istore 7
    //   259: iload_2
    //   260: istore 5
    //   262: iload 6
    //   264: istore_2
    //   265: iload 4
    //   267: istore 6
    //   269: aload 9
    //   271: invokestatic 277	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   274: ifne +42 -> 316
    //   277: iload_3
    //   278: iflt +38 -> 316
    //   281: iload 6
    //   283: iflt +33 -> 316
    //   286: iload 7
    //   288: iflt +28 -> 316
    //   291: iload 5
    //   293: ifge +5 -> 298
    //   296: aconst_null
    //   297: areturn
    //   298: new 138	com/tencent/qqmini/minigame/model/BlockAdInfo
    //   301: dup
    //   302: aload 9
    //   304: iload_3
    //   305: iload 6
    //   307: iload_2
    //   308: iload 5
    //   310: iload 7
    //   312: invokespecial 335	com/tencent/qqmini/minigame/model/BlockAdInfo:<init>	(Ljava/lang/String;IIIII)V
    //   315: areturn
    //   316: aconst_null
    //   317: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	BlockAdPlugin
    //   0	318	1	paramString	String
    //   112	196	2	i	int
    //   60	245	3	j	int
    //   75	191	4	k	int
    //   86	223	5	m	int
    //   149	157	6	n	int
    //   145	166	7	i1	int
    //   123	3	8	bool	boolean
    //   12	291	9	localObject1	Object
    //   16	103	10	localObject2	Object
    //   172	1	10	localException1	java.lang.Exception
    //   177	1	10	localException2	java.lang.Exception
    //   182	1	10	localException3	java.lang.Exception
    //   187	16	10	localException4	java.lang.Exception
    //   208	40	10	localObject3	Object
    //   26	112	11	localJSONObject	JSONObject
    //   195	12	11	localException5	java.lang.Exception
    //   222	21	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   137	147	172	java/lang/Exception
    //   88	110	177	java/lang/Exception
    //   116	125	177	java/lang/Exception
    //   77	88	182	java/lang/Exception
    //   61	77	187	java/lang/Exception
    //   18	28	195	java/lang/Exception
    //   32	42	195	java/lang/Exception
    //   46	61	195	java/lang/Exception
  }
  
  private void reportBlockAd(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportBlockAd reportUrl = ");
    localStringBuilder.append(paramString);
    QMLog.i("BlockAdPlugin", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      if (!URLUtil.isNetworkUrl(paramString)) {
        return;
      }
      ThreadManager.executeOnNetworkIOThreadPool(new BlockAdPlugin.7(this, paramString));
    }
  }
  
  private boolean showBlockAd(int paramInt)
  {
    try
    {
      if ((this.mBlockAdViewMap != null) && (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) != null) && (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() != null))
      {
        if ((this.mBlockAdInfoMap != null) && (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) != null))
        {
          Object localObject1 = (AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt));
          BlockAdInfo localBlockAdInfo = (BlockAdInfo)this.mBlockAdInfoMap.get(Integer.valueOf(paramInt));
          View localView = ((AdProxy.AbsBlockAdView)localObject1).getView();
          if (localView == null) {
            return false;
          }
          localView.setVisibility(0);
          Object localObject3 = localView.getParent();
          if (localObject3 != null) {
            return true;
          }
          localObject3 = (ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView();
          Object localObject4;
          if ((localObject3 instanceof FrameLayout))
          {
            localObject4 = new FrameLayout.LayoutParams(-2, -2);
            ((FrameLayout.LayoutParams)localObject4).leftMargin = gameDpTopx(localBlockAdInfo.getLeft());
            ((FrameLayout.LayoutParams)localObject4).topMargin = gameDpTopx(localBlockAdInfo.getTop());
            ((ViewGroup)localObject3).addView(localView, (ViewGroup.LayoutParams)localObject4);
          }
          else if ((localObject3 instanceof RelativeLayout))
          {
            localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject4).leftMargin = gameDpTopx(localBlockAdInfo.getLeft());
            ((RelativeLayout.LayoutParams)localObject4).topMargin = gameDpTopx(localBlockAdInfo.getTop());
            ((ViewGroup)localObject3).addView(localView, (ViewGroup.LayoutParams)localObject4);
          }
          ((AdProxy.AbsBlockAdView)localObject1).showBlockAdAnimation((AdProxy.AbsBlockAdView)localObject1);
          localObject1 = ((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getReportUrl();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext()) {
              reportBlockAd((String)((Iterator)localObject1).next());
            }
          }
          return true;
        }
        QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
        return false;
      }
      QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private boolean updateBlockAd(int paramInt)
  {
    try
    {
      if ((this.mBlockAdViewMap != null) && (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) != null) && (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() != null))
      {
        if ((this.mBlockAdInfoMap != null) && (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) != null))
        {
          if ((ViewGroup)this.mMiniAppContext.getAttachedActivity().getWindow().getDecorView() == null)
          {
            QMLog.e("BlockAdPlugin", "showBlockAd, root view is null");
            return false;
          }
          BlockAdInfo localBlockAdInfo = (BlockAdInfo)this.mBlockAdInfoMap.get(Integer.valueOf(paramInt));
          if (localBlockAdInfo == null) {
            return false;
          }
          Object localObject2 = (AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt));
          View localView = ((AdProxy.AbsBlockAdView)localObject2).updateAdInfo(localBlockAdInfo.getLeft(), localBlockAdInfo.getTop());
          if (localView == null) {
            return false;
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
          return true;
        }
        QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
        return false;
      }
      QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
      return false;
    }
    finally {}
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
    try
    {
      i = new JSONObject(paramRequestEvent.jsonParams).getInt("compId");
    }
    catch (JSONException localJSONException)
    {
      QMLog.i("BlockAdPlugin", "handle createBlockAd,", localJSONException);
      i = -1;
    }
    BlockAdInfo localBlockAdInfo = parseBlockAdInfoFromJson(paramRequestEvent.jsonParams);
    if (localBlockAdInfo == null)
    {
      blockErrorStateCallbackDelay(paramRequestEvent, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), i, 300);
      return "";
    }
    Object localObject4 = this.mMiniAppInfo;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    String str1;
    if ((localObject4 != null) && (((MiniAppInfo)localObject4).launchParam != null))
    {
      if (((MiniAppInfo)localObject4).launchParam.entryPath != null) {
        localObject1 = ((MiniAppInfo)localObject4).launchParam.entryPath;
      } else {
        localObject1 = "";
      }
      if (((MiniAppInfo)localObject4).launchParam != null) {
        localObject2 = ((MiniAppInfo)localObject4).launchParam.reportData;
      } else {
        localObject2 = "";
      }
      localObject3 = String.valueOf(((MiniAppInfo)localObject4).launchParam.scene);
    }
    else
    {
      str1 = "";
      localObject1 = str1;
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = str1;
    }
    if ((localObject4 != null) && (((MiniAppInfo)localObject4).via != null)) {
      str1 = ((MiniAppInfo)localObject4).via;
    } else {
      str1 = "";
    }
    localObject4 = this.mApkgInfo.appId;
    int i = 1;
    Object localObject5 = this.mMiniAppContext.getAttachedActivity();
    if (localObject5 != null)
    {
      i = MiniAppEnv.g().getContext().getResources().getConfiguration().orientation;
      initActivitySize((Activity)localObject5);
    }
    String str2 = LoginManager.getInstance().getAccount();
    localObject5 = AdUtil.getSpAdGdtCookie(13);
    Bundle localBundle = new Bundle();
    localBundle.putString(AdProxy.KEY_ACCOUNT, str2);
    localBundle.putInt(AdProxy.KEY_AD_TYPE, 13);
    str2 = AdProxy.KEY_ORIENTATION;
    if (i == 2) {
      i = 90;
    } else {
      i = 0;
    }
    localBundle.putInt(str2, i);
    localBundle.putString(AdProxy.KEY_GDT_COOKIE, (String)localObject5);
    localBundle.putString(AdProxy.KEY_ENTRY_PATH, (String)localObject1);
    localBundle.putString(AdProxy.KEY_REPORT_DATA, (String)localObject2);
    localBundle.putString(AdProxy.KEY_REFER, (String)localObject3);
    localBundle.putString(AdProxy.KEY_VIA, str1);
    AppBrandTask.runTaskOnUiThread(new BlockAdPlugin.1(this, localBlockAdInfo, (String)localObject4, paramRequestEvent, localBundle));
    return "";
  }
  
  public boolean hideBlockAd(int paramInt)
  {
    try
    {
      if ((this.mBlockAdViewMap != null) && (this.mBlockAdViewMap.get(Integer.valueOf(paramInt)) != null) && (((AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt))).getView() != null))
      {
        if ((this.mBlockAdInfoMap != null) && (this.mBlockAdInfoMap.get(Integer.valueOf(paramInt)) != null))
        {
          AdProxy.AbsBlockAdView localAbsBlockAdView = (AdProxy.AbsBlockAdView)this.mBlockAdViewMap.get(Integer.valueOf(paramInt));
          View localView = localAbsBlockAdView.getView();
          if (localView == null) {
            return false;
          }
          localView.setVisibility(8);
          localAbsBlockAdView.clearBlockAdAnimation(localAbsBlockAdView);
          return true;
        }
        QMLog.e("BlockAdPlugin", "showBannerAd error, data is null");
        return false;
      }
      QMLog.e("BlockAdPlugin", "showBannerAd error, view is null");
      return false;
    }
    finally {}
  }
  
  public void initActivitySize(Activity paramActivity)
  {
    if (this.mGameDensity > 0.0F) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    this.mGameDensity = localDisplayMetrics.density;
    paramActivity = new StringBuilder();
    paramActivity.append("density = ");
    paramActivity.append(localDisplayMetrics.density);
    paramActivity.append(", ViewUtils.density = ");
    paramActivity.append(ViewUtils.getDensity());
    QMLog.i("BlockAdPlugin", paramActivity.toString());
    if (this.mGameDensity == -1.0F) {
      this.mGameDensity = ViewUtils.getDensity();
    }
  }
  
  @JsEvent({"operateBlockAd"})
  public String operateBlockAd(RequestEvent paramRequestEvent)
  {
    QMLog.i("BlockAdPlugin", "receive operateBlockAd event");
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).getString("type");
      int i = ((JSONObject)localObject).getInt("compId");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle operateBlockAd type = ");
      ((StringBuilder)localObject).append(str);
      QMLog.i("BlockAdPlugin", ((StringBuilder)localObject).toString());
      if ("show".equals(str))
      {
        AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.3(this, i, paramRequestEvent), 300L);
      }
      else if ("hide".equals(str))
      {
        AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.4(this, i), 300L);
      }
      else if ("destroy".equals(str))
      {
        AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.5(this, i), 300L);
      }
      else
      {
        paramRequestEvent = new StringBuilder();
        paramRequestEvent.append("handle operateBlockAd not define type = ");
        paramRequestEvent.append(str);
        QMLog.i("BlockAdPlugin", paramRequestEvent.toString());
      }
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.i("BlockAdPlugin", "handle operateBlockAd parse json error", paramRequestEvent);
    }
    return "";
  }
  
  @JsEvent({"updateBlockAdSize"})
  public String updateBlockAdSize(RequestEvent paramRequestEvent)
  {
    QMLog.i("BlockAdPlugin", "receive updateBlockAdSize event");
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramRequestEvent.jsonParams);
        int k = ((JSONObject)localObject).getInt("compId");
        if (((JSONObject)localObject).has("left"))
        {
          i = ((JSONObject)localObject).getInt("left");
          j = 1;
        }
        else
        {
          if (!((JSONObject)localObject).has("top")) {
            break label159;
          }
          j = 2;
          i = ((JSONObject)localObject).getInt("top");
        }
        if (j != -1)
        {
          localObject = (BlockAdInfo)this.mBlockAdInfoMap.get(Integer.valueOf(k));
          if (localObject != null)
          {
            if (!handleBlockAdType(j, i, (BlockAdInfo)localObject, true))
            {
              QMLog.e("BlockAdPlugin", "updateBlockAd no need to resize");
              return "";
            }
            callbackUpdateSuccess(paramRequestEvent, k, (BlockAdInfo)localObject);
            return "";
          }
        }
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.i("BlockAdPlugin", "handle updateBlockAdSize parse json error", paramRequestEvent);
      }
      return "";
      label159:
      int i = -1;
      int j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin
 * JD-Core Version:    0.7.0.1
 */