package com.tencent.qa.apphook.util;

import com.taobao.android.dexposed.XC_MethodHook;
import com.tencent.qa.apphook.GalileoHookLog;
import java.io.File;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GalileoHookHelper
{
  public static boolean deleteDir(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label64;
        }
        if (!deleteDir(new File(paramFile, arrayOfString[i]))) {
          break;
        }
        i += 1;
      }
    }
    paramFile.delete();
    label64:
    return true;
  }
  
  public static void ensureResolved(Member paramMember)
  {
    if (!Modifier.isStatic(paramMember.getModifiers())) {
      GalileoHookLog.d("not static, ignore.");
    }
    do
    {
      return;
      GalileoHookLog.d(paramMember.getName() + " is static");
    } while (!(paramMember instanceof Method));
    try
    {
      ((Method)paramMember).invoke(null, new Object[0]);
      GalileoHookLog.d("ensure resolved");
      return;
    }
    catch (Exception paramMember) {}
  }
  
  public static String genClassName(Member paramMember)
  {
    return paramMember.getDeclaringClass().getName().replace(".", "_") + "_" + SignatureUtil.sign(paramMember);
  }
  
  public static Class<?>[] getParameterClasses(ClassLoader paramClassLoader, Object[] paramArrayOfObject)
  {
    Object localObject1 = null;
    int i = paramArrayOfObject.length - 1;
    Object localObject2;
    if (i >= 0)
    {
      Object localObject4 = paramArrayOfObject[i];
      if (localObject4 == null) {
        throw new NullPointerException("parameter type must not be null");
      }
      if ((localObject4 instanceof XC_MethodHook)) {}
      for (;;)
      {
        i -= 1;
        break;
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Class[i + 1];
        }
        if ((localObject4 instanceof Class))
        {
          localObject3[i] = ((Class)localObject4);
          localObject1 = localObject3;
        }
        else
        {
          if (!(localObject4 instanceof String)) {
            break label122;
          }
          try
          {
            localObject3[i] = paramClassLoader.loadClass((String)localObject4);
            localObject1 = localObject3;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localObject2 = localObject3;
          }
        }
      }
      label122:
      throw new NullPointerException("parameter type must either be specified as Class or String");
    }
    paramClassLoader = localObject2;
    if (localObject2 == null) {
      paramClassLoader = new Class[0];
    }
    return paramClassLoader;
  }
  
  public static String getSignName(Member paramMember)
  {
    return paramMember.getDeclaringClass().getSimpleName() + "_" + SignatureUtil.sign(paramMember);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.util.GalileoHookHelper
 * JD-Core Version:    0.7.0.1
 */