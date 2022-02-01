package cooperation.qqcircle.picload;

import android.net.TrafficStats;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.List;

class RFWNetSpeed$2
  implements Runnable
{
  RFWNetSpeed$2(RFWNetSpeed paramRFWNetSpeed) {}
  
  public void run()
  {
    if (RFWNetSpeed.access$000(this.this$0))
    {
      QLog.d("QCircleNetSpeed", 1, "QQ on back direct return");
      return;
    }
    RFWNetSpeed.access$200(this.this$0).postDelayed(RFWNetSpeed.access$100(this.this$0), 10000L);
    float f = (float)((TrafficStats.getTotalRxBytes() - RFWNetSpeed.access$300(this.this$0)) / 1024L);
    RFWNetSpeed.access$302(this.this$0, TrafficStats.getTotalRxBytes());
    f /= 9.0F;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qCircle net speed:");
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append("kb/s");
    QLog.d("QCircleNetSpeed", 1, ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((List)localObject).add(QCircleReportHelper.newEntry("rate", String.valueOf(f)));
    QCircleQualityReporter.reportImageQualityEvent("net_work_speed", "", "", "", 0, new List[] { localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWNetSpeed.2
 * JD-Core Version:    0.7.0.1
 */