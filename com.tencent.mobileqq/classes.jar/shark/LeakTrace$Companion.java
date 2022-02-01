package shark;

import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTrace$Companion;", "", "()V", "ZERO_WIDTH_SPACE", "", "serialVersionUID", "", "getNextElementString", "", "leakTrace", "Lshark/LeakTrace;", "reference", "Lshark/LeakTraceReference;", "index", "", "showLeakingStatus", "", "shark"}, k=1, mv={1, 4, 1})
public final class LeakTrace$Companion
{
  private final String a(LeakTrace paramLeakTrace, LeakTraceReference paramLeakTraceReference, int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramLeakTraceReference.getReferenceType() == LeakTraceReference.ReferenceType.STATIC_FIELD) {
      str = " static";
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("    ↓");
    localStringBuilder.append(str);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramLeakTraceReference.getOwningClassSimpleName());
    localStringBuilder.append('.');
    localStringBuilder.append(paramLeakTraceReference.getReferenceDisplayName());
    paramLeakTraceReference = localStringBuilder.toString();
    if ((paramBoolean) && (paramLeakTrace.referencePathElementIsSuspect(paramInt)))
    {
      paramInt = StringsKt.lastIndexOf$default((CharSequence)paramLeakTraceReference, '.', 0, false, 6, null) + 1;
      int i = paramLeakTraceReference.length();
      paramLeakTrace = StringsKt.repeat((CharSequence)" ", paramInt);
      str = StringsKt.repeat((CharSequence)"~", i - paramInt);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n│");
      localStringBuilder.append(paramLeakTraceReference);
      localStringBuilder.append("\n│");
      localStringBuilder.append(paramLeakTrace);
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    paramLeakTrace = new StringBuilder();
    paramLeakTrace.append("\n│");
    paramLeakTrace.append(paramLeakTraceReference);
    return paramLeakTrace.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTrace.Companion
 * JD-Core Version:    0.7.0.1
 */