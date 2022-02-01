package me.weishu.reflection;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

public class Reflection
{
  private static final int ERROR_EXEMPT_FAILED = -21;
  private static final int ERROR_SET_APPLICATION_FAILED = -20;
  private static final String TAG = "Reflection";
  private static int UNKNOWN;
  private static Object sVmRuntime;
  private static Method setHiddenApiExemptions;
  private static int unsealed;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 28) {}
    try
    {
      Object localObject = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
      Method localMethod1 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
      localObject = (Class)((Method)localObject).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
      Method localMethod2 = (Method)localMethod1.invoke(localObject, new Object[] { "getRuntime", null });
      setHiddenApiExemptions = (Method)localMethod1.invoke(localObject, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
      sVmRuntime = localMethod2.invoke(null, new Object[0]);
      UNKNOWN = -9999;
      unsealed = UNKNOWN;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("Reflection", "reflect bootstrap failed:", localThrowable);
      }
    }
  }
  
  public static boolean exempt(String paramString)
  {
    return exempt(new String[] { paramString });
  }
  
  public static boolean exempt(String... paramVarArgs)
  {
    if ((sVmRuntime == null) || (setHiddenApiExemptions == null)) {
      return false;
    }
    try
    {
      setHiddenApiExemptions.invoke(sVmRuntime, new Object[] { paramVarArgs });
      return true;
    }
    catch (Throwable paramVarArgs) {}
    return false;
  }
  
  public static boolean exemptAll()
  {
    return exempt(new String[] { "L" });
  }
  
  public static int unseal(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 28) {}
    while (exemptAll()) {
      return 0;
    }
    return -21;
  }
  
  private static native int unsealNative(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.reflection.Reflection
 * JD-Core Version:    0.7.0.1
 */