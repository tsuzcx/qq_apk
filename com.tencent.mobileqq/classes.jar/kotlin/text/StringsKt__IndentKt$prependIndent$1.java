package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "invoke"}, k=3, mv={1, 1, 16})
final class StringsKt__IndentKt$prependIndent$1
  extends Lambda
  implements Function1<String, String>
{
  StringsKt__IndentKt$prependIndent$1(String paramString)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "it");
    Object localObject;
    if (StringsKt.isBlank((CharSequence)paramString))
    {
      localObject = paramString;
      if (paramString.length() < this.$indent.length()) {
        return this.$indent;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.$indent);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.StringsKt__IndentKt.prependIndent.1
 * JD-Core Version:    0.7.0.1
 */