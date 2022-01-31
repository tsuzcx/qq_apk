package com.tencent.mobileqq.filemanager.app;

import aque;
import aqvb;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    aqvb localaqvb = null;
    if (aque.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaqvb = (aqvb)aque.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaqvb != null)
    {
      localaqvb.b();
      localaqvb.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */