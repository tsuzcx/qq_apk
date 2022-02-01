package cooperation.qzone.plugin;

import com.tencent.component.network.module.base.inter.Log;
import com.tencent.qphone.base.util.QLog;

public class QZonePluginDownloaderLog
  implements Log
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public int getLogLevel()
  {
    return 1;
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.w(paramString1, 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloaderLog
 * JD-Core Version:    0.7.0.1
 */