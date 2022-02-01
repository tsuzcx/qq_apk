package cooperation.vip.manager;

import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AdvReportSsoModel;

class GdtGeneralManager$3
  implements Runnable
{
  GdtGeneralManager$3(GdtGeneralManager paramGdtGeneralManager, AdvReportSsoModel paramAdvReportSsoModel) {}
  
  public void run()
  {
    GdtGeneralManager.a(this.this$0, this.this$0.a());
    GdtGeneralServlet.a(this.a, GdtGeneralManager.a(this.this$0));
    QZLog.i("GdtGeneralManager", " @getGdtInfo gdtDeviceInfo == null  sendAdvInfoExposeOrClickReport");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.manager.GdtGeneralManager.3
 * JD-Core Version:    0.7.0.1
 */