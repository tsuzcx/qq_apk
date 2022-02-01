package cooperation.qqcircle;

import android.support.v4.content.FileProvider;
import com.tencent.biz.richframework.download.RFWDownloader.GetFileListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class QCircleConfig$1
  implements RFWDownloader.GetFileListener
{
  QCircleConfig$1(QCircleConfig paramQCircleConfig) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    QLog.d("QCircleConfig", 1, "tryGetSplashVideoAsync onRspCallback " + paramBoolean + ", " + paramString);
    if (paramBoolean)
    {
      paramString = new File(paramString, QCircleConfig.access$000(this.this$0));
      if ((!paramString.exists()) || (paramString.length() <= 0L)) {}
    }
    try
    {
      QCircleConfig.access$102(FileProvider.getUriForFile(MobileQQ.getContext(), "com.tencent.mobileqq.fileprovider", paramString));
      QLog.d("QCircleConfig", 1, "tryGetSplashVideoAsync splashVideoPath: " + QCircleConfig.access$100());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QCircleConfig", 1, paramString.getMessage());
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.QCircleConfig.1
 * JD-Core Version:    0.7.0.1
 */