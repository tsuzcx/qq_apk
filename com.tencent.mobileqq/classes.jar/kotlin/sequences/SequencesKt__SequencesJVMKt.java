package kotlin.sequences;

import java.util.Enumeration;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asSequence", "Lkotlin/sequences/Sequence;", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/sequences/SequencesKt")
class SequencesKt__SequencesJVMKt
  extends SequencesKt__SequenceBuilderKt
{
  @InlineOnly
  private static final <T> Sequence<T> asSequence(@NotNull Enumeration<T> paramEnumeration)
  {
    return SequencesKt.asSequence(CollectionsKt.iterator(paramEnumeration));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.SequencesKt__SequencesJVMKt
 * JD-Core Version:    0.7.0.1
 */