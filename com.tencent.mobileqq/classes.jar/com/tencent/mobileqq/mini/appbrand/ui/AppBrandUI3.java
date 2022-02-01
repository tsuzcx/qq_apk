package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import com.tencent.mobileqq.mini.fake.FakeSdkBrandUI;
import com.tencent.mobileqq.mini.fake.IFakeBrandUI;

public class AppBrandUI3
  extends AppBrandUI
{
  private static final String COOKIE_DOMAIN = "qzone.qq.com";
  private static volatile boolean mHasOKHttpClientInit = false;
  
  public IFakeBrandUI getFakeBrandUI()
  {
    if (this.mFakeBrandUI != null) {
      return this.mFakeBrandUI;
    }
    this.mFakeBrandUI = new FakeSdkBrandUI();
    return this.mFakeBrandUI;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3
 * JD-Core Version:    0.7.0.1
 */