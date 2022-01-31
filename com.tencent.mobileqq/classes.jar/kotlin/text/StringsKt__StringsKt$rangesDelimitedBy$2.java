package kotlin.text;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k=3, mv={1, 1, 16})
final class StringsKt__StringsKt$rangesDelimitedBy$2
  extends Lambda
  implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>
{
  StringsKt__StringsKt$rangesDelimitedBy$2(char[] paramArrayOfChar, boolean paramBoolean)
  {
    super(2);
  }
  
  @Nullable
  public final Pair<Integer, Integer> invoke(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$receiver");
    paramInt = StringsKt.indexOfAny(paramCharSequence, this.$delimiters, paramInt, this.$ignoreCase);
    if (paramInt < 0) {
      return null;
    }
    return TuplesKt.to(Integer.valueOf(paramInt), Integer.valueOf(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.StringsKt__StringsKt.rangesDelimitedBy.2
 * JD-Core Version:    0.7.0.1
 */