package kotlin.collections;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/ULongIterator;", "", "Lkotlin/ULong;", "()V", "next", "nextULong", "()J", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@ExperimentalUnsignedTypes
@SinceKotlin(version="1.3")
public abstract class ULongIterator
  implements Iterator<ULong>, KMappedMarker
{
  @NotNull
  public final ULong next()
  {
    return ULong.box-impl(nextULong());
  }
  
  public abstract long nextULong();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.ULongIterator
 * JD-Core Version:    0.7.0.1
 */