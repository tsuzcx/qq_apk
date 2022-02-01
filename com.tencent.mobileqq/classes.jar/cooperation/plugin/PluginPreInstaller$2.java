package cooperation.plugin;

import bklx;
import bktg;
import com.tencent.qphone.base.util.QLog;

public class PluginPreInstaller$2
  implements Runnable
{
  public PluginPreInstaller$2(bklx parambklx) {}
  
  public void run()
  {
    if (bklx.a(this.this$0) != null) {}
    try
    {
      bktg.a(1, bklx.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PluginPreInstaller", 2, "installPlugin: load reader offPkg error -> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.plugin.PluginPreInstaller.2
 * JD-Core Version:    0.7.0.1
 */