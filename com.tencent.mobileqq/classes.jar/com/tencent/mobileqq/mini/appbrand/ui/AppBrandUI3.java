package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bcxm;
import bdgq;
import bdgr;
import begs;
import bepk;
import beqe;
import besl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class AppBrandUI3
  extends BaseActivity
{
  private static final String COOKIE_DOMAIN = "qzone.qq.com";
  private beqe mUIProxy;
  
  private void initUIProxy(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
    this.mUIProxy = bepk.a().a(paramIntent);
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
    begs.a(getApplicationContext());
    MiniOkHttpClientFactory.init(30000L, 30000L, 30000L);
    AppBrandProxy.g().onAppStart(BaseApplicationImpl.getApplication().getQQProcessName(), null);
    bepk.a().a(AppBrandUI3.QQBaselibLoader.g());
    Object localObject1 = new RelativeLayout(this);
    setContentView((View)localObject1);
    Object localObject2 = new FrameLayout(this);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    initUIProxy(getIntent());
    this.mUIProxy.onCreate(this, paramBundle, (ViewGroup)localObject2);
    super.onCreate(paramBundle);
    long l1 = System.currentTimeMillis();
    try
    {
      paramBundle = new bdgr(bcxm.a().a());
      localObject1 = new bdgq();
      ((bdgq)localObject1).a(true);
      long l2 = bcxm.a().a();
      Object localObject3 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      localObject2 = ((TicketManager)localObject3).getSkey(String.valueOf(l2));
      localObject3 = ((TicketManager)localObject3).getPskey(String.valueOf(l2), "qzone.qq.com");
      ((bdgq)localObject1).a("qzone.qq.com/", "uin=" + l2 + "; path=/; domain=." + "qzone.qq.com" + ";");
      ((bdgq)localObject1).a("qzone.qq.com/", "p_uin=" + l2 + "; path=/; domain=." + "qzone.qq.com" + ";");
      ((bdgq)localObject1).a("qzone.qq.com/", "skey=" + (String)localObject2 + "; path=/; domain=." + "qzone.qq.com" + ";");
      ((bdgq)localObject1).a("qzone.qq.com/", "p_skey=" + (String)localObject3 + "; path=/; domain=." + "qzone.qq.com" + ";");
      paramBundle.a();
      l2 = System.currentTimeMillis();
      besl.d(AppBrandUI3.class.getSimpleName(), "cost:" + (l2 - l1));
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3
 * JD-Core Version:    0.7.0.1
 */