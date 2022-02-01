package com.tencent.mobileqq.filemanager.app;

import atan;
import atbk;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(atan paramatan, String paramString) {}
  
  public void run()
  {
    atbk localatbk = null;
    if (atan.a(this.this$0).containsKey(this.a)) {
      localatbk = (atbk)atan.a(this.this$0).get(this.a);
    }
    if (localatbk != null) {
      localatbk.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */