package shark.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "objectId", "", "invoke"}, k=3, mv={1, 4, 1})
final class DominatorTree$buildFullDominatorTree$retainedSizes$1
  extends Lambda
  implements Function1<Long, Integer>
{
  DominatorTree$buildFullDominatorTree$retainedSizes$1(Function1 paramFunction1, Map paramMap)
  {
    super(1);
  }
  
  public final int invoke(long paramLong)
  {
    int i = ((Number)this.$computeSize.invoke(Long.valueOf(paramLong))).intValue();
    ((DominatorTree.MutableDominatorNode)MapsKt.getValue(this.$dominators, Long.valueOf(paramLong))).a(i);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.DominatorTree.buildFullDominatorTree.retainedSizes.1
 * JD-Core Version:    0.7.0.1
 */