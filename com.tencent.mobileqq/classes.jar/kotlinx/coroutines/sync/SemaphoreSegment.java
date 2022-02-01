package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/SemaphoreSegment;", "", "id", "prev", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)V", "", "index", "", "cancel", "(I)Z", "", "expected", "value", "cas", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "get", "(I)Ljava/lang/Object;", "getAndSet", "(ILjava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "getRemoved", "()Z", "removed", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/Segment;"}, k=1, mv={1, 1, 16})
final class SemaphoreSegment
  extends Segment<SemaphoreSegment>
{
  private static final AtomicIntegerFieldUpdater cancelledSlots$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreSegment.class, "cancelledSlots");
  @NotNull
  AtomicReferenceArray acquirers = new AtomicReferenceArray(SemaphoreKt.access$getSEGMENT_SIZE$p());
  private volatile int cancelledSlots = 0;
  
  public SemaphoreSegment(long paramLong, @Nullable SemaphoreSegment paramSemaphoreSegment)
  {
    super(paramLong, (Segment)paramSemaphoreSegment);
  }
  
  public final boolean cancel(int paramInt)
  {
    Symbol localSymbol = SemaphoreKt.access$getCANCELLED$p();
    boolean bool;
    if (this.acquirers.getAndSet(paramInt, localSymbol) != SemaphoreKt.access$getRESUMED$p()) {
      bool = true;
    } else {
      bool = false;
    }
    if (cancelledSlots$FU.incrementAndGet(this) == SemaphoreKt.access$getSEGMENT_SIZE$p()) {
      remove();
    }
    return bool;
  }
  
  public final boolean cas(int paramInt, @Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return this.acquirers.compareAndSet(paramInt, paramObject1, paramObject2);
  }
  
  @Nullable
  public final Object get(int paramInt)
  {
    return this.acquirers.get(paramInt);
  }
  
  @Nullable
  public final Object getAndSet(int paramInt, @Nullable Object paramObject)
  {
    return this.acquirers.getAndSet(paramInt, paramObject);
  }
  
  public boolean getRemoved()
  {
    return this.cancelledSlots == SemaphoreKt.access$getSEGMENT_SIZE$p();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SemaphoreSegment[id=");
    localStringBuilder.append(getId());
    localStringBuilder.append(", hashCode=");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.SemaphoreSegment
 * JD-Core Version:    0.7.0.1
 */