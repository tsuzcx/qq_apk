package cooperation.qzone.plugin;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

final class IQZonePluginManager$4
  implements Runnable
{
  IQZonePluginManager$4(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, String paramString) {}
  
  public void run()
  {
    PluginProxyService.openService(this.val$context, this.val$pp.mPluginName, this.val$pp.mPluginID, this.val$path, this.val$pp.mConponentName, this.val$pp.mIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.IQZonePluginManager.4
 * JD-Core Version:    0.7.0.1
 */