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
  public static final FreeReflection.Companion Companion = new FreeReflection.Companion(null);
  private static final String TAG = "QAPM_common_FreeReflection";
  private static Method setHiddenApiExemptions;
  private static Object vmRuntime;
  
  static
  {
    if (AndroidVersion.Companion.isP()) {}
    try
    {
      Object localObject1 = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
      Method localMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, new Class[0].getClass() });
      Object localObject2 = ((Method)localObject1).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
      localObject1 = localObject2;
      if (!(localObject2 instanceof Class)) {
        localObject1 = null;
      }
      Class localClass = (Class)localObject1;
      localObject2 = localMethod.invoke(localClass, new Object[] { "getRuntime", null });
      localObject1 = localObject2;
      if (!(localObject2 instanceof Method)) {
        localObject1 = null;
      }
      localObject1 = (Method)localObject1;
      if (localObject1 != null) {}
      for (localObject1 = ((Method)localObject1).invoke(null, new Object[0]);; localObject1 = null)
      {
        vmRuntime = localObject1;
        localObject2 = localMethod.invoke(localClass, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
        localObject1 = localObject2;
        if (!(localObject2 instanceof Method)) {
          localObject1 = null;
        }
        setHiddenApiExemptions = (Method)localObject1;
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_common_FreeReflection", "reflect bootstrap failed:", localThrowable.toString() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.freereflection.FreeReflection
 * JD-Core Version:    0.7.0.1
 */