package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.model.Version;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "engineJar", "Ljava/io/File;", "getEngineJar", "()Ljava/io/File;", "globalConfig", "", "getGlobalConfig", "()Ljava/lang/String;", "version", "Lcom/tencent/mobileqq/triton/model/Version;", "getVersion", "()Lcom/tencent/mobileqq/triton/model/Version;", "getEngineNativeLibrary", "name", "Companion", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface EnginePackage
  extends ScriptPackage
{
  public static final EnginePackage.Companion Companion = EnginePackage.Companion.$$INSTANCE;
  
  @Nullable
  public abstract File getEngineJar();
  
  @Nullable
  public abstract File getEngineNativeLibrary(@NotNull String paramString);
  
  @Nullable
  public abstract String getGlobalConfig();
  
  @NotNull
  public abstract Version getVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.EnginePackage
 * JD-Core Version:    0.7.0.1
 */