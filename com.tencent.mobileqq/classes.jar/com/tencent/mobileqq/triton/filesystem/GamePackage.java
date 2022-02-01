package com.tencent.mobileqq.triton.filesystem;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "environment", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "getEnvironment", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "gameConfig", "", "getGameConfig", "()Ljava/lang/String;", "id", "getId", "name", "getName", "optionConfig", "", "", "getOptionConfig", "()Ljava/util/Map;", "orientation", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "getOrientation", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "plugins", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "getPlugins", "()Ljava/util/List;", "version", "getVersion", "getSubpackage", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "Companion", "Environment", "Orientation", "SubpackageListener", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface GamePackage
  extends ScriptPackage
{
  public static final GamePackage.Companion Companion = GamePackage.Companion.$$INSTANCE;
  
  @NotNull
  public abstract GamePackage.Environment getEnvironment();
  
  @NotNull
  public abstract String getGameConfig();
  
  @NotNull
  public abstract String getId();
  
  @NotNull
  public abstract String getName();
  
  @NotNull
  public abstract Map<String, Object> getOptionConfig();
  
  @NotNull
  public abstract GamePackage.Orientation getOrientation();
  
  @NotNull
  public abstract List<GamePluginPackage> getPlugins();
  
  public abstract void getSubpackage(@NotNull String paramString, @NotNull GamePackage.SubpackageListener paramSubpackageListener);
  
  @NotNull
  public abstract String getVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GamePackage
 * JD-Core Version:    0.7.0.1
 */