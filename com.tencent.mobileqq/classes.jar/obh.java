import com.tencent.biz.pubaccount.QualityReporter.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoReq;

public class obh
{
  public static void a(rgc paramrgc)
  {
    ThreadManager.excute(new QualityReporter.1(paramrgc), 16, null, true);
  }
  
  private static void b(cc_sso_report_svr.ReportInfoReq paramReportInfoReq)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), oaz.class);
    localNewIntent.putExtra("cmd", "FeedsContentCenter.QualityReport");
    localNewIntent.putExtra("data", paramReportInfoReq.toByteArray());
    localNewIntent.setObserver(new obi(localNewIntent));
    pha.a().startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obh
 * JD-Core Version:    0.7.0.1
 */