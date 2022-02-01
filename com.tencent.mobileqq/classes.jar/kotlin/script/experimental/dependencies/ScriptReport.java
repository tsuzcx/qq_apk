package kotlin.script.experimental.dependencies;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/ScriptReport;", "", "message", "", "severity", "Lkotlin/script/experimental/dependencies/ScriptReport$Severity;", "position", "Lkotlin/script/experimental/dependencies/ScriptReport$Position;", "(Ljava/lang/String;Lkotlin/script/experimental/dependencies/ScriptReport$Severity;Lkotlin/script/experimental/dependencies/ScriptReport$Position;)V", "getMessage", "()Ljava/lang/String;", "getPosition", "()Lkotlin/script/experimental/dependencies/ScriptReport$Position;", "getSeverity", "()Lkotlin/script/experimental/dependencies/ScriptReport$Severity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Position", "Severity", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public final class ScriptReport
{
  @NotNull
  private final String message;
  @Nullable
  private final ScriptReport.Position position;
  @NotNull
  private final ScriptReport.Severity severity;
  
  public ScriptReport(@NotNull String paramString, @NotNull ScriptReport.Severity paramSeverity, @Nullable ScriptReport.Position paramPosition)
  {
    this.message = paramString;
    this.severity = paramSeverity;
    this.position = paramPosition;
  }
  
  @NotNull
  public final String component1()
  {
    return this.message;
  }
  
  @NotNull
  public final ScriptReport.Severity component2()
  {
    return this.severity;
  }
  
  @Nullable
  public final ScriptReport.Position component3()
  {
    return this.position;
  }
  
  @NotNull
  public final ScriptReport copy(@NotNull String paramString, @NotNull ScriptReport.Severity paramSeverity, @Nullable ScriptReport.Position paramPosition)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Intrinsics.checkParameterIsNotNull(paramSeverity, "severity");
    return new ScriptReport(paramString, paramSeverity, paramPosition);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ScriptReport))
      {
        paramObject = (ScriptReport)paramObject;
        if ((Intrinsics.areEqual(this.message, paramObject.message)) && (Intrinsics.areEqual(this.severity, paramObject.severity)) && (Intrinsics.areEqual(this.position, paramObject.position))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getMessage()
  {
    return this.message;
  }
  
  @Nullable
  public final ScriptReport.Position getPosition()
  {
    return this.position;
  }
  
  @NotNull
  public final ScriptReport.Severity getSeverity()
  {
    return this.severity;
  }
  
  public int hashCode()
  {
    Object localObject = this.message;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.severity;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.position;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScriptReport(message=");
    localStringBuilder.append(this.message);
    localStringBuilder.append(", severity=");
    localStringBuilder.append(this.severity);
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.position);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.ScriptReport
 * JD-Core Version:    0.7.0.1
 */