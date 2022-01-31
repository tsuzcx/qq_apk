package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import aruk;
import arvc;
import arvd;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(arvc paramarvc) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((arvc.a(this.this$0) != null) && (arvc.a(this.this$0).a() != null)))
    {
      arvc.a(this.this$0, ((Integer)arvc.a(this.this$0).a().first).intValue());
      arvc.a(this.this$0, Long.valueOf(Long.parseLong((String)arvc.a(this.this$0).a().second)));
      aruk localaruk = arvc.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + arvc.a(this.this$0) + "], sessionUin = [" + arvc.a(this.this$0) + "], locationItem = [" + localaruk + "]" });
      }
      if (arvc.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(arvc.a(this.this$0)), " sessionUin: ", arvc.a(this.this$0), " locationItem: ", localaruk });
        }
        return;
      }
      this.this$0.a(arvc.a(this.this$0), arvc.a(this.this$0).longValue(), localaruk);
    }
    for (;;)
    {
      arvc.a(this.this$0).postDelayed(this, arvc.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", arvc.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */