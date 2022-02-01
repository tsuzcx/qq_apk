package com.tencent.rmonitor.common.util;

import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/Reflect;", "", "()V", "TAG", "", "getInstancePrivateField", "instance", "filedName", "getThreadPrivateField", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class Reflect
{
  public static final Reflect a = new Reflect();
  
  @Nullable
  public final Object a(@NotNull Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "instance");
    Intrinsics.checkParameterIsNotNull(paramString, "filedName");
    try
    {
      localObject = Thread.class.getDeclaredField(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread::class.java.getDeclaredField(filedName)");
      ((Field)localObject).setAccessible(true);
      paramObject = ((Field)localObject).get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      Object localObject = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getThreadPrivateField ");
      localStringBuilder.append(paramString);
      ((Logger)localObject).d(new String[] { "RMonitor_common_Reflect", localStringBuilder.toString(), paramObject.toString() });
    }
    return null;
  }
  
  @Nullable
  public final Object b(@NotNull Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "instance");
    Intrinsics.checkParameterIsNotNull(paramString, "filedName");
    try
    {
      localObject = paramObject.getClass().getDeclaredField(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "instance.javaClass.getDeclaredField(filedName)");
      ((Field)localObject).setAccessible(true);
      paramObject = ((Field)localObject).get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      Object localObject = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInstancePrivateField ");
      localStringBuilder.append(paramString);
      ((Logger)localObject).d(new String[] { "RMonitor_common_Reflect", localStringBuilder.toString(), paramObject.toString() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.Reflect
 * JD-Core Version:    0.7.0.1
 */