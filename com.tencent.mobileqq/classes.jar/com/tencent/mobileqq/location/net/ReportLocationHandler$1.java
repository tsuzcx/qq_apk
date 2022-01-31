package com.tencent.mobileqq.location.net;

import android.os.Handler;
import android.util.Pair;
import arui;
import arva;
import arvb;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReportLocationHandler$1
  implements Runnable
{
  public ReportLocationHandler$1(arva paramarva) {}
  
  public void run()
  {
    if ((!QLog.isColorLevel()) || ((arva.a(this.this$0) != null) && (arva.a(this.this$0).a() != null)))
    {
      arva.a(this.this$0, ((Integer)arva.a(this.this$0).a().first).intValue());
      arva.a(this.this$0, Long.valueOf(Long.parseLong((String)arva.a(this.this$0).a().second)));
      arui localarui = arva.a(this.this$0).a();
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", "uinType = [" + arva.a(this.this$0) + "], sessionUin = [" + arva.a(this.this$0) + "], locationItem = [" + localarui + "]" });
      }
      if (arva.a(this.this$0).get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. stop old heartbeat ", " uinType: ", Integer.valueOf(arva.a(this.this$0)), " sessionUin: ", arva.a(this.this$0), " locationItem: ", localarui });
        }
        return;
      }
      this.this$0.a(arva.a(this.this$0), arva.a(this.this$0).longValue(), localarui);
    }
    for (;;)
    {
      arva.a(this.this$0).postDelayed(this, arva.b());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "report run: invoked. ", " check null: mLocationCallback: ", arva.a(this.this$0) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.ReportLocationHandler.1
 * JD-Core Version:    0.7.0.1
 */