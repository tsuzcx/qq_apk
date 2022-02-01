package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.Nullable;

final class NewCapturedTypeConstructor$_supertypes$2
  extends Lambda
  implements Function0<List<? extends UnwrappedType>>
{
  NewCapturedTypeConstructor$_supertypes$2(NewCapturedTypeConstructor paramNewCapturedTypeConstructor)
  {
    super(0);
  }
  
  @Nullable
  public final List<UnwrappedType> invoke()
  {
    Function0 localFunction0 = NewCapturedTypeConstructor.access$getSupertypesComputation$p(this.this$0);
    if (localFunction0 != null) {
      return (List)localFunction0.invoke();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor._supertypes.2
 * JD-Core Version:    0.7.0.1
 */