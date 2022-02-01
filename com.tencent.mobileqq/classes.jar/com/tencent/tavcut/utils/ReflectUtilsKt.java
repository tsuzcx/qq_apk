package com.tencent.tavcut.utils;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getFieldData", "", "obj", "exceptedFieldNames", "", "", "(Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/Object;", "fieldName", "reflectField", "", "callback", "Lkotlin/Function1;", "Ljava/lang/reflect/Field;", "lib_tavcut_release"}, k=2, mv={1, 1, 16})
public final class ReflectUtilsKt
{
  @Nullable
  public static final Object a(@NotNull Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    Intrinsics.checkParameterIsNotNull(paramString, "fieldName");
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = null;
    a(paramObject, paramString, (Function1)new ReflectUtilsKt.getFieldData.2(localObjectRef, paramObject));
    return localObjectRef.element;
  }
  
  @Nullable
  public static final Object a(@NotNull Object paramObject, @NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "exceptedFieldNames");
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = a(paramObject, paramArrayOfString[i]);
      if (localObject != null) {
        return localObject;
      }
      i += 1;
    }
    return null;
  }
  
  public static final void a(@NotNull Object paramObject, @NotNull String paramString, @NotNull Function1<? super Field, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    Intrinsics.checkParameterIsNotNull(paramString, "fieldName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    try
    {
      paramObject = paramObject.getClass().getDeclaredField(paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "field");
      boolean bool = paramObject.isAccessible();
      paramObject.setAccessible(true);
      paramFunction1.invoke(paramObject);
      paramObject.setAccessible(bool);
      return;
    }
    catch (NoSuchFieldException paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.ReflectUtilsKt
 * JD-Core Version:    0.7.0.1
 */