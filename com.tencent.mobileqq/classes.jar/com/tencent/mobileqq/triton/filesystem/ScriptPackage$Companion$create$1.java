package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/filesystem/ScriptPackage$Companion$create$1", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile$Path;", "name", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class ScriptPackage$Companion$create$1
  implements ScriptPackage
{
  ScriptPackage$Companion$create$1(File paramFile) {}
  
  @NotNull
  public ScriptFile.Path getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    File localFile1 = new File(this.$baseDir, paramString);
    File localFile2 = this.$baseDir;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".cc");
    return new ScriptFile.Path(paramString, localFile1, new File(localFile2, localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.ScriptPackage.Companion.create.1
 * JD-Core Version:    0.7.0.1
 */