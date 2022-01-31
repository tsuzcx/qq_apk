package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bdct;
import bdle;
import bdlu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class AppBrandUI3
  extends BaseActivity
{
  private bdlu mUIProxy;
  
  private void initUIProxy(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
    this.mUIProxy = bdle.a().a(paramIntent);
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
    bdct.a(getApplicationContext(), null);
    MiniOkHttpClientFactory.init(30000L, 30000L, 30000L);
    AppBrandProxy.g().onAppStart(BaseApplicationImpl.getApplication().getQQProcessName(), null);
    bdle.a().a(AppBrandUI3.QQBaselibLoader.g());
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    setContentView(localRelativeLayout);
    FrameLayout localFrameLayout = new FrameLayout(this);
    localRelativeLayout.addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
    initUIProxy(getIntent());
    this.mUIProxy.onCreate(this, paramBundle, localFrameLayout);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3
 * JD-Core Version:    0.7.0.1
 */