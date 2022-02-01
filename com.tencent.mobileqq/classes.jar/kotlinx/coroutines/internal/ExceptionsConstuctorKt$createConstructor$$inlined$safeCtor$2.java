package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, k=3, mv={1, 1, 16})
public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2
  extends Lambda
  implements Function1<Throwable, Throwable>
{
  public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(Constructor paramConstructor)
  {
    super(1);
  }
  
  @Nullable
  public final Throwable invoke(@NotNull Throwable paramThrowable)
  {
    Object localObject;
    try
    {
      localObject = Result.Companion;
      paramThrowable = this.$constructor$inlined.newInstance(new Object[] { paramThrowable });
      if (paramThrowable != null) {
        paramThrowable = Result.constructor-impl((Throwable)paramThrowable);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
      }
    }
    catch (Throwable paramThrowable)
    {
      localObject = Result.Companion;
      paramThrowable = Result.constructor-impl(ResultKt.createFailure(paramThrowable));
      localObject = paramThrowable;
      if (Result.isFailure-impl(paramThrowable)) {
        localObject = null;
      }
    }
    return (Throwable)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ExceptionsConstuctorKt.createConstructor..inlined.safeCtor.2
 * JD-Core Version:    0.7.0.1
 */