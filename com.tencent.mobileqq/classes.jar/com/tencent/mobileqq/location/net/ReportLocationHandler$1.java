package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import aqyu;
import aqzm;
import aqzn;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(aqzm paramaqzm) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((aqzm.a(this.this$0) != null) && (aqzm.a(this.this$0).a() != null)))
    {
      aqzm.a(this.this$0, ((Integer)aqzm.a(this.this$0).a().first).intValue());
      aqzm.a(this.this$0, Long.valueOf(Long.parseLong((String)aqzm.a(this.this$0).a().second)));
      aqyu localaqyu = aqzm.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + aqzm.a(this.this$0) + "], sessionUin = [" + aqzm.a(this.this$0) + "], locationItem = [" + localaqyu + "]" });
      }
      if (aqzm.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(aqzm.a(this.this$0)), " sessionUin: ", aqzm.a(this.this$0), " locationItem: ", localaqyu });
        }
        return;
      }
      this.this$0.a(aqzm.a(this.this$0), aqzm.a(this.this$0).longValue(), localaqyu);
    }
    for (;;)
    {
      aqzm.a(this.this$0).postDelayed(this, aqzm.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", aqzm.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */