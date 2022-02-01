package com.tencent.tavcut.composition.dataprocessor;

import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 1, 16})
public final class RenderModelHolder$queryByEntityId$$inlined$sortedBy$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    Object localObject1 = ((Iterable)((Entity)paramT1).getComponents()).iterator();
    Object localObject2;
    do
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      localObject2 = null;
      if (!bool) {
        break;
      }
      paramT1 = ((Iterator)localObject1).next();
    } while (!(((IdentifyComponent)paramT1).getData() instanceof Priority));
    break label58;
    paramT1 = null;
    label58:
    paramT1 = (IdentifyComponent)paramT1;
    if (paramT1 != null) {
      paramT1 = paramT1.getData();
    } else {
      paramT1 = null;
    }
    localObject1 = paramT1;
    if (!(paramT1 instanceof Priority)) {
      localObject1 = null;
    }
    paramT1 = (Priority)localObject1;
    if (paramT1 != null) {
      paramT1 = paramT1.priority;
    } else {
      paramT1 = null;
    }
    localObject1 = (Comparable)paramT1;
    paramT2 = ((Iterable)((Entity)paramT2).getComponents()).iterator();
    while (paramT2.hasNext())
    {
      paramT1 = paramT2.next();
      if ((((IdentifyComponent)paramT1).getData() instanceof Priority)) {
        break label166;
      }
    }
    paramT1 = null;
    label166:
    paramT1 = (IdentifyComponent)paramT1;
    if (paramT1 != null) {
      paramT1 = paramT1.getData();
    } else {
      paramT1 = null;
    }
    paramT2 = paramT1;
    if (!(paramT1 instanceof Priority)) {
      paramT2 = null;
    }
    paramT2 = (Priority)paramT2;
    paramT1 = localObject2;
    if (paramT2 != null) {
      paramT1 = paramT2.priority;
    }
    return ComparisonsKt.compareValues((Comparable)localObject1, (Comparable)paramT1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.dataprocessor.RenderModelHolder.queryByEntityId..inlined.sortedBy.1
 * JD-Core Version:    0.7.0.1
 */