package com.tencent.mobileqq.filemanager.core;

import atul;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class FileIPv6StrateyController$1
  implements Runnable
{
  public FileIPv6StrateyController$1(atul paramatul) {}
  
  public void run()
  {
    if (atul.a(this.this$0)) {
      return;
    }
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.this$0);
    atul.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.1
 * JD-Core Version:    0.7.0.1
 */