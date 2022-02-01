package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ObjectInspectors$Companion;", "", "()V", "ANONYMOUS_CLASS_NAME_PATTERN", "", "ANONYMOUS_CLASS_NAME_PATTERN_REGEX", "Lkotlin/text/Regex;", "jdkDefaults", "", "Lshark/ObjectInspector;", "getJdkDefaults", "()Ljava/util/List;", "jdkLeakingObjectFilters", "Lshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "getJdkLeakingObjectFilters", "createLeakingObjectFilters", "inspectors", "", "Lshark/ObjectInspectors;", "shark"}, k=1, mv={1, 4, 1})
public final class ObjectInspectors$Companion
{
  @NotNull
  public final List<FilteringLeakingObjectFinder.LeakingObjectFilter> a(@NotNull Set<? extends ObjectInspectors> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "inspectors");
    Object localObject = (Iterable)paramSet;
    paramSet = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Function1 localFunction1 = ((ObjectInspectors)((Iterator)localObject).next()).getLeakingObjectFilter$shark();
      if (localFunction1 != null) {
        paramSet.add(localFunction1);
      }
    }
    localObject = (Iterable)paramSet;
    paramSet = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramSet.add(new ObjectInspectors.Companion.createLeakingObjectFilters.2.1((Function1)((Iterator)localObject).next()));
    }
    return (List)paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspectors.Companion
 * JD-Core Version:    0.7.0.1
 */