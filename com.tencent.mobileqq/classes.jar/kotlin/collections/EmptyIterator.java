package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/EmptyIterator;", "", "", "()V", "hasNext", "", "hasPrevious", "next", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class EmptyIterator
  implements ListIterator, KMappedMarker
{
  public static final EmptyIterator INSTANCE = new EmptyIterator();
  
  public void add(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public boolean hasPrevious()
  {
    return false;
  }
  
  @NotNull
  public Void next()
  {
    throw ((Throwable)new NoSuchElementException());
  }
  
  public int nextIndex()
  {
    return 0;
  }
  
  @NotNull
  public Void previous()
  {
    throw ((Throwable)new NoSuchElementException());
  }
  
  public int previousIndex()
  {
    return -1;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void set(Void paramVoid)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.EmptyIterator
 * JD-Core Version:    0.7.0.1
 */