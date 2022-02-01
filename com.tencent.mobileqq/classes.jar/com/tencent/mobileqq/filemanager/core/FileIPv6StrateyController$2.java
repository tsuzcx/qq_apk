package com.tencent.mobileqq.filemanager.core;

import asgv;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class FileIPv6StrateyController$2
  implements Runnable
{
  public void run()
  {
    if (!asgv.a(this.this$0)) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.this$0);
    asgv.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.2
 * JD-Core Version:    0.7.0.1
 */