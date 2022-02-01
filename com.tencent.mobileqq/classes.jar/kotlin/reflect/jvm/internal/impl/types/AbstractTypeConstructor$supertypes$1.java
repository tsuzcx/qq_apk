package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class AbstractTypeConstructor$supertypes$1
  extends Lambda
  implements Function0<AbstractTypeConstructor.Supertypes>
{
  AbstractTypeConstructor$supertypes$1(AbstractTypeConstructor paramAbstractTypeConstructor)
  {
    super(0);
  }
  
  @NotNull
  public final AbstractTypeConstructor.Supertypes invoke()
  {
    return new AbstractTypeConstructor.Supertypes(this.this$0.computeSupertypes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes.1
 * JD-Core Version:    0.7.0.1
 */