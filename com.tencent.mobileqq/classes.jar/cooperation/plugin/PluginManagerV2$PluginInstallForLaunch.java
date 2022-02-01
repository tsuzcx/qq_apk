package cooperation.plugin;

import android.app.ProgressDialog;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;

class PluginManagerV2$PluginInstallForLaunch
  extends OnPluginInstallListener.Stub
{
  long a = 0L;
  boolean b;
  private PluginManagerV2.LaunchState d;
  
  public PluginManagerV2$PluginInstallForLaunch(PluginManagerV2 paramPluginManagerV2, PluginManagerV2.LaunchState paramLaunchState)
  {
    this.d = paramLaunchState;
  }
  
  public void onInstallBegin(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInstallBegin.");
    localStringBuilder.append(paramString);
    QLog.d("plugin_tag", 1, localStringBuilder.toString());
    if ((!this.d.b) && (this.d.e != null)) {
      this.d.e.show();
    }
    this.a = System.currentTimeMillis();
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInstallDownloadProgress.");
      localStringBuilder.append(paramString);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    if ((!this.d.b) && (this.d.e != null))
    {
      this.d.e.setMax(paramInt2);
      this.d.e.setProgress(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInstallError.");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("plugin_tag", 1, (String)localObject);
    localObject = this.d;
    if ((localObject != null) && (((PluginManagerV2.LaunchState)localObject).d != null))
    {
      paramString = this.c.d(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        ((PluginManagerV2.LaunchState)localObject).c.f = paramString.mInstalledPath;
      }
      if (!this.b)
      {
        paramString = ((PluginManagerV2.LaunchState)localObject).d;
        if (paramInt != 2) {
          bool = false;
        }
        paramString.a(bool, ((PluginManagerV2.LaunchState)localObject).a, ((PluginManagerV2.LaunchState)localObject).c);
      }
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInstallFinish.");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("plugin_tag", 1, ((StringBuilder)localObject).toString());
    paramString = this.d;
    if ((paramString != null) && (!paramString.b) && (paramString.e != null)) {
      paramString.e.dismiss();
    }
    if ((paramString != null) && (paramString.d != null))
    {
      localObject = PluginManagerV2.a(this.c).c(paramString.c.d);
      if ((localObject != null) && (((PluginInfo)localObject).mInstalledPath != null))
      {
        paramString.c.f = ((PluginInfo)localObject).mInstalledPath;
        paramString.c.a((PluginBaseInfo)localObject);
      }
      if (!this.b)
      {
        paramString.d.a(true, paramString.a, paramString.c);
        PluginManagerV2.a(this.c, paramString.c);
      }
    }
    long l2 = this.a;
    long l1 = 0L;
    if (l2 != 0L) {
      l1 = System.currentTimeMillis() - this.a;
    }
    this.c.a(this.d.c.d, "pluginDownloadCost", l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.PluginInstallForLaunch
 * JD-Core Version:    0.7.0.1
 */