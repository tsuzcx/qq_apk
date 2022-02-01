package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class LockFreeTaskQueueCore$Companion
{
  public final int addFailReason(long paramLong)
  {
    if ((paramLong & 0x0) != 0L) {
      return 2;
    }
    return 1;
  }
  
  public final long updateHead(long paramLong, int paramInt)
  {
    return ((Companion)this).wo(paramLong, 1073741823L) | paramInt << 0;
  }
  
  public final long updateTail(long paramLong, int paramInt)
  {
    return ((Companion)this).wo(paramLong, 1152921503533105152L) | paramInt << 30;
  }
  
  public final <T> T withState(long paramLong, @NotNull Function2<? super Integer, ? super Integer, ? extends T> paramFunction2)
  {
    return paramFunction2.invoke(Integer.valueOf((int)((0x3FFFFFFF & paramLong) >> 0)), Integer.valueOf((int)((paramLong & 0xC0000000) >> 30)));
  }
  
  public final long wo(long paramLong1, long paramLong2)
  {
    return paramLong1 & (paramLong2 ^ 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion
 * JD-Core Version:    0.7.0.1
 */