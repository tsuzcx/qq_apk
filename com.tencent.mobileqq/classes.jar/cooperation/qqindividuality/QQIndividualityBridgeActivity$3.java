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
    paramString = HardCodeUtil.a(2131710341);
    if (this.a.b == QQIndividualityBridgeActivity.c) {
      paramString = HardCodeUtil.a(2131710334);
    } else if (this.a.b == QQIndividualityBridgeActivity.d) {
      paramString = HardCodeUtil.a(2131710335);
    } else if (this.a.b == QQIndividualityBridgeActivity.e) {
      paramString = HardCodeUtil.a(2131710338);
    }
    IPluginManager.a(str, paramString);
    int i = NetworkUtil.getSystemNetwork(this.a);
    paramString = new StringBuilder();
    paramString.append("install plugin fail: ");
    paramString.append(paramInt);
    paramString.append(" and netType = ");
    paramString.append(i);
    QLog.e("QQIndividuality", 2, paramString.toString());
    this.a.setResult(1001);
    QQIndividualityBridgeActivity.c(this.a);
    ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8006A98", 0, 0, str, String.valueOf(i), "", "");
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityBridgeActivity.3
 * JD-Core Version:    0.7.0.1
 */