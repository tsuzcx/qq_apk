package kotlin.script.experimental.dependencies;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asSuccess", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult$Success;", "Lkotlin/script/experimental/dependencies/ScriptDependencies;", "kotlin-script-runtime"}, k=2, mv={1, 1, 16})
public final class ResolversKt
{
  @NotNull
  public static final DependenciesResolver.ResolveResult.Success asSuccess(@NotNull ScriptDependencies paramScriptDependencies)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptDependencies, "$this$asSuccess");
    return new DependenciesResolver.ResolveResult.Success(paramScriptDependencies, null, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.ResolversKt
 * JD-Core Version:    0.7.0.1
 */