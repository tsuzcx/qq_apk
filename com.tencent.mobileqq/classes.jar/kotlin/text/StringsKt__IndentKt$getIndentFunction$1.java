package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "line", "invoke"}, k=3, mv={1, 1, 16})
final class StringsKt__IndentKt$getIndentFunction$1
  extends Lambda
  implements Function1<String, String>
{
  public static final 1 INSTANCE = new 1();
  
  StringsKt__IndentKt$getIndentFunction$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "line");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.text.StringsKt__IndentKt.getIndentFunction.1
 * JD-Core Version:    0.7.0.1
 */