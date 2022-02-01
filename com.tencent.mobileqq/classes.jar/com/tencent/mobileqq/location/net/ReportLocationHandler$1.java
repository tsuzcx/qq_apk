package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import avco;
import avdg;
import avdh;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(avdg paramavdg) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((avdg.a(this.this$0) != null) && (avdg.a(this.this$0).a() != null)))
    {
      avdg.a(this.this$0, ((Integer)avdg.a(this.this$0).a().first).intValue());
      avdg.a(this.this$0, Long.valueOf(Long.parseLong((String)avdg.a(this.this$0).a().second)));
      avco localavco = avdg.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + avdg.a(this.this$0) + "], sessionUin = [" + avdg.a(this.this$0) + "], locationItem = [" + localavco + "]" });
      }
      if (avdg.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(avdg.a(this.this$0)), " sessionUin: ", avdg.a(this.this$0), " locationItem: ", localavco });
        }
        return;
      }
      this.this$0.a(avdg.a(this.this$0), avdg.a(this.this$0).longValue(), localavco);
    }
    for (;;)
    {
      avdg.a(this.this$0).postDelayed(this, avdg.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", avdg.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */