package com.tencent.mobileqq.location.net;

import android.os.Handler;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ReportLocationHandler$1
  implements Runnable
{
  ReportLocationHandler$1(ReportLocationHandler paramReportLocationHandler, int paramInt, String paramString) {}
  
  public void run()
  {
    QLog.isColorLevel();
    if ((ReportLocationHandler.b(this.this$0) != null) && (ReportLocationHandler.b(this.this$0).a() != null))
    {
      ReportLocationHandler.a(this.this$0, this.a);
      ReportLocationHandler.a(this.this$0, Long.valueOf(Long.parseLong(this.b)));
      LocationItem localLocationItem = ReportLocationHandler.b(this.this$0).a();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uinType = [");
        ((StringBuilder)localObject).append(ReportLocationHandler.c(this.this$0));
        ((StringBuilder)localObject).append("], sessionUin = [");
        ((StringBuilder)localObject).append(ReportLocationHandler.d(this.this$0));
        ((StringBuilder)localObject).append("], locationItem = [");
        ((StringBuilder)localObject).append(localLocationItem);
        ((StringBuilder)localObject).append("]");
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", ((StringBuilder)localObject).toString() });
      }
      if (ReportLocationHandler.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(ReportLocationHandler.c(this.this$0)), " sessionUin: ", ReportLocationHandler.d(this.this$0), " locationItem: ", localLocationItem });
        }
        return;
      }
      Object localObject = this.this$0;
      ReportLocationHandler.a((ReportLocationHandler)localObject, ReportLocationHandler.c((ReportLocationHandler)localObject), ReportLocationHandler.d(this.this$0).longValue(), localLocationItem);
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", ReportLocationHandler.b(this.this$0) });
    }
    ReportLocationHandler.e(this.this$0).postDelayed(this, ReportLocationHandler.f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */