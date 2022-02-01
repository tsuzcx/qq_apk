package cooperation.qqcircle.report;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportCacheDataListToServer size:");
    ((StringBuilder)localObject).append(QCircleReporter.access$200(this.this$0).size());
    QLog.w("QCircleReporter", 1, ((StringBuilder)localObject).toString());
    QLog.d("QCircleReporter", 1, "reportCacheDataListToServerWithSession called");
    localObject = QCircleReporter.access$200(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QQCircleReport.SingleDcData)((Iterator)localObject).next()).byteExtinfo.add(QCircleReportHelper.newEntry("SessionID", this.val$session));
    }
    localObject = this.this$0;
    QCircleReporter.access$300((QCircleReporter)localObject, QCircleReporter.access$200((QCircleReporter)localObject));
    QCircleReporter.access$200(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReporter.3
 * JD-Core Version:    0.7.0.1
 */