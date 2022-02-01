package cooperation.plugin;

import android.os.Bundle;
import mqq.observer.BusinessObserver;
import tencent.im.plugin.ResourceConfig.GetResourceRespV2;

class PluginUpdater$1
  implements BusinessObserver
{
  PluginUpdater$1(PluginUpdater paramPluginUpdater) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ResourceConfig.GetResourceRespV2 localGetResourceRespV2;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      localGetResourceRespV2 = new ResourceConfig.GetResourceRespV2();
    }
    try
    {
      localGetResourceRespV2.mergeFrom(paramBundle);
      this.a.b(true, 128, localGetResourceRespV2);
      return;
    }
    catch (Exception paramBundle)
    {
      label41:
      break label41;
    }
    this.a.b(false, 128, null);
    return;
    this.a.b(false, 128, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginUpdater.1
 * JD-Core Version:    0.7.0.1
 */