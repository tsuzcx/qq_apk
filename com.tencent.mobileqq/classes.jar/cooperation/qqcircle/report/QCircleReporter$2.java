package cooperation.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class QCircleReporter$2
  implements Runnable
{
  QCircleReporter$2(QCircleReporter paramQCircleReporter, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QCircleReporter.access$200(this.this$0).size() == 0) {
      return;
    }
    QLog.w("QCircleReporter", 2, "reportCacheDataListToServer size:" + QCircleReporter.access$200(this.this$0).size());
    QLog.d("QCircleReporter", 2, "reportCacheDataListToServerWithSession called");
    Iterator localIterator = QCircleReporter.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((QQCircleReport.SingleDcData)localIterator.next()).byteExtinfo.add(QCircleReportHelper.newEntry("SessionID", this.val$session));
    }
    QCircleReporter.access$300(this.this$0, QCircleReporter.access$200(this.this$0));
    QCircleReporter.access$200(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.2
 * JD-Core Version:    0.7.0.1
 */