package cooperation.plugin;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.QReaderHelper;

class PluginPreInstaller$2
  implements Runnable
{
  PluginPreInstaller$2(PluginPreInstaller paramPluginPreInstaller) {}
  
  public void run()
  {
    if (PluginPreInstaller.a(this.this$0) != null) {}
    try
    {
      QReaderHelper.a(1, PluginPreInstaller.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PluginPreInstaller", 2, "installPlugin: load reader offPkg error -> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginPreInstaller.2
 * JD-Core Version:    0.7.0.1
 */