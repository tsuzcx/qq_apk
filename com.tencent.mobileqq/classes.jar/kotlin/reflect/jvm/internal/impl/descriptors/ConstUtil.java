package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class ConstUtil
{
  public static final ConstUtil INSTANCE = new ConstUtil();
  
  @JvmStatic
  public static final boolean canBeUsedForConstVal(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    return ConstUtilKt.canBeUsedForConstVal(paramKotlinType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ConstUtil
 * JD-Core Version:    0.7.0.1
 */