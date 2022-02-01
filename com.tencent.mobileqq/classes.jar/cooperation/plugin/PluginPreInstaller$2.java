package cooperation.plugin;

import blgo;
import blnx;
import com.tencent.qphone.base.util.QLog;

public class PluginPreInstaller$2
  implements Runnable
{
  public PluginPreInstaller$2(blgo paramblgo) {}
  
  public void run()
  {
    if (blgo.a(this.this$0) != null) {}
    try
    {
      blnx.a(1, blgo.a(this.this$0));
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