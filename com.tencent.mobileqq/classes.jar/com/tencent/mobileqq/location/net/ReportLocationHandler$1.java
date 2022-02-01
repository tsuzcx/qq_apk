package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ReportLocationHandler$1
  implements Runnable
{
  ReportLocationHandler$1(ReportLocationHandler paramReportLocationHandler) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((ReportLocationHandler.a(this.this$0) != null) && (ReportLocationHandler.a(this.this$0).a() != null)))
    {
      ReportLocationHandler.a(this.this$0, ((Integer)ReportLocationHandler.a(this.this$0).a().first).intValue());
      ReportLocationHandler.a(this.this$0, Long.valueOf(Long.parseLong((String)ReportLocationHandler.a(this.this$0).a().second)));
      LocationItem localLocationItem = ReportLocationHandler.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + ReportLocationHandler.a(this.this$0) + "], sessionUin = [" + ReportLocationHandler.a(this.this$0) + "], locationItem = [" + localLocationItem + "]" });
      }
      if (ReportLocationHandler.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(ReportLocationHandler.a(this.this$0)), " sessionUin: ", ReportLocationHandler.a(this.this$0), " locationItem: ", localLocationItem });
        }
        return;
      }
      this.this$0.a(ReportLocationHandler.a(this.this$0), ReportLocationHandler.a(this.this$0).longValue(), localLocationItem);
    }
    for (;;)
    {
      ReportLocationHandler.a(this.this$0).postDelayed(this, ReportLocationHandler.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", ReportLocationHandler.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */