package com.tencent.mobileqq.mini.sdk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

final class MiniAppLauncher$3
  implements Runnable
{
  MiniAppLauncher$3(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131706823) + this.val$appId, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher.3
 * JD-Core Version:    0.7.0.1
 */