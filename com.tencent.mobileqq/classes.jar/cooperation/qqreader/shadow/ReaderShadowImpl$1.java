package cooperation.qqreader.shadow;

import android.content.Context;
import android.os.Bundle;
import bfmr;
import bfne;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;

public class ReaderShadowImpl$1
  implements Runnable
{
  public ReaderShadowImpl$1(bfmr parambfmr, long paramLong, Context paramContext, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback) {}
  
  public void run()
  {
    bfne.d("ReaderShadowImpl", "enter: " + this.jdField_a_of_type_Long);
    PluginManager localPluginManager = this.this$0.getPluginManager(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPluginManager != null)
    {
      if ((this.jdField_a_of_type_Long == 1002L) && (bfmr.a(this.this$0)))
      {
        bfne.d("ReaderShadowImpl", "HasLoadPlugin return");
        return;
      }
      bfmr.a(this.this$0, true);
      this.jdField_a_of_type_AndroidOsBundle.putString("hostuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putString("hostVersion", "8.2.6");
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_frame_version", Integer.valueOf("3").intValue());
      localPluginManager.enter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback);
      return;
    }
    bfne.a("ReaderShadowImpl", "[enter] pluginManager is null !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderShadowImpl.1
 * JD-Core Version:    0.7.0.1
 */