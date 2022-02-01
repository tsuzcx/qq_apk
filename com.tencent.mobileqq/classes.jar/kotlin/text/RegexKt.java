package kotlin.text;

import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class RegexKt
{
  private static final MatchResult findNext(@NotNull Matcher paramMatcher, int paramInt, CharSequence paramCharSequence)
  {
    if (!paramMatcher.find(paramInt)) {
      return null;
    }
    return (MatchResult)new MatcherMatchResult(paramMatcher, paramCharSequence);
  }
  
  private static final MatchResult matchEntire(@NotNull Matcher paramMatcher, CharSequence paramCharSequence)
  {
    if (!paramMatcher.matches()) {
      return null;
    }
    return (MatchResult)new MatcherMatchResult(paramMatcher, paramCharSequence);
  }
  
  private static final IntRange range(@NotNull java.util.regex.MatchResult paramMatchResult)
  {
    return RangesKt.until(paramMatchResult.start(), paramMatchResult.end());
  }
  
  private static final IntRange range(@NotNull java.util.regex.MatchResult paramMatchResult, int paramInt)
  {
    return RangesKt.until(paramMatchResult.start(paramInt), paramMatchResult.end(paramInt));
  }
  
  private static final int toInt(@NotNull Iterable<? extends FlagEnum> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext()) {
      i |= ((FlagEnum)paramIterable.next()).getValue();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.RegexKt
 * JD-Core Version:    0.7.0.1
 */