package cooperation.qzone.plugin;

import android.content.Context;

final class IQZonePluginManager$5
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  IQZonePluginManager$5(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener) {}
  
  public void onQzonePluginClientReady(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null)
    {
      QZonePluginMangerHelper.getQzonePluginClient(this.val$context, this);
      return;
    }
    paramIQZonePluginManager.readyForLaunch(this.val$context, this.val$pp, this.val$l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.IQZonePluginManager.5
 * JD-Core Version:    0.7.0.1
 */