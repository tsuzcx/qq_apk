package com.tencent.wxop.stat.common;

import android.util.Log;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.g;

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
    if (arrayOfStackTraceElement == null) {}
    for (;;)
    {
      return null;
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if ((!localStackTraceElement.isNativeMethod()) && (!localStackTraceElement.getClassName().equals(Thread.class.getName())) && (!localStackTraceElement.getClassName().equals(getClass().getName()))) {
          return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + "]";
        }
        i += 1;
      }
    }
  }
  
  public final void d(Object paramObject)
  {
    if (isDebugEnable()) {
      debug(paramObject);
    }
  }
  
  public final void debug(Object paramObject)
  {
    Object localObject;
    if (this.c <= 3)
    {
      localObject = a();
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.d(this.a, paramObject);
      localObject = StatConfig.getCustomLogger();
      if (localObject != null) {
        ((g)localObject).e(paramObject);
      }
      return;
    }
  }
  
  public final void e(Object paramObject)
  {
    if (isDebugEnable()) {
      error(paramObject);
    }
  }
  
  public final void e(Throwable paramThrowable)
  {
    if (isDebugEnable()) {
      error(paramThrowable);
    }
  }
  
  public final void error(Object paramObject)
  {
    Object localObject;
    if (this.c <= 6)
    {
      localObject = a();
      if (localObject != null) {
        break label48;
      }
    }
    label48:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.e(this.a, paramObject);
      localObject = StatConfig.getCustomLogger();
      if (localObject != null) {
        ((g)localObject).d(paramObject);
      }
      return;
    }
  }
  
  public final void error(Throwable paramThrowable)
  {
    if (this.c <= 6)
    {
      Log.e(this.a, "", paramThrowable);
      g localg = StatConfig.getCustomLogger();
      if (localg != null) {
        localg.d(paramThrowable);
      }
    }
  }
  
  public final int getLogLevel()
  {
    return this.c;
  }
  
  public final void i(Object paramObject)
  {
    if (isDebugEnable()) {
      info(paramObject);
    }
  }
  
  public final void info(Object paramObject)
  {
    Object localObject;
    if (this.c <= 4)
    {
      localObject = a();
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.i(this.a, paramObject);
      localObject = StatConfig.getCustomLogger();
      if (localObject != null) {
        ((g)localObject).a(paramObject);
      }
      return;
    }
  }
  
  public final boolean isDebugEnable()
  {
    return this.b;
  }
  
  public final void setDebugEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void setLogLevel(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void setTag(String paramString)
  {
    this.a = paramString;
  }
  
  public final void v(Object paramObject)
  {
    if (isDebugEnable()) {
      verbose(paramObject);
    }
  }
  
  public final void verbose(Object paramObject)
  {
    Object localObject;
    if (this.c <= 2)
    {
      localObject = a();
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.v(this.a, paramObject);
      localObject = StatConfig.getCustomLogger();
      if (localObject != null) {
        ((g)localObject).b(paramObject);
      }
      return;
    }
  }
  
  public final void w(Object paramObject)
  {
    if (isDebugEnable()) {
      warn(paramObject);
    }
  }
  
  public final void warn(Object paramObject)
  {
    Object localObject;
    if (this.c <= 5)
    {
      localObject = a();
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.w(this.a, paramObject);
      localObject = StatConfig.getCustomLogger();
      if (localObject != null) {
        ((g)localObject).c(paramObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.common.StatLogger
 * JD-Core Version:    0.7.0.1
 */