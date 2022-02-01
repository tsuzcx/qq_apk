package kotlin.script.dependencies;

import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/dependencies/BasicScriptDependenciesResolver;", "Lkotlin/script/dependencies/ScriptDependenciesResolver;", "()V", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public final class BasicScriptDependenciesResolver
  implements ScriptDependenciesResolver
{
  @NotNull
  public Future<KotlinScriptExternalDependencies> resolve(@NotNull ScriptContents paramScriptContents, @Nullable Map<String, ? extends Object> paramMap, @NotNull Function3<? super ScriptDependenciesResolver.ReportSeverity, ? super String, ? super ScriptContents.Position, Unit> paramFunction3, @Nullable KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContents, "script");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "report");
    return ScriptDependenciesResolver.DefaultImpls.resolve(this, paramScriptContents, paramMap, paramFunction3, paramKotlinScriptExternalDependencies);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.BasicScriptDependenciesResolver
 * JD-Core Version:    0.7.0.1
 */