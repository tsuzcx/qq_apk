package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.model.Version;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/filesystem/EnginePackage$Companion$create$1", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "engineJar", "Ljava/io/File;", "getEngineJar", "()Ljava/io/File;", "globalConfig", "", "getGlobalConfig", "()Ljava/lang/String;", "version", "Lcom/tencent/mobileqq/triton/model/Version;", "getVersion", "()Lcom/tencent/mobileqq/triton/model/Version;", "getEngineNativeLibrary", "name", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class EnginePackage$Companion$create$1
  implements EnginePackage
{
  @Nullable
  private final File engineJar;
  @Nullable
  private final String globalConfig;
  @NotNull
  private final Version version;
  
  EnginePackage$Companion$create$1(File paramFile1, File paramFile2, File paramFile3, Version paramVersion, String paramString)
  {
    this.engineJar = paramFile3;
    this.version = paramVersion;
    this.globalConfig = paramString;
  }
  
  @Nullable
  public File getEngineJar()
  {
    return this.engineJar;
  }
  
  @Nullable
  public File getEngineNativeLibrary(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    File localFile = this.$soDir;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localFile != null)
    {
      paramString = new File(localFile, System.mapLibraryName(paramString));
      localObject1 = localObject2;
      if (paramString.exists()) {
        localObject1 = paramString;
      }
    }
    return localObject1;
  }
  
  @Nullable
  public String getGlobalConfig()
  {
    return this.globalConfig;
  }
  
  @NotNull
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    File localFile1 = new File(this.$baseLibDir, paramString);
    File localFile2 = this.$baseLibDir;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".cc");
    return (ScriptFile)new ScriptFile.Path(paramString, localFile1, new File(localFile2, localStringBuilder.toString()));
  }
  
  @NotNull
  public Version getVersion()
  {
    return this.version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.EnginePackage.Companion.create.1
 * JD-Core Version:    0.7.0.1
 */