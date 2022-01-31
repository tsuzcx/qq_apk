package com.tencent.stat.common;

import android.util.Log;

public final class StatLogger
{
  private String a = "default";
  private boolean b = true;
  private int c = 2;
  
  public StatLogger() {}
  
  public StatLogger(String paramString)
  {
    this.a = paramString;
  }
  
  private String a()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null) {
      return null;
    }
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    label18:
    StackTraceElement localStackTraceElement;
    if (i < j)
    {
      localStackTraceElement = arrayOfStackTraceElement[i];
      if (!localStackTraceElement.isNativeMethod()) {
        break label43;
      }
    }
    label43:
    while ((localStackTraceElement.getClassName().equals(Thread.class.getName())) || (localStackTraceElement.getClassName().equals(getClass().getName())))
    {
      i += 1;
      break label18;
      break;
    }
    return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + "]";
  }
  
  public void d(Object paramObject)
  {
    if (isDebugEnable()) {
      debug(paramObject);
    }
  }
  
  public void debug(Object paramObject)
  {
    String str;
    if (this.c <= 3)
    {
      str = a();
      if (str != null) {
        break label32;
      }
    }
    label32:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.d(this.a, paramObject);
      return;
    }
  }
  
  public void e(Object paramObject)
  {
    if (isDebugEnable()) {
      error(paramObject);
    }
  }
  
  public void e(Throwable paramThrowable)
  {
    if (isDebugEnable()) {
      error(paramThrowable);
    }
  }
  
  public void error(Object paramObject)
  {
    String str;
    if (this.c <= 6)
    {
      str = a();
      if (str != null) {
        break label33;
      }
    }
    label33:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.e(this.a, paramObject);
      return;
    }
  }
  
  public void error(Throwable paramThrowable)
  {
    if (this.c <= 6) {
      Log.e(this.a, "", paramThrowable);
    }
  }
  
  public int getLogLevel()
  {
    return this.c;
  }
  
  public void i(Object paramObject)
  {
    if (isDebugEnable()) {
      info(paramObject);
    }
  }
  
  public void info(Object paramObject)
  {
    String str;
    if (this.c <= 4)
    {
      str = a();
      if (str != null) {
        break label32;
      }
    }
    label32:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.i(this.a, paramObject);
      return;
    }
  }
  
  public boolean isDebugEnable()
  {
    return this.b;
  }
  
  public void setDebugEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setLogLevel(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setTag(String paramString)
  {
    this.a = paramString;
  }
  
  public void v(Object paramObject)
  {
    if (isDebugEnable()) {
      verbose(paramObject);
    }
  }
  
  public void verbose(Object paramObject)
  {
    String str;
    if (this.c <= 2)
    {
      str = a();
      if (str != null) {
        break label32;
      }
    }
    label32:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.v(this.a, paramObject);
      return;
    }
  }
  
  public void w(Object paramObject)
  {
    if (isDebugEnable()) {
      warn(paramObject);
    }
  }
  
  public void warn(Object paramObject)
  {
    String str;
    if (this.c <= 5)
    {
      str = a();
      if (str != null) {
        break label32;
      }
    }
    label32:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.w(this.a, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.common.StatLogger
 * JD-Core Version:    0.7.0.1
 */