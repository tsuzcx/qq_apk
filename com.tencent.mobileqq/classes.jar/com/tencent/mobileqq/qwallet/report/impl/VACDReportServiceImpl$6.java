package com.tencent.mobileqq.qwallet.report.impl;

import VACDReport.ReportHeader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class VACDReportServiceImpl$6
  implements Runnable
{
  VACDReportServiceImpl$6(VACDReportServiceImpl paramVACDReportServiceImpl, List paramList) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "handleReponse headers is null or empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VACDReport", 2, "handleReponse, headers= " + this.a);
    }
    synchronized (VACDReportServiceImpl.access$000())
    {
      ArrayList localArrayList = new ArrayList(8);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ReportHeader localReportHeader = (ReportHeader)localIterator.next();
        if (localReportHeader != null)
        {
          if (localReportHeader.result == 0)
          {
            localArrayList.add(Long.valueOf(localReportHeader.seqno));
            VACDReportServiceImpl.access$100(this.this$0).remove(Long.valueOf(localReportHeader.seqno));
          }
          VACDReportServiceImpl.access$1200(this.this$0).remove(Long.valueOf(localReportHeader.seqno));
        }
      }
    }
    if (!localList.isEmpty()) {
      VACDReportServiceImpl.access$200(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */