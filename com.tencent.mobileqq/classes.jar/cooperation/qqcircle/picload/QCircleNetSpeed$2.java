package cooperation.qqcircle.picload;

import android.net.TrafficStats;
import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.List;

class QCircleNetSpeed$2
  implements Runnable
{
  QCircleNetSpeed$2(QCircleNetSpeed paramQCircleNetSpeed) {}
  
  public void run()
  {
    if (QCircleNetSpeed.access$000(this.this$0))
    {
      RFLog.d("QCircleNetSpeed", RFLog.USR, "QQ on back direct return");
      return;
    }
    QCircleNetSpeed.access$200(this.this$0).postDelayed(QCircleNetSpeed.access$100(this.this$0), 10000L);
    float f = (float)((TrafficStats.getTotalRxBytes() - QCircleNetSpeed.access$300(this.this$0)) / 1024L);
    QCircleNetSpeed.access$302(this.this$0, TrafficStats.getTotalRxBytes());
    f /= 9.0F;
    int i = RFLog.USR;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qCircle net speed:");
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append("kb/s");
    RFLog.d("QCircleNetSpeed", i, ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((List)localObject).add(QCircleReportHelper.newEntry("rate", String.valueOf(f)));
    QCircleQualityReporter.reportImageQualityEvent("net_work_speed", "", "", "", 0, new List[] { localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleNetSpeed.2
 * JD-Core Version:    0.7.0.1
 */