package kotlin.script.experimental.dependencies;

import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.script.dependencies.KotlinScriptExternalDependencies;
import kotlin.script.dependencies.ScriptContents;
import kotlin.script.dependencies.ScriptContents.Position;
import kotlin.script.dependencies.ScriptDependenciesResolver.ReportSeverity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class AsyncDependenciesResolver$DefaultImpls
{
  @NotNull
  public static Future<KotlinScriptExternalDependencies> resolve(AsyncDependenciesResolver paramAsyncDependenciesResolver, @NotNull ScriptContents paramScriptContents, @Nullable Map<String, ? extends Object> paramMap, @NotNull Function3<? super ScriptDependenciesResolver.ReportSeverity, ? super String, ? super ScriptContents.Position, Unit> paramFunction3, @Nullable KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContents, "script");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "report");
    return DependenciesResolver.DefaultImpls.resolve((DependenciesResolver)paramAsyncDependenciesResolver, paramScriptContents, paramMap, paramFunction3, paramKotlinScriptExternalDependencies);
  }
  
  @NotNull
  public static DependenciesResolver.ResolveResult resolve(AsyncDependenciesResolver paramAsyncDependenciesResolver, @NotNull ScriptContents paramScriptContents, @NotNull Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContents, "scriptContents");
    Intrinsics.checkParameterIsNotNull(paramMap, "environment");
    throw ((Throwable)new NotImplementedError(null, 1, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.AsyncDependenciesResolver.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */