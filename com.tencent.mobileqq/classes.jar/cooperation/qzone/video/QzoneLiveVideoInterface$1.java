package cooperation.qzone.video;

import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;

final class QzoneLiveVideoInterface$1
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  QzoneLiveVideoInterface$1(String paramString) {}
  
  public void onQzonePluginClientReady(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null) {
      QZonePluginMangerHelper.getQzonePluginClient(QzoneLiveVideoInterface.getContext(), this);
    }
    do
    {
      return;
      paramIQZonePluginManager = paramIQZonePluginManager.queryPlugin(this.val$pluginId);
    } while (paramIQZonePluginManager == null);
    QzoneLiveVideoInterface.access$002(paramIQZonePluginManager.ver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoInterface.1
 * JD-Core Version:    0.7.0.1
 */