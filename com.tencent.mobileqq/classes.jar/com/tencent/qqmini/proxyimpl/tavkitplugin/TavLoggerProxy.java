package com.tencent.qqmini.proxyimpl.tavkitplugin;

import android.util.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;

class TavLoggerProxy
  implements ILog
{
  public static void a()
  {
    Logger.setLevel(3);
    Logger.setLogProxy(new TavLoggerProxy());
  }
  
  public void d(String paramString1, String paramString2)
  {
    QMLog.d("WS_" + paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QMLog.e("WS_" + paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.e("WS_" + paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QMLog.i("WS_" + paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    QMLog.w("WS_" + paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.TavLoggerProxy
 * JD-Core Version:    0.7.0.1
 */