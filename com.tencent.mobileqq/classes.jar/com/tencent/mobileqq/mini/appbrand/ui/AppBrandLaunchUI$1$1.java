package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class AppBrandLaunchUI$1$1
  implements Runnable
{
  AppBrandLaunchUI$1$1(AppBrandLaunchUI.1 param1, String paramString, long paramLong) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.val$errMsg);
    QQToast.makeText(localBaseApplication, 1, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI.1.1
 * JD-Core Version:    0.7.0.1
 */