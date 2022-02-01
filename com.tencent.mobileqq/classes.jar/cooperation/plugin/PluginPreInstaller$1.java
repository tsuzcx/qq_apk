package cooperation.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.qqreader.QRProcessManager;

class PluginPreInstaller$1
  implements OnPluginInstallListener
{
  PluginPreInstaller$1(PluginPreInstaller paramPluginPreInstaller) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if ("qqreaderplugin.apk".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "PluginPreInstaller onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
      }
      ReportController.b(PluginPreInstaller.a(this.a), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, paramInt, "", "", "", "");
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PluginPreInstaller", 2, "PluginReinstallInWiFi finish,plugin:" + paramString);
    }
    Object localObject;
    if ("qqreaderplugin.apk".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "PluginPreInstaller onInstallFinish, pluginId = " + paramString);
      }
      ReportController.b(PluginPreInstaller.a(this.a), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, 0, "", "", "", "");
      localObject = (QRProcessManager)PluginPreInstaller.a(this.a).getManager(QQManagerFactory.QR_PROCESS_MANAGER);
      if (localObject != null) {
        ((QRProcessManager)localObject).a();
      }
    }
    for (;;)
    {
      localObject = new Intent("com.tencent.mobileqq.cooperation.plugin." + paramString);
      ((Intent)localObject).putExtra("plugin", paramString);
      PluginPreInstaller.a(this.a).sendBroadcast((Intent)localObject);
      return;
      if ("comic_plugin.apk".equals(paramString)) {
        QQComicPluginBridge.a(PluginPreInstaller.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginPreInstaller.1
 * JD-Core Version:    0.7.0.1
 */