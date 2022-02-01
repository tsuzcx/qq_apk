import com.tencent.biz.pubaccount.QualityReporter.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoReq;

public class olv
{
  public static void a(rqa paramrqa)
  {
    ThreadManager.excute(new QualityReporter.1(paramrqa), 16, null, true);
  }
  
  private static void b(cc_sso_report_svr.ReportInfoReq paramReportInfoReq)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), oln.class);
    localNewIntent.putExtra("cmd", "FeedsContentCenter.QualityReport");
    localNewIntent.putExtra("data", paramReportInfoReq.toByteArray());
    localNewIntent.setObserver(new olw(localNewIntent));
    pkh.a().startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olv
 * JD-Core Version:    0.7.0.1
 */