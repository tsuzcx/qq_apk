package cooperation.qqcircle.picload;

import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.List;

class QCircleFeedPicLoader$7
  implements Runnable
{
  QCircleFeedPicLoader$7(QCircleFeedPicLoader paramQCircleFeedPicLoader, double paramDouble, int paramInt, Option paramOption) {}
  
  public void run()
  {
    QCircleQualityReporter.reportImageQualityEvent("image_load_ret", String.valueOf(this.val$finalTimeCost), String.valueOf(this.val$retCode), this.val$option.getUrl(), this.val$option.mLoadType, new List[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCircleFeedPicLoader.7
 * JD-Core Version:    0.7.0.1
 */