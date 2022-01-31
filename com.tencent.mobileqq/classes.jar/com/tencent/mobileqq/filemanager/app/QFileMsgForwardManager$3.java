package com.tencent.mobileqq.filemanager.app;

import aowx;
import aoxu;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(aowx paramaowx, String paramString) {}
  
  public void run()
  {
    aoxu localaoxu = null;
    if (aowx.a(this.this$0).containsKey(this.a)) {
      localaoxu = (aoxu)aowx.a(this.this$0).get(this.a);
    }
    if (localaoxu != null) {
      localaoxu.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */