package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/collections/CharIterator;", "invoke"}, k=3, mv={1, 1, 16})
final class StringsKt___StringsKt$withIndex$1
  extends Lambda
  implements Function0<CharIterator>
{
  StringsKt___StringsKt$withIndex$1(CharSequence paramCharSequence)
  {
    super(0);
  }
  
  @NotNull
  public final CharIterator invoke()
  {
    return StringsKt.iterator(this.$this_withIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.text.StringsKt___StringsKt.withIndex.1
 * JD-Core Version:    0.7.0.1
 */