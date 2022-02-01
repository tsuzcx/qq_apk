package cooperation.plugin;

import android.content.Context;
import bmgt;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public final class IPluginManager$6
  implements Runnable
{
  public IPluginManager$6(Context paramContext, bmgt parambmgt) {}
  
  public void run()
  {
    PluginProxyService.openService(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bmgt.d, this.jdField_a_of_type_Bmgt.b, this.jdField_a_of_type_Bmgt.c, this.jdField_a_of_type_Bmgt.e, this.jdField_a_of_type_Bmgt.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.6
 * JD-Core Version:    0.7.0.1
 */