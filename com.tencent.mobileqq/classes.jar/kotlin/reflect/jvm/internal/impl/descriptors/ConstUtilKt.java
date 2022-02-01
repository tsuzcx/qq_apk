package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;

public final class ConstUtilKt
{
  public static final boolean canBeUsedForConstVal(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$canBeUsedForConstVal");
    return ((KotlinBuiltIns.isPrimitiveType(paramKotlinType)) || (UnsignedTypes.INSTANCE.isUnsignedType(paramKotlinType))) && ((!TypeUtils.isNullableType(paramKotlinType)) || (KotlinBuiltIns.isString(paramKotlinType)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ConstUtilKt
 * JD-Core Version:    0.7.0.1
 */