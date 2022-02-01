package com.tencent.mobileqq.triton.filesystem;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "", "getFile", "Ljava/io/File;", "pathInGame", "", "getFilePathInGame", "file", "newTempFile", "Lcom/tencent/mobileqq/triton/filesystem/TemporaryFile;", "hash", "suffix", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface GameDataFileSystem
{
  @NotNull
  public abstract File getFile(@NotNull String paramString);
  
  @NotNull
  public abstract String getFilePathInGame(@NotNull File paramFile);
  
  @NotNull
  public abstract TemporaryFile newTempFile(@Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GameDataFileSystem
 * JD-Core Version:    0.7.0.1
 */