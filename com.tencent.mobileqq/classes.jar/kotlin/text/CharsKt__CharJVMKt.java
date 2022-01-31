package kotlin.text;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.internal.InlineOnly;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "toLowerCase", "toTitleCase", "toUpperCase", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/CharsKt")
public class CharsKt__CharJVMKt
{
  @PublishedApi
  public static final int checkRadix(int paramInt)
  {
    if ((2 > paramInt) || (36 < paramInt)) {
      throw ((Throwable)new IllegalArgumentException("radix " + paramInt + " was not in valid range " + new IntRange(2, 36)));
    }
    return paramInt;
  }
  
  public static final int digitOf(char paramChar, int paramInt)
  {
    return Character.digit(paramChar, paramInt);
  }
  
  @NotNull
  public static final CharCategory getCategory(char paramChar)
  {
    return CharCategory.Companion.valueOf(Character.getType(paramChar));
  }
  
  @NotNull
  public static final CharDirectionality getDirectionality(char paramChar)
  {
    return CharDirectionality.Companion.valueOf(Character.getDirectionality(paramChar));
  }
  
  @InlineOnly
  private static final boolean isDefined(char paramChar)
  {
    return Character.isDefined(paramChar);
  }
  
  @InlineOnly
  private static final boolean isDigit(char paramChar)
  {
    return Character.isDigit(paramChar);
  }
  
  @InlineOnly
  private static final boolean isHighSurrogate(char paramChar)
  {
    return Character.isHighSurrogate(paramChar);
  }
  
  @InlineOnly
  private static final boolean isISOControl(char paramChar)
  {
    return Character.isISOControl(paramChar);
  }
  
  @InlineOnly
  private static final boolean isIdentifierIgnorable(char paramChar)
  {
    return Character.isIdentifierIgnorable(paramChar);
  }
  
  @InlineOnly
  private static final boolean isJavaIdentifierPart(char paramChar)
  {
    return Character.isJavaIdentifierPart(paramChar);
  }
  
  @InlineOnly
  private static final boolean isJavaIdentifierStart(char paramChar)
  {
    return Character.isJavaIdentifierStart(paramChar);
  }
  
  @InlineOnly
  private static final boolean isLetter(char paramChar)
  {
    return Character.isLetter(paramChar);
  }
  
  @InlineOnly
  private static final boolean isLetterOrDigit(char paramChar)
  {
    return Character.isLetterOrDigit(paramChar);
  }
  
  @InlineOnly
  private static final boolean isLowSurrogate(char paramChar)
  {
    return Character.isLowSurrogate(paramChar);
  }
  
  @InlineOnly
  private static final boolean isLowerCase(char paramChar)
  {
    return Character.isLowerCase(paramChar);
  }
  
  @InlineOnly
  private static final boolean isTitleCase(char paramChar)
  {
    return Character.isTitleCase(paramChar);
  }
  
  @InlineOnly
  private static final boolean isUpperCase(char paramChar)
  {
    return Character.isUpperCase(paramChar);
  }
  
  public static final boolean isWhitespace(char paramChar)
  {
    return (Character.isWhitespace(paramChar)) || (Character.isSpaceChar(paramChar));
  }
  
  @InlineOnly
  private static final char toLowerCase(char paramChar)
  {
    return Character.toLowerCase(paramChar);
  }
  
  @InlineOnly
  private static final char toTitleCase(char paramChar)
  {
    return Character.toTitleCase(paramChar);
  }
  
  @InlineOnly
  private static final char toUpperCase(char paramChar)
  {
    return Character.toUpperCase(paramChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.CharsKt__CharJVMKt
 * JD-Core Version:    0.7.0.1
 */