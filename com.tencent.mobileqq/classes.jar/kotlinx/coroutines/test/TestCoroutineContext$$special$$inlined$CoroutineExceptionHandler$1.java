package kotlinx.coroutines.test;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class TestCoroutineContext$$special$$inlined$CoroutineExceptionHandler$1
  extends AbstractCoroutineContextElement
  implements CoroutineExceptionHandler
{
  public TestCoroutineContext$$special$$inlined$CoroutineExceptionHandler$1(CoroutineContext.Key paramKey, TestCoroutineContext paramTestCoroutineContext)
  {
    super(paramKey);
  }
  
  public void handleException(@NotNull CoroutineContext paramCoroutineContext, @NotNull Throwable paramThrowable)
  {
    ((Collection)TestCoroutineContext.access$getUncaughtExceptions$p(this.this$0)).add(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.test.TestCoroutineContext..special..inlined.CoroutineExceptionHandler.1
 * JD-Core Version:    0.7.0.1
 */