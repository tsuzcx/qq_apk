package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bfbm;
import bfkm;
import bfkn;
import bhbu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class AppBrandUI3
  extends BaseActivity
{
  private static final String COOKIE_DOMAIN = "qzone.qq.com";
  private static volatile boolean mHasOKHttpClientInit;
  public static volatile boolean mHasOnCreate;
  private IUIProxy mUIProxy;
  
  public static void initOKHttpClient()
  {
    if (!mHasOKHttpClientInit)
    {
      mHasOKHttpClientInit = true;
      MiniOkHttpClientFactory.init(30000L, 30000L, 30000L);
    }
  }
  
  public static void setCookie()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      bfkn localbfkn = new bfkn(bfbm.a().a());
      bfkm localbfkm = new bfkm();
      localbfkm.a(true);
      long l2 = bfbm.a().a();
      Object localObject = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      String str = ((TicketManager)localObject).getSkey(String.valueOf(l2));
      localObject = ((TicketManager)localObject).getPskey(String.valueOf(l2), "qzone.qq.com");
      localbfkm.a("qzone.qq.com/", "uin=" + l2 + "; path=/; domain=." + "qzone.qq.com" + ";");
      localbfkm.a("qzone.qq.com/", "p_uin=" + l2 + "; path=/; domain=." + "qzone.qq.com" + ";");
      localbfkm.a("qzone.qq.com/", "skey=" + str + "; path=/; domain=." + "qzone.qq.com" + ";");
      localbfkm.a("qzone.qq.com/", "p_skey=" + (String)localObject + "; path=/; domain=." + "qzone.qq.com" + ";");
      localbfkn.a();
      l2 = System.currentTimeMillis();
      QMLog.e(AppBrandUI3.class.getSimpleName(), "setCookie cost:" + (l2 - l1));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mUIProxy.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.mUIProxy.onBackPressed(this)) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    mHasOnCreate = true;
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)getIntent().getParcelableExtra("KEY_APPINFO");
    if (localMiniAppInfo != null)
    {
      bhbu.b(localMiniAppInfo.appId, bhbu.a);
      QMLog.w("minisdk-start", "AppBrandUI3.onCreate baseLib pre load:" + bhbu.a + " appid:" + localMiniAppInfo.appId);
    }
    ThreadManager.executeOnSubThread(new AppBrandUI3.1(this));
    MiniSDK.init(getApplicationContext());
    initOKHttpClient();
    AppBrandProxy.g().onAppStart(BaseApplicationImpl.getApplication().getQQProcessName(), null);
    AppLoaderFactory.g().setBaselibLoader(AppBrandUI3.QQBaselibLoader.g());
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    setContentView(localRelativeLayout);
    FrameLayout localFrameLayout = new FrameLayout(this);
    localRelativeLayout.addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
    this.mUIProxy = AppLoaderFactory.g().getAppUIProxy(localMiniAppInfo);
    if (this.mUIProxy != null) {
      this.mUIProxy.onCreate(this, paramBundle, localFrameLayout);
    }
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.mUIProxy.onDestroy(this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.mUIProxy.onBackPressed(this)) {
        return true;
      }
      super.onBackPressed();
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.mUIProxy.onNewIntent(this, paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.mUIProxy.onPause(this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mUIProxy.onRequestPermissionsResult(this, paramInt, paramArrayOfString, paramArrayOfInt);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    this.mUIProxy.onResume(this);
    ImmersiveUtils.a(true, getWindow());
  }
  
  public void onStart()
  {
    super.onStart();
    this.mUIProxy.onStart(this);
  }
  
  public void onStop()
  {
    super.onStop();
    this.mUIProxy.onStop(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3
 * JD-Core Version:    0.7.0.1
 */