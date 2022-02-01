package cooperation.qqcircle.download;

import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import cooperation.qqcircle.QCircleConstants;

public class QCircleDownloadStrategy
  extends RFWDownloadStrategy
{
  public String getBusinessKey()
  {
    return "QCircleStrategy";
  }
  
  public String getDownloadRootPath()
  {
    return QCircleConstants.QCIRCLE_DOWNLOAD_ROOT_PATH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.download.QCircleDownloadStrategy
 * JD-Core Version:    0.7.0.1
 */