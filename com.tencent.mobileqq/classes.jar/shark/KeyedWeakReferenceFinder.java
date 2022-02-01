package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.internal.KeyedWeakReferenceMirror;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/KeyedWeakReferenceFinder;", "Lshark/LeakingObjectFinder;", "()V", "findKeyedWeakReferences", "", "Lshark/internal/KeyedWeakReferenceMirror;", "graph", "Lshark/HeapGraph;", "findKeyedWeakReferences$shark", "findLeakingObjectIds", "", "", "heapDumpUptimeMillis", "(Lshark/HeapGraph;)Ljava/lang/Long;", "shark"}, k=1, mv={1, 4, 1})
public final class KeyedWeakReferenceFinder
  implements LeakingObjectFinder
{
  @NotNull
  public static final KeyedWeakReferenceFinder a = new KeyedWeakReferenceFinder();
  
  @NotNull
  public Set<Long> a(@NotNull HeapGraph paramHeapGraph)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "graph");
    Object localObject1 = (Iterable)c(paramHeapGraph);
    paramHeapGraph = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KeyedWeakReferenceMirror localKeyedWeakReferenceMirror = (KeyedWeakReferenceMirror)localObject2;
      int i;
      if ((localKeyedWeakReferenceMirror.a()) && (localKeyedWeakReferenceMirror.b())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramHeapGraph.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramHeapGraph;
    paramHeapGraph = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramHeapGraph.add(Long.valueOf(((KeyedWeakReferenceMirror)((Iterator)localObject1).next()).c().b()));
    }
    return CollectionsKt.toSet((Iterable)paramHeapGraph);
  }
  
  @Nullable
  public final Long b(@NotNull HeapGraph paramHeapGraph)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "graph");
    return (Long)paramHeapGraph.b().a("heapDumpUptimeMillis", (Function0)new KeyedWeakReferenceFinder.heapDumpUptimeMillis.1(paramHeapGraph));
  }
  
  @NotNull
  public final List<KeyedWeakReferenceMirror> c(@NotNull HeapGraph paramHeapGraph)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "graph");
    return (List)paramHeapGraph.b().a(ObjectInspectors.KEYED_WEAK_REFERENCE.name(), (Function0)new KeyedWeakReferenceFinder.findKeyedWeakReferences.1(paramHeapGraph));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.KeyedWeakReferenceFinder
 * JD-Core Version:    0.7.0.1
 */