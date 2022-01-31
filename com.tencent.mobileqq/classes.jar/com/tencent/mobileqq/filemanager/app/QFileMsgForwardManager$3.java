package com.tencent.mobileqq.filemanager.app;

import aque;
import aqvb;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(aque paramaque, String paramString) {}
  
  public void run()
  {
    aqvb localaqvb = null;
    if (aque.a(this.this$0).containsKey(this.a)) {
      localaqvb = (aqvb)aque.a(this.this$0).get(this.a);
    }
    if (localaqvb != null) {
      localaqvb.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */