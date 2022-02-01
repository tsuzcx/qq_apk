package com.tencent.qapmsdk.common.freereflection;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.AndroidVersion.Companion;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/freereflection/FreeReflection$Companion;", "", "()V", "TAG", "", "setHiddenApiExemptions", "Ljava/lang/reflect/Method;", "vmRuntime", "exempt", "", "methods", "", "([Ljava/lang/String;)Z", "exemptAll", "unseal", "unsealAll", "common_release"}, k=1, mv={1, 1, 15})
public final class FreeReflection$Companion
{
  private final boolean exempt(String... paramVarArgs)
  {
    if (FreeReflection.access$getVmRuntime$cp() == null) {
      return false;
    }
    try
    {
      Method localMethod = FreeReflection.access$getSetHiddenApiExemptions$cp();
      if (localMethod != null)
      {
        localMethod.invoke(FreeReflection.access$getVmRuntime$cp(), new Object[] { (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length) });
        return true;
      }
    }
    catch (Throwable paramVarArgs)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_common_FreeReflection", paramVarArgs.toString() });
    }
    return false;
  }
  
  private final boolean exemptAll()
  {
    return ((Companion)this).exempt(new String[] { "L" });
  }
  
  @JvmStatic
  public final boolean unseal(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "methods");
    if (AndroidVersion.Companion.isP()) {
      return ((Companion)this).exempt((String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
    return true;
  }
  
  @JvmStatic
  public final boolean unsealAll()
  {
    if (AndroidVersion.Companion.isP()) {
      return ((Companion)this).exemptAll();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.freereflection.FreeReflection.Companion
 * JD-Core Version:    0.7.0.1
 */