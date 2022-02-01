package com.tencent.mobileqq.triton.filesystem;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage$Companion;", "", "()V", "create", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "name", "", "id", "version", "packageDir", "Ljava/io/File;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GamePluginPackage$Companion
{
  @NotNull
  public final GamePluginPackage create(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "id");
    Intrinsics.checkParameterIsNotNull(paramString3, "version");
    Intrinsics.checkParameterIsNotNull(paramFile, "packageDir");
    return (GamePluginPackage)new GamePluginPackage.Companion.create.1(paramFile, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GamePluginPackage.Companion
 * JD-Core Version:    0.7.0.1
 */