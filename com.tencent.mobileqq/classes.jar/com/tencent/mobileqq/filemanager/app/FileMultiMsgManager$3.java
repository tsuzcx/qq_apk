package com.tencent.mobileqq.filemanager.app;

import aouu;
import aovq;
import java.util.HashMap;

public class FileMultiMsgManager$3
  implements Runnable
{
  public FileMultiMsgManager$3(aouu paramaouu, long paramLong) {}
  
  public void run()
  {
    aovq localaovq = null;
    if (aouu.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaovq = (aovq)aouu.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaovq != null) {
      localaovq.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.3
 * JD-Core Version:    0.7.0.1
 */