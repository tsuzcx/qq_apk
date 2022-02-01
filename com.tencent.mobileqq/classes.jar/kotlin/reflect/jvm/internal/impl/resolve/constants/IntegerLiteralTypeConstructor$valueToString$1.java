package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class IntegerLiteralTypeConstructor$valueToString$1
  extends Lambda
  implements Function1<KotlinType, String>
{
  public static final 1 INSTANCE = new 1();
  
  IntegerLiteralTypeConstructor$valueToString$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "it");
    return paramKotlinType.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor.valueToString.1
 * JD-Core Version:    0.7.0.1
 */