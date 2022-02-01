package cooperation.qqcircle.report;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class QCircleReporter$3
  implements Runnable
{
  QCircleReporter$3(QCircleReporter paramQCircleReporter, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QCircleReporter.access$200(this.this$0).size() == 0) {
      return;
    }
    RFLog.w("QCircleReporter", RFLog.USR, "reportCacheDataListToServer size:" + QCircleReporter.access$200(this.this$0).size());
    RFLog.d("QCircleReporter", RFLog.USR, "reportCacheDataListToServerWithSession called");
    Iterator localIterator = QCircleReporter.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((QQCircleReport.SingleDcData)localIterator.next()).byteExtinfo.add(QCircleReportHelper.newEntry("SessionID", this.val$session));
    }
    QCircleReporter.access$300(this.this$0, QCircleReporter.access$200(this.this$0));
    QCircleReporter.access$200(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.3
 * JD-Core Version:    0.7.0.1
 */