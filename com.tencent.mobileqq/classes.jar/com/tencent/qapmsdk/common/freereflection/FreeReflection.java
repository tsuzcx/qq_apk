package com.tencent.qapmsdk.common.freereflection;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.AndroidVersion.Companion;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/freereflection/FreeReflection;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class FreeReflection
{
  public static final FreeReflection.Companion Companion;
  private static final String TAG = "QAPM_common_FreeReflection";
  private static Method setHiddenApiExemptions;
  private static Object vmRuntime;
  
  static
  {
    Object localObject3 = null;
    Companion = new FreeReflection.Companion(null);
    if (AndroidVersion.Companion.isP()) {}
    label232:
    label237:
    for (;;)
    {
      try
      {
        Object localObject1 = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
        Method localMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, new Class[0].getClass() });
        Object localObject4 = ((Method)localObject1).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
        localObject1 = localObject4;
        if (!(localObject4 instanceof Class)) {
          localObject1 = null;
        }
        Class localClass = (Class)localObject1;
        localObject4 = localMethod.invoke(localClass, new Object[] { "getRuntime", null });
        localObject1 = localObject4;
        if (!(localObject4 instanceof Method)) {
          localObject1 = null;
        }
        localObject1 = (Method)localObject1;
        if (localObject1 == null) {
          break label232;
        }
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
        vmRuntime = localObject1;
        localObject1 = localMethod.invoke(localClass, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
        if ((localObject1 instanceof Method)) {
          break label237;
        }
        localObject1 = localObject3;
        setHiddenApiExemptions = (Method)localObject1;
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_common_FreeReflection", "reflect bootstrap failed:", localThrowable.toString() });
      }
      return;
      Object localObject2 = null;
    }
  }
  
  @JvmStatic
  public static final boolean unseal(@NotNull String... paramVarArgs)
  {
    return Companion.unseal(paramVarArgs);
  }
  
  @JvmStatic
  public static final boolean unsealAll()
  {
    return Companion.unsealAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.freereflection.FreeReflection
 * JD-Core Version:    0.7.0.1
 */