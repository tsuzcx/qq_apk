package com.tencent.mobileqq.filemanager.app;

import atsi;
import attf;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    attf localattf = null;
    if (atsi.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localattf = (attf)atsi.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localattf != null)
    {
      localattf.b();
      localattf.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */