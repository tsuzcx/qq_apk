package kotlin.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Regex$Companion
{
  private final int ensureUnicodeCase(int paramInt)
  {
    int i = paramInt;
    if ((paramInt & 0x2) != 0) {
      i = paramInt | 0x40;
    }
    return i;
  }
  
  @NotNull
  public final String escape(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "literal");
    paramString = Pattern.quote(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Pattern.quote(literal)");
    return paramString;
  }
  
  @NotNull
  public final String escapeReplacement(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "literal");
    paramString = Matcher.quoteReplacement(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Matcher.quoteReplacement(literal)");
    return paramString;
  }
  
  @NotNull
  public final Regex fromLiteral(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "literal");
    return new Regex(paramString, RegexOption.LITERAL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.text.Regex.Companion
 * JD-Core Version:    0.7.0.1
 */