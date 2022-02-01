package cooperation.plugin;

import android.app.Application;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature;
import mqq.os.MqqHandler;

final class IPluginManager$8
  implements Runnable
{
  IPluginManager$8(IPluginManager.PluginParams paramPluginParams, Context paramContext) {}
  
  public void run()
  {
    LoadCompactDynamicFeature.a().b(this.a.d, (Application)this.b.getApplicationContext());
    ThreadManager.getUIHandler().post(new IPluginManager.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.8
 * JD-Core Version:    0.7.0.1
 */