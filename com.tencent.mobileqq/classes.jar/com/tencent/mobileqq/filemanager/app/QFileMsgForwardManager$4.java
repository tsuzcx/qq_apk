package com.tencent.mobileqq.filemanager.app;

import aofz;
import aogw;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    aogw localaogw = null;
    if (aofz.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaogw = (aogw)aofz.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaogw != null)
    {
      localaogw.b();
      localaogw.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */