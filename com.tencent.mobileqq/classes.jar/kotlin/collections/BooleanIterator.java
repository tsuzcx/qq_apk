package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/BooleanIterator;", "", "", "()V", "next", "()Ljava/lang/Boolean;", "nextBoolean", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class BooleanIterator
  implements Iterator<Boolean>, KMappedMarker
{
  @NotNull
  public final Boolean next()
  {
    return Boolean.valueOf(nextBoolean());
  }
  
  public abstract boolean nextBoolean();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.BooleanIterator
 * JD-Core Version:    0.7.0.1
 */