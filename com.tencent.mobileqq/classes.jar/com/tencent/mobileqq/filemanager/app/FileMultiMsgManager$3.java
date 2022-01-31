package com.tencent.mobileqq.filemanager.app;

import aoea;
import aoew;
import java.util.HashMap;

public class FileMultiMsgManager$3
  implements Runnable
{
  public FileMultiMsgManager$3(aoea paramaoea, long paramLong) {}
  
  public void run()
  {
    aoew localaoew = null;
    if (aoea.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaoew = (aoew)aoea.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaoew != null) {
      localaoew.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.3
 * JD-Core Version:    0.7.0.1
 */