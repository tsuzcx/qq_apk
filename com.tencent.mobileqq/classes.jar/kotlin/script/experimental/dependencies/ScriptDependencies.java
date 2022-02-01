package kotlin.script.experimental.dependencies;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/ScriptDependencies;", "", "javaHome", "Ljava/io/File;", "classpath", "", "imports", "", "sources", "scripts", "(Ljava/io/File;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getClasspath", "()Ljava/util/List;", "getImports", "getJavaHome", "()Ljava/io/File;", "getScripts", "getSources", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public final class ScriptDependencies
{
  public static final ScriptDependencies.Companion Companion = new ScriptDependencies.Companion(null);
  @NotNull
  private static final ScriptDependencies Empty = new ScriptDependencies(null, null, null, null, null, 31, null);
  @NotNull
  private final List<File> classpath;
  @NotNull
  private final List<String> imports;
  @Nullable
  private final File javaHome;
  @NotNull
  private final List<File> scripts;
  @NotNull
  private final List<File> sources;
  
  public ScriptDependencies()
  {
    this(null, null, null, null, null, 31, null);
  }
  
  public ScriptDependencies(@Nullable File paramFile, @NotNull List<? extends File> paramList1, @NotNull List<String> paramList, @NotNull List<? extends File> paramList2, @NotNull List<? extends File> paramList3)
  {
    this.javaHome = paramFile;
    this.classpath = paramList1;
    this.imports = paramList;
    this.sources = paramList2;
    this.scripts = paramList3;
  }
  
  @Nullable
  public final File component1()
  {
    return this.javaHome;
  }
  
  @NotNull
  public final List<File> component2()
  {
    return this.classpath;
  }
  
  @NotNull
  public final List<String> component3()
  {
    return this.imports;
  }
  
  @NotNull
  public final List<File> component4()
  {
    return this.sources;
  }
  
  @NotNull
  public final List<File> component5()
  {
    return this.scripts;
  }
  
  @NotNull
  public final ScriptDependencies copy(@Nullable File paramFile, @NotNull List<? extends File> paramList1, @NotNull List<String> paramList, @NotNull List<? extends File> paramList2, @NotNull List<? extends File> paramList3)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "classpath");
    Intrinsics.checkParameterIsNotNull(paramList, "imports");
    Intrinsics.checkParameterIsNotNull(paramList2, "sources");
    Intrinsics.checkParameterIsNotNull(paramList3, "scripts");
    return new ScriptDependencies(paramFile, paramList1, paramList, paramList2, paramList3);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ScriptDependencies))
      {
        paramObject = (ScriptDependencies)paramObject;
        if ((Intrinsics.areEqual(this.javaHome, paramObject.javaHome)) && (Intrinsics.areEqual(this.classpath, paramObject.classpath)) && (Intrinsics.areEqual(this.imports, paramObject.imports)) && (Intrinsics.areEqual(this.sources, paramObject.sources)) && (Intrinsics.areEqual(this.scripts, paramObject.scripts))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final List<File> getClasspath()
  {
    return this.classpath;
  }
  
  @NotNull
  public final List<String> getImports()
  {
    return this.imports;
  }
  
  @Nullable
  public final File getJavaHome()
  {
    return this.javaHome;
  }
  
  @NotNull
  public final List<File> getScripts()
  {
    return this.scripts;
  }
  
  @NotNull
  public final List<File> getSources()
  {
    return this.sources;
  }
  
  public int hashCode()
  {
    Object localObject = this.javaHome;
    int n = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.classpath;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.imports;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.sources;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.scripts;
    if (localObject != null) {
      n = localObject.hashCode();
    }
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScriptDependencies(javaHome=");
    localStringBuilder.append(this.javaHome);
    localStringBuilder.append(", classpath=");
    localStringBuilder.append(this.classpath);
    localStringBuilder.append(", imports=");
    localStringBuilder.append(this.imports);
    localStringBuilder.append(", sources=");
    localStringBuilder.append(this.sources);
    localStringBuilder.append(", scripts=");
    localStringBuilder.append(this.scripts);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.ScriptDependencies
 * JD-Core Version:    0.7.0.1
 */