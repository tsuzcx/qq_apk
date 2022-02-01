package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.model.Version;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/EnginePackage$Companion;", "", "()V", "create", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "baseLibDir", "Ljava/io/File;", "version", "Lcom/tencent/mobileqq/triton/model/Version;", "soDir", "jarFile", "globalConfig", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class EnginePackage$Companion
{
  @NotNull
  public final EnginePackage create(@NotNull File paramFile1, @NotNull Version paramVersion, @Nullable File paramFile2, @Nullable File paramFile3, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "baseLibDir");
    Intrinsics.checkParameterIsNotNull(paramVersion, "version");
    return (EnginePackage)new EnginePackage.Companion.create.1(paramFile2, paramFile1, paramFile3, paramVersion, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.EnginePackage.Companion
 * JD-Core Version:    0.7.0.1
 */