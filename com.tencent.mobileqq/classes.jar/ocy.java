import com.tencent.aladdin.config.utils.AladdinLogger;
import com.tencent.qphone.base.util.QLog;

public class ocy
  implements AladdinLogger
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 2, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public boolean isDebugVersion()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocy
 * JD-Core Version:    0.7.0.1
 */