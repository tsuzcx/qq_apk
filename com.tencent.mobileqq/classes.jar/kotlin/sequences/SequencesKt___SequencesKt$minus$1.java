package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.BooleanRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/SequencesKt___SequencesKt$minus$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class SequencesKt___SequencesKt$minus$1
  implements Sequence<T>
{
  SequencesKt___SequencesKt$minus$1(Sequence<? extends T> paramSequence, Object paramObject) {}
  
  @NotNull
  public Iterator<T> iterator()
  {
    Ref.BooleanRef localBooleanRef = new Ref.BooleanRef();
    localBooleanRef.element = false;
    return SequencesKt.filter(this.$this_minus, (Function1)new SequencesKt___SequencesKt.minus.1.iterator.1(this, localBooleanRef)).iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt___SequencesKt.minus.1
 * JD-Core Version:    0.7.0.1
 */