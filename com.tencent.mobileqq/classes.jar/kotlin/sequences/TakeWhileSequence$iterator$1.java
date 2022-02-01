package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class TakeWhileSequence$iterator$1
  implements Iterator<T>, KMappedMarker
{
  @NotNull
  private final Iterator<T> iterator;
  @Nullable
  private T nextItem;
  private int nextState;
  
  TakeWhileSequence$iterator$1()
  {
    this.iterator = TakeWhileSequence.access$getSequence$p(localTakeWhileSequence).iterator();
    this.nextState = -1;
  }
  
  private final void calcNext()
  {
    if (this.iterator.hasNext())
    {
      Object localObject = this.iterator.next();
      if (((Boolean)TakeWhileSequence.access$getPredicate$p(this.this$0).invoke(localObject)).booleanValue())
      {
        this.nextState = 1;
        this.nextItem = localObject;
        return;
      }
    }
    this.nextState = 0;
  }
  
  @NotNull
  public final Iterator<T> getIterator()
  {
    return this.iterator;
  }
  
  @Nullable
  public final T getNextItem()
  {
    return this.nextItem;
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
  
  public T next()
  {
    if (this.nextState == -1) {
      calcNext();
    }
    if (this.nextState != 0)
    {
      Object localObject = this.nextItem;
      this.nextItem = null;
      this.nextState = -1;
      return localObject;
    }
    throw ((Throwable)new NoSuchElementException());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final void setNextItem(@Nullable T paramT)
  {
    this.nextItem = paramT;
  }
  
  public final void setNextState(int paramInt)
  {
    this.nextState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.TakeWhileSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */