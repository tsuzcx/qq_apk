package com.tencent.mobileqq.mini.sdk;

import anvx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class MiniAppLauncher$3
  implements Runnable
{
  MiniAppLauncher$3(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131706283) + this.val$appId, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher.3
 * JD-Core Version:    0.7.0.1
 */