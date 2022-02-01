package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import avwn;
import avxf;
import avxg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(avxf paramavxf) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((avxf.a(this.this$0) != null) && (avxf.a(this.this$0).a() != null)))
    {
      avxf.a(this.this$0, ((Integer)avxf.a(this.this$0).a().first).intValue());
      avxf.a(this.this$0, Long.valueOf(Long.parseLong((String)avxf.a(this.this$0).a().second)));
      avwn localavwn = avxf.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + avxf.a(this.this$0) + "], sessionUin = [" + avxf.a(this.this$0) + "], locationItem = [" + localavwn + "]" });
      }
      if (avxf.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(avxf.a(this.this$0)), " sessionUin: ", avxf.a(this.this$0), " locationItem: ", localavwn });
        }
        return;
      }
      this.this$0.a(avxf.a(this.this$0), avxf.a(this.this$0).longValue(), localavwn);
    }
    for (;;)
    {
      avxf.a(this.this$0).postDelayed(this, avxf.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", avxf.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */