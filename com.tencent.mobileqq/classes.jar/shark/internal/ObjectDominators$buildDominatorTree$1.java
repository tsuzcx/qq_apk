package shark.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "objectId", "", "invoke"}, k=3, mv={1, 4, 1})
final class ObjectDominators$buildDominatorTree$1
  extends Lambda
  implements Function1<Long, Integer>
{
  ObjectDominators$buildDominatorTree$1(Map paramMap, ShallowSizeCalculator paramShallowSizeCalculator)
  {
    super(1);
  }
  
  public final int invoke(long paramLong)
  {
    Integer localInteger = (Integer)this.$nativeSizes.get(Long.valueOf(paramLong));
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 0;
    }
    return i + this.$shallowSizeCalculator.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ObjectDominators.buildDominatorTree.1
 * JD-Core Version:    0.7.0.1
 */