package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface CoroutineExceptionHandler
  extends CoroutineContext.Element
{
  public static final CoroutineExceptionHandler.Key Key = CoroutineExceptionHandler.Key.$$INSTANCE;
  
  public abstract void handleException(@NotNull CoroutineContext paramCoroutineContext, @NotNull Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineExceptionHandler
 * JD-Core Version:    0.7.0.1
 */