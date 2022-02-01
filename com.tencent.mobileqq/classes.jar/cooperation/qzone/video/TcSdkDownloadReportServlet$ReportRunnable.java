package cooperation.qzone.video;

import awhh;
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
      if (QLog.isDevelopLevel()) {
        QLog.d("TcSdkDownloadReportServlet", 4, "tcSdkReport, report:" + this.mReportUrl);
      }
      awhh.a(this.mReportUrl, null, "GET", null);
      if (QLog.isDevelopLevel()) {
        QLog.d("TcSdkDownloadReportServlet", 4, "report success");
      }
      return;
    }
    catch (HttpResponseException localHttpResponseException)
    {
      QLog.w("TcSdkDownloadReportServlet", 2, "TcSdkDownloadReport failed, code=" + localHttpResponseException.getStateCode());
      return;
    }
    catch (Exception localException)
    {
      QLog.w("TcSdkDownloadReportServlet", 2, "", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.TcSdkDownloadReportServlet.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */