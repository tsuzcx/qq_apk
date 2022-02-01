package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

class QQFileIPv6StrateyController$2
  implements Runnable
{
  public void run()
  {
    if (!QQFileIPv6StrateyController.a(this.this$0)) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.this$0);
    QQFileIPv6StrateyController.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QQFileIPv6StrateyController.2
 * JD-Core Version:    0.7.0.1
 */