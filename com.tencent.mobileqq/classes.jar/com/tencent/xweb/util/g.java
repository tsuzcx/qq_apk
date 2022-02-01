package com.tencent.xweb.util;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.xwalk.core.Log;

public class g
{
  public static Object a(Object paramObject, String paramString)
  {
    return a(paramObject, paramString, (Class[])null, new Object[0]);
  }
  
  public static Object a(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Object localObject = paramObject.getClass();
      if (Build.VERSION.SDK_INT > 10) {
        paramArrayOfClass = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
      } else {
        paramArrayOfClass = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass);
      }
      paramArrayOfClass.setAccessible(true);
      localObject = paramVarArgs;
      if (paramVarArgs.length == 0) {
        localObject = null;
      }
      paramObject = paramArrayOfClass.invoke(paramObject, (Object[])localObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      if ((paramObject.getCause() != null) && (paramObject.getCause().toString().contains("AuthenticationFail"))) {
        return new String("AuthenticationFail");
      }
      if ((paramString != null) && ((paramString.equalsIgnoreCase("canLoadX5Core")) || (paramString.equalsIgnoreCase("initTesRuntimeEnvironment")))) {
        return null;
      }
      paramString = new StringWriter();
      paramObject.printStackTrace(new PrintWriter(paramString));
      paramObject = new StringBuilder();
      paramObject.append("invokeInstance -- exceptions:");
      paramObject.append(paramString.toString());
      Log.e("ReflectionUtils", paramObject.toString());
    }
    return null;
  }
  
  public static Object a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static Object a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, new Class[0]).invoke(null, new Object[0]);
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramString1.setAccessible(true);
      paramString1 = paramString1.invoke(null, paramVarArgs);
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.g
 * JD-Core Version:    0.7.0.1
 */