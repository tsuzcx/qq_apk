package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"appendRange", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "", "startIndex", "", "endIndex", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "", "", "clear", "deleteAt", "index", "deleteRange", "insertRange", "set", "", "setRange", "toCharArray", "destination", "destinationOffset", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt
  extends StringsKt__RegexExtensionsKt
{
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final StringBuilder appendRange(@NotNull StringBuilder paramStringBuilder, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append(paramCharSequence, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "this.append(value, startIndex, endIndex)");
    return paramStringBuilder;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final StringBuilder appendRange(@NotNull StringBuilder paramStringBuilder, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append(paramArrayOfChar, paramInt1, paramInt2 - paramInt1);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "this.append(value, start…x, endIndex - startIndex)");
    return paramStringBuilder;
  }
  
  @NotNull
  public static final Appendable appendln(@NotNull Appendable paramAppendable)
  {
    Intrinsics.checkParameterIsNotNull(paramAppendable, "$this$appendln");
    paramAppendable = paramAppendable.append((CharSequence)SystemProperties.LINE_SEPARATOR);
    Intrinsics.checkExpressionValueIsNotNull(paramAppendable, "append(SystemProperties.LINE_SEPARATOR)");
    return paramAppendable;
  }
  
  @InlineOnly
  private static final Appendable appendln(@NotNull Appendable paramAppendable, char paramChar)
  {
    paramAppendable = paramAppendable.append(paramChar);
    Intrinsics.checkExpressionValueIsNotNull(paramAppendable, "append(value)");
    return StringsKt.appendln(paramAppendable);
  }
  
  @InlineOnly
  private static final Appendable appendln(@NotNull Appendable paramAppendable, CharSequence paramCharSequence)
  {
    paramAppendable = paramAppendable.append(paramCharSequence);
    Intrinsics.checkExpressionValueIsNotNull(paramAppendable, "append(value)");
    return StringsKt.appendln(paramAppendable);
  }
  
  @NotNull
  public static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "$this$appendln");
    paramStringBuilder.append(SystemProperties.LINE_SEPARATOR);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(SystemProperties.LINE_SEPARATOR)");
    return paramStringBuilder;
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, byte paramByte)
  {
    paramStringBuilder.append(paramByte);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value.toInt())");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, char paramChar)
  {
    paramStringBuilder.append(paramChar);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, double paramDouble)
  {
    paramStringBuilder.append(paramDouble);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, float paramFloat)
  {
    paramStringBuilder.append(paramFloat);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, long paramLong)
  {
    paramStringBuilder.append(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, CharSequence paramCharSequence)
  {
    paramStringBuilder.append(paramCharSequence);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, Object paramObject)
  {
    paramStringBuilder.append(paramObject);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, StringBuffer paramStringBuffer)
  {
    paramStringBuilder.append(paramStringBuffer);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramStringBuilder1.append((CharSequence)paramStringBuilder2);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder1, "append(value)");
    return StringsKt.appendln(paramStringBuilder1);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, short paramShort)
  {
    paramStringBuilder.append(paramShort);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value.toInt())");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    paramStringBuilder.append(paramBoolean);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @InlineOnly
  private static final StringBuilder appendln(@NotNull StringBuilder paramStringBuilder, char[] paramArrayOfChar)
  {
    paramStringBuilder.append(paramArrayOfChar);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "append(value)");
    return StringsKt.appendln(paramStringBuilder);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final StringBuilder clear(@NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "$this$clear");
    paramStringBuilder.setLength(0);
    return paramStringBuilder;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final StringBuilder deleteAt(@NotNull StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = paramStringBuilder.deleteCharAt(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "this.deleteCharAt(index)");
    return paramStringBuilder;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final StringBuilder deleteRange(@NotNull StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    paramStringBuilder = paramStringBuilder.delete(paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "this.delete(startIndex, endIndex)");
    return paramStringBuilder;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final StringBuilder insertRange(@NotNull StringBuilder paramStringBuilder, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    paramStringBuilder = paramStringBuilder.insert(paramInt1, paramCharSequence, paramInt2, paramInt3);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "this.insert(index, value, startIndex, endIndex)");
    return paramStringBuilder;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final StringBuilder insertRange(@NotNull StringBuilder paramStringBuilder, int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    paramStringBuilder = paramStringBuilder.insert(paramInt1, paramArrayOfChar, paramInt2, paramInt3 - paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "this.insert(index, value…x, endIndex - startIndex)");
    return paramStringBuilder;
  }
  
  @InlineOnly
  private static final void set(@NotNull StringBuilder paramStringBuilder, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "$this$set");
    paramStringBuilder.setCharAt(paramInt, paramChar);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final StringBuilder setRange(@NotNull StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    paramStringBuilder = paramStringBuilder.replace(paramInt1, paramInt2, paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "this.replace(startIndex, endIndex, value)");
    return paramStringBuilder;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final void toCharArray(@NotNull StringBuilder paramStringBuilder, char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    paramStringBuilder.getChars(paramInt2, paramInt3, paramArrayOfChar, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.text.StringsKt__StringBuilderJVMKt
 * JD-Core Version:    0.7.0.1
 */