package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/Segment;", "S", "", "id", "prev", "<init>", "(JLkotlinx/coroutines/internal/Segment;)V", "expected", "value", "", "casNext", "(Lkotlinx/coroutines/internal/Segment;Lkotlinx/coroutines/internal/Segment;)Z", "next", "", "moveNextToRight", "(Lkotlinx/coroutines/internal/Segment;)V", "movePrevToLeft", "remove", "()V", "J", "getId", "()J", "getNext", "()Lkotlinx/coroutines/internal/Segment;", "getRemoved", "()Z", "removed", "kotlinx-coroutines-core", ""}, k=1, mv={1, 1, 16})
public abstract class Segment<S extends Segment<S>>
{
  private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(Segment.class, Object.class, "_next");
  static final AtomicReferenceFieldUpdater prev$FU = AtomicReferenceFieldUpdater.newUpdater(Segment.class, Object.class, "prev");
  private volatile Object _next;
  private final long id;
  @NotNull
  volatile Object prev;
  
  public Segment(long paramLong, @Nullable S paramS)
  {
    this.id = paramLong;
    this._next = null;
    this.prev = null;
    this.prev = paramS;
  }
  
  private final void moveNextToRight(S paramS)
  {
    Object localObject;
    do
    {
      localObject = this._next;
      if (localObject == null) {
        break;
      }
      localObject = (Segment)localObject;
      if (paramS.id <= ((Segment)localObject).id) {
        return;
      }
    } while (!_next$FU.compareAndSet(this, localObject, paramS));
    return;
    paramS = new TypeCastException("null cannot be cast to non-null type S");
    for (;;)
    {
      throw paramS;
    }
  }
  
  private final void movePrevToLeft(S paramS)
  {
    Segment localSegment;
    do
    {
      localSegment = (Segment)this.prev;
      if (localSegment == null) {
        break;
      }
      if (localSegment.id <= paramS.id) {
        return;
      }
    } while (!prev$FU.compareAndSet(this, localSegment, paramS));
  }
  
  public final boolean casNext(@Nullable S paramS1, @Nullable S paramS2)
  {
    return _next$FU.compareAndSet(this, paramS1, paramS2);
  }
  
  public final long getId()
  {
    return this.id;
  }
  
  @Nullable
  public final S getNext()
  {
    return (Segment)this._next;
  }
  
  public abstract boolean getRemoved();
  
  public final void remove()
  {
    if ((DebugKt.getASSERTIONS_ENABLED()) && (!getRemoved())) {
      throw ((Throwable)new AssertionError());
    }
    Segment localSegment1 = (Segment)this._next;
    if (localSegment1 != null)
    {
      Object localObject = (Segment)this.prev;
      if (localObject != null)
      {
        ((Segment)localObject).moveNextToRight(localSegment1);
        while (((Segment)localObject).getRemoved())
        {
          Segment localSegment2 = (Segment)((Segment)localObject).prev;
          if (localSegment2 == null) {
            break;
          }
          localSegment2.moveNextToRight(localSegment1);
          localObject = localSegment2;
        }
        localSegment1.movePrevToLeft((Segment)localObject);
        while (localSegment1.getRemoved())
        {
          localSegment1 = localSegment1.getNext();
          if (localSegment1 == null) {
            break;
          }
          localSegment1.movePrevToLeft((Segment)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.Segment
 * JD-Core Version:    0.7.0.1
 */