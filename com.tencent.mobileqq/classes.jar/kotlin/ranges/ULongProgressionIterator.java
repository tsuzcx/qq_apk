package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ULongIterator;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/ULongProgressionIterator;", "Lkotlin/collections/ULongIterator;", "first", "Lkotlin/ULong;", "last", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "nextULong", "()J", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
final class ULongProgressionIterator
  extends ULongIterator
{
  private final long finalElement;
  private boolean hasNext;
  private long next;
  private final long step;
  
  private ULongProgressionIterator(long paramLong1, long paramLong2, long paramLong3)
  {
    this.finalElement = paramLong2;
    if (paramLong3 > 0L) {
      if (UnsignedKt.ulongCompare(paramLong1, paramLong2) <= 0)
      {
        this.hasNext = bool;
        this.step = ULong.constructor-impl(paramLong3);
        if (!this.hasNext) {
          break label78;
        }
      }
    }
    for (;;)
    {
      this.next = paramLong1;
      return;
      bool = false;
      break;
      if (UnsignedKt.ulongCompare(paramLong1, paramLong2) >= 0) {
        break;
      }
      bool = false;
      break;
      label78:
      paramLong1 = this.finalElement;
    }
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public long nextULong()
  {
    long l = this.next;
    if (l == this.finalElement)
    {
      if (!this.hasNext) {
        throw ((Throwable)new NoSuchElementException());
      }
      this.hasNext = false;
      return l;
    }
    this.next = ULong.constructor-impl(this.next + this.step);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.ranges.ULongProgressionIterator
 * JD-Core Version:    0.7.0.1
 */