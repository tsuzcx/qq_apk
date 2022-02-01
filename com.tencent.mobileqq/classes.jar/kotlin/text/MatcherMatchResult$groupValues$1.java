package kotlin.text;

import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class MatcherMatchResult$groupValues$1
  extends AbstractList<String>
{
  @NotNull
  public String get(int paramInt)
  {
    String str = MatcherMatchResult.access$getMatchResult$p(this.this$0).group(paramInt);
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public int getSize()
  {
    return MatcherMatchResult.access$getMatchResult$p(this.this$0).groupCount() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.MatcherMatchResult.groupValues.1
 * JD-Core Version:    0.7.0.1
 */