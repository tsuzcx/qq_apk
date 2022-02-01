package cooperation.ilive.lite.module;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import cooperation.ilive.util.IliveEntranceUtil;
import mqq.app.MobileQQ;

class IliveReportModule$3$1
  implements Runnable
{
  IliveReportModule$3$1(IliveReportModule.3 param3) {}
  
  public void run()
  {
    if ((IliveReportModule.a(this.a.a)) && (IliveEntranceUtil.a(500)))
    {
      QLog.e("IliveReportModule", 1, "ScrollBottomEvent onScrollLoadEndReport");
      QQToast.a(MobileQQ.sMobileQQ.getApplicationContext(), "已经全部加载完毕", 0).a();
      IliveLiteDataReport.a().d(IliveReportModule.a(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.3.1
 * JD-Core Version:    0.7.0.1
 */