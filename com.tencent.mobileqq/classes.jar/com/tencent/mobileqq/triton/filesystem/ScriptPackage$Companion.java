package com.tencent.mobileqq.triton.filesystem;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage$Companion;", "", "()V", "create", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "baseDir", "Ljava/io/File;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class ScriptPackage$Companion
{
  @NotNull
  public final ScriptPackage create(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "baseDir");
    return (ScriptPackage)new ScriptPackage.Companion.create.1(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.ScriptPackage.Companion
 * JD-Core Version:    0.7.0.1
 */