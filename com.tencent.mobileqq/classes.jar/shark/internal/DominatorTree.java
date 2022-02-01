package shark.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import shark.internal.hppc.LongLongScatterMap;
import shark.internal.hppc.LongLongScatterMap.ForEachCallback;
import shark.internal.hppc.LongScatterSet;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/DominatorTree;", "", "expectedElements", "", "(I)V", "dominated", "Lshark/internal/hppc/LongLongScatterMap;", "buildFullDominatorTree", "", "", "Lshark/internal/ObjectDominators$DominatorNode;", "computeSize", "Lkotlin/Function1;", "computeRetainedSizes", "Lkotlin/Pair;", "retainedObjectIds", "", "updateDominated", "", "objectId", "parentObjectId", "updateDominatedAsRoot", "MutableDominatorNode", "shark"}, k=1, mv={1, 4, 1})
public final class DominatorTree
{
  private final LongLongScatterMap a;
  
  public DominatorTree()
  {
    this(0, 1, null);
  }
  
  public DominatorTree(int paramInt)
  {
    this.a = new LongLongScatterMap(paramInt);
  }
  
  @NotNull
  public final Map<Long, Pair<Integer, Integer>> a(@NotNull Set<Long> paramSet, @NotNull Function1<? super Long, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "retainedObjectIds");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "computeSize");
    Map localMap = (Map)new LinkedHashMap();
    paramSet = ((Iterable)paramSet).iterator();
    while (paramSet.hasNext()) {
      localMap.put(Long.valueOf(((Number)paramSet.next()).longValue()), TuplesKt.to(Integer.valueOf(0), Integer.valueOf(0)));
    }
    this.a.a((LongLongScatterMap.ForEachCallback)new DominatorTree.computeRetainedSizes.2(this, localMap, paramFunction1));
    this.a.c();
    return localMap;
  }
  
  public final boolean a(long paramLong1, long paramLong2)
  {
    int i = this.a.a(paramLong1);
    boolean bool;
    if (i != -1) {
      bool = true;
    } else {
      bool = false;
    }
    if ((bool) && (paramLong2 != 0L))
    {
      long l2 = this.a.a(i);
      if (l2 != 0L)
      {
        Object localObject = new LongScatterSet(0, 1, null);
        long l1 = l2;
        while (l1 != 0L)
        {
          ((LongScatterSet)localObject).a(l1);
          i = this.a.a(l1);
          if (i != -1)
          {
            l1 = this.a.a(i);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Did not find dominator for ");
            localStringBuilder.append(l1);
            localStringBuilder.append(" when going through the dominator chain for ");
            localStringBuilder.append(l2);
            localStringBuilder.append(": ");
            localStringBuilder.append(localObject);
            throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
          }
        }
        l1 = paramLong2;
        while ((l1 != 0L) && (!((LongScatterSet)localObject).b(l1)))
        {
          i = this.a.a(l1);
          if (i != -1)
          {
            l1 = this.a.a(i);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Did not find dominator for ");
            ((StringBuilder)localObject).append(l1);
            ((StringBuilder)localObject).append(" when going through the dominator chain for ");
            ((StringBuilder)localObject).append(paramLong2);
            throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString()));
          }
        }
        this.a.a(paramLong1, l1);
        return bool;
      }
    }
    else
    {
      this.a.a(paramLong1, paramLong2);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.DominatorTree
 * JD-Core Version:    0.7.0.1
 */