package com.tencent.rmonitor.common.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/ClassUtil;", "", "()V", "classAvailable", "", "className", "", "getClassName", "obj", "withIndex", "", "(Ljava/lang/Object;Ljava/lang/Integer;)Ljava/lang/String;", "objectIsInstanceClass", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ClassUtil
{
  public static final ClassUtil a = new ClassUtil();
  
  @JvmStatic
  @NotNull
  public static final String a(@NotNull Object paramObject, @Nullable Integer paramInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    if (paramInteger != null)
    {
      int i = ((Number)paramInteger).intValue();
      paramInteger = new StringBuilder();
      paramInteger.append(paramObject.getClass().getName());
      paramInteger.append('[');
      paramInteger.append(i);
      paramInteger.append(']');
      paramInteger = paramInteger.toString();
      if (paramInteger != null) {
        return paramInteger;
      }
    }
    paramObject = paramObject.getClass().getName();
    Intrinsics.checkExpressionValueIsNotNull(paramObject, "obj.javaClass.name");
    return paramObject;
  }
  
  @JvmStatic
  public static final boolean a(@Nullable Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    boolean bool = false;
    if (paramObject != null) {}
    try
    {
      bool = Class.forName(paramString).isInstance(paramObject);
      return bool;
    }
    catch (ClassNotFoundException paramObject) {}
    return false;
  }
  
  @JvmStatic
  public static final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException paramString)
    {
      label13:
      break label13;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.ClassUtil
 * JD-Core Version:    0.7.0.1
 */