package com.tencent.mobileqq.triton.filesystem;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/TemporaryFile;", "", "file", "Ljava/io/File;", "pathInGame", "", "(Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getPathInGame", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class TemporaryFile
{
  @NotNull
  private final File file;
  @NotNull
  private final String pathInGame;
  
  public TemporaryFile(@NotNull File paramFile, @NotNull String paramString)
  {
    this.file = paramFile;
    this.pathInGame = paramString;
  }
  
  @NotNull
  public final File component1()
  {
    return this.file;
  }
  
  @NotNull
  public final String component2()
  {
    return this.pathInGame;
  }
  
  @NotNull
  public final TemporaryFile copy(@NotNull File paramFile, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    Intrinsics.checkParameterIsNotNull(paramString, "pathInGame");
    return new TemporaryFile(paramFile, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof TemporaryFile))
      {
        paramObject = (TemporaryFile)paramObject;
        if ((!Intrinsics.areEqual(this.file, paramObject.file)) || (!Intrinsics.areEqual(this.pathInGame, paramObject.pathInGame))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final File getFile()
  {
    return this.file;
  }
  
  @NotNull
  public final String getPathInGame()
  {
    return this.pathInGame;
  }
  
  public int hashCode()
  {
    int j = 0;
    Object localObject = this.file;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.pathInGame;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "TemporaryFile(file=" + this.file + ", pathInGame=" + this.pathInGame + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.TemporaryFile
 * JD-Core Version:    0.7.0.1
 */