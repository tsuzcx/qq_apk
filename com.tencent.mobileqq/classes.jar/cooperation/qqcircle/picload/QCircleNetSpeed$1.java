package cooperation.qqcircle.picload;

import android.net.TrafficStats;
import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.List;

class QCircleNetSpeed$1
  implements Runnable
{
  QCircleNetSpeed$1(QCircleNetSpeed paramQCircleNetSpeed) {}
  
  public void run()
  {
    QCircleNetSpeed.access$100(this.this$0).postDelayed(QCircleNetSpeed.access$000(this.this$0), 10000L);
    float f = (float)((TrafficStats.getTotalRxBytes() - QCircleNetSpeed.access$200(this.this$0)) / 1024L);
    QCircleNetSpeed.access$202(this.this$0, TrafficStats.getTotalRxBytes());
    f /= 9.0F;
    RFLog.d("QCircleNetSpeed", RFLog.USR, "qCircle net speed:" + f + "kb/s");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleReportHelper.newEntry("rate", String.valueOf(f)));
    QCircleQualityReporter.reportImageQualityEvent("net_work_speed", "", "", "", 0, new List[] { localArrayList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleNetSpeed.1
 * JD-Core Version:    0.7.0.1
 */