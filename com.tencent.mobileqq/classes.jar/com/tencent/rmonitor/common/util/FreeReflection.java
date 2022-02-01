package com.tencent.rmonitor.common.util;

import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/FreeReflection;", "", "()V", "TAG", "", "setHiddenApiExemptions", "Ljava/lang/reflect/Method;", "vmRuntime", "exempt", "", "methods", "", "([Ljava/lang/String;)Z", "exemptAll", "unseal", "unsealAll", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class FreeReflection
{
  public static final FreeReflection a = new FreeReflection();
  private static Object b;
  private static Method c;
  
  static
  {
    if (AndroidVersion.a.h()) {}
    for (;;)
    {
      try
      {
        Object localObject1 = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "Class::class.java.getDec…ame\", String::class.java)");
        Method localMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, new Class[0].getClass() });
        Intrinsics.checkExpressionValueIsNotNull(localMethod, "Class::class.java.getDec…<Class<*>>()::class.java)");
        Object localObject3 = ((Method)localObject1).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
        localObject1 = localObject3;
        if (!(localObject3 instanceof Class)) {
          localObject1 = null;
        }
        Class localClass = (Class)localObject1;
        localObject3 = localMethod.invoke(localClass, new Object[] { "getRuntime", null });
        localObject1 = localObject3;
        if (!(localObject3 instanceof Method)) {
          localObject1 = null;
        }
        localObject1 = (Method)localObject1;
        if (localObject1 == null) {
          break label237;
        }
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
        b = localObject1;
        localObject3 = localMethod.invoke(localClass, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
        localObject1 = localObject3;
        if (!(localObject3 instanceof Method)) {
          localObject1 = null;
        }
        c = (Method)localObject1;
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.b.e(new String[] { "RMonitor_common_FreeReflection", "reflect bootstrap failed:", localThrowable.toString() });
      }
      return;
      label237:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.FreeReflection
 * JD-Core Version:    0.7.0.1
 */