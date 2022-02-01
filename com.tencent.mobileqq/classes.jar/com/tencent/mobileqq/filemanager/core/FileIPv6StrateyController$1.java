package com.tencent.mobileqq.filemanager.core;

import asgv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class FileIPv6StrateyController$1
  implements Runnable
{
  public FileIPv6StrateyController$1(asgv paramasgv) {}
  
  public void run()
  {
    if (asgv.a(this.this$0)) {
      return;
    }
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.this$0);
    asgv.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.1
 * JD-Core Version:    0.7.0.1
 */