package com.tencent.mobileqq.triton.script;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/ScriptFile$Path;", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "name", "", "path", "Ljava/io/File;", "codeCache", "(Ljava/lang/String;Ljava/io/File;Ljava/io/File;)V", "getCodeCache", "()Ljava/io/File;", "getName", "()Ljava/lang/String;", "getPath", "valid", "", "getValid", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class ScriptFile$Path
  extends ScriptFile
{
  @Nullable
  private final File codeCache;
  @NotNull
  private final String name;
  @NotNull
  private final File path;
  
  public ScriptFile$Path(@NotNull String paramString, @NotNull File paramFile1, @Nullable File paramFile2)
  {
    super(null);
    this.name = paramString;
    this.path = paramFile1;
    this.codeCache = paramFile2;
  }
  
  @NotNull
  public final String component1()
  {
    return this.name;
  }
  
  @NotNull
  public final File component2()
  {
    return this.path;
  }
  
  @Nullable
  public final File component3()
  {
    return this.codeCache;
  }
  
  @NotNull
  public final Path copy(@NotNull String paramString, @NotNull File paramFile1, @Nullable File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramFile1, "path");
    return new Path(paramString, paramFile1, paramFile2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof Path))
      {
        paramObject = (Path)paramObject;
        if ((!Intrinsics.areEqual(this.name, paramObject.name)) || (!Intrinsics.areEqual(this.path, paramObject.path)) || (!Intrinsics.areEqual(this.codeCache, paramObject.codeCache))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @Nullable
  public final File getCodeCache()
  {
    return this.codeCache;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  @NotNull
  public final File getPath()
  {
    return this.path;
  }
  
  public boolean getValid()
  {
    return (this.path.exists()) && (this.path.length() > 0L);
  }
  
  public int hashCode()
  {
    int k = 0;
    Object localObject = this.name;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.path;
      if (localObject == null) {
        break label70;
      }
    }
    label70:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.codeCache;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "Path(name=" + this.name + ", path=" + this.path + ", codeCache=" + this.codeCache + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ScriptFile.Path
 * JD-Core Version:    0.7.0.1
 */