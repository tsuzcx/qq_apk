package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class PreloadingFragment$3$1
  implements Runnable
{
  PreloadingFragment$3$1(PreloadingFragment.3 param3, String paramString, long paramLong) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.val$errMsg);
    QQToast.a(localBaseApplication, 1, localStringBuilder.toString(), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */