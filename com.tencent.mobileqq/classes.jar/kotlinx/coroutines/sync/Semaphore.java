package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/Semaphore;", "", "availablePermits", "", "getAvailablePermits", "()I", "acquire", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "tryAcquire", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface Semaphore
{
  @Nullable
  public abstract Object acquire(@NotNull Continuation<? super Unit> paramContinuation);
  
  public abstract int getAvailablePermits();
  
  public abstract void release();
  
  public abstract boolean tryAcquire();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.Semaphore
 * JD-Core Version:    0.7.0.1
 */