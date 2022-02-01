package com.tencent.mobileqq.filemanager.app;

import ases;
import asfp;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    asfp localasfp = null;
    if (ases.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localasfp = (asfp)ases.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localasfp != null)
    {
      localasfp.b();
      localasfp.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */