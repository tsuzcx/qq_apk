package cooperation.qzone.video;

import autx;
import com.tencent.mobileqq.myapp.net.HttpResponseException;
import com.tencent.qphone.base.util.QLog;

public class TcSdkDownloadReportServlet$ReportRunnable
  implements Runnable
{
  private String a;
  
  public TcSdkDownloadReportServlet$ReportRunnable(TcSdkDownloadReportServlet paramTcSdkDownloadReportServlet, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TcSdkDownloadReportServlet", 4, "tcSdkReport, report:" + this.a);
      }
      autx.a(this.a, null, "GET", null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.video.TcSdkDownloadReportServlet.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */