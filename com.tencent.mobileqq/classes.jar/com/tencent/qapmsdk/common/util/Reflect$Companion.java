package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/Reflect$Companion;", "", "()V", "TAG", "", "getInstancePrivateField", "instance", "filedName", "getThreadPrivateField", "common_release"}, k=1, mv={1, 1, 15})
public final class Reflect$Companion
{
  @Nullable
  public final Object getInstancePrivateField(@NotNull Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "instance");
    Intrinsics.checkParameterIsNotNull(paramString, "filedName");
    try
    {
      localObject = paramObject.getClass().getDeclaredField(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "field");
      ((Field)localObject).setAccessible(true);
      paramObject = ((Field)localObject).get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      Object localObject = Logger.INSTANCE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInstancePrivateField ");
      localStringBuilder.append(paramString);
      ((Logger)localObject).d(new String[] { "QAPM_common_Reflect", localStringBuilder.toString(), paramObject.toString() });
    }
    return null;
  }
  
  @Nullable
  public final Object getThreadPrivateField(@NotNull Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "instance");
    Intrinsics.checkParameterIsNotNull(paramString, "filedName");
    try
    {
      localObject = Thread.class.getDeclaredField(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "field");
      ((Field)localObject).setAccessible(true);
      paramObject = ((Field)localObject).get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      Object localObject = Logger.INSTANCE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getThreadPrivateField ");
      localStringBuilder.append(paramString);
      ((Logger)localObject).d(new String[] { "QAPM_common_Reflect", localStringBuilder.toString(), paramObject.toString() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.Reflect.Companion
 * JD-Core Version:    0.7.0.1
 */