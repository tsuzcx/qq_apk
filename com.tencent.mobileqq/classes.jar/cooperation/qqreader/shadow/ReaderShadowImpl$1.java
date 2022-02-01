package cooperation.qqreader.shadow;

import android.content.Context;
import android.os.Bundle;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.qqreader.utils.Log;

class ReaderShadowImpl$1
  implements Runnable
{
  ReaderShadowImpl$1(ReaderShadowImpl paramReaderShadowImpl, Context paramContext, String paramString1, String paramString2, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback) {}
  
  public void run()
  {
    PluginManager localPluginManager = this.this$0.getPluginManager(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.b);
    Log.c("ReaderShadowImpl", "enter: " + this.jdField_a_of_type_Long + ", frameVersion = " + "5");
    if (localPluginManager != null)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidOsBundle.putString("hostuid", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putString("hostVersion", "8.5.5");
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_frame_version", Integer.valueOf("5").intValue());
      this.jdField_a_of_type_AndroidOsBundle.putLong("entryTime", l);
      localPluginManager.enter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle, new ReaderShadowImpl.1.1(this, l));
      return;
    }
    Log.a("ReaderShadowImpl", "[enter] pluginManager is null !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderShadowImpl.1
 * JD-Core Version:    0.7.0.1
 */