package com.tencent.qmsp.sdk.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class f
{
  private static Context a;
  
  /* Error */
  public static Context a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	com/tencent/qmsp/sdk/base/f:a	Landroid/content/Context;
    //   6: ifnonnull +9 -> 15
    //   9: invokestatic 17	com/tencent/qmsp/sdk/base/f:b	()Landroid/content/Context;
    //   12: putstatic 14	com/tencent/qmsp/sdk/base/f:a	Landroid/content/Context;
    //   15: getstatic 14	com/tencent/qmsp/sdk/base/f:a	Landroid/content/Context;
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: astore_0
    //   25: aload_0
    //   26: athrow
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	5	0	localContext	Context
    //   24	2	0	localObject1	Object
    //   27	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	24	finally
    //   15	19	24	finally
    //   19	22	27	finally
    //   25	27	27	finally
    //   28	31	27	finally
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getApplicationInfo();
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.packageName))) {
        return paramContext.packageName;
      }
      paramContext = a().getPackageName();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static Context b()
  {
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread");
      localObject = (Context)((Class)localObject).getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException) {}catch (SecurityException localSecurityException) {}catch (NoSuchMethodException localNoSuchMethodException) {}catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    localClassNotFoundException.printStackTrace();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.base.f
 * JD-Core Version:    0.7.0.1
 */