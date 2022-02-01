package com.tencent.tkd.weibo.utils;

import android.text.Editable;
import com.tencent.tkd.weibo.richEditText.span.RichSpan;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 1, 16})
public final class CollectionUtil$sortArrayByStartPosition$$inlined$sortBy$1<T>
  implements Comparator<T>
{
  public CollectionUtil$sortArrayByStartPosition$$inlined$sortBy$1(Editable paramEditable) {}
  
  public final int compare(T paramT1, T paramT2)
  {
    paramT1 = (RichSpan)paramT1;
    paramT1 = (Comparable)Integer.valueOf(this.a.getSpanStart(paramT1));
    paramT2 = (RichSpan)paramT2;
    return ComparisonsKt.compareValues(paramT1, (Comparable)Integer.valueOf(this.a.getSpanStart(paramT2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.CollectionUtil.sortArrayByStartPosition..inlined.sortBy.1
 * JD-Core Version:    0.7.0.1
 */