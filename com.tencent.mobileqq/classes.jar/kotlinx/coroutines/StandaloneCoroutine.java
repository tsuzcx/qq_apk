package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "handleJobException", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
class StandaloneCoroutine
  extends AbstractCoroutine<Unit>
{
  public StandaloneCoroutine(@NotNull CoroutineContext paramCoroutineContext, boolean paramBoolean)
  {
    super(paramCoroutineContext, paramBoolean);
  }
  
  protected boolean handleJobException(@NotNull Throwable paramThrowable)
  {
    CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), paramThrowable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.StandaloneCoroutine
 * JD-Core Version:    0.7.0.1
 */