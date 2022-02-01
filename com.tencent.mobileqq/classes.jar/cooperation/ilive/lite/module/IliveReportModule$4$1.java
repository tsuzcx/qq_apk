package cooperation.ilive.lite.module;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import cooperation.ilive.util.IliveEntranceUtil;
import mqq.app.MobileQQ;

class IliveReportModule$4$1
  implements Runnable
{
  IliveReportModule$4$1(IliveReportModule.4 param4) {}
  
  public void run()
  {
    if ((IliveReportModule.f(this.a.a)) && (IliveEntranceUtil.a(500)))
    {
      QLog.e("IliveReportModule", 1, "ScrollBottomEvent onScrollLoadEndReport");
      QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), "已经全部加载完毕", 0).show();
      IliveLiteDataReport.a().d(IliveReportModule.a(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.4.1
 * JD-Core Version:    0.7.0.1
 */