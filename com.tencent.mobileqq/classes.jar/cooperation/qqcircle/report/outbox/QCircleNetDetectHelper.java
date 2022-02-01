package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.qcircle.api.requests.QCircleClientReportRequest;
import java.util.ArrayList;

public class QCircleNetDetectHelper
{
  private static final String TAG = "QCircleNetCheckHelper";
  
  public static void detectQCircleNetConnection(QCircleNetDetectHelper.DetectListener paramDetectListener)
  {
    QCircleClientReportRequest localQCircleClientReportRequest = new QCircleClientReportRequest(new ArrayList());
    VSNetworkHelper.getInstance().sendRequest(localQCircleClientReportRequest, new QCircleNetDetectHelper.1(paramDetectListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleNetDetectHelper
 * JD-Core Version:    0.7.0.1
 */