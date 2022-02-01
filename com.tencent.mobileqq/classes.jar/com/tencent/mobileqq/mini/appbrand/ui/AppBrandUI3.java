package com.tencent.mobileqq.mini.appbrand.ui;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.mini.fake.FakeSdkBrandUI;
import com.tencent.mobileqq.mini.fake.IFakeBrandUI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AppBrandUI3
  extends AppBrandUI
{
  private static final String COOKIE_DOMAIN = "qzone.qq.com";
  private static volatile boolean mHasOKHttpClientInit;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public IFakeBrandUI getFakeBrandUI()
  {
    if (this.mFakeBrandUI != null) {
      return this.mFakeBrandUI;
    }
    this.mFakeBrandUI = new FakeSdkBrandUI();
    return this.mFakeBrandUI;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3
 * JD-Core Version:    0.7.0.1
 */