package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;

class QQFileIPv6StrateyController$1
  implements Runnable
{
  QQFileIPv6StrateyController$1(QQFileIPv6StrateyController paramQQFileIPv6StrateyController) {}
  
  public void run()
  {
    if (QQFileIPv6StrateyController.a(this.this$0)) {
      return;
    }
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.this$0);
    QQFileIPv6StrateyController.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QQFileIPv6StrateyController.1
 * JD-Core Version:    0.7.0.1
 */