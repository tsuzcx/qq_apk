package cooperation.plugin;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

final class IPluginManager$9
  implements Runnable
{
  IPluginManager$9(Context paramContext, IPluginManager.PluginParams paramPluginParams) {}
  
  public void run()
  {
    PluginProxyService.openService(this.a, this.b.g, this.b.d, this.b.f, this.b.h, this.b.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.9
 * JD-Core Version:    0.7.0.1
 */