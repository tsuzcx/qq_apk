package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class AbstractTypeConstructor$supertypes$2
  extends Lambda
  implements Function1<Boolean, AbstractTypeConstructor.Supertypes>
{
  public static final 2 INSTANCE = new 2();
  
  AbstractTypeConstructor$supertypes$2()
  {
    super(1);
  }
  
  @NotNull
  public final AbstractTypeConstructor.Supertypes invoke(boolean paramBoolean)
  {
    return new AbstractTypeConstructor.Supertypes((Collection)CollectionsKt.listOf(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes.2
 * JD-Core Version:    0.7.0.1
 */