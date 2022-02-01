package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import awir;
import awjj;
import awjk;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(awjj paramawjj) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((awjj.a(this.this$0) != null) && (awjj.a(this.this$0).a() != null)))
    {
      awjj.a(this.this$0, ((Integer)awjj.a(this.this$0).a().first).intValue());
      awjj.a(this.this$0, Long.valueOf(Long.parseLong((String)awjj.a(this.this$0).a().second)));
      awir localawir = awjj.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + awjj.a(this.this$0) + "], sessionUin = [" + awjj.a(this.this$0) + "], locationItem = [" + localawir + "]" });
      }
      if (awjj.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(awjj.a(this.this$0)), " sessionUin: ", awjj.a(this.this$0), " locationItem: ", localawir });
        }
        return;
      }
      this.this$0.a(awjj.a(this.this$0), awjj.a(this.this$0).longValue(), localawir);
    }
    for (;;)
    {
      awjj.a(this.this$0).postDelayed(this, awjj.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", awjj.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */