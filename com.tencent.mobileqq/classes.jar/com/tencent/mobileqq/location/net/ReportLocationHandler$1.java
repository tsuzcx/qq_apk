package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import awpi;
import awqa;
import awqb;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(awqa paramawqa) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((awqa.a(this.this$0) != null) && (awqa.a(this.this$0).a() != null)))
    {
      awqa.a(this.this$0, ((Integer)awqa.a(this.this$0).a().first).intValue());
      awqa.a(this.this$0, Long.valueOf(Long.parseLong((String)awqa.a(this.this$0).a().second)));
      awpi localawpi = awqa.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + awqa.a(this.this$0) + "], sessionUin = [" + awqa.a(this.this$0) + "], locationItem = [" + localawpi + "]" });
      }
      if (awqa.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(awqa.a(this.this$0)), " sessionUin: ", awqa.a(this.this$0), " locationItem: ", localawpi });
        }
        return;
      }
      this.this$0.a(awqa.a(this.this$0), awqa.a(this.this$0).longValue(), localawpi);
    }
    for (;;)
    {
      awqa.a(this.this$0).postDelayed(this, awqa.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", awqa.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */