package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class AbstractTypeConstructor$supertypes$3$2
  extends Lambda
  implements Function1<TypeConstructor, Collection<? extends KotlinType>>
{
  AbstractTypeConstructor$supertypes$3$2(AbstractTypeConstructor.supertypes.3 param3)
  {
    super(1);
  }
  
  @NotNull
  public final Collection<KotlinType> invoke(@NotNull TypeConstructor paramTypeConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "it");
    return AbstractTypeConstructor.access$computeNeighbours(this.this$0.this$0, paramTypeConstructor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes.3.2
 * JD-Core Version:    0.7.0.1
 */