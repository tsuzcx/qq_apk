package cooperation.plugin;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class IPluginManager$4
  implements IPluginManager.OnPluginReadyListener
{
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      IPluginManager.e(paramContext, paramPluginParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.4
 * JD-Core Version:    0.7.0.1
 */