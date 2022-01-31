package kotlin.text;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k=3, mv={1, 1, 16})
final class StringsKt__StringsKt$rangesDelimitedBy$4
  extends Lambda
  implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>
{
  StringsKt__StringsKt$rangesDelimitedBy$4(List paramList, boolean paramBoolean)
  {
    super(2);
  }
  
  @Nullable
  public final Pair<Integer, Integer> invoke(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$receiver");
    paramCharSequence = StringsKt__StringsKt.access$findAnyOf(paramCharSequence, (Collection)this.$delimitersList, paramInt, this.$ignoreCase, false);
    if (paramCharSequence != null) {
      return TuplesKt.to(paramCharSequence.getFirst(), Integer.valueOf(((String)paramCharSequence.getSecond()).length()));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.StringsKt__StringsKt.rangesDelimitedBy.4
 * JD-Core Version:    0.7.0.1
 */