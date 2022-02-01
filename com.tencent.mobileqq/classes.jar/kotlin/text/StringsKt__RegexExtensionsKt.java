package kotlin.text;

import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toRegex", "Lkotlin/text/Regex;", "", "options", "", "Lkotlin/text/RegexOption;", "option", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__RegexExtensionsKt
  extends StringsKt__RegexExtensionsJVMKt
{
  @InlineOnly
  private static final Regex toRegex(@NotNull String paramString)
  {
    return new Regex(paramString);
  }
  
  @InlineOnly
  private static final Regex toRegex(@NotNull String paramString, Set<? extends RegexOption> paramSet)
  {
    return new Regex(paramString, paramSet);
  }
  
  @InlineOnly
  private static final Regex toRegex(@NotNull String paramString, RegexOption paramRegexOption)
  {
    return new Regex(paramString, paramRegexOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.text.StringsKt__RegexExtensionsKt
 * JD-Core Version:    0.7.0.1
 */