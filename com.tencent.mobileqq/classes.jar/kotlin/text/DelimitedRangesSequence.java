package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class DelimitedRangesSequence
  implements Sequence<IntRange>
{
  private final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;
  private final CharSequence input;
  private final int limit;
  private final int startIndex;
  
  public DelimitedRangesSequence(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, @NotNull Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> paramFunction2)
  {
    this.input = paramCharSequence;
    this.startIndex = paramInt1;
    this.limit = paramInt2;
    this.getNextMatch = paramFunction2;
  }
  
  @NotNull
  public Iterator<IntRange> iterator()
  {
    return (Iterator)new DelimitedRangesSequence.iterator.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.DelimitedRangesSequence
 * JD-Core Version:    0.7.0.1
 */