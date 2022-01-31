import com.tencent.biz.pubaccount.QualityReporter.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoReq;

public class now
{
  public static void a(qbu paramqbu)
  {
    ThreadManager.excute(new QualityReporter.1(paramqbu), 16, null, true);
  }
  
  private static void b(cc_sso_report_svr.ReportInfoReq paramReportInfoReq)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), nor.class);
    localNewIntent.putExtra("cmd", "FeedsContentCenter.QualityReport");
    localNewIntent.putExtra("data", paramReportInfoReq.toByteArray());
    localNewIntent.setObserver(new nox(localNewIntent));
    onh.a().startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     now
 * JD-Core Version:    0.7.0.1
 */