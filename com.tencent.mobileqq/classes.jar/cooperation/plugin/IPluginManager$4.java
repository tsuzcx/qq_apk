package cooperation.plugin;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.qphone.base.util.QLog;

final class IPluginManager$4
  extends OnPluginInstallListener.Stub
{
  IPluginManager$4(IPluginManager.OnPluginReadyListener paramOnPluginReadyListener, IPluginManager.PluginParams paramPluginParams, Context paramContext) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallError");
    }
    paramString = this.a;
    if (paramString != null) {
      paramString.a(false, this.c, this.b);
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("plugin_tag", 4, "doHandleOtherProcess onInstallFinish");
    }
    if (this.a != null)
    {
      paramString = IPluginManager.d().queryPlugin(this.b.d);
      if (paramString != null)
      {
        this.b.f = paramString.mInstalledPath;
        this.b.a(paramString);
      }
      this.a.a(true, this.c, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.4
 * JD-Core Version:    0.7.0.1
 */