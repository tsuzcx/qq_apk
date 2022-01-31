package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ArraysKt___ArraysKt$asSequence$$inlined$Sequence$2
  implements Sequence<Byte>
{
  public ArraysKt___ArraysKt$asSequence$$inlined$Sequence$2(byte[] paramArrayOfByte) {}
  
  @NotNull
  public Iterator<Byte> iterator()
  {
    return (Iterator)ArrayIteratorsKt.iterator(this.$this_asSequence$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysKt.asSequence..inlined.Sequence.2
 * JD-Core Version:    0.7.0.1
 */