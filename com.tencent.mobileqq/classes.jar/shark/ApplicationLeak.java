package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ApplicationLeak;", "Lshark/Leak;", "leakTraces", "", "Lshark/LeakTrace;", "(Ljava/util/List;)V", "getLeakTraces", "()Ljava/util/List;", "shortDescription", "", "getShortDescription", "()Ljava/lang/String;", "signature", "getSignature", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k=1, mv={1, 4, 1})
public final class ApplicationLeak
  extends Leak
{
  @NotNull
  public static final ApplicationLeak.Companion Companion = new ApplicationLeak.Companion(null);
  private static final long serialVersionUID = 524928276700576863L;
  @NotNull
  private final List<LeakTrace> leakTraces;
  
  public ApplicationLeak(@NotNull List<LeakTrace> paramList)
  {
    super(null);
    this.leakTraces = paramList;
  }
  
  @NotNull
  public final List<LeakTrace> component1()
  {
    return getLeakTraces();
  }
  
  @NotNull
  public final ApplicationLeak copy(@NotNull List<LeakTrace> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "leakTraces");
    return new ApplicationLeak(paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ApplicationLeak))
      {
        paramObject = (ApplicationLeak)paramObject;
        if (Intrinsics.areEqual(getLeakTraces(), paramObject.getLeakTraces())) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public List<LeakTrace> getLeakTraces()
  {
    return this.leakTraces;
  }
  
  @NotNull
  public String getShortDescription()
  {
    LeakTrace localLeakTrace = (LeakTrace)CollectionsKt.first(getLeakTraces());
    Object localObject = (LeakTraceReference)SequencesKt.firstOrNull(localLeakTrace.getSuspectReferenceSubpath());
    if (localObject != null)
    {
      String str = ((LeakTraceReference)localObject).getReferenceGenericName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((LeakTraceReference)localObject).getOriginObject().getClassSimpleName());
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      localObject = localStringBuilder.toString();
      if (localObject != null) {
        return localObject;
      }
    }
    return localLeakTrace.getLeakingObject().getClassName();
  }
  
  @NotNull
  public String getSignature()
  {
    return ((LeakTrace)CollectionsKt.first(getLeakTraces())).getSignature();
  }
  
  public int hashCode()
  {
    List localList = getLeakTraces();
    if (localList != null) {
      return localList.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ApplicationLeak
 * JD-Core Version:    0.7.0.1
 */