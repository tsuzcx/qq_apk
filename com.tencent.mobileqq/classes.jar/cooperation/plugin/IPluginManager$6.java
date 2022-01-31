package cooperation.plugin;

import android.content.Context;
import bimp;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public final class IPluginManager$6
  implements Runnable
{
  public IPluginManager$6(Context paramContext, bimp parambimp) {}
  
  public void run()
  {
    PluginProxyService.openService(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bimp.d, this.jdField_a_of_type_Bimp.b, this.jdField_a_of_type_Bimp.c, this.jdField_a_of_type_Bimp.e, this.jdField_a_of_type_Bimp.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.6
 * JD-Core Version:    0.7.0.1
 */