package kotlin.script.dependencies;

import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/dependencies/ScriptDependenciesResolver;", "", "resolve", "Ljava/util/concurrent/Future;", "Lkotlin/script/dependencies/KotlinScriptExternalDependencies;", "script", "Lkotlin/script/dependencies/ScriptContents;", "environment", "", "", "Lkotlin/script/dependencies/Environment;", "report", "Lkotlin/Function3;", "Lkotlin/script/dependencies/ScriptDependenciesResolver$ReportSeverity;", "Lkotlin/script/dependencies/ScriptContents$Position;", "", "previousDependencies", "ReportSeverity", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public abstract interface ScriptDependenciesResolver
{
  @NotNull
  public abstract Future<KotlinScriptExternalDependencies> resolve(@NotNull ScriptContents paramScriptContents, @Nullable Map<String, ? extends Object> paramMap, @NotNull Function3<? super ScriptDependenciesResolver.ReportSeverity, ? super String, ? super ScriptContents.Position, Unit> paramFunction3, @Nullable KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.ScriptDependenciesResolver
 * JD-Core Version:    0.7.0.1
 */