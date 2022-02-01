package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class StringsKt___StringsKt$asIterable$$inlined$Iterable$1
  implements Iterable<Character>, KMappedMarker
{
  public StringsKt___StringsKt$asIterable$$inlined$Iterable$1(CharSequence paramCharSequence) {}
  
  @NotNull
  public Iterator<Character> iterator()
  {
    return (Iterator)StringsKt.iterator(this.$this_asIterable$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.StringsKt___StringsKt.asIterable..inlined.Iterable.1
 * JD-Core Version:    0.7.0.1
 */