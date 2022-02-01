package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "element", "Lshark/LeakTraceReference;", "invoke"}, k=3, mv={1, 4, 1})
final class LeakTrace$signature$1
  extends Lambda
  implements Function1<LeakTraceReference, CharSequence>
{
  public static final 1 INSTANCE = new 1();
  
  LeakTrace$signature$1()
  {
    super(1);
  }
  
  @NotNull
  public final CharSequence invoke(@NotNull LeakTraceReference paramLeakTraceReference)
  {
    Intrinsics.checkParameterIsNotNull(paramLeakTraceReference, "element");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLeakTraceReference.getOriginObject().getClassName());
    localStringBuilder.append(paramLeakTraceReference.getReferenceGenericName());
    return (CharSequence)localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTrace.signature.1
 * JD-Core Version:    0.7.0.1
 */