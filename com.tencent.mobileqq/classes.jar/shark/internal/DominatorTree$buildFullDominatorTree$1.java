package shark.internal;

import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import shark.internal.hppc.LongLongScatterMap.ForEachCallback;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/internal/DominatorTree$buildFullDominatorTree$1", "Lshark/internal/hppc/LongLongScatterMap$ForEachCallback;", "onEntry", "", "key", "", "value", "shark"}, k=1, mv={1, 4, 1})
public final class DominatorTree$buildFullDominatorTree$1
  implements LongLongScatterMap.ForEachCallback
{
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject1 = this.a;
    Object localObject2 = Long.valueOf(paramLong1);
    if (((Map)localObject1).get(localObject2) == null) {
      ((Map)localObject1).put(localObject2, new DominatorTree.MutableDominatorNode());
    }
    Map localMap = this.a;
    Long localLong = Long.valueOf(paramLong2);
    localObject2 = localMap.get(localLong);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new DominatorTree.MutableDominatorNode();
      localMap.put(localLong, localObject1);
    }
    ((Collection)((DominatorTree.MutableDominatorNode)localObject1).b()).add(Long.valueOf(paramLong1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.DominatorTree.buildFullDominatorTree.1
 * JD-Core Version:    0.7.0.1
 */