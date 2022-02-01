package kotlin.text;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toRegex", "Lkotlin/text/Regex;", "Ljava/util/regex/Pattern;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__RegexExtensionsJVMKt
  extends StringsKt__IndentKt
{
  @InlineOnly
  private static final Regex toRegex(@NotNull Pattern paramPattern)
  {
    return new Regex(paramPattern);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.StringsKt__RegexExtensionsJVMKt
 * JD-Core Version:    0.7.0.1
 */