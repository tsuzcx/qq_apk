package shark.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import shark.internal.hppc.LongLongScatterMap;
import shark.internal.hppc.LongLongScatterMap.ForEachCallback;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/internal/DominatorTree$computeRetainedSizes$2", "Lshark/internal/hppc/LongLongScatterMap$ForEachCallback;", "onEntry", "", "key", "", "value", "shark"}, k=1, mv={1, 4, 1})
public final class DominatorTree$computeRetainedSizes$2
  implements LongLongScatterMap.ForEachCallback
{
  DominatorTree$computeRetainedSizes$2(Map paramMap, Function1 paramFunction1) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject1 = (Pair)this.b.get(Long.valueOf(paramLong1));
    int i;
    int k;
    int j;
    if (localObject1 != null)
    {
      i = ((Number)((Pair)localObject1).component1()).intValue();
      k = ((Number)((Pair)localObject1).component2()).intValue();
      j = ((Number)this.c.invoke(Long.valueOf(paramLong1))).intValue();
      this.b.put(Long.valueOf(paramLong1), TuplesKt.to(Integer.valueOf(i + j), Integer.valueOf(k + 1)));
    }
    else
    {
      j = -1;
    }
    if (paramLong2 != 0L)
    {
      localObject1 = CollectionsKt.mutableListOf(new Long[] { Long.valueOf(paramLong1) });
      while (paramLong2 != 0L)
      {
        if (this.b.containsKey(Long.valueOf(paramLong2)))
        {
          Object localObject2 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            long l = ((Number)((Iterator)localObject2).next()).longValue();
            DominatorTree.a(this.a).a(l, paramLong2);
          }
          i = j;
          if (j == -1) {
            i = ((Number)this.c.invoke(Long.valueOf(paramLong1))).intValue();
          }
          localObject2 = (Pair)MapsKt.getValue(this.b, Long.valueOf(paramLong2));
          j = ((Number)((Pair)localObject2).component1()).intValue();
          k = ((Number)((Pair)localObject2).component2()).intValue();
          this.b.put(Long.valueOf(paramLong2), TuplesKt.to(Integer.valueOf(j + i), Integer.valueOf(k + 1)));
          ((List)localObject1).clear();
        }
        else
        {
          ((Collection)localObject1).add(Long.valueOf(paramLong2));
          i = j;
        }
        paramLong2 = DominatorTree.a(this.a).b(paramLong2);
        j = i;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramLong1 = ((Number)((Iterator)localObject1).next()).longValue();
        DominatorTree.a(this.a).a(paramLong1, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.DominatorTree.computeRetainedSizes.2
 * JD-Core Version:    0.7.0.1
 */