package com.tencent.mobileqq.filemanager.app;

import aowx;
import aoxu;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    aoxu localaoxu = null;
    if (aowx.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaoxu = (aoxu)aowx.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaoxu != null)
    {
      localaoxu.b();
      localaoxu.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */