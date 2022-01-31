package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import atpo;
import atqg;
import atqh;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(atqg paramatqg) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((atqg.a(this.this$0) != null) && (atqg.a(this.this$0).a() != null)))
    {
      atqg.a(this.this$0, ((Integer)atqg.a(this.this$0).a().first).intValue());
      atqg.a(this.this$0, Long.valueOf(Long.parseLong((String)atqg.a(this.this$0).a().second)));
      atpo localatpo = atqg.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + atqg.a(this.this$0) + "], sessionUin = [" + atqg.a(this.this$0) + "], locationItem = [" + localatpo + "]" });
      }
      if (atqg.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(atqg.a(this.this$0)), " sessionUin: ", atqg.a(this.this$0), " locationItem: ", localatpo });
        }
        return;
      }
      this.this$0.a(atqg.a(this.this$0), atqg.a(this.this$0).longValue(), localatpo);
    }
    for (;;)
    {
      atqg.a(this.this$0).postDelayed(this, atqg.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", atqg.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */