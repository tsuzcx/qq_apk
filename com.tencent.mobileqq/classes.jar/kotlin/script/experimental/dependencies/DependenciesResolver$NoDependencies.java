package kotlin.script.experimental.dependencies;

import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.script.dependencies.KotlinScriptExternalDependencies;
import kotlin.script.dependencies.ScriptContents;
import kotlin.script.dependencies.ScriptContents.Position;
import kotlin.script.dependencies.ScriptDependenciesResolver.ReportSeverity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/DependenciesResolver$NoDependencies;", "Lkotlin/script/experimental/dependencies/DependenciesResolver;", "()V", "resolve", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Success;", "scriptContents", "Lkotlin/script/dependencies/ScriptContents;", "environment", "", "", "", "Lkotlin/script/dependencies/Environment;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public final class DependenciesResolver$NoDependencies
  implements DependenciesResolver
{
  public static final NoDependencies INSTANCE = new NoDependencies();
  
  @NotNull
  public Future<KotlinScriptExternalDependencies> resolve(@NotNull ScriptContents paramScriptContents, @Nullable Map<String, ? extends Object> paramMap, @NotNull Function3<? super ScriptDependenciesResolver.ReportSeverity, ? super String, ? super ScriptContents.Position, Unit> paramFunction3, @Nullable KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContents, "script");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "report");
    return DependenciesResolver.DefaultImpls.resolve(this, paramScriptContents, paramMap, paramFunction3, paramKotlinScriptExternalDependencies);
  }
  
  @NotNull
  public DependenciesResolver.ResolveResult.Success resolve(@NotNull ScriptContents paramScriptContents, @NotNull Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContents, "scriptContents");
    Intrinsics.checkParameterIsNotNull(paramMap, "environment");
    return ResolversKt.asSuccess(ScriptDependencies.Companion.getEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.DependenciesResolver.NoDependencies
 * JD-Core Version:    0.7.0.1
 */