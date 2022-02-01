package cooperation.plugin;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class IPluginManager$5
  implements IPluginManager.OnPluginReadyListener
{
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      IPluginManager.f(paramContext, paramPluginParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.5
 * JD-Core Version:    0.7.0.1
 */