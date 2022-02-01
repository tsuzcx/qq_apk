package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "first", "", "last", "step", "", "(CCI)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextChar", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class CharProgressionIterator
  extends CharIterator
{
  private final int finalElement;
  private boolean hasNext;
  private int next;
  private final int step;
  
  public CharProgressionIterator(char paramChar1, char paramChar2, int paramInt)
  {
    this.step = paramInt;
    this.finalElement = paramChar2;
    paramInt = this.step;
    boolean bool = true;
    if (paramInt > 0 ? paramChar1 > paramChar2 : paramChar1 < paramChar2) {
      bool = false;
    }
    this.hasNext = bool;
    if (!this.hasNext) {
      paramChar1 = this.finalElement;
    }
    this.next = paramChar1;
  }
  
  public final int getStep()
  {
    return this.step;
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public char nextChar()
  {
    int i = this.next;
    if (i == this.finalElement)
    {
      if (this.hasNext) {
        this.hasNext = false;
      } else {
        throw ((Throwable)new NoSuchElementException());
      }
    }
    else {
      this.next = (this.step + i);
    }
    return (char)i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ranges.CharProgressionIterator
 * JD-Core Version:    0.7.0.1
 */