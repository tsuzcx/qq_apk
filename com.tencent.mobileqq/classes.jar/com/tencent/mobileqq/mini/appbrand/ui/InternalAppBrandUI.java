package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.IAppUIProxy;

public class InternalAppBrandUI
  extends AppBrandUI
{
  public IAppUIProxy getAppUIProxy()
  {
    if (this.mAppUIProxy == null) {
      this.mAppUIProxy = AppLoaderFactory.createInternalAppUIProxy();
    }
    return this.mAppUIProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.InternalAppBrandUI
 * JD-Core Version:    0.7.0.1
 */