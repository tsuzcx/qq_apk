package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CoroutineExceptionHandlerKt
{
  @NotNull
  public static final CoroutineExceptionHandler CoroutineExceptionHandler(@NotNull Function2<? super CoroutineContext, ? super Throwable, Unit> paramFunction2)
  {
    return (CoroutineExceptionHandler)new CoroutineExceptionHandlerKt.CoroutineExceptionHandler.1(paramFunction2, (CoroutineContext.Key)CoroutineExceptionHandler.Key);
  }
  
  @InternalCoroutinesApi
  public static final void handleCoroutineException(@NotNull CoroutineContext paramCoroutineContext, @NotNull Throwable paramThrowable)
  {
    try
    {
      CoroutineExceptionHandler localCoroutineExceptionHandler = (CoroutineExceptionHandler)paramCoroutineContext.get((CoroutineContext.Key)CoroutineExceptionHandler.Key);
      if (localCoroutineExceptionHandler != null)
      {
        localCoroutineExceptionHandler.handleException(paramCoroutineContext, paramThrowable);
        return;
      }
      CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(paramCoroutineContext, paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(paramCoroutineContext, handlerException(paramThrowable, localThrowable));
    }
  }
  
  @NotNull
  public static final Throwable handlerException(@NotNull Throwable paramThrowable1, @NotNull Throwable paramThrowable2)
  {
    if (paramThrowable1 == paramThrowable2) {
      return paramThrowable1;
    }
    paramThrowable2 = (Throwable)new RuntimeException("Exception while trying to handle coroutine exception", paramThrowable2);
    ExceptionsKt.addSuppressed(paramThrowable2, paramThrowable1);
    return paramThrowable2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineExceptionHandlerKt
 * JD-Core Version:    0.7.0.1
 */