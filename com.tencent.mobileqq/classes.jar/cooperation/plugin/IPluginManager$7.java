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
    LoadCompactDynamicFeature.a().a(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b, (Application)this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a);
    PluginReporter.a(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, true);
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.7
 * JD-Core Version:    0.7.0.1
 */