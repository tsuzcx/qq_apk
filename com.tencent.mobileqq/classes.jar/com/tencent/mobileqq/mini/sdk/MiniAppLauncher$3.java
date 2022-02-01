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
    localStringBuilder.append(HardCodeUtil.a(2131904693));
    localStringBuilder.append(this.val$appId);
    QQToast.makeText(localBaseApplication, 1, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher.3
 * JD-Core Version:    0.7.0.1
 */