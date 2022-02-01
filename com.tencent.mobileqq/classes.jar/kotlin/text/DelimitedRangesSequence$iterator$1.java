package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class DelimitedRangesSequence$iterator$1
  implements Iterator<IntRange>, KMappedMarker
{
  private int counter;
  private int currentStartIndex;
  @Nullable
  private IntRange nextItem;
  private int nextSearchIndex;
  private int nextState = -1;
  
  DelimitedRangesSequence$iterator$1()
  {
    this.currentStartIndex = RangesKt.coerceIn(DelimitedRangesSequence.access$getStartIndex$p(localDelimitedRangesSequence), 0, DelimitedRangesSequence.access$getInput$p(localDelimitedRangesSequence).length());
    this.nextSearchIndex = this.currentStartIndex;
  }
  
  private final void calcNext()
  {
    if (this.nextSearchIndex < 0)
    {
      this.nextState = 0;
      this.nextItem = ((IntRange)null);
      return;
    }
    if (DelimitedRangesSequence.access$getLimit$p(this.this$0) > 0)
    {
      this.counter += 1;
      if (this.counter >= DelimitedRangesSequence.access$getLimit$p(this.this$0)) {}
    }
    else
    {
      if (this.nextSearchIndex <= DelimitedRangesSequence.access$getInput$p(this.this$0).length()) {
        break label110;
      }
    }
    this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.access$getInput$p(this.this$0)));
    label110:
    Pair localPair;
    for (this.nextSearchIndex = -1;; this.nextSearchIndex = -1)
    {
      this.nextState = 1;
      return;
      localPair = (Pair)DelimitedRangesSequence.access$getGetNextMatch$p(this.this$0).invoke(DelimitedRangesSequence.access$getInput$p(this.this$0), Integer.valueOf(this.nextSearchIndex));
      if (localPair != null) {
        break;
      }
      this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.access$getInput$p(this.this$0)));
    }
    int j = ((Number)localPair.component1()).intValue();
    int i = ((Number)localPair.component2()).intValue();
    this.nextItem = RangesKt.until(this.currentStartIndex, j);
    this.currentStartIndex = (j + i);
    j = this.currentStartIndex;
    if (i == 0) {}
    for (i = 1;; i = 0)
    {
      this.nextSearchIndex = (i + j);
      break;
    }
  }
  
  public final int getCounter()
  {
    return this.counter;
  }
  
  public final int getCurrentStartIndex()
  {
    return this.currentStartIndex;
  }
  
  @Nullable
  public final IntRange getNextItem()
  {
    return this.nextItem;
  }
  
  public final int getNextSearchIndex()
  {
    return this.nextSearchIndex;
  }
  
  public final int getNextState()
  {
    return this.nextState;
  }
  
  public boolean hasNext()
  {
    if (this.nextState == -1) {
      calcNext();
    }
    return this.nextState == 1;
  }
  
  @NotNull
  public IntRange next()
  {
    if (this.nextState == -1) {
      calcNext();
    }
    if (this.nextState == 0) {
      throw ((Throwable)new NoSuchElementException());
    }
    IntRange localIntRange = this.nextItem;
    if (localIntRange == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.ranges.IntRange");
    }
    this.nextItem = ((IntRange)null);
    this.nextState = -1;
    return localIntRange;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final void setCounter(int paramInt)
  {
    this.counter = paramInt;
  }
  
  public final void setCurrentStartIndex(int paramInt)
  {
    this.currentStartIndex = paramInt;
  }
  
  public final void setNextItem(@Nullable IntRange paramIntRange)
  {
    this.nextItem = paramIntRange;
  }
  
  public final void setNextSearchIndex(int paramInt)
  {
    this.nextSearchIndex = paramInt;
  }
  
  public final void setNextState(int paramInt)
  {
    this.nextState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.DelimitedRangesSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */