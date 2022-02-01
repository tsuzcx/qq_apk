package dov.com.qq.im.ae.util;

import com.tencent.qphone.base.util.QLog;
import org.light.utils.ILightLogger;

public class AELightLogger
  implements ILightLogger
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d("AELightLog_" + paramString1, 4, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d("AELightLog_" + paramString1, 4, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e("AELightLog_" + paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e("AELightLog_" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i("AELightLog_" + paramString1, 1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i("AELightLog_" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      e(paramString1, paramString2);
      return;
    case 5: 
      w(paramString1, paramString2);
      return;
    case 4: 
      i(paramString1, paramString2);
      return;
    }
    d(paramString1, paramString2);
  }
  
  public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      e(paramString1, paramString2, paramThrowable);
      return;
    case 5: 
      w(paramString1, paramString2, paramThrowable);
      return;
    case 4: 
      i(paramString1, paramString2, paramThrowable);
      return;
    }
    d(paramString1, paramString2, paramThrowable);
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w("AELightLog_" + paramString1, 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.w("AELightLog_" + paramString1, 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.util.AELightLogger
 * JD-Core Version:    0.7.0.1
 */