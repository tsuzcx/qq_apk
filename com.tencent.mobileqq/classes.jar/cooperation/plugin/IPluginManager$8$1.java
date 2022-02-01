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
      if (this.this$0.a.o != null) {
        this.this$0.b.bindService(this.this$0.a.j, this.this$0.a.o, 1);
      } else {
        this.this$0.b.startService(this.this$0.a.j);
      }
      PluginReporter.a(this.this$0.a, true);
    }
    catch (Exception localException)
    {
      QLog.e("plugin_tag", 1, "launch df plugin service error! ", localException);
      PluginReporter.a(this.this$0.a, false);
    }
    this.this$0.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.8.1
 * JD-Core Version:    0.7.0.1
 */