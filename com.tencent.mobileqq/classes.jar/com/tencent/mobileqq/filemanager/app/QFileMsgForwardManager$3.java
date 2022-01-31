package com.tencent.mobileqq.filemanager.app;

import aqpv;
import aqqs;
import java.util.HashMap;

public class QFileMsgForwardManager$3
  implements Runnable
{
  public QFileMsgForwardManager$3(aqpv paramaqpv, String paramString) {}
  
  public void run()
  {
    aqqs localaqqs = null;
    if (aqpv.a(this.this$0).containsKey(this.a)) {
      localaqqs = (aqqs)aqpv.a(this.this$0).get(this.a);
    }
    if (localaqqs != null) {
      localaqqs.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
 * JD-Core Version:    0.7.0.1
 */