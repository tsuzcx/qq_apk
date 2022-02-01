package com.tencent.tbs.one.impl.a;

import android.util.Log;
import java.util.Locale;

public final class f
{
  private static f.a a = new f.a((byte)0);
  
  private static String a(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null) {
      if ((paramThrowable != null) || (paramVarArgs.length <= 0))
      {
        str = paramString;
        if (paramVarArgs.length <= 1) {}
      }
      else
      {
        str = String.format(Locale.US, paramString, paramVarArgs);
      }
    }
    paramString = str;
    if (paramThrowable != null)
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append('\n');
      paramString.append(Log.getStackTraceString(paramThrowable));
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  private static Throwable a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length == 0) {
        return null;
      }
      paramArrayOfObject = paramArrayOfObject[(paramArrayOfObject.length - 1)];
      if (!(paramArrayOfObject instanceof Throwable)) {
        return null;
      }
      return (Throwable)paramArrayOfObject;
    }
    return null;
  }
  
  public static void a(f.b paramb)
  {
    a.a = paramb;
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    paramString = a(paramString, a(paramVarArgs), paramVarArgs);
    a.a(4, paramString);
  }
  
  public static void a(boolean paramBoolean)
  {
    a.b = paramBoolean;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    paramString = a(paramString, a(paramVarArgs), paramVarArgs);
    a.a(5, paramString);
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    paramString = a(paramString, a(paramVarArgs), paramVarArgs);
    a.a(6, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.f
 * JD-Core Version:    0.7.0.1
 */