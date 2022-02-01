package kotlin.script.dependencies;

import java.io.File;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class KotlinScriptExternalDependencies$DefaultImpls
{
  public static int compareTo(KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies1, @NotNull KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies2)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinScriptExternalDependencies2, "other");
    int i = Dependencies_deprecatedKt.access$compareValues((Comparable)paramKotlinScriptExternalDependencies1.getJavaHome(), (Comparable)paramKotlinScriptExternalDependencies2.getJavaHome());
    if (i == 0) {
      i = Dependencies_deprecatedKt.access$compareIterables(paramKotlinScriptExternalDependencies1.getClasspath(), paramKotlinScriptExternalDependencies2.getClasspath());
    }
    if (i == 0) {
      i = Dependencies_deprecatedKt.access$compareIterables(paramKotlinScriptExternalDependencies1.getImports(), paramKotlinScriptExternalDependencies2.getImports());
    }
    if (i == 0) {
      i = Dependencies_deprecatedKt.access$compareIterables(paramKotlinScriptExternalDependencies1.getSources(), paramKotlinScriptExternalDependencies2.getSources());
    }
    if (i != 0) {
      return i;
    }
    return Dependencies_deprecatedKt.access$compareIterables(paramKotlinScriptExternalDependencies1.getScripts(), paramKotlinScriptExternalDependencies2.getScripts());
  }
  
  @NotNull
  public static Iterable<File> getClasspath(KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    return (Iterable)CollectionsKt.emptyList();
  }
  
  @NotNull
  public static Iterable<String> getImports(KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    return (Iterable)CollectionsKt.emptyList();
  }
  
  @Nullable
  public static String getJavaHome(KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    return null;
  }
  
  @NotNull
  public static Iterable<File> getScripts(KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    return (Iterable)CollectionsKt.emptyList();
  }
  
  @NotNull
  public static Iterable<File> getSources(KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies)
  {
    return (Iterable)CollectionsKt.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.KotlinScriptExternalDependencies.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */