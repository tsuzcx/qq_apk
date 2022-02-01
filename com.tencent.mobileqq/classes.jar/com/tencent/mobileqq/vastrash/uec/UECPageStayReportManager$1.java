package com.tencent.mobileqq.vastrash.uec;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class UECPageStayReportManager$1
  implements Runnable
{
  UECPageStayReportManager$1(UECPageStayReportManager paramUECPageStayReportManager) {}
  
  public void run()
  {
    try
    {
      if (UECPageStayReportManager.a(this.this$0) > 0L) {
        Thread.sleep(UECPageStayReportManager.a(this.this$0));
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    ArrayList localArrayList2 = new ArrayList();
    synchronized (UECPageStayReportManager.a(this.this$0))
    {
      localArrayList2.addAll(UECPageStayReportManager.a(this.this$0));
      UECPageStayReportManager.a(this.this$0).clear();
      UECPageStayReportManager.a(this.this$0).set(false);
      UECPageStayReportManager.a(this.this$0, localArrayList2);
      if (QLog.isDevelopLevel()) {
        QLog.d("UECPageStayReportManager", 4, "report finish!!!");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayReportManager.1
 * JD-Core Version:    0.7.0.1
 */