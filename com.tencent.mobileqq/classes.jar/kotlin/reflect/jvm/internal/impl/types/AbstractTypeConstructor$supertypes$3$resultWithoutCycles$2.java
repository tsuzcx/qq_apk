package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2
  extends Lambda
  implements Function1<KotlinType, Unit>
{
  AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(AbstractTypeConstructor.supertypes.3 param3)
  {
    super(1);
  }
  
  public final void invoke(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "it");
    this.this$0.this$0.reportSupertypeLoopError(paramKotlinType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes.3.resultWithoutCycles.2
 * JD-Core Version:    0.7.0.1
 */