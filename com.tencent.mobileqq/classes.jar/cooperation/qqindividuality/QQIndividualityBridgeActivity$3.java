package cooperation.qqindividuality;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;

class QQIndividualityBridgeActivity$3
  extends OnPluginInstallListener.Stub
{
  QQIndividualityBridgeActivity$3(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    String str = String.valueOf(paramInt);
    paramString = HardCodeUtil.a(2131710362);
    if (this.a.b == QQIndividualityBridgeActivity.c) {
      paramString = HardCodeUtil.a(2131710355);
    }
    for (;;)
    {
      IPluginManager.a(str, paramString);
      int i = NetworkUtil.a(this.a);
      QLog.e("QQIndividuality", 2, "install plugin fail: " + paramInt + " and netType = " + i);
      this.a.setResult(1001);
      QQIndividualityBridgeActivity.c(this.a);
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8006A98", 0, 0, str, String.valueOf(i), "", "");
      return;
      if (this.a.b == QQIndividualityBridgeActivity.d) {
        paramString = HardCodeUtil.a(2131710356);
      } else if (this.a.b == QQIndividualityBridgeActivity.e) {
        paramString = HardCodeUtil.a(2131710359);
      }
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity.3
 * JD-Core Version:    0.7.0.1
 */