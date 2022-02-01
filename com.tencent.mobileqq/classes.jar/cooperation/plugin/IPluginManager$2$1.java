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
      if ((this.this$0.b instanceof Activity)) {
        ((Activity)this.this$0.b).startActivityForResult(this.this$0.a.j, this.this$0.a.k);
      } else {
        this.this$0.b.startActivity(this.this$0.a.j);
      }
      if (this.this$0.c != null) {
        this.this$0.c.a(true);
      }
      PluginReporter.a(this.this$0.a, true);
    }
    catch (Exception localException)
    {
      QLog.e("plugin_tag", 1, "launch df plugin service error! ", localException);
      PluginReporter.a(this.this$0.a, false);
      if (this.this$0.c != null) {
        this.this$0.c.a(false);
      }
    }
    this.this$0.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.2.1
 * JD-Core Version:    0.7.0.1
 */