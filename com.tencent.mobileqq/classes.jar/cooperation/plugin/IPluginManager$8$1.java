package cooperation.plugin;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;

class IPluginManager$8$1
  implements Runnable
{
  IPluginManager$8$1(IPluginManager.8 param8) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.jdField_a_of_type_AndroidContentServiceConnection != null) {
        this.this$0.jdField_a_of_type_AndroidContentContext.bindService(this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.jdField_a_of_type_AndroidContentIntent, this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.jdField_a_of_type_AndroidContentServiceConnection, 1);
      } else {
        this.this$0.jdField_a_of_type_AndroidContentContext.startService(this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.jdField_a_of_type_AndroidContentIntent);
      }
      PluginReporter.a(this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, true);
    }
    catch (Exception localException)
    {
      QLog.e("plugin_tag", 1, "launch df plugin service error! ", localException);
      PluginReporter.a(this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, false);
    }
    this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.8.1
 * JD-Core Version:    0.7.0.1
 */