package com.tencent.mobileqq.filemanager.app;

import aouy;
import aovu;
import java.util.HashMap;

public class FileMultiMsgManager$4
  implements Runnable
{
  public void run()
  {
    aovu localaovu = null;
    if (aouy.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaovu = (aovu)aouy.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaovu != null)
    {
      localaovu.b();
      localaovu.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.4
 * JD-Core Version:    0.7.0.1
 */