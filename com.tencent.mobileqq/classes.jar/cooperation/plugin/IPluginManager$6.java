package cooperation.plugin;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.qphone.base.util.QLog;

final class IPluginManager$6
  implements IPluginManager.OnPluginReadyListener
{
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchPluginService onPluginReady.");
      localStringBuilder.append(paramBoolean);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (paramPluginParams.b == 1)
      {
        QShadow.getInstance().startService(paramPluginParams.e, paramPluginParams.h, paramPluginParams.j.getExtras(), new IPluginManager.6.1(this, paramPluginParams));
        return;
      }
      if (paramPluginParams.b == 2)
      {
        IPluginManager.g(paramContext, paramPluginParams);
        return;
      }
      IPluginManager.h(paramContext, paramPluginParams);
      return;
    }
    PluginReporter.a(paramPluginParams, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.6
 * JD-Core Version:    0.7.0.1
 */