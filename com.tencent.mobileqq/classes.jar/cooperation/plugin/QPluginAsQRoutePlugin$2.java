package cooperation.plugin;

import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;

class QPluginAsQRoutePlugin$2
  extends OnPluginInstallListener.Stub
{
  QPluginAsQRoutePlugin$2(QPluginAsQRoutePlugin paramQPluginAsQRoutePlugin, IQRoutePluginInstallListener paramIQRoutePluginInstallListener) {}
  
  public void onInstallBegin(String paramString)
  {
    this.a.onInstallBegin(paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    this.a.onInstallDownloadProgress(paramString, paramInt1, paramInt2);
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    this.a.onInstallError(paramString, paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.onInstallFinish(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.QPluginAsQRoutePlugin.2
 * JD-Core Version:    0.7.0.1
 */