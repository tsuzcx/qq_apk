package kotlin.script.experimental.dependencies;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "", "()V", "dependencies", "Lkotlin/script/experimental/dependencies/ScriptDependencies;", "getDependencies", "()Lkotlin/script/experimental/dependencies/ScriptDependencies;", "reports", "", "Lkotlin/script/experimental/dependencies/ScriptReport;", "getReports", "()Ljava/util/List;", "Failure", "Success", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Success;", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Failure;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public abstract class DependenciesResolver$ResolveResult
{
  @Nullable
  public abstract ScriptDependencies getDependencies();
  
  @NotNull
  public abstract List<ScriptReport> getReports();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.DependenciesResolver.ResolveResult
 * JD-Core Version:    0.7.0.1
 */