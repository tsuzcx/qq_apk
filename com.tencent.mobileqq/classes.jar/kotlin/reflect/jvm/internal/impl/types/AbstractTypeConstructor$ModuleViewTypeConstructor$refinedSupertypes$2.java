package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import org.jetbrains.annotations.NotNull;

final class AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2
  extends Lambda
  implements Function0<List<? extends KotlinType>>
{
  AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(AbstractTypeConstructor.ModuleViewTypeConstructor paramModuleViewTypeConstructor)
  {
    super(0);
  }
  
  @NotNull
  public final List<KotlinType> invoke()
  {
    return KotlinTypeRefinerKt.refineTypes(AbstractTypeConstructor.ModuleViewTypeConstructor.access$getKotlinTypeRefiner$p(this.this$0), (Iterable)this.this$0.this$0.getSupertypes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.ModuleViewTypeConstructor.refinedSupertypes.2
 * JD-Core Version:    0.7.0.1
 */