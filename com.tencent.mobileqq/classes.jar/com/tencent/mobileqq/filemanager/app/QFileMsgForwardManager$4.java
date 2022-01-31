package com.tencent.mobileqq.filemanager.app;

import aqpv;
import aqqs;
import java.util.HashMap;

public class QFileMsgForwardManager$4
  implements Runnable
{
  public void run()
  {
    aqqs localaqqs = null;
    if (aqpv.a(this.this$0).containsKey(Long.valueOf(this.a))) {
      localaqqs = (aqqs)aqpv.a(this.this$0).get(Long.valueOf(this.a));
    }
    if (localaqqs != null)
    {
      localaqqs.b();
      localaqqs.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.4
 * JD-Core Version:    0.7.0.1
 */