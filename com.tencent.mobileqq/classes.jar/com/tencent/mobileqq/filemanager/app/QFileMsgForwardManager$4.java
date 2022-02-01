package com.tencent.mobileqq.filemanager.app;

import atiy;
import atjv;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    atjv localatjv = null;
    if (atiy.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localatjv = (atjv)atiy.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localatjv != null)
    {
      localatjv.b();
      localatjv.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */