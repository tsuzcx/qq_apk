package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/LongIterator;", "", "", "()V", "next", "()Ljava/lang/Long;", "nextLong", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class LongIterator
  implements Iterator<Long>, KMappedMarker
{
  @NotNull
  public final Long next()
  {
    return Long.valueOf(nextLong());
  }
  
  public abstract long nextLong();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.LongIterator
 * JD-Core Version:    0.7.0.1
 */