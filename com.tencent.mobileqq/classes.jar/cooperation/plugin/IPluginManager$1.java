package cooperation.plugin;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class IPluginManager$1
  implements IPluginManager.OnPluginReadyListener
{
  IPluginManager$1(IPluginManager.OnOpenPluginListener paramOnOpenPluginListener) {}
  
  public void a(boolean paramBoolean, Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    bool = paramBoolean;
    if (paramBoolean) {}
    try
    {
      IPluginManager.d(paramContext, paramPluginParams);
      bool = paramBoolean;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("plugin_tag", 2, "launch plugin error", paramContext);
        bool = false;
      }
    }
    if (this.a != null) {
      this.a.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.1
 * JD-Core Version:    0.7.0.1
 */