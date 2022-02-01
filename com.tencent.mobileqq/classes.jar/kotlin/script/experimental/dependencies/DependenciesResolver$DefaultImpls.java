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
import kotlin.script.dependencies.ScriptDependenciesResolver;
import kotlin.script.dependencies.ScriptDependenciesResolver.DefaultImpls;
import kotlin.script.dependencies.ScriptDependenciesResolver.ReportSeverity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class DependenciesResolver$DefaultImpls
{
  @NotNull
  public static Future<KotlinScriptExternalDependencies> resolve(DependenciesResolver paramDependenciesResolver, @NotNull ScriptContents paramScriptContents, @Nullable Map<String, ? extends Object> paramMap, @NotNull Function3<? super ScriptDependenciesResolver.ReportSeverity, ? super String, ? super ScriptContents.Position, Unit> paramFunction3, @Nullable KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContents, "script");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "report");
    return ScriptDependenciesResolver.DefaultImpls.resolve((ScriptDependenciesResolver)paramDependenciesResolver, paramScriptContents, paramMap, paramFunction3, paramKotlinScriptExternalDependencies);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.DependenciesResolver.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */