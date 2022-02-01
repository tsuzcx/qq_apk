package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

final class NewCapturedTypeConstructor$1
  extends Lambda
  implements Function0<List<? extends UnwrappedType>>
{
  NewCapturedTypeConstructor$1(List paramList)
  {
    super(0);
  }
  
  @NotNull
  public final List<UnwrappedType> invoke()
  {
    return this.$supertypes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor.1
 * JD-Core Version:    0.7.0.1
 */