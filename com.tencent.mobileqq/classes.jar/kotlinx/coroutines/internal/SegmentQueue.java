package kotlinx.coroutines.internal;

import TS;;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/SegmentQueue;", "Lkotlinx/coroutines/internal/Segment;", "S", "<init>", "()V", "startFrom", "", "id", "getSegment", "(Lkotlinx/coroutines/internal/Segment;J)Lkotlinx/coroutines/internal/Segment;", "getSegmentAndMoveHead", "new", "", "moveHeadForward", "(Lkotlinx/coroutines/internal/Segment;)V", "moveTailForward", "prev", "newSegment", "(JLkotlinx/coroutines/internal/Segment;)Lkotlinx/coroutines/internal/Segment;", "getHead", "()Lkotlinx/coroutines/internal/Segment;", "head", "getTail", "tail", "kotlinx-coroutines-core", ""}, k=1, mv={1, 1, 16})
public abstract class SegmentQueue<S extends Segment<S>>
{
  private static final AtomicReferenceFieldUpdater _head$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_head");
  private static final AtomicReferenceFieldUpdater _tail$FU = AtomicReferenceFieldUpdater.newUpdater(SegmentQueue.class, Object.class, "_tail");
  private volatile Object _head;
  private volatile Object _tail;
  
  public SegmentQueue()
  {
    Segment localSegment = newSegment$default(this, 0L, null, 2, null);
    this._head = localSegment;
    this._tail = localSegment;
  }
  
  private final void moveHeadForward(S paramS)
  {
    Segment localSegment;
    do
    {
      localSegment = (Segment)this._head;
      if (localSegment.getId() > paramS.getId()) {
        return;
      }
    } while (!_head$FU.compareAndSet(this, localSegment, paramS));
    paramS.prev = null;
  }
  
  private final void moveTailForward(S paramS)
  {
    Segment localSegment;
    do
    {
      localSegment = (Segment)this._tail;
      if (localSegment.getId() > paramS.getId()) {
        return;
      }
    } while (!_tail$FU.compareAndSet(this, localSegment, paramS));
  }
  
  @NotNull
  protected final S getHead()
  {
    return (Segment)this._head;
  }
  
  @Nullable
  protected final S getSegment(@NotNull S paramS, long paramLong)
  {
    for (Object localObject = paramS; ((Segment)localObject).getId() < paramLong; localObject = paramS)
    {
      Segment localSegment = ((Segment)localObject).getNext();
      paramS = localSegment;
      if (localSegment == null)
      {
        paramS = newSegment(((Segment)localObject).getId() + 1L, (Segment)localObject);
        if (((Segment)localObject).casNext(null, paramS))
        {
          if (((Segment)localObject).getRemoved()) {
            ((Segment)localObject).remove();
          }
          moveTailForward(paramS);
        }
        else
        {
          localObject = ((Segment)localObject).getNext();
          paramS = (TS)localObject;
          if (localObject == null)
          {
            Intrinsics.throwNpe();
            paramS = (TS)localObject;
          }
        }
      }
    }
    if (((Segment)localObject).getId() != paramLong) {
      return null;
    }
    return localObject;
  }
  
  @Nullable
  protected final S getSegmentAndMoveHead(@NotNull S paramS, long paramLong)
  {
    if (paramS.getId() == paramLong) {
      return paramS;
    }
    paramS = getSegment(paramS, paramLong);
    if (paramS != null)
    {
      moveHeadForward(paramS);
      return paramS;
    }
    return null;
  }
  
  @NotNull
  protected final S getTail()
  {
    return (Segment)this._tail;
  }
  
  @NotNull
  public abstract S newSegment(long paramLong, @Nullable S paramS);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.SegmentQueue
 * JD-Core Version:    0.7.0.1
 */