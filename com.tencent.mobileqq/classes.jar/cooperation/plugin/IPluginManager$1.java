package cooperation.plugin;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.qphone.base.util.QLog;

final class IPluginManager$1
  implements IPluginManager.OnPluginReadyListener
{
  IPluginManager$1(IPluginManager.OnOpenPluginListener paramOnOpenPluginListener) {}
  
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openActivityForResult onPluginReady.");
      localStringBuilder.append(paramBoolean);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (paramPluginParams.b == 1)
      {
        QShadow.getInstance().startActivity(paramPluginParams.c, paramPluginParams.f, paramPluginParams.a.getExtras(), new IPluginManager.1.1(this, paramPluginParams));
        return;
      }
      if (paramPluginParams.b == 2)
      {
        IPluginManager.b(paramContext, paramPluginParams, this.a);
        return;
      }
      PluginReporter.a(paramPluginParams, true);
      IPluginManager.d(paramContext, paramPluginParams);
      paramContext = this.a;
      if (paramContext != null) {
        paramContext.a(true);
      }
    }
    else
    {
      paramContext = this.a;
      if (paramContext != null) {
        paramContext.a(false);
      }
      PluginReporter.a(paramPluginParams, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.1
 * JD-Core Version:    0.7.0.1
 */