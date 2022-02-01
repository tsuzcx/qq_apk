package cooperation.plugin;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class IPluginManager$5
  implements IPluginManager.OnPluginReadyListener
{
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchPluginBroadcast onPluginReady.");
      localStringBuilder.append(paramBoolean);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (paramPluginParams.b == 2)
      {
        IPluginManager.e(paramContext, paramPluginParams);
        return;
      }
      IPluginManager.f(paramContext, paramPluginParams);
      return;
    }
    PluginReporter.a(paramPluginParams, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.5
 * JD-Core Version:    0.7.0.1
 */