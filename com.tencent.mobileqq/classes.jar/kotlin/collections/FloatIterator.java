package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/FloatIterator;", "", "", "()V", "next", "()Ljava/lang/Float;", "nextFloat", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class FloatIterator
  implements Iterator<Float>, KMappedMarker
{
  @NotNull
  public final Float next()
  {
    return Float.valueOf(nextFloat());
  }
  
  public abstract float nextFloat();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.FloatIterator
 * JD-Core Version:    0.7.0.1
 */