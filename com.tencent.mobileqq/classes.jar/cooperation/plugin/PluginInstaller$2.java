package cooperation.plugin;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PluginInstaller$2
  implements Dex2Oat.ResultCallback
{
  PluginInstaller$2(PluginInstaller paramPluginInstaller) {}
  
  public void a(File paramFile1, File paramFile2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dex2Oat onStart ");
      localStringBuilder.append(paramFile1.getAbsolutePath());
      localStringBuilder.append(" o");
      localStringBuilder.append(paramFile2.getAbsolutePath());
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
  }
  
  public void a(File paramFile1, File paramFile2, File paramFile3)
  {
    if (QLog.isColorLevel())
    {
      paramFile3 = new StringBuilder();
      paramFile3.append("dex2Oat onSuccess ");
      paramFile3.append(paramFile1.getAbsolutePath());
      paramFile3.append(" o");
      paramFile3.append(paramFile2.getAbsolutePath());
      QLog.d("plugin_tag", 2, paramFile3.toString());
    }
  }
  
  public void a(File paramFile1, File paramFile2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("preDex2Oat onFailed ");
      paramThrowable.append(paramFile1.getAbsolutePath());
      paramThrowable.append(" o");
      paramThrowable.append(paramFile2.getAbsolutePath());
      QLog.d("plugin_tag", 2, paramThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginInstaller.2
 * JD-Core Version:    0.7.0.1
 */