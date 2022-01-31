package cooperation.qzone.video;

import com.tencent.mobileqq.myapp.net.Http;
import com.tencent.mobileqq.myapp.net.HttpResponseException;
import com.tencent.qphone.base.util.QLog;

public class TcSdkDownloadReportServlet$ReportRunnable
  implements Runnable
{
  private String jdField_a_of_type_JavaLangString;
  
  public TcSdkDownloadReportServlet$ReportRunnable(TcSdkDownloadReportServlet paramTcSdkDownloadReportServlet, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TcSdkDownloadReportServlet", 4, "tcSdkReport, report:" + this.jdField_a_of_type_JavaLangString);
      }
      Http.a(this.jdField_a_of_type_JavaLangString, null, "GET", null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.TcSdkDownloadReportServlet.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */