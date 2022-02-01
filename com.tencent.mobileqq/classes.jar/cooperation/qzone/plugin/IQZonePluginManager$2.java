package cooperation.qzone.plugin;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class IQZonePluginManager$2
  implements IQZonePluginManager.OnPluginReadyListener
{
  public void onPluginReady(boolean paramBoolean, Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      IQZonePluginManager.doLaunchPluginService(paramContext, paramPluginParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.IQZonePluginManager.2
 * JD-Core Version:    0.7.0.1
 */