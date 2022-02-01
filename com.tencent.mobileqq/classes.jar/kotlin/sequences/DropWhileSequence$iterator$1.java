package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/DropWhileSequence$iterator$1", "", "dropState", "", "getDropState", "()I", "setDropState", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "drop", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class DropWhileSequence$iterator$1
  implements Iterator<T>, KMappedMarker
{
  private int dropState;
  @NotNull
  private final Iterator<T> iterator;
  @Nullable
  private T nextItem;
  
  DropWhileSequence$iterator$1()
  {
    this.iterator = DropWhileSequence.access$getSequence$p(localDropWhileSequence).iterator();
    this.dropState = -1;
  }
  
  private final void drop()
  {
    while (this.iterator.hasNext())
    {
      Object localObject = this.iterator.next();
      if (!((Boolean)DropWhileSequence.access$getPredicate$p(this.this$0).invoke(localObject)).booleanValue())
      {
        this.nextItem = localObject;
        this.dropState = 1;
        return;
      }
    }
    this.dropState = 0;
  }
  
  public final int getDropState()
  {
    return this.dropState;
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
  
  public boolean hasNext()
  {
    if (this.dropState == -1) {
      drop();
    }
    return (this.dropState == 1) || (this.iterator.hasNext());
  }
  
  public T next()
  {
    if (this.dropState == -1) {
      drop();
    }
    if (this.dropState == 1)
    {
      Object localObject = this.nextItem;
      this.nextItem = null;
      this.dropState = 0;
      return localObject;
    }
    return this.iterator.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final void setDropState(int paramInt)
  {
    this.dropState = paramInt;
  }
  
  public final void setNextItem(@Nullable T paramT)
  {
    this.nextItem = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.DropWhileSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */