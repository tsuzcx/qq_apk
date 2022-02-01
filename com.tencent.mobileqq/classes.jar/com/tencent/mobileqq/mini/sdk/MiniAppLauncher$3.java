package com.tencent.mobileqq.mini.sdk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

final class MiniAppLauncher$3
  implements Runnable
{
  MiniAppLauncher$3(String paramString) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131706845));
    localStringBuilder.append(this.val$appId);
    QQToast.a(localBaseApplication, 1, localStringBuilder.toString(), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher.3
 * JD-Core Version:    0.7.0.1
 */