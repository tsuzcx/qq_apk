package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.log;

import android.content.Context;
import com.tencent.falco.base.libapi.log.LogInterface.LogAdapter;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;

class CustomLogBuilder$1
  implements com.tencent.falco.base.libapi.log.LogInterface
{
  CustomLogBuilder$1(CustomLogBuilder paramCustomLogBuilder) {}
  
  public void clearEventOutput() {}
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogFactory.a().b(paramString1, CustomLogBuilder.a(this.a, paramString2, paramVarArgs));
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogFactory.a().e(paramString1, CustomLogBuilder.a(this.a, paramString2, paramVarArgs));
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogFactory.a().c(paramString1, CustomLogBuilder.a(this.a, paramString2, paramVarArgs));
  }
  
  public void init(LogInterface.LogAdapter paramLogAdapter) {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void printException(String paramString, Throwable paramThrowable)
  {
    printException(paramString, paramThrowable, "");
  }
  
  public void printException(String paramString1, Throwable paramThrowable, String paramString2)
  {
    LogFactory.a().e(paramString1, CustomLogBuilder.a(this.a, paramThrowable, paramString2));
  }
  
  public void printException(Throwable paramThrowable)
  {
    printException("", paramThrowable, "");
  }
  
  public void printStackTrace(Throwable paramThrowable)
  {
    printException("", paramThrowable, "");
  }
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogFactory.a().a(paramString1, CustomLogBuilder.a(this.a, paramString2, paramVarArgs));
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogFactory.a().d(paramString1, CustomLogBuilder.a(this.a, paramString2, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.log.CustomLogBuilder.1
 * JD-Core Version:    0.7.0.1
 */