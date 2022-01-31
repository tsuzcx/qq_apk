package com.tencent.mobileqq.filemanager.app;

import aqsf;
import aqtb;
import java.util.HashMap;

public class FileMultiMsgManager$3
  implements Runnable
{
  public FileMultiMsgManager$3(aqsf paramaqsf, long paramLong) {}
  
  public void run()
  {
    aqtb localaqtb = null;
    if (aqsf.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaqtb = (aqtb)aqsf.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaqtb != null) {
      localaqtb.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.3
 * JD-Core Version:    0.7.0.1
 */