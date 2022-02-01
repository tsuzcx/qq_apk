package kotlin.script.dependencies;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asFuture", "Lkotlin/script/dependencies/PseudoFuture;", "Lkotlin/script/dependencies/KotlinScriptExternalDependencies;", "Environment", "", "", "", "kotlin-script-runtime"}, k=2, mv={1, 1, 16})
public final class Resolvers_deprecatedKt
{
  @NotNull
  public static final PseudoFuture<KotlinScriptExternalDependencies> asFuture(@Nullable KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    return new PseudoFuture(paramKotlinScriptExternalDependencies);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.Resolvers_deprecatedKt
 * JD-Core Version:    0.7.0.1
 */