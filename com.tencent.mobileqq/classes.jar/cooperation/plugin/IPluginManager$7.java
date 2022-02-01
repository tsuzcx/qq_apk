package cooperation.plugin;

import android.app.Application;
import android.content.Context;
import com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature;

final class IPluginManager$7
  implements Runnable
{
  IPluginManager$7(IPluginManager.PluginParams paramPluginParams, Context paramContext) {}
  
  public void run()
  {
    LoadCompactDynamicFeature.a().b(this.a.d, (Application)this.b.getApplicationContext());
    this.b.sendBroadcast(this.a.j);
    PluginReporter.a(this.a, true);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.7
 * JD-Core Version:    0.7.0.1
 */