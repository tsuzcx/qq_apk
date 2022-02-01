package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class MatcherMatchResult
  implements MatchResult
{
  private List<String> groupValues_;
  @NotNull
  private final MatchGroupCollection groups;
  private final CharSequence input;
  private final Matcher matcher;
  
  public MatcherMatchResult(@NotNull Matcher paramMatcher, @NotNull CharSequence paramCharSequence)
  {
    this.matcher = paramMatcher;
    this.input = paramCharSequence;
    this.groups = ((MatchGroupCollection)new MatcherMatchResult.groups.1(this));
  }
  
  private final java.util.regex.MatchResult getMatchResult()
  {
    return (java.util.regex.MatchResult)this.matcher;
  }
  
  @NotNull
  public MatchResult.Destructured getDestructured()
  {
    return MatchResult.DefaultImpls.getDestructured(this);
  }
  
  @NotNull
  public List<String> getGroupValues()
  {
    if (this.groupValues_ == null) {
      this.groupValues_ = ((List)new MatcherMatchResult.groupValues.1(this));
    }
    List localList = this.groupValues_;
    if (localList == null) {
      Intrinsics.throwNpe();
    }
    return localList;
  }
  
  @NotNull
  public MatchGroupCollection getGroups()
  {
    return this.groups;
  }
  
  @NotNull
  public IntRange getRange()
  {
    return RegexKt.access$range(getMatchResult());
  }
  
  @NotNull
  public String getValue()
  {
    String str = getMatchResult().group();
    Intrinsics.checkExpressionValueIsNotNull(str, "matchResult.group()");
    return str;
  }
  
  @Nullable
  public MatchResult next()
  {
    int j = getMatchResult().end();
    if (getMatchResult().end() == getMatchResult().start()) {}
    for (int i = 1;; i = 0)
    {
      i += j;
      if (i > this.input.length()) {
        break;
      }
      Matcher localMatcher = this.matcher.pattern().matcher(this.input);
      Intrinsics.checkExpressionValueIsNotNull(localMatcher, "matcher.pattern().matcher(input)");
      return RegexKt.access$findNext(localMatcher, i, this.input);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.text.MatcherMatchResult
 * JD-Core Version:    0.7.0.1
 */