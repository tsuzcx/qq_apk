package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asHandler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlinx/coroutines/CancelHandlerBase;", "getAsHandler", "(Lkotlinx/coroutines/CancelHandlerBase;)Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/CompletionHandlerBase;", "(Lkotlinx/coroutines/CompletionHandlerBase;)Lkotlin/jvm/functions/Function1;", "invokeIt", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CompletionHandlerKt
{
  @NotNull
  public static final Function1<Throwable, Unit> getAsHandler(@NotNull CancelHandlerBase paramCancelHandlerBase)
  {
    return (Function1)paramCancelHandlerBase;
  }
  
  @NotNull
  public static final Function1<Throwable, Unit> getAsHandler(@NotNull CompletionHandlerBase paramCompletionHandlerBase)
  {
    return (Function1)paramCompletionHandlerBase;
  }
  
  public static final void invokeIt(@NotNull Function1<? super Throwable, Unit> paramFunction1, @Nullable Throwable paramThrowable)
  {
    paramFunction1.invoke(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CompletionHandlerKt
 * JD-Core Version:    0.7.0.1
 */