package com.tencent.mobileqq.filemanager.app;

import atan;
import atbk;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    atbk localatbk = null;
    if (atan.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localatbk = (atbk)atan.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localatbk != null)
    {
      localatbk.b();
      localatbk.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */