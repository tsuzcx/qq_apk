package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class ReturnsCheck$ReturnsBoolean$1
  extends Lambda
  implements Function1<KotlinBuiltIns, SimpleType>
{
  public static final 1 INSTANCE = new 1();
  
  ReturnsCheck$ReturnsBoolean$1()
  {
    super(1);
  }
  
  @NotNull
  public final SimpleType invoke(@NotNull KotlinBuiltIns paramKotlinBuiltIns)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinBuiltIns, "$receiver");
    paramKotlinBuiltIns = paramKotlinBuiltIns.getBooleanType();
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinBuiltIns, "booleanType");
    return paramKotlinBuiltIns;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean.1
 * JD-Core Version:    0.7.0.1
 */