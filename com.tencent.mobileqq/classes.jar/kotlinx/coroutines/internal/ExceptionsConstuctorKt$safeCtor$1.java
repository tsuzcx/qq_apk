package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "e", "invoke"}, k=3, mv={1, 1, 16})
public final class ExceptionsConstuctorKt$safeCtor$1
  extends Lambda
  implements Function1<Throwable, Throwable>
{
  public ExceptionsConstuctorKt$safeCtor$1(Function1 paramFunction1)
  {
    super(1);
  }
  
  @Nullable
  public final Throwable invoke(@NotNull Throwable paramThrowable)
  {
    try
    {
      localObject = Result.Companion;
      paramThrowable = Result.constructor-impl((Throwable)this.$block.invoke(paramThrowable));
    }
    catch (Throwable paramThrowable)
    {
      localObject = Result.Companion;
      paramThrowable = Result.constructor-impl(ResultKt.createFailure(paramThrowable));
    }
    Object localObject = paramThrowable;
    if (Result.isFailure-impl(paramThrowable)) {
      localObject = null;
    }
    return (Throwable)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ExceptionsConstuctorKt.safeCtor.1
 * JD-Core Version:    0.7.0.1
 */