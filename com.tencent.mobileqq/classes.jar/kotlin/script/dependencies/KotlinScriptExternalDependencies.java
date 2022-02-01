package kotlin.script.dependencies;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/dependencies/KotlinScriptExternalDependencies;", "", "classpath", "", "Ljava/io/File;", "getClasspath", "()Ljava/lang/Iterable;", "imports", "", "getImports", "javaHome", "getJavaHome", "()Ljava/lang/String;", "scripts", "getScripts", "sources", "getSources", "compareTo", "", "other", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public abstract interface KotlinScriptExternalDependencies
  extends Comparable<KotlinScriptExternalDependencies>
{
  public abstract int compareTo(@NotNull KotlinScriptExternalDependencies paramKotlinScriptExternalDependencies);
  
  @NotNull
  public abstract Iterable<File> getClasspath();
  
  @NotNull
  public abstract Iterable<String> getImports();
  
  @Nullable
  public abstract String getJavaHome();
  
  @NotNull
  public abstract Iterable<File> getScripts();
  
  @NotNull
  public abstract Iterable<File> getSources();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.KotlinScriptExternalDependencies
 * JD-Core Version:    0.7.0.1
 */