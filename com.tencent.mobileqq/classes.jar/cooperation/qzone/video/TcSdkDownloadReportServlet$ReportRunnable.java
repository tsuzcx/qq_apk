package cooperation.qzone.video;

import com.tencent.mobileqq.myapp.net.Http;
import com.tencent.mobileqq.myapp.net.HttpResponseException;
import com.tencent.qphone.base.util.QLog;

public class TcSdkDownloadReportServlet$ReportRunnable
  implements Runnable
{
  private String mReportUrl;
  
  public TcSdkDownloadReportServlet$ReportRunnable(TcSdkDownloadReportServlet paramTcSdkDownloadReportServlet, String paramString)
  {
    this.mReportUrl = paramString;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("tcSdkReport, report:");
        localStringBuilder1.append(this.mReportUrl);
        QLog.d("TcSdkDownloadReportServlet", 4, localStringBuilder1.toString());
      }
      Http.a(this.mReportUrl, null, "GET", null);
      if (QLog.isDevelopLevel())
      {
        QLog.d("TcSdkDownloadReportServlet", 4, "report success");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("TcSdkDownloadReportServlet", 2, "", localException);
      return;
    }
    catch (HttpResponseException localHttpResponseException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("TcSdkDownloadReport failed, code=");
      localStringBuilder2.append(localHttpResponseException.getStateCode());
      QLog.w("TcSdkDownloadReportServlet", 2, localStringBuilder2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.video.TcSdkDownloadReportServlet.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */