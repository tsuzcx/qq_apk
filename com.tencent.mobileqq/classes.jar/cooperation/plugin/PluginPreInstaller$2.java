package cooperation.plugin;

import bmhr;
import bmoz;
import com.tencent.qphone.base.util.QLog;

public class PluginPreInstaller$2
  implements Runnable
{
  public PluginPreInstaller$2(bmhr parambmhr) {}
  
  public void run()
  {
    if (bmhr.a(this.this$0) != null) {}
    try
    {
      bmoz.a(1, bmhr.a(this.this$0));
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