package com.tencent.mobileqq.filemanager.app;

import aofz;
import aogw;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(aofz paramaofz, String paramString) {}
  
  public void run()
  {
    aogw localaogw = null;
    if (aofz.a(this.this$0).containsKey(this.a)) {
      localaogw = (aogw)aofz.a(this.this$0).get(this.a);
    }
    if (localaogw != null) {
      localaogw.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */