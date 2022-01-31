package com.tencent.qqmini.sdk.core.plugins;

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
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bdcy;
import bdcz;
import bdew;
import bdfx;
import bdfz;
import bdgg;
import bdgi;
import bdnw;
import bdyg;
import bdyj;
import bdza;
import bdzh;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class BannerAdPlugin
  extends BaseJsPlugin
{
  private static final HashMap<Integer, String> AD_ERROR_MSG = bdza.a;
  public static final String API_AD_CREATE_BANNER_AD = "createBannerAd";
  public static final String API_AD_OPERATE_BANNER_AD = "operateBannerAd";
  public static final String API_AD_UPDATE_BANNER_AD_SIZE = "updateBannerAdSize";
  public static final String EVENT_BANNER_AD_SHOW_DONE = "onBannerAdShowDone";
  public static final String EVENT_BANNER_AD_STATE_CHANGE = "onBannerAdStateChange";
  private static final String TAG = "BannerAdPlugin";
  private FrameLayout mBannerAdContainer;
  private bdyj mBannerAdPosInfo;
  private AdProxy.AbsBannerAdView mBannerAdView;
  private float mGameDensity = -1.0F;
  private int mGameHeight;
  private int mGameWidth;
  private boolean mHasNewAd;
  
  private void bannerErrorStateCallbackDelay(bdfz parambdfz, int paramInt1, String paramString, int paramInt2)
  {
    bdgi.a(new BannerAdPlugin.7(this, paramString, paramInt1, parambdfz), paramInt2);
  }
  
  private void destroyBannerAd()
  {
    try
    {
      if (this.mBannerAdContainer != null) {
        this.mBannerAdContainer.removeAllViews();
      }
      if (this.mBannerAdView != null)
      {
        this.mBannerAdView.destroy(this.mMiniAppContext.a());
        this.mBannerAdView = null;
      }
      this.mBannerAdContainer = null;
      this.mBannerAdPosInfo = null;
      return;
    }
    finally {}
  }
  
  private int gameDpTopx(float paramFloat)
  {
    return Math.round(this.mGameDensity * paramFloat);
  }
  
  private void informJs(bdfz parambdfz, JSONObject paramJSONObject, String paramString)
  {
    parambdfz.jdField_a_of_type_Bdcy.a(paramString, paramJSONObject.toString(), 0);
  }
  
  private boolean makeSureContainerAdded()
  {
    if ((this.mBannerAdContainer != null) && (this.mBannerAdContainer.getParent() != null)) {
      return true;
    }
    ViewGroup localViewGroup = (ViewGroup)this.mMiniAppContext.a().findViewById(16908290);
    if (localViewGroup == null)
    {
      bdnw.d("BannerAdPlugin", "makeSureContainerAdded, root view is null");
      return false;
    }
    if (this.mBannerAdContainer == null) {
      this.mBannerAdContainer = new FrameLayout(this.mMiniAppContext.a());
    }
    if ((localViewGroup instanceof FrameLayout)) {
      localViewGroup.addView(this.mBannerAdContainer, new FrameLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      return true;
      if ((localViewGroup instanceof RelativeLayout)) {
        localViewGroup.addView(this.mBannerAdContainer, new RelativeLayout.LayoutParams(-1, -1));
      }
    }
  }
  
  private void reportBannerAd(String paramString)
  {
    bdnw.b("BannerAdPlugin", "reportBannerAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    bdew.a(new BannerAdPlugin.5(this, paramString), 16, null, false);
  }
  
  private boolean showBannerAd()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if ((this.mBannerAdView == null) || (this.mBannerAdView.getView() == null) || (this.mBannerAdPosInfo == null))
        {
          bdnw.d("BannerAdPlugin", "showBannerAd error, data is null");
          return bool;
        }
        if (!this.mBannerAdPosInfo.a())
        {
          bdnw.d("BannerAdPlugin", "showBannerAd error, adPosInfo is invalid." + this.mBannerAdPosInfo);
          continue;
        }
        if (this.mMiniAppContext == null) {
          break label103;
        }
      }
      finally {}
      if (this.mMiniAppContext.a() == null)
      {
        label103:
        bdnw.d("BannerAdPlugin", "showBannerAd error, mGdtBannerView == null");
      }
      else
      {
        makeSureContainerAdded();
        if ((!this.mHasNewAd) && (this.mBannerAdContainer.getChildCount() > 0))
        {
          this.mBannerAdContainer.setVisibility(0);
          bdnw.b("BannerAdPlugin", "showBannerAd, just set visible");
          bool = true;
        }
        else
        {
          this.mBannerAdContainer.removeAllViews();
          if ((this.mBannerAdView != null) && (this.mBannerAdView.getView() != null))
          {
            Object localObject2 = new FrameLayout.LayoutParams(gameDpTopx(this.mBannerAdPosInfo.f), gameDpTopx(this.mBannerAdPosInfo.g));
            ((FrameLayout.LayoutParams)localObject2).leftMargin = gameDpTopx(this.mBannerAdPosInfo.b);
            ((FrameLayout.LayoutParams)localObject2).topMargin = gameDpTopx(this.mBannerAdPosInfo.c);
            this.mBannerAdContainer.addView(this.mBannerAdView.getView(), (ViewGroup.LayoutParams)localObject2);
            this.mBannerAdContainer.setVisibility(0);
            localObject2 = this.mBannerAdView.getReportUrl();
            if ((this.mHasNewAd) && (this.mBannerAdPosInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              reportBannerAd((String)localObject2);
            }
            this.mHasNewAd = false;
            bool = true;
          }
          else
          {
            bdnw.d("BannerAdPlugin", "showBannerAd error, mGdtBannerView is null");
          }
        }
      }
    }
  }
  
  private void updateBannerSize(bdfz parambdfz)
  {
    int n = 1;
    int i;
    int j;
    float f1;
    bdyj localbdyj;
    int k;
    int m;
    float f2;
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      if (localJSONObject.has("left"))
      {
        i = localJSONObject.getInt("left");
        j = 1;
        break label537;
      }
      if (localJSONObject.has("top"))
      {
        i = localJSONObject.getInt("top");
        j = 2;
        break label537;
      }
      if (!localJSONObject.has("width")) {
        break label531;
      }
      f1 = bdzh.a();
      i = bdzh.a();
      j = bdzh.b();
      localbdyj = this.mBannerAdPosInfo;
      Activity localActivity = this.mMiniAppContext.a();
      if (localActivity == null) {
        break label519;
      }
      int i1 = MiniAppEnv.g().getContext().getResources().getConfiguration().orientation;
      initActivitySize(localActivity);
      if (this.mGameDensity > 0.0F) {
        f1 = this.mGameDensity;
      }
      if (this.mGameWidth > 0) {
        i = this.mGameWidth;
      }
      k = i;
      m = i1;
      f2 = f1;
      if (this.mGameHeight > 0)
      {
        j = this.mGameHeight;
        f2 = f1;
        m = i1;
        k = i;
      }
      i1 = localJSONObject.getInt("width");
      i = bdyj.a(i1, m, f2, k, j);
      if ((localbdyj == null) || (i1 == localbdyj.d) || (i != localbdyj.f)) {
        break label513;
      }
      localbdyj.d = i1;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("state", "resize");
        localJSONObject.put("width", localbdyj.f);
        localJSONObject.put("height", localbdyj.g);
        informJs(parambdfz, localJSONObject, "onBannerAdStateChange");
        return;
      }
      catch (JSONException parambdfz)
      {
        bdnw.d("BannerAdPlugin", "updateBannerAd informJs error", parambdfz);
        return;
      }
      if (i >= 0) {
        break label367;
      }
    }
    catch (JSONException parambdfz)
    {
      bdnw.d("BannerAdPlugin", "handle updateBannerAdSize parse json error", parambdfz);
      return;
    }
    label337:
    bannerErrorStateCallbackDelay(parambdfz, 1003, (String)AD_ERROR_MSG.get(Integer.valueOf(1003)), 0);
    return;
    label367:
    if ((j != -1) && (this.mIsMiniGame))
    {
      localbdyj = this.mBannerAdPosInfo;
      if (localbdyj != null) {
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        if (bdnw.a())
        {
          bdnw.b("BannerAdPlugin", "updateBannerAd no need to resize");
          return;
          if (localbdyj.b == i) {
            break label554;
          }
          k = 1;
          break label551;
          k = n;
          if (localbdyj.c != i) {
            continue;
          }
          k = 0;
          continue;
          k = n;
          if (localbdyj.f != i) {
            continue;
          }
          k = 0;
        }
      }
      else
      {
        bdgi.a(new BannerAdPlugin.6(this, j, i, parambdfz));
        return;
        label513:
        j = 3;
        break label537;
        label519:
        m = 1;
        k = i;
        f2 = f1;
        break;
        label531:
        i = -1;
        j = -1;
        label537:
        if (j != -1) {
          break label337;
        }
      }
      return;
      k = n;
    }
    for (;;)
    {
      label551:
      break;
      label554:
      k = 0;
    }
  }
  
  public String createBannerAd(bdfz parambdfz)
  {
    int i = 90;
    Object localObject1;
    for (;;)
    {
      label161:
      label210:
      try
      {
        bdnw.b("BannerAdPlugin", "receive createBannerAd event");
        try
        {
          localObject1 = bdyj.a(parambdfz.b);
          if (localObject1 != null) {
            continue;
          }
          bannerErrorStateCallbackDelay(parambdfz, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
          bdnw.b("BannerAdPlugin", "handle createBannerAd error params, " + parambdfz.b);
          parambdfz = "";
        }
        catch (Exception localException)
        {
          String str3;
          float f;
          int j;
          int k;
          String str4;
          Object localObject2;
          bdyj localbdyj;
          String str5;
          Object localObject4;
          localObject1 = bdgg.b(parambdfz.jdField_a_of_type_JavaLangString, null);
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((JSONObject)localObject1).toString();
          bannerErrorStateCallbackDelay(parambdfz, 1003, (String)AD_ERROR_MSG.get(Integer.valueOf(1003)), 0);
          bdnw.b("BannerAdPlugin", "handle createBannerAd parse json error" + parambdfz.b, localException);
          if (localObject1 == null) {
            continue;
          }
          parambdfz = (bdfz)localObject1;
          continue;
          localObject1 = "";
          continue;
        }
        return parambdfz;
      }
      finally {}
      str3 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
      f = bdzh.a();
      j = bdzh.a();
      k = bdzh.a();
      str4 = this.mApkgInfo.d;
      localObject2 = this.mMiniAppContext.a();
      if (localObject2 == null) {
        break label728;
      }
      if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation != 2) {
        break label737;
      }
      initActivitySize((Activity)localObject2);
      if (this.mGameDensity > 0.0F) {
        f = this.mGameDensity;
      }
      if (this.mGameWidth > 0) {
        j = this.mGameWidth;
      }
      if (this.mGameHeight <= 0) {
        break label734;
      }
      k = this.mGameHeight;
      break label734;
      bdnw.b("BannerAdPlugin", "handle createBannerAd appId = " + str4);
      if (TextUtils.isEmpty(str4))
      {
        bannerErrorStateCallbackDelay(parambdfz, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
        parambdfz = "";
      }
      else
      {
        localbdyj = bdyj.a((bdyj)localObject1, i, f, j, k);
        if ((localbdyj == null) || (!localbdyj.a()))
        {
          bannerErrorStateCallbackDelay(parambdfz, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), 300);
          bdnw.b("BannerAdPlugin", "handle createBannerAd invalid adInfo = " + localbdyj);
          parambdfz = "";
        }
        else
        {
          this.mBannerAdPosInfo = localbdyj;
          str5 = bdyg.a(0);
          localObject4 = this.mMiniAppInfo;
          if ((localObject4 != null) && (((MiniAppInfo)localObject4).launchParam != null)) {
            if (((MiniAppInfo)localObject4).launchParam.c != null)
            {
              localObject1 = ((MiniAppInfo)localObject4).launchParam.c;
              label414:
              if (((MiniAppInfo)localObject4).launchParam == null) {
                break label742;
              }
            }
          }
        }
      }
    }
    String str1;
    label728:
    label734:
    label737:
    label742:
    for (localObject2 = MiniAppInfo.getReportDataString(((MiniAppInfo)localObject4).launchParam.jdField_a_of_type_JavaUtilMap);; str1 = "")
    {
      j = ((MiniAppInfo)localObject4).launchParam.jdField_a_of_type_Int;
      String str2 = String.valueOf(j);
      Object localObject3 = localObject1;
      for (localObject1 = str2;; localObject1 = "")
      {
        if ((localObject4 != null) && (((MiniAppInfo)localObject4).via != null)) {}
        for (str2 = ((MiniAppInfo)localObject4).via;; str2 = "")
        {
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString(AdProxy.KEY_ACCOUNT, str3);
          ((Bundle)localObject4).putInt(AdProxy.KEY_AD_TYPE, 0);
          ((Bundle)localObject4).putInt(AdProxy.KEY_ORIENTATION, i);
          ((Bundle)localObject4).putString(AdProxy.KEY_GDT_COOKIE, str5);
          ((Bundle)localObject4).putString(AdProxy.KEY_ENTRY_PATH, (String)localObject3);
          ((Bundle)localObject4).putString(AdProxy.KEY_REPORT_DATA, (String)localObject2);
          ((Bundle)localObject4).putString(AdProxy.KEY_REFER, (String)localObject1);
          ((Bundle)localObject4).putString(AdProxy.KEY_VIA, str2);
          bdgi.a(new BannerAdPlugin.1(this, str4, localbdyj, parambdfz, (Bundle)localObject4));
          parambdfz = "";
          break;
          localObject1 = "";
          break label414;
        }
        localObject3 = "";
        str1 = "";
      }
      i = 90;
      break label210;
      break label210;
      i = 0;
      break label161;
    }
  }
  
  /* Error */
  public boolean hideBannerAd()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 63	com/tencent/qqmini/sdk/core/plugins/BannerAdPlugin:mBannerAdView	Lcom/tencent/qqmini/sdk/core/proxy/AdProxy$AbsBannerAdView;
    //   8: ifnonnull +17 -> 25
    //   11: ldc 26
    //   13: ldc_w 525
    //   16: invokestatic 173	bdnw:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: iload_2
    //   20: istore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: iload_2
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 108	com/tencent/qqmini/sdk/core/plugins/BannerAdPlugin:mBannerAdContainer	Landroid/widget/FrameLayout;
    //   31: ifnull -10 -> 21
    //   34: iload_2
    //   35: istore_1
    //   36: aload_0
    //   37: getfield 108	com/tencent/qqmini/sdk/core/plugins/BannerAdPlugin:mBannerAdContainer	Landroid/widget/FrameLayout;
    //   40: ifnull -19 -> 21
    //   43: iload_2
    //   44: istore_1
    //   45: aload_0
    //   46: getfield 108	com/tencent/qqmini/sdk/core/plugins/BannerAdPlugin:mBannerAdContainer	Landroid/widget/FrameLayout;
    //   49: invokevirtual 528	android/widget/FrameLayout:getVisibility	()I
    //   52: ifne -31 -> 21
    //   55: aload_0
    //   56: getfield 108	com/tencent/qqmini/sdk/core/plugins/BannerAdPlugin:mBannerAdContainer	Landroid/widget/FrameLayout;
    //   59: bipush 8
    //   61: invokevirtual 253	android/widget/FrameLayout:setVisibility	(I)V
    //   64: iconst_1
    //   65: istore_1
    //   66: goto -45 -> 21
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	BannerAdPlugin
    //   20	46	1	bool1	boolean
    //   1	43	2	bool2	boolean
    //   69	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	19	69	finally
    //   27	34	69	finally
    //   36	43	69	finally
    //   45	64	69	finally
  }
  
  public void initActivitySize(Activity paramActivity)
  {
    if ((this.mGameDensity > 0.0F) && (this.mGameWidth > 0) && (this.mGameHeight > 0)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramActivity.getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    this.mGameDensity = localDisplayMetrics.density;
    this.mGameWidth = localDisplayMetrics.widthPixels;
    this.mGameHeight = localDisplayMetrics.heightPixels;
    bdnw.b("BannerAdPlugin", "density = " + localDisplayMetrics.density + ", ViewUtils.density = " + bdzh.a() + ", screenW = " + localDisplayMetrics.widthPixels + ", screenH = " + localDisplayMetrics.heightPixels);
  }
  
  public void onDestroy()
  {
    if ((this.mBannerAdView != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.a() != null)) {
      this.mBannerAdView.destroy(this.mMiniAppContext.a());
    }
  }
  
  public void onPause()
  {
    if ((this.mBannerAdView != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.a() != null)) {
      this.mBannerAdView.pause(this.mMiniAppContext.a());
    }
  }
  
  public void onResume()
  {
    if ((this.mBannerAdView != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.a() != null)) {
      this.mBannerAdView.resume(this.mMiniAppContext.a());
    }
  }
  
  public String operateBannerAd(bdfz parambdfz)
  {
    bdnw.b("BannerAdPlugin", "receive operateBannerAd event");
    try
    {
      str = new JSONObject(parambdfz.b).getString("type");
      bdnw.b("BannerAdPlugin", "handle operateBannerAd type = " + str);
      if ("show".equals(str)) {
        bdgi.a(new BannerAdPlugin.2(this, parambdfz), 300L);
      }
      for (;;)
      {
        return "";
        if (!"hide".equals(str)) {
          break;
        }
        bdgi.a(new BannerAdPlugin.3(this));
      }
    }
    catch (JSONException parambdfz)
    {
      for (;;)
      {
        String str;
        bdnw.b("BannerAdPlugin", "handle operateBannerAd parse json error", parambdfz);
        continue;
        if ("destroy".equals(str)) {
          bdgi.a(new BannerAdPlugin.4(this));
        } else {
          bdnw.b("BannerAdPlugin", "handle operateBannerAd not define type = " + str);
        }
      }
    }
  }
  
  public boolean updateBannerAdPosition(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        bdnw.b("BannerAdPlugin", "updateBannerAdPosition");
        if ((this.mBannerAdView == null) || (this.mBannerAdPosInfo == null))
        {
          bdnw.d("BannerAdPlugin", "updateBannerAdPosition error, no data");
          return bool;
        }
        switch (paramInt1)
        {
        default: 
          if ((this.mBannerAdContainer == null) || (this.mBannerAdContainer.getChildCount() <= 0)) {
            break label261;
          }
          View localView = this.mBannerAdContainer.getChildAt(0);
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
          localLayoutParams.leftMargin = gameDpTopx(this.mBannerAdPosInfo.b);
          localLayoutParams.topMargin = gameDpTopx(this.mBannerAdPosInfo.c);
          localLayoutParams.width = gameDpTopx(this.mBannerAdPosInfo.f);
          localLayoutParams.height = gameDpTopx(this.mBannerAdPosInfo.g);
          this.mBannerAdView.setSize(gameDpTopx(this.mBannerAdPosInfo.f), gameDpTopx(this.mBannerAdPosInfo.g));
          localView.setLayoutParams(localLayoutParams);
        }
      }
      finally {}
      this.mBannerAdPosInfo.b = paramInt2;
      continue;
      this.mBannerAdPosInfo.c = paramInt2;
      continue;
      this.mBannerAdPosInfo.f = paramInt2;
      this.mBannerAdPosInfo.g = bdyj.a(paramInt2);
      continue;
      label261:
      bool = true;
    }
  }
  
  public void updateBannerAdSize(bdfz parambdfz)
  {
    bdnw.b("BannerAdPlugin", "updateBannerAdSize " + parambdfz.b);
    updateBannerSize(parambdfz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BannerAdPlugin
 * JD-Core Version:    0.7.0.1
 */