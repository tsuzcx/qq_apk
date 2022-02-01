package kotlin.script.dependencies;

import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class ScriptDependenciesResolver$DefaultImpls
{
  @NotNull
  public static Future<KotlinScriptExternalDependencies> resolve(ScriptDependenciesResolver paramScriptDependenciesResolver, @NotNull ScriptContents paramScriptContents, @Nullable Map<String, ? extends Object> paramMap, @NotNull Function3<? super ScriptDependenciesResolver.ReportSeverity, ? super String, ? super ScriptContents.Position, Unit> paramFunction3, @Nullable KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContents, "script");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "report");
    return (Future)new PseudoFuture(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.ScriptDependenciesResolver.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */