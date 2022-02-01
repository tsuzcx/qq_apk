package cooperation.plugin;

import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

final class IPluginManager$3
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "handleOtherProcess onPluginManagerLoaded");
    }
    IPluginManager.a(paramPluginManagerClient);
    IPluginManager.a(null);
    while (!IPluginManager.c().isEmpty())
    {
      paramPluginManagerClient = (IPluginManager.WaitingCommand)IPluginManager.c().poll();
      if (paramPluginManagerClient != null) {
        IPluginManager.b(paramPluginManagerClient.a, paramPluginManagerClient.b, paramPluginManagerClient.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.3
 * JD-Core Version:    0.7.0.1
 */