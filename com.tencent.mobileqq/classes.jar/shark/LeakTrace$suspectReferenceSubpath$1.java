package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "index", "", "<anonymous parameter 1>", "Lshark/LeakTraceReference;", "invoke"}, k=3, mv={1, 4, 1})
final class LeakTrace$suspectReferenceSubpath$1
  extends Lambda
  implements Function2<Integer, LeakTraceReference, Boolean>
{
  LeakTrace$suspectReferenceSubpath$1(LeakTrace paramLeakTrace)
  {
    super(2);
  }
  
  public final boolean invoke(int paramInt, @NotNull LeakTraceReference paramLeakTraceReference)
  {
    Intrinsics.checkParameterIsNotNull(paramLeakTraceReference, "<anonymous parameter 1>");
    return this.this$0.referencePathElementIsSuspect(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTrace.suspectReferenceSubpath.1
 * JD-Core Version:    0.7.0.1
 */