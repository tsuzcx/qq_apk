package cooperation.plugin;

import android.app.Activity;
import android.content.Context;
import com.tencent.qphone.base.util.QLog;

class IPluginManager$2$1
  implements Runnable
{
  IPluginManager$2$1(IPluginManager.2 param2) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ((Activity)this.this$0.jdField_a_of_type_AndroidContentContext).startActivityForResult(this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a, this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.c);
      } else {
        this.this$0.jdField_a_of_type_AndroidContentContext.startActivity(this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a);
      }
      if (this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$OnOpenPluginListener != null) {
        this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$OnOpenPluginListener.a(true);
      }
      PluginReporter.a(this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, true);
    }
    catch (Exception localException)
    {
      QLog.e("plugin_tag", 1, "launch df plugin service error! ", localException);
      PluginReporter.a(this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, false);
      if (this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$OnOpenPluginListener != null) {
        this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$OnOpenPluginListener.a(false);
      }
    }
    this.this$0.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.2.1
 * JD-Core Version:    0.7.0.1
 */