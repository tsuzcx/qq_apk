package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "index", "invoke", "(I)Ljava/lang/Integer;"}, k=3, mv={1, 4, 1})
final class HeapAnalyzer$computeLeakStatuses$nextNotLeakingIndex$1
  extends Lambda
  implements Function1<Integer, Integer>
{
  HeapAnalyzer$computeLeakStatuses$nextNotLeakingIndex$1(Ref.IntRef paramIntRef)
  {
    super(1);
  }
  
  @Nullable
  public final Integer invoke(int paramInt)
  {
    if (paramInt < this.$lastNotLeakingElementIndex.element) {
      return Integer.valueOf(paramInt + 1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalyzer.computeLeakStatuses.nextNotLeakingIndex.1
 * JD-Core Version:    0.7.0.1
 */