package kotlin.script.experimental.dependencies;

import java.util.Map;
import kotlin.Metadata;
import kotlin.script.dependencies.ScriptContents;
import kotlin.script.dependencies.ScriptDependenciesResolver;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/DependenciesResolver;", "Lkotlin/script/dependencies/ScriptDependenciesResolver;", "resolve", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "scriptContents", "Lkotlin/script/dependencies/ScriptContents;", "environment", "", "", "", "Lkotlin/script/dependencies/Environment;", "NoDependencies", "ResolveResult", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public abstract interface DependenciesResolver
  extends ScriptDependenciesResolver
{
  @NotNull
  public abstract DependenciesResolver.ResolveResult resolve(@NotNull ScriptContents paramScriptContents, @NotNull Map<String, ? extends Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.DependenciesResolver
 * JD-Core Version:    0.7.0.1
 */