package com.tencent.tavcut.render.parser;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import org.libpag.PAGLayer;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 1, 16})
public final class PagEffectParser$layersInComposition$$inlined$sortedBy$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    return ComparisonsKt.compareValues((Comparable)Integer.valueOf(((PAGLayer)paramT1).editableIndex()), (Comparable)Integer.valueOf(((PAGLayer)paramT2).editableIndex()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.parser.PagEffectParser.layersInComposition..inlined.sortedBy.1
 * JD-Core Version:    0.7.0.1
 */