package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", "first", "Lkotlin/UInt;", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "nextUInt", "()I", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
final class UIntProgressionIterator
  extends UIntIterator
{
  private final int finalElement;
  private boolean hasNext;
  private int next;
  private final int step;
  
  private UIntProgressionIterator(int paramInt1, int paramInt2, int paramInt3)
  {
    this.finalElement = paramInt2;
    if (paramInt3 > 0) {
      if (UnsignedKt.uintCompare(paramInt1, paramInt2) <= 0)
      {
        this.hasNext = bool;
        this.step = UInt.constructor-impl(paramInt3);
        if (!this.hasNext) {
          break label74;
        }
      }
    }
    for (;;)
    {
      this.next = paramInt1;
      return;
      bool = false;
      break;
      if (UnsignedKt.uintCompare(paramInt1, paramInt2) >= 0) {
        break;
      }
      bool = false;
      break;
      label74:
      paramInt1 = this.finalElement;
    }
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public int nextUInt()
  {
    int i = this.next;
    if (i == this.finalElement)
    {
      if (!this.hasNext) {
        throw ((Throwable)new NoSuchElementException());
      }
      this.hasNext = false;
      return i;
    }
    this.next = UInt.constructor-impl(this.next + this.step);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.UIntProgressionIterator
 * JD-Core Version:    0.7.0.1
 */