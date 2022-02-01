package cooperation.troop;

import android.os.Handler;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class TroopPluginManager$InstallRunable$2
  extends OnPluginInstallListener.Stub
{
  TroopPluginManager$InstallRunable$2(TroopPluginManager.InstallRunable paramInstallRunable) {}
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = TroopPluginManager.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Troop plugin onInstallBegin...  pluginId = ");
      localStringBuilder.append(this.a.b);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString = TroopPluginManager.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Troop plugin onInstallDownloadProgress... pluginId = ");
      localStringBuilder.append(this.a.b);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = TroopPluginManager.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Troop plugin onInstallError... = ");
      localStringBuilder.append(this.a.b);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.a.this$0.c.remove(paramString);
    this.a.c.sendEmptyMessage(1002);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_plugin", "install_plugin", 0, 1, null, null, null, null);
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = TroopPluginManager.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Troop plugin onInstallFinish...   pluginId = ");
      localStringBuilder.append(this.a.b);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.a.this$0.c.remove(paramString);
    this.a.c.sendEmptyMessage(1001);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_plugin", "install_plugin", 0, 0, null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable.2
 * JD-Core Version:    0.7.0.1
 */