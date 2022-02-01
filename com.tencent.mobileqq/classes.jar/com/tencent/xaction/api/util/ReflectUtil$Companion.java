package com.tencent.xaction.api.util;

import android.util.Log;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/ReflectUtil$Companion;", "", "()V", "getClassByName", "Ljava/lang/Class;", "T", "clazzName", "", "getField", "Ljava/lang/reflect/Field;", "clazz", "propName", "setValue", "", "obj", "key", "value", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ReflectUtil$Companion
{
  @Nullable
  public final <T> Class<T> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "clazzName");
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("ReflectUtil", "getClassByName error!", (Throwable)paramString);
    }
    return null;
  }
  
  @JvmStatic
  @Nullable
  public final Field a(@NotNull Class<?> paramClass, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    Intrinsics.checkParameterIsNotNull(paramString, "propName");
    for (;;)
    {
      try
      {
        localObject1 = paramClass.getDeclaredField(paramString);
        return localObject1;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Object localObject1;
        Object localObject2;
        continue;
      }
      try
      {
        if (paramClass.getClass().getSuperclass() != null)
        {
          localObject1 = (Companion)this;
          localObject2 = paramClass.getSuperclass();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "clazz.superclass");
          localObject1 = ((Companion)localObject1).a((Class)localObject2, paramString);
          return localObject1;
        }
        return null;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("class:");
        ((StringBuilder)localObject2).append(paramClass);
        ((StringBuilder)localObject2).append(" propName:");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" getField");
        Log.e("ReflectUtil", ((StringBuilder)localObject2).toString(), (Throwable)localException);
        return null;
      }
    }
  }
  
  @JvmStatic
  public final void a(@NotNull Object paramObject1, @NotNull String paramString, @Nullable Object paramObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject1, "obj");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    try
    {
      Field localField = ((Companion)this).a(paramObject1.getClass(), paramString);
      if (localField != null)
      {
        localField.setAccessible(true);
        localField.set(paramObject1, paramObject2);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("obj:");
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(" key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", value:");
      localStringBuilder.append(paramObject2);
      localStringBuilder.append(" setValue");
      Log.e("ReflectUtil", localStringBuilder.toString(), (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.util.ReflectUtil.Companion
 * JD-Core Version:    0.7.0.1
 */