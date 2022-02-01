package com.tencent.mobileqq.triton.filesystem;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "version", "getVersion", "Companion", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface GamePluginPackage
  extends ScriptPackage
{
  public static final GamePluginPackage.Companion Companion = GamePluginPackage.Companion.$$INSTANCE;
  
  @NotNull
  public abstract String getId();
  
  @NotNull
  public abstract String getName();
  
  @NotNull
  public abstract String getVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GamePluginPackage
 * JD-Core Version:    0.7.0.1
 */