package kotlin.collections;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/UByteIterator;", "", "Lkotlin/UByte;", "()V", "next", "nextUByte", "()B", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public abstract class UByteIterator
  implements Iterator<UByte>, KMappedMarker
{
  @NotNull
  public final UByte next()
  {
    return UByte.box-impl(nextUByte());
  }
  
  public abstract byte nextUByte();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.UByteIterator
 * JD-Core Version:    0.7.0.1
 */