package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class IntProgressionIterator
  extends IntIterator
{
  private final int finalElement;
  private boolean hasNext;
  private int next;
  private final int step;
  
  public IntProgressionIterator(int paramInt1, int paramInt2, int paramInt3)
  {
    this.step = paramInt3;
    this.finalElement = paramInt2;
    paramInt3 = this.step;
    boolean bool = true;
    if (paramInt3 > 0 ? paramInt1 > paramInt2 : paramInt1 < paramInt2) {
      bool = false;
    }
    this.hasNext = bool;
    if (!this.hasNext) {
      paramInt1 = this.finalElement;
    }
    this.next = paramInt1;
  }
  
  public final int getStep()
  {
    return this.step;
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public int nextInt()
  {
    int i = this.next;
    if (i == this.finalElement)
    {
      if (this.hasNext)
      {
        this.hasNext = false;
        return i;
      }
      throw ((Throwable)new NoSuchElementException());
    }
    this.next = (this.step + i);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.ranges.IntProgressionIterator
 * JD-Core Version:    0.7.0.1
 */