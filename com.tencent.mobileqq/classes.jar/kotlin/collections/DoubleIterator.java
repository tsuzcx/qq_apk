package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/DoubleIterator;", "", "", "()V", "next", "()Ljava/lang/Double;", "nextDouble", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class DoubleIterator
  implements Iterator<Double>, KMappedMarker
{
  @NotNull
  public final Double next()
  {
    return Double.valueOf(nextDouble());
  }
  
  public abstract double nextDouble();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.DoubleIterator
 * JD-Core Version:    0.7.0.1
 */