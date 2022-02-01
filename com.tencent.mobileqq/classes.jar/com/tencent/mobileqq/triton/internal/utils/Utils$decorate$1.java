package com.tencent.mobileqq.triton.internal.utils;

import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.mobileqq.triton.script.ScriptFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/utils/Utils$decorate$1", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "engineJar", "Ljava/io/File;", "getEngineJar", "()Ljava/io/File;", "globalConfig", "", "getGlobalConfig", "()Ljava/lang/String;", "version", "Lcom/tencent/mobileqq/triton/model/Version;", "getVersion", "()Lcom/tencent/mobileqq/triton/model/Version;", "getEngineNativeLibrary", "name", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class Utils$decorate$1
  implements EnginePackage
{
  Utils$decorate$1(EnginePackage paramEnginePackage, boolean paramBoolean) {}
  
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
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return Utils.access$decorate(this.$this_decorate.getScript(paramString), this.$enableCodeCache, "/game_preload/", paramString);
  }
  
  @NotNull
  public Version getVersion()
  {
    return this.$$delegate_0.getVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.utils.Utils.decorate.1
 * JD-Core Version:    0.7.0.1
 */