package cooperation.qqcircle;

import android.support.v4.content.FileProvider;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import java.io.File;
import mqq.app.MobileQQ;

class QCircleConfig$1
  implements RFWDownloader.RFWDownloadListener
{
  QCircleConfig$1(QCircleConfig paramQCircleConfig) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    RFLog.d("QCircleConfig", RFLog.USR, "tryGetSplashVideoAsync onRspCallback " + paramBoolean + ", " + paramString);
    if (paramBoolean)
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.length() > 0L))
      {
        QCircleConfig.access$002(FileProvider.getUriForFile(MobileQQ.getContext(), "com.tencent.mobileqq.fileprovider", paramString));
        RFLog.d("QCircleConfig", RFLog.USR, "tryGetSplashVideoAsync splashVideoPath: " + QCircleConfig.access$000());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.QCircleConfig.1
 * JD-Core Version:    0.7.0.1
 */