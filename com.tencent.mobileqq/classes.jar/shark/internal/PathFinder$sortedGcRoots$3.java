package shark.internal;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import shark.GcRoot;
import shark.HeapObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lshark/HeapObject;", "Lshark/GcRoot;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 1>", "compare"}, k=3, mv={1, 4, 1})
final class PathFinder$sortedGcRoots$3<T>
  implements Comparator<Pair<? extends HeapObject, ? extends GcRoot>>
{
  PathFinder$sortedGcRoots$3(Function1 paramFunction1) {}
  
  public final int a(Pair<? extends HeapObject, ? extends GcRoot> paramPair1, Pair<? extends HeapObject, ? extends GcRoot> paramPair2)
  {
    HeapObject localHeapObject = (HeapObject)paramPair1.component1();
    Object localObject = (GcRoot)paramPair1.component2();
    paramPair1 = (HeapObject)paramPair2.component1();
    paramPair2 = ((GcRoot)paramPair2.component2()).getClass().getName();
    localObject = localObject.getClass().getName();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "root1::class.java.name");
    int i = paramPair2.compareTo((String)localObject);
    if (i != 0) {
      return i;
    }
    return ((String)this.a.invoke(localHeapObject)).compareTo((String)this.a.invoke(paramPair1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.PathFinder.sortedGcRoots.3
 * JD-Core Version:    0.7.0.1
 */