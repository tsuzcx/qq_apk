package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class StringsKt___StringsKt$windowedSequence$1
  extends Lambda
  implements Function1<CharSequence, String>
{
  public static final 1 INSTANCE = new 1();
  
  StringsKt___StringsKt$windowedSequence$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "it");
    return paramCharSequence.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.text.StringsKt___StringsKt.windowedSequence.1
 * JD-Core Version:    0.7.0.1
 */