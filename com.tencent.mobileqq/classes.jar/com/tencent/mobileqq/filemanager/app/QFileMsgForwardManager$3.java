package com.tencent.mobileqq.filemanager.app;

import atiy;
import atjv;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(atiy paramatiy, String paramString) {}
  
  public void run()
  {
    atjv localatjv = null;
    if (atiy.a(this.this$0).containsKey(this.a)) {
      localatjv = (atjv)atiy.a(this.this$0).get(this.a);
    }
    if (localatjv != null) {
      localatjv.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */