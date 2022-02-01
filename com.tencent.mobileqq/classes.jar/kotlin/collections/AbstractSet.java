package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractSet;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "equals", "", "other", "", "hashCode", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract class AbstractSet<E>
  extends AbstractCollection<E>
  implements Set<E>, KMappedMarker
{
  public static final AbstractSet.Companion Companion = new AbstractSet.Companion(null);
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (AbstractSet)this) {
      return true;
    }
    if (!(paramObject instanceof Set)) {
      return false;
    }
    return Companion.setEquals$kotlin_stdlib((Set)this, (Set)paramObject);
  }
  
  public int hashCode()
  {
    return Companion.unorderedHashCode$kotlin_stdlib((Collection)this);
  }
  
  public Iterator<E> iterator()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.AbstractSet
 * JD-Core Version:    0.7.0.1
 */