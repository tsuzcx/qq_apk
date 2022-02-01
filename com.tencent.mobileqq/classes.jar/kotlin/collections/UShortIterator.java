package kotlin.collections;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UShort;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/UShortIterator;", "", "Lkotlin/UShort;", "()V", "next", "nextUShort", "()S", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public abstract class UShortIterator
  implements Iterator<UShort>, KMappedMarker
{
  @NotNull
  public final UShort next()
  {
    return UShort.box-impl(nextUShort());
  }
  
  public abstract short nextUShort();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.UShortIterator
 * JD-Core Version:    0.7.0.1
 */