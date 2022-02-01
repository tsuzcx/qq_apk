package com.tencent.videocut.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/GsonUtils$SuperclassExclusionStrategy;", "Lcom/google/gson/ExclusionStrategy;", "()V", "getField", "Ljava/lang/reflect/Field;", "theClass", "Ljava/lang/Class;", "fieldName", "", "isFieldInSuperclass", "", "subclass", "shouldSkipClass", "arg0", "shouldSkipField", "fieldAttributes", "Lcom/google/gson/FieldAttributes;", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class GsonUtils$SuperclassExclusionStrategy
  implements ExclusionStrategy
{
  @NotNull
  public static final SuperclassExclusionStrategy a = new SuperclassExclusionStrategy();
  
  private final boolean a(Class<?> paramClass, String paramString)
  {
    for (paramClass = paramClass.getSuperclass(); paramClass != null; paramClass = paramClass.getSuperclass()) {
      if (b(paramClass, paramString) != null) {
        return true;
      }
    }
    return false;
  }
  
  private final Field b(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public boolean shouldSkipClass(@Nullable Class<?> paramClass)
  {
    return false;
  }
  
  public boolean shouldSkipField(@NotNull FieldAttributes paramFieldAttributes)
  {
    Intrinsics.checkNotNullParameter(paramFieldAttributes, "fieldAttributes");
    String str = paramFieldAttributes.getName();
    Intrinsics.checkNotNullExpressionValue(str, "fieldAttributes.name");
    paramFieldAttributes = paramFieldAttributes.getDeclaringClass();
    Intrinsics.checkNotNullExpressionValue(paramFieldAttributes, "fieldAttributes.declaringClass");
    return a(paramFieldAttributes, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.GsonUtils.SuperclassExclusionStrategy
 * JD-Core Version:    0.7.0.1
 */