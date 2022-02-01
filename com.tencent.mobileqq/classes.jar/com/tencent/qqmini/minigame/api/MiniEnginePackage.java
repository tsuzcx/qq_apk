package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.EnginePackage.Companion;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.mobileqq.triton.script.ScriptFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "jsLibVersion", "Lcom/tencent/mobileqq/triton/model/Version;", "baseLibDir", "Ljava/io/File;", "tritonSoVersion", "soDir", "jarFile", "globalConfig", "", "(Lcom/tencent/mobileqq/triton/model/Version;Ljava/io/File;Lcom/tencent/mobileqq/triton/model/Version;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "getBaseLibDir", "()Ljava/io/File;", "engineJar", "getEngineJar", "getGlobalConfig", "()Ljava/lang/String;", "getJsLibVersion", "()Lcom/tencent/mobileqq/triton/model/Version;", "getSoDir", "version", "getVersion", "getEngineNativeLibrary", "name", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniEnginePackage
  implements EnginePackage
{
  @NotNull
  private final File baseLibDir;
  @NotNull
  private final Version jsLibVersion;
  @Nullable
  private final File soDir;
  
  public MiniEnginePackage(@NotNull Version paramVersion1, @NotNull File paramFile1, @NotNull Version paramVersion2, @Nullable File paramFile2, @Nullable File paramFile3, @Nullable String paramString)
  {
    this.$$delegate_0 = EnginePackage.Companion.create(paramFile1, paramVersion2, paramFile2, paramFile3, paramString);
    this.jsLibVersion = paramVersion1;
    this.baseLibDir = paramFile1;
    this.soDir = paramFile2;
  }
  
  @NotNull
  public final File getBaseLibDir()
  {
    return this.baseLibDir;
  }
  
  @Nullable
  public File getEngineJar()
  {
    return this.$$delegate_0.getEngineJar();
  }
  
  @Nullable
  public File getEngineNativeLibrary(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return this.$$delegate_0.getEngineNativeLibrary(paramString);
  }
  
  @Nullable
  public String getGlobalConfig()
  {
    return this.$$delegate_0.getGlobalConfig();
  }
  
  @NotNull
  public final Version getJsLibVersion()
  {
    return this.jsLibVersion;
  }
  
  @NotNull
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return this.$$delegate_0.getScript(paramString);
  }
  
  @Nullable
  public final File getSoDir()
  {
    return this.soDir;
  }
  
  @NotNull
  public Version getVersion()
  {
    return this.$$delegate_0.getVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniEnginePackage
 * JD-Core Version:    0.7.0.1
 */