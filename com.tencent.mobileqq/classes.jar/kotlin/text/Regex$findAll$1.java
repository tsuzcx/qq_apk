package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/text/MatchResult;", "invoke"}, k=3, mv={1, 1, 16})
final class Regex$findAll$1
  extends Lambda
  implements Function0<MatchResult>
{
  Regex$findAll$1(Regex paramRegex, CharSequence paramCharSequence, int paramInt)
  {
    super(0);
  }
  
  @Nullable
  public final MatchResult invoke()
  {
    return this.this$0.find(this.$input, this.$startIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.Regex.findAll.1
 * JD-Core Version:    0.7.0.1
 */