package com.tencent.mobileqq.qroute;

import android.util.Log;
import com.tencent.mobileqq.qroute.route.ILogger;

final class QRouteConfigBuilder$1
  implements ILogger
{
  public void debug(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void info(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public boolean isColorLevel()
  {
    return true;
  }
  
  public void warning(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public void warning(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.QRouteConfigBuilder.1
 * JD-Core Version:    0.7.0.1
 */