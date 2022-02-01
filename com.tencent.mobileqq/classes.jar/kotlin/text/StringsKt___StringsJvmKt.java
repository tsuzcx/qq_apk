package kotlin.text;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"elementAt", "", "", "index", "", "toSortedSet", "Ljava/util/SortedSet;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt___StringsJvmKt
  extends StringsKt__StringsKt
{
  @InlineOnly
  private static final char elementAt(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    return paramCharSequence.charAt(paramInt);
  }
  
  @NotNull
  public static final SortedSet<Character> toSortedSet(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toSortedSet");
    return (SortedSet)StringsKt.toCollection(paramCharSequence, (Collection)new TreeSet());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.text.StringsKt___StringsJvmKt
 * JD-Core Version:    0.7.0.1
 */