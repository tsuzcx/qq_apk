package cooperation.qzone.plugin;

import android.os.IInterface;

public abstract interface QZoneRemotePluginManager
  extends IInterface
{
  public abstract PluginRecord a(String paramString);
  
  public abstract void a();
  
  public abstract void a(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneRemotePluginManager
 * JD-Core Version:    0.7.0.1
 */