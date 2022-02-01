package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "line", "invoke"}, k=3, mv={1, 1, 16})
final class StringsKt__IndentKt$getIndentFunction$2
  extends Lambda
  implements Function1<String, String>
{
  StringsKt__IndentKt$getIndentFunction$2(String paramString)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "line");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.$indent);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.text.StringsKt__IndentKt.getIndentFunction.2
 * JD-Core Version:    0.7.0.1
 */