package com.tencent.mobileqq.filemanager.app;

import ases;
import asfp;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(ases paramases, String paramString) {}
  
  public void run()
  {
    asfp localasfp = null;
    if (ases.a(this.this$0).containsKey(this.a)) {
      localasfp = (asfp)ases.a(this.this$0).get(this.a);
    }
    if (localasfp != null) {
      localasfp.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */