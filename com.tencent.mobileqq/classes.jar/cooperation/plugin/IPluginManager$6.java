package cooperation.plugin;

import android.content.Context;
import bglq;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public final class IPluginManager$6
  implements Runnable
{
  public IPluginManager$6(Context paramContext, bglq parambglq) {}
  
  public void run()
  {
    PluginProxyService.openService(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bglq.d, this.jdField_a_of_type_Bglq.b, this.jdField_a_of_type_Bglq.c, this.jdField_a_of_type_Bglq.e, this.jdField_a_of_type_Bglq.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.6
 * JD-Core Version:    0.7.0.1
 */