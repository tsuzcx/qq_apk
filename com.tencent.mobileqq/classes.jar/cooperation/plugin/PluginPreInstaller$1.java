package cooperation.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PluginPreInstaller onInstallError, pluginId = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", errorCode = ");
        localStringBuilder.append(paramInt);
        QLog.d("PluginPreInstaller", 2, localStringBuilder.toString());
      }
      ReportController.b(PluginPreInstaller.a(this.a), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, paramInt, "", "", "", "");
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PluginReinstallInWiFi finish,plugin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("PluginPreInstaller", 2, ((StringBuilder)localObject).toString());
    }
    if ("comic_plugin.apk".equals(paramString)) {
      ((IQQComicPluginUtil)QRoute.api(IQQComicPluginUtil.class)).loadComicModule(PluginPreInstaller.a(this.a));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("com.tencent.mobileqq.cooperation.plugin.");
    ((StringBuilder)localObject).append(paramString);
    localObject = new Intent(((StringBuilder)localObject).toString());
    ((Intent)localObject).putExtra("plugin", paramString);
    PluginPreInstaller.a(this.a).sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginPreInstaller.1
 * JD-Core Version:    0.7.0.1
 */