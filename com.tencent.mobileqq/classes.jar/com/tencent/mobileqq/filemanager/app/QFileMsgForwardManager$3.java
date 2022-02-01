package com.tencent.mobileqq.filemanager.app;

import atsi;
import attf;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(atsi paramatsi, String paramString) {}
  
  public void run()
  {
    attf localattf = null;
    if (atsi.a(this.this$0).containsKey(this.a)) {
      localattf = (attf)atsi.a(this.this$0).get(this.a);
    }
    if (localattf != null) {
      localattf.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */