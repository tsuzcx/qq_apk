package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "charSequence", "", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringsJVMKt
  extends StringsKt__StringNumberConversionsKt
{
  @InlineOnly
  private static final String String(StringBuffer paramStringBuffer)
  {
    return new String(paramStringBuffer);
  }
  
  @InlineOnly
  private static final String String(StringBuilder paramStringBuilder)
  {
    return new String(paramStringBuilder);
  }
  
  @InlineOnly
  private static final String String(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, Charsets.UTF_8);
  }
  
  @InlineOnly
  private static final String String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new String(paramArrayOfByte, paramInt1, paramInt2, Charsets.UTF_8);
  }
  
  @InlineOnly
  private static final String String(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Charset paramCharset)
  {
    return new String(paramArrayOfByte, paramInt1, paramInt2, paramCharset);
  }
  
  @InlineOnly
  private static final String String(byte[] paramArrayOfByte, Charset paramCharset)
  {
    return new String(paramArrayOfByte, paramCharset);
  }
  
  @InlineOnly
  private static final String String(char[] paramArrayOfChar)
  {
    return new String(paramArrayOfChar);
  }
  
  @InlineOnly
  private static final String String(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return new String(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  @InlineOnly
  private static final String String(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return new String(paramArrayOfInt, paramInt1, paramInt2);
  }
  
  @NotNull
  public static final String capitalize(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$capitalize");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (Character.isLowerCase(paramString.charAt(0))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString.substring(0, 1);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (str != null)
      {
        str = str.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toUpperCase()");
        localStringBuilder.append(str);
        paramString = paramString.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramString;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @LowPriorityInOverloadResolution
  @NotNull
  public static final String capitalize(@NotNull String paramString, @NotNull Locale paramLocale)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$capitalize");
    Intrinsics.checkParameterIsNotNull(paramLocale, "locale");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      char c1 = paramString.charAt(0);
      if (Character.isLowerCase(c1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        char c2 = Character.toTitleCase(c1);
        if (c2 != Character.toUpperCase(c1))
        {
          localStringBuilder.append(c2);
        }
        else
        {
          String str = paramString.substring(0, 1);
          Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          if (str == null) {
            break label156;
          }
          paramLocale = str.toUpperCase(paramLocale);
          Intrinsics.checkExpressionValueIsNotNull(paramLocale, "(this as java.lang.String).toUpperCase(locale)");
          localStringBuilder.append(paramLocale);
        }
        paramString = paramString.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "StringBuilder().apply(builderAction).toString()");
        return paramString;
        label156:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return paramString;
  }
  
  @InlineOnly
  private static final int codePointAt(@NotNull String paramString, int paramInt)
  {
    if (paramString != null) {
      return paramString.codePointAt(paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final int codePointBefore(@NotNull String paramString, int paramInt)
  {
    if (paramString != null) {
      return paramString.codePointBefore(paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final int codePointCount(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null) {
      return paramString.codePointCount(paramInt1, paramInt2);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final int compareTo(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$compareTo");
    Intrinsics.checkParameterIsNotNull(paramString2, "other");
    if (paramBoolean) {
      return paramString1.compareToIgnoreCase(paramString2);
    }
    return paramString1.compareTo(paramString2);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String concatToString(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$concatToString");
    return new String(paramArrayOfChar);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String concatToString(@NotNull char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$concatToString");
    AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(paramInt1, paramInt2, paramArrayOfChar.length);
    return new String(paramArrayOfChar, paramInt1, paramInt2 - paramInt1);
  }
  
  @InlineOnly
  private static final boolean contentEquals(@NotNull String paramString, CharSequence paramCharSequence)
  {
    if (paramString != null) {
      return paramString.contentEquals(paramCharSequence);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final boolean contentEquals(@NotNull String paramString, StringBuffer paramStringBuffer)
  {
    if (paramString != null) {
      return paramString.contentEquals(paramStringBuffer);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @NotNull
  public static final String decapitalize(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$decapitalize");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (Character.isUpperCase(paramString.charAt(0))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString.substring(0, 1);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (str != null)
      {
        str = str.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase()");
        localStringBuilder.append(str);
        paramString = paramString.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramString;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @LowPriorityInOverloadResolution
  @NotNull
  public static final String decapitalize(@NotNull String paramString, @NotNull Locale paramLocale)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$decapitalize");
    Intrinsics.checkParameterIsNotNull(paramLocale, "locale");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!Character.isLowerCase(paramString.charAt(0))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString.substring(0, 1);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (str != null)
      {
        paramLocale = str.toLowerCase(paramLocale);
        Intrinsics.checkExpressionValueIsNotNull(paramLocale, "(this as java.lang.String).toLowerCase(locale)");
        localStringBuilder.append(paramLocale);
        paramString = paramString.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramString;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String decodeToString(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$decodeToString");
    return new String(paramArrayOfByte, Charsets.UTF_8);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final String decodeToString(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$decodeToString");
    AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(paramInt1, paramInt2, paramArrayOfByte.length);
    if (!paramBoolean) {
      return new String(paramArrayOfByte, paramInt1, paramInt2 - paramInt1, Charsets.UTF_8);
    }
    paramArrayOfByte = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2 - paramInt1)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "decoder.decode(ByteBuffe…- startIndex)).toString()");
    return paramArrayOfByte;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] encodeToByteArray(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$encodeToByteArray");
    paramString = paramString.getBytes(Charsets.UTF_8);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    return paramString;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] encodeToByteArray(@NotNull String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$encodeToByteArray");
    AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(paramInt1, paramInt2, paramString.length());
    if (!paramBoolean)
    {
      paramString = paramString.substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject = Charsets.UTF_8;
      if (paramString != null)
      {
        paramString = paramString.getBytes((Charset)localObject);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
        return paramString;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    paramString = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap((CharSequence)paramString, paramInt1, paramInt2));
    if ((paramString.hasArray()) && (paramString.arrayOffset() == 0))
    {
      paramInt1 = paramString.remaining();
      localObject = paramString.array();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (paramInt1 == localObject.length)
      {
        paramString = paramString.array();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "byteBuffer.array()");
        return paramString;
      }
    }
    Object localObject = new byte[paramString.remaining()];
    paramString.get((byte[])localObject);
    return localObject;
  }
  
  public static final boolean endsWith(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$endsWith");
    Intrinsics.checkParameterIsNotNull(paramString2, "suffix");
    if (!paramBoolean) {
      return paramString1.endsWith(paramString2);
    }
    return StringsKt.regionMatches(paramString1, paramString1.length() - paramString2.length(), paramString2, 0, paramString2.length(), true);
  }
  
  public static final boolean equals(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    if (!paramBoolean) {
      return paramString1.equals(paramString2);
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
  
  @InlineOnly
  private static final String format(@NotNull String paramString, Locale paramLocale, Object... paramVarArgs)
  {
    paramString = String.format(paramLocale, paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(locale, this, *args)");
    return paramString;
  }
  
  @InlineOnly
  private static final String format(@NotNull String paramString, Object... paramVarArgs)
  {
    paramString = String.format(paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(this, *args)");
    return paramString;
  }
  
  @InlineOnly
  private static final String format(@NotNull StringCompanionObject paramStringCompanionObject, String paramString, Object... paramVarArgs)
  {
    paramStringCompanionObject = String.format(paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramStringCompanionObject, "java.lang.String.format(format, *args)");
    return paramStringCompanionObject;
  }
  
  @InlineOnly
  private static final String format(@NotNull StringCompanionObject paramStringCompanionObject, Locale paramLocale, String paramString, Object... paramVarArgs)
  {
    paramStringCompanionObject = String.format(paramLocale, paramString, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramStringCompanionObject, "java.lang.String.format(locale, format, *args)");
    return paramStringCompanionObject;
  }
  
  @NotNull
  public static final Comparator<String> getCASE_INSENSITIVE_ORDER(@NotNull StringCompanionObject paramStringCompanionObject)
  {
    Intrinsics.checkParameterIsNotNull(paramStringCompanionObject, "$this$CASE_INSENSITIVE_ORDER");
    paramStringCompanionObject = String.CASE_INSENSITIVE_ORDER;
    Intrinsics.checkExpressionValueIsNotNull(paramStringCompanionObject, "java.lang.String.CASE_INSENSITIVE_ORDER");
    return paramStringCompanionObject;
  }
  
  @InlineOnly
  private static final String intern(@NotNull String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.intern();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).intern()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final boolean isBlank(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$isBlank");
    int i = paramCharSequence.length();
    boolean bool = false;
    if (i != 0)
    {
      Object localObject = (Iterable)StringsKt.getIndices(paramCharSequence);
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject).hasNext())
        {
          i = 1;
          break;
          localObject = ((Iterable)localObject).iterator();
        }
      } while (CharsKt.isWhitespace(paramCharSequence.charAt(((IntIterator)localObject).nextInt())));
      i = 0;
      if (i == 0) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  @InlineOnly
  private static final int nativeIndexOf(@NotNull String paramString, char paramChar, int paramInt)
  {
    if (paramString != null) {
      return paramString.indexOf(paramChar, paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final int nativeIndexOf(@NotNull String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 != null) {
      return paramString1.indexOf(paramString2, paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final int nativeLastIndexOf(@NotNull String paramString, char paramChar, int paramInt)
  {
    if (paramString != null) {
      return paramString.lastIndexOf(paramChar, paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final int nativeLastIndexOf(@NotNull String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 != null) {
      return paramString1.lastIndexOf(paramString2, paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final int offsetByCodePoints(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null) {
      return paramString.offsetByCodePoints(paramInt1, paramInt2);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final boolean regionMatches(@NotNull CharSequence paramCharSequence1, int paramInt1, @NotNull CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$regionMatches");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return StringsKt.regionMatches((String)paramCharSequence1, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3, paramBoolean);
    }
    return StringsKt.regionMatchesImpl(paramCharSequence1, paramInt1, paramCharSequence2, paramInt2, paramInt3, paramBoolean);
  }
  
  public static final boolean regionMatches(@NotNull String paramString1, int paramInt1, @NotNull String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$regionMatches");
    Intrinsics.checkParameterIsNotNull(paramString2, "other");
    if (!paramBoolean) {
      return paramString1.regionMatches(paramInt1, paramString2, paramInt2, paramInt3);
    }
    return paramString1.regionMatches(paramBoolean, paramInt1, paramString2, paramInt2, paramInt3);
  }
  
  @NotNull
  public static final String repeat(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$repeat");
    int k = 0;
    int m = 1;
    int j;
    if (paramInt >= 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      String str = "";
      Object localObject = str;
      if (paramInt != 0) {
        if (paramInt != 1)
        {
          j = paramCharSequence.length();
          localObject = str;
          if (j != 0)
          {
            if (j != 1)
            {
              localObject = new StringBuilder(paramCharSequence.length() * paramInt);
              if (1 <= paramInt)
              {
                j = m;
                for (;;)
                {
                  ((StringBuilder)localObject).append(paramCharSequence);
                  if (j == paramInt) {
                    break;
                  }
                  j += 1;
                }
              }
              paramCharSequence = ((StringBuilder)localObject).toString();
              Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "sb.toString()");
              return paramCharSequence;
            }
            int i = paramCharSequence.charAt(0);
            paramCharSequence = new char[paramInt];
            j = k;
            while (j < paramInt)
            {
              paramCharSequence[j] = i;
              j += 1;
            }
            return new String(paramCharSequence);
          }
        }
        else
        {
          localObject = paramCharSequence.toString();
        }
      }
      return localObject;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Count 'n' must be non-negative, but was ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append('.');
    paramCharSequence = (Throwable)new IllegalArgumentException(paramCharSequence.toString().toString());
    for (;;)
    {
      throw paramCharSequence;
    }
  }
  
  @NotNull
  public static final String replace(@NotNull String paramString, char paramChar1, char paramChar2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$replace");
    if (!paramBoolean)
    {
      paramString = paramString.replace(paramChar1, paramChar2);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…replace(oldChar, newChar)");
      return paramString;
    }
    return SequencesKt.joinToString$default(StringsKt.splitToSequence$default((CharSequence)paramString, new char[] { paramChar1 }, paramBoolean, 0, 4, null), (CharSequence)String.valueOf(paramChar2), null, null, 0, null, null, 62, null);
  }
  
  @NotNull
  public static final String replace(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replace");
    Intrinsics.checkParameterIsNotNull(paramString2, "oldValue");
    Intrinsics.checkParameterIsNotNull(paramString3, "newValue");
    return SequencesKt.joinToString$default(StringsKt.splitToSequence$default((CharSequence)paramString1, new String[] { paramString2 }, paramBoolean, 0, 4, null), (CharSequence)paramString3, null, null, 0, null, null, 62, null);
  }
  
  @NotNull
  public static final String replaceFirst(@NotNull String paramString, char paramChar1, char paramChar2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$replaceFirst");
    CharSequence localCharSequence = (CharSequence)paramString;
    int i = StringsKt.indexOf$default(localCharSequence, paramChar1, 0, paramBoolean, 2, null);
    if (i < 0) {
      return paramString;
    }
    return StringsKt.replaceRange(localCharSequence, i, i + 1, (CharSequence)String.valueOf(paramChar2)).toString();
  }
  
  @NotNull
  public static final String replaceFirst(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceFirst");
    Intrinsics.checkParameterIsNotNull(paramString2, "oldValue");
    Intrinsics.checkParameterIsNotNull(paramString3, "newValue");
    CharSequence localCharSequence = (CharSequence)paramString1;
    int i = StringsKt.indexOf$default(localCharSequence, paramString2, 0, paramBoolean, 2, null);
    if (i < 0) {
      return paramString1;
    }
    return StringsKt.replaceRange(localCharSequence, i, paramString2.length() + i, (CharSequence)paramString3).toString();
  }
  
  @NotNull
  public static final List<String> split(@NotNull CharSequence paramCharSequence, @NotNull Pattern paramPattern, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$split");
    Intrinsics.checkParameterIsNotNull(paramPattern, "regex");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = paramInt;
      if (paramInt == 0) {
        i = -1;
      }
      paramCharSequence = paramPattern.split(paramCharSequence, i);
      Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "regex.split(this, if (limit == 0) -1 else limit)");
      return ArraysKt.asList(paramCharSequence);
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append('.');
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public static final boolean startsWith(@NotNull String paramString1, @NotNull String paramString2, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramString2, "prefix");
    if (!paramBoolean) {
      return paramString1.startsWith(paramString2, paramInt);
    }
    return StringsKt.regionMatches(paramString1, paramInt, paramString2, 0, paramString2.length(), paramBoolean);
  }
  
  public static final boolean startsWith(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramString2, "prefix");
    if (!paramBoolean) {
      return paramString1.startsWith(paramString2);
    }
    return StringsKt.regionMatches(paramString1, 0, paramString2, 0, paramString2.length(), paramBoolean);
  }
  
  @InlineOnly
  private static final String substring(@NotNull String paramString, int paramInt)
  {
    if (paramString != null)
    {
      paramString = paramString.substring(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final String substring(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.substring(paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final byte[] toByteArray(@NotNull String paramString, Charset paramCharset)
  {
    if (paramString != null)
    {
      paramString = paramString.getBytes(paramCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final char[] toCharArray(@NotNull String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.toCharArray();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toCharArray()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final char[] toCharArray(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toCharArray");
    AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(paramInt1, paramInt2, paramString.length());
    char[] arrayOfChar = new char[paramInt2 - paramInt1];
    paramString.getChars(paramInt1, paramInt2, arrayOfChar, 0);
    return arrayOfChar;
  }
  
  @InlineOnly
  private static final char[] toCharArray(@NotNull String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString != null)
    {
      paramString.getChars(paramInt2, paramInt3, paramArrayOfChar, paramInt1);
      return paramArrayOfChar;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final String toLowerCase(@NotNull String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final String toLowerCase(@NotNull String paramString, Locale paramLocale)
  {
    if (paramString != null)
    {
      paramString = paramString.toLowerCase(paramLocale);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase(locale)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final Pattern toPattern(@NotNull String paramString, int paramInt)
  {
    paramString = Pattern.compile(paramString, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.util.regex.Pattern.compile(this, flags)");
    return paramString;
  }
  
  @InlineOnly
  private static final String toUpperCase(@NotNull String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.toUpperCase();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toUpperCase()");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @InlineOnly
  private static final String toUpperCase(@NotNull String paramString, Locale paramLocale)
  {
    if (paramString != null)
    {
      paramString = paramString.toUpperCase(paramLocale);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toUpperCase(locale)");
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.text.StringsKt__StringsJVMKt
 * JD-Core Version:    0.7.0.1
 */