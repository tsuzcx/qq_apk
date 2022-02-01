package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

final class IntersectionTypeConstructor$createType$1
  extends Lambda
  implements Function1<KotlinTypeRefiner, SimpleType>
{
  IntersectionTypeConstructor$createType$1(IntersectionTypeConstructor paramIntersectionTypeConstructor)
  {
    super(1);
  }
  
  @NotNull
  public final SimpleType invoke(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return this.this$0.refine(paramKotlinTypeRefiner).createType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.createType.1
 * JD-Core Version:    0.7.0.1
 */