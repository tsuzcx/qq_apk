package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

final class LazyWrappedType$refine$1
  extends Lambda
  implements Function0<KotlinType>
{
  LazyWrappedType$refine$1(LazyWrappedType paramLazyWrappedType, KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    super(0);
  }
  
  @NotNull
  public final KotlinType invoke()
  {
    return this.$kotlinTypeRefiner.refineType((KotlinType)LazyWrappedType.access$getComputation$p(this.this$0).invoke());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.LazyWrappedType.refine.1
 * JD-Core Version:    0.7.0.1
 */