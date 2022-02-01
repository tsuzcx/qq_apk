package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class Unconfined
  extends CoroutineDispatcher
{
  public static final Unconfined INSTANCE = new Unconfined();
  
  public void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    paramCoroutineContext = (YieldContext)paramCoroutineContext.get((CoroutineContext.Key)YieldContext.Key);
    if (paramCoroutineContext != null)
    {
      paramCoroutineContext.dispatcherWasUnconfined = true;
      return;
    }
    throw ((Throwable)new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls."));
  }
  
  public boolean isDispatchNeeded(@NotNull CoroutineContext paramCoroutineContext)
  {
    return false;
  }
  
  @NotNull
  public String toString()
  {
    return "Unconfined";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Unconfined
 * JD-Core Version:    0.7.0.1
 */