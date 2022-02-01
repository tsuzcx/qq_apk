package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Delay.DefaultImpls;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k=1, mv={1, 1, 16})
public abstract class HandlerDispatcher
  extends MainCoroutineDispatcher
  implements Delay
{
  @Nullable
  public Object delay(long paramLong, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return Delay.DefaultImpls.delay(this, paramLong, paramContinuation);
  }
  
  @NotNull
  public abstract HandlerDispatcher getImmediate();
  
  @NotNull
  public DisposableHandle invokeOnTimeout(long paramLong, @NotNull Runnable paramRunnable)
  {
    return Delay.DefaultImpls.invokeOnTimeout(this, paramLong, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.android.HandlerDispatcher
 * JD-Core Version:    0.7.0.1
 */