package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentQueue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/SemaphoreImpl;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addToQueueAndSuspend", "incPermits", "()I", "", "id", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "prev", "newSegment", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", "release", "()V", "resumeNextFromQueue$kotlinx_coroutines_core", "resumeNextFromQueue", "", "tryAcquire", "()Z", "getAvailablePermits", "availablePermits", "I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/sync/Semaphore;", "Lkotlinx/coroutines/internal/SegmentQueue;"}, k=1, mv={1, 1, 16})
final class SemaphoreImpl
  extends SegmentQueue<SemaphoreSegment>
  implements Semaphore
{
  private static final AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
  private static final AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
  static final AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
  private volatile int _availablePermits;
  private volatile long deqIdx;
  volatile long enqIdx;
  private final int permits;
  
  public SemaphoreImpl(int paramInt1, int paramInt2)
  {
    this.permits = paramInt1;
    paramInt1 = this.permits;
    int i = 1;
    if (paramInt1 > 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0)
    {
      paramInt1 = this.permits;
      if ((paramInt2 >= 0) && (paramInt1 >= paramInt2)) {
        paramInt1 = i;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        this._availablePermits = (this.permits - paramInt2);
        this.enqIdx = 0L;
        this.deqIdx = 0L;
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("The number of acquired permits should be in 0..");
      localStringBuilder.append(this.permits);
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Semaphore should have at least 1 permit, but had ");
    localStringBuilder.append(this.permits);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  @Nullable
  public Object acquire(@NotNull Continuation<? super Unit> paramContinuation)
  {
    if (_availablePermits$FU.getAndDecrement(this) > 0) {
      return Unit.INSTANCE;
    }
    paramContinuation = addToQueueAndSuspend(paramContinuation);
    if (paramContinuation == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramContinuation;
    }
    return Unit.INSTANCE;
  }
  
  public int getAvailablePermits()
  {
    return Math.max(this._availablePermits, 0);
  }
  
  public final int incPermits()
  {
    int j;
    do
    {
      j = this._availablePermits;
      int i;
      if (j < this.permits) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        break;
      }
    } while (!_availablePermits$FU.compareAndSet(this, j, j + 1));
    return j;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("The number of released permits cannot be greater than ");
    ((StringBuilder)localObject).append(this.permits);
    localObject = (Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @NotNull
  public SemaphoreSegment newSegment(long paramLong, @Nullable SemaphoreSegment paramSemaphoreSegment)
  {
    return new SemaphoreSegment(paramLong, paramSemaphoreSegment);
  }
  
  public void release()
  {
    if (incPermits() >= 0) {
      return;
    }
    resumeNextFromQueue$kotlinx_coroutines_core();
  }
  
  public final void resumeNextFromQueue$kotlinx_coroutines_core()
  {
    do
    {
      long l;
      do
      {
        localObject1 = (SemaphoreSegment)getHead();
        l = deqIdx$FU.getAndIncrement(this);
        localObject1 = (SemaphoreSegment)getSegmentAndMoveHead((Segment)localObject1, l / SemaphoreKt.access$getSEGMENT_SIZE$p());
      } while (localObject1 == null);
      int i = (int)(l % SemaphoreKt.access$getSEGMENT_SIZE$p());
      localObject2 = SemaphoreKt.access$getRESUMED$p();
      localObject1 = ((SemaphoreSegment)localObject1).acquirers.getAndSet(i, localObject2);
      if (localObject1 == null) {
        return;
      }
    } while (localObject1 == SemaphoreKt.access$getCANCELLED$p());
    Object localObject1 = (Continuation)localObject1;
    Object localObject2 = Unit.INSTANCE;
    Result.Companion localCompanion = Result.Companion;
    ((Continuation)localObject1).resumeWith(Result.constructor-impl(localObject2));
  }
  
  public boolean tryAcquire()
  {
    int i;
    do
    {
      i = this._availablePermits;
      if (i <= 0) {
        return false;
      }
    } while (!_availablePermits$FU.compareAndSet(this, i, i - 1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.SemaphoreImpl
 * JD-Core Version:    0.7.0.1
 */