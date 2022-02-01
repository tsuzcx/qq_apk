package cooperation.plugin;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature;
import mqq.os.MqqHandler;

final class IPluginManager$2
  implements Runnable
{
  IPluginManager$2(IPluginManager.PluginParams paramPluginParams, Context paramContext, IPluginManager.OnOpenPluginListener paramOnOpenPluginListener) {}
  
  public void run()
  {
    LoadCompactDynamicFeature.a().a(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b, (Application)this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a.putExtra("extra_is_plugin", true);
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a.putExtra("extra_plugin_id", this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b);
    ThreadManager.getUIHandler().post(new IPluginManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.2
 * JD-Core Version:    0.7.0.1
 */