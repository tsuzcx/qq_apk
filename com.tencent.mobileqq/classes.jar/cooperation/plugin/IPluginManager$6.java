package cooperation.plugin;

import android.content.Context;
import biqw;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public final class IPluginManager$6
  implements Runnable
{
  public IPluginManager$6(Context paramContext, biqw parambiqw) {}
  
  public void run()
  {
    PluginProxyService.openService(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Biqw.d, this.jdField_a_of_type_Biqw.b, this.jdField_a_of_type_Biqw.c, this.jdField_a_of_type_Biqw.e, this.jdField_a_of_type_Biqw.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.6
 * JD-Core Version:    0.7.0.1
 */