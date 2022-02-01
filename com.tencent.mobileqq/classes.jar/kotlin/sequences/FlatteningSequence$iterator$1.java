package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class FlatteningSequence$iterator$1
  implements Iterator<E>, KMappedMarker
{
  @Nullable
  private Iterator<? extends E> itemIterator;
  @NotNull
  private final Iterator<T> iterator;
  
  FlatteningSequence$iterator$1()
  {
    this.iterator = FlatteningSequence.access$getSequence$p(localFlatteningSequence).iterator();
  }
  
  private final boolean ensureItemIterator()
  {
    Object localObject = this.itemIterator;
    if ((localObject != null) && (!((Iterator)localObject).hasNext())) {
      this.itemIterator = ((Iterator)null);
    }
    while (this.itemIterator == null)
    {
      if (!this.iterator.hasNext()) {
        return false;
      }
      localObject = this.iterator.next();
      localObject = (Iterator)FlatteningSequence.access$getIterator$p(this.this$0).invoke(FlatteningSequence.access$getTransformer$p(this.this$0).invoke(localObject));
      if (((Iterator)localObject).hasNext())
      {
        this.itemIterator = ((Iterator)localObject);
        return true;
      }
    }
    return true;
  }
  
  @Nullable
  public final Iterator<E> getItemIterator()
  {
    return this.itemIterator;
  }
  
  @NotNull
  public final Iterator<T> getIterator()
  {
    return this.iterator;
  }
  
  public boolean hasNext()
  {
    return ensureItemIterator();
  }
  
  public E next()
  {
    if (!ensureItemIterator()) {
      throw ((Throwable)new NoSuchElementException());
    }
    Iterator localIterator = this.itemIterator;
    if (localIterator == null) {
      Intrinsics.throwNpe();
    }
    return localIterator.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final void setItemIterator(@Nullable Iterator<? extends E> paramIterator)
  {
    this.itemIterator = paramIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.FlatteningSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */