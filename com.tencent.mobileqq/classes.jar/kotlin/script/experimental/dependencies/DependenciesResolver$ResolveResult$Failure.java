package kotlin.script.experimental.dependencies;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Failure;", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "reports", "", "Lkotlin/script/experimental/dependencies/ScriptReport;", "([Lkotlin/script/experimental/dependencies/ScriptReport;)V", "", "(Ljava/util/List;)V", "dependencies", "Lkotlin/script/experimental/dependencies/ScriptDependencies;", "getDependencies", "()Lkotlin/script/experimental/dependencies/ScriptDependencies;", "getReports", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public final class DependenciesResolver$ResolveResult$Failure
  extends DependenciesResolver.ResolveResult
{
  @NotNull
  private final List<ScriptReport> reports;
  
  public DependenciesResolver$ResolveResult$Failure(@NotNull List<ScriptReport> paramList)
  {
    super(null);
    this.reports = paramList;
  }
  
  public DependenciesResolver$ResolveResult$Failure(@NotNull ScriptReport... paramVarArgs)
  {
    this(ArraysKt.asList(paramVarArgs));
  }
  
  @NotNull
  public final List<ScriptReport> component1()
  {
    return getReports();
  }
  
  @NotNull
  public final Failure copy(@NotNull List<ScriptReport> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "reports");
    return new Failure(paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Failure))
      {
        paramObject = (Failure)paramObject;
        if (Intrinsics.areEqual(getReports(), paramObject.getReports())) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public ScriptDependencies getDependencies()
  {
    return null;
  }
  
  @NotNull
  public List<ScriptReport> getReports()
  {
    return this.reports;
  }
  
  public int hashCode()
  {
    List localList = getReports();
    if (localList != null) {
      return localList.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failure(reports=");
    localStringBuilder.append(getReports());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.DependenciesResolver.ResolveResult.Failure
 * JD-Core Version:    0.7.0.1
 */