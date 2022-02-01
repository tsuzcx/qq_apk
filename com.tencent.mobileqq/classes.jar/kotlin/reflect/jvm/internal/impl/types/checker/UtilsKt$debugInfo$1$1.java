package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

final class UtilsKt$debugInfo$1$1
  extends Lambda
  implements Function1<String, StringBuilder>
{
  UtilsKt$debugInfo$1$1(StringBuilder paramStringBuilder)
  {
    super(1);
  }
  
  @NotNull
  public final StringBuilder invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$unaryPlus");
    StringBuilder localStringBuilder = this.$this_buildString;
    localStringBuilder.append(paramString);
    Intrinsics.checkExpressionValueIsNotNull(localStringBuilder, "append(value)");
    return StringsKt.appendln(localStringBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.UtilsKt.debugInfo.1.1
 * JD-Core Version:    0.7.0.1
 */