package kotlin.script.experimental.dependencies;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Success;", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "dependencies", "Lkotlin/script/experimental/dependencies/ScriptDependencies;", "reports", "", "Lkotlin/script/experimental/dependencies/ScriptReport;", "(Lkotlin/script/experimental/dependencies/ScriptDependencies;Ljava/util/List;)V", "getDependencies", "()Lkotlin/script/experimental/dependencies/ScriptDependencies;", "getReports", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public final class DependenciesResolver$ResolveResult$Success
  extends DependenciesResolver.ResolveResult
{
  @NotNull
  private final ScriptDependencies dependencies;
  @NotNull
  private final List<ScriptReport> reports;
  
  public DependenciesResolver$ResolveResult$Success(@NotNull ScriptDependencies paramScriptDependencies, @NotNull List<ScriptReport> paramList)
  {
    super(null);
    this.dependencies = paramScriptDependencies;
    this.reports = paramList;
  }
  
  @NotNull
  public final ScriptDependencies component1()
  {
    return getDependencies();
  }
  
  @NotNull
  public final List<ScriptReport> component2()
  {
    return getReports();
  }
  
  @NotNull
  public final Success copy(@NotNull ScriptDependencies paramScriptDependencies, @NotNull List<ScriptReport> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptDependencies, "dependencies");
    Intrinsics.checkParameterIsNotNull(paramList, "reports");
    return new Success(paramScriptDependencies, paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Success))
      {
        paramObject = (Success)paramObject;
        if ((Intrinsics.areEqual(getDependencies(), paramObject.getDependencies())) && (Intrinsics.areEqual(getReports(), paramObject.getReports()))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public ScriptDependencies getDependencies()
  {
    return this.dependencies;
  }
  
  @NotNull
  public List<ScriptReport> getReports()
  {
    return this.reports;
  }
  
  public int hashCode()
  {
    Object localObject = getDependencies();
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = getReports();
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Success(dependencies=");
    localStringBuilder.append(getDependencies());
    localStringBuilder.append(", reports=");
    localStringBuilder.append(getReports());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.DependenciesResolver.ResolveResult.Success
 * JD-Core Version:    0.7.0.1
 */