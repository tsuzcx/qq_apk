package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import atlf;
import atlx;
import atly;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(atlx paramatlx) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((atlx.a(this.this$0) != null) && (atlx.a(this.this$0).a() != null)))
    {
      atlx.a(this.this$0, ((Integer)atlx.a(this.this$0).a().first).intValue());
      atlx.a(this.this$0, Long.valueOf(Long.parseLong((String)atlx.a(this.this$0).a().second)));
      atlf localatlf = atlx.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + atlx.a(this.this$0) + "], sessionUin = [" + atlx.a(this.this$0) + "], locationItem = [" + localatlf + "]" });
      }
      if (atlx.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(atlx.a(this.this$0)), " sessionUin: ", atlx.a(this.this$0), " locationItem: ", localatlf });
        }
        return;
      }
      this.this$0.a(atlx.a(this.this$0), atlx.a(this.this$0).longValue(), localatlf);
    }
    for (;;)
    {
      atlx.a(this.this$0).postDelayed(this, atlx.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", atlx.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */