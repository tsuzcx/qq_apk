package com.tencent.tavcut.utils;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/reflect/Field;", "invoke"}, k=3, mv={1, 1, 16})
final class ReflectUtilsKt$getFieldData$2
  extends Lambda
  implements Function1<Field, Unit>
{
  ReflectUtilsKt$getFieldData$2(Ref.ObjectRef paramObjectRef, Object paramObject)
  {
    super(1);
  }
  
  public final void invoke(@NotNull Field paramField)
  {
    Intrinsics.checkParameterIsNotNull(paramField, "it");
    this.$filedData.element = paramField.get(this.$obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.ReflectUtilsKt.getFieldData.2
 * JD-Core Version:    0.7.0.1
 */