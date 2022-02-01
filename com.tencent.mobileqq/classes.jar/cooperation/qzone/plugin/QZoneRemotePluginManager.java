package cooperation.qzone.plugin;

import android.os.IInterface;

public abstract interface QZoneRemotePluginManager
  extends IInterface
{
  public abstract boolean cancelInstall(String paramString);
  
  public abstract void installPituSo(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt);
  
  public abstract boolean installPlugin(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt);
  
  public abstract boolean isPluginInstalled(String paramString);
  
  public abstract boolean isReady();
  
  public abstract PluginRecord queryPlugin(String paramString);
  
  public abstract void triggerQQDownloadPtuFilter();
  
  public abstract boolean uninstallPlugin(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneRemotePluginManager
 * JD-Core Version:    0.7.0.1
 */