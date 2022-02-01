package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "R", "index", "", "invoke", "(I)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
final class StringsKt___StringsKt$windowedSequence$2
  extends Lambda
  implements Function1<Integer, R>
{
  StringsKt___StringsKt$windowedSequence$2(CharSequence paramCharSequence, int paramInt, Function1 paramFunction1)
  {
    super(1);
  }
  
  public final R invoke(int paramInt)
  {
    int j = this.$size + paramInt;
    int i;
    if (j >= 0)
    {
      i = j;
      if (j <= this.$this_windowedSequence.length()) {}
    }
    else
    {
      i = this.$this_windowedSequence.length();
    }
    return this.$transform.invoke(this.$this_windowedSequence.subSequence(paramInt, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.StringsKt___StringsKt.windowedSequence.2
 * JD-Core Version:    0.7.0.1
 */