package kotlin.script.experimental.dependencies;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.script.dependencies.ScriptContents;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/AsyncDependenciesResolver;", "Lkotlin/script/experimental/dependencies/DependenciesResolver;", "resolve", "Lkotlin/script/experimental/dependencies/DependenciesResolver$ResolveResult;", "scriptContents", "Lkotlin/script/dependencies/ScriptContents;", "environment", "", "", "", "Lkotlin/script/dependencies/Environment;", "resolveAsync", "(Lkotlin/script/dependencies/ScriptContents;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public abstract interface AsyncDependenciesResolver
  extends DependenciesResolver
{
  @NotNull
  public abstract DependenciesResolver.ResolveResult resolve(@NotNull ScriptContents paramScriptContents, @NotNull Map<String, ? extends Object> paramMap);
  
  @Nullable
  public abstract Object resolveAsync(@NotNull ScriptContents paramScriptContents, @NotNull Map<String, ? extends Object> paramMap, @NotNull Continuation<? super DependenciesResolver.ResolveResult> paramContinuation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.AsyncDependenciesResolver
 * JD-Core Version:    0.7.0.1
 */