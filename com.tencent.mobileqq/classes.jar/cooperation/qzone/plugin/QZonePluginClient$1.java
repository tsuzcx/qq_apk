package cooperation.qzone.plugin;

import android.content.Context;

class QZonePluginClient$1
  extends OnQZonePluginInstallListner.Stub
{
  QZonePluginClient$1(QZonePluginClient paramQZonePluginClient, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, float paramFloat, long paramLong) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (paramInt == 2)
    {
      this.val$l.onPluginReady(true, this.val$context, this.val$pp);
      return;
    }
    this.val$l.onPluginReady(false, this.val$context, this.val$pp);
  }
  
  public void onInstallFinish(String paramString)
  {
    this.val$l.onPluginReady(true, this.val$context, this.val$pp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginClient.1
 * JD-Core Version:    0.7.0.1
 */