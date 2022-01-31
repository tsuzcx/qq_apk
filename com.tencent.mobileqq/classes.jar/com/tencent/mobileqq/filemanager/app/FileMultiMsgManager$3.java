package com.tencent.mobileqq.filemanager.app;

import aqnw;
import aqos;
import java.util.HashMap;

public class FileMultiMsgManager$3
  implements Runnable
{
  public FileMultiMsgManager$3(aqnw paramaqnw, long paramLong) {}
  
  public void run()
  {
    aqos localaqos = null;
    if (aqnw.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaqos = (aqos)aqnw.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaqos != null) {
      localaqos.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.3
 * JD-Core Version:    0.7.0.1
 */