package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/filesystem/GamePackage$Companion$create$1", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "environment", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "getEnvironment", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "gameConfig", "", "getGameConfig", "()Ljava/lang/String;", "id", "getId", "name", "getName", "optionConfig", "", "", "getOptionConfig", "()Ljava/util/Map;", "orientation", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "getOrientation", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "plugins", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "getPlugins", "()Ljava/util/List;", "version", "getVersion", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "getSubpackage", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "toString", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GamePackage$Companion$create$1
  implements GamePackage
{
  @NotNull
  private final GamePackage.Environment environment;
  @NotNull
  private final String gameConfig;
  @NotNull
  private final String id;
  @NotNull
  private final String name;
  @NotNull
  private final Map<String, Object> optionConfig;
  @NotNull
  private final GamePackage.Orientation orientation;
  @NotNull
  private final List<GamePluginPackage> plugins;
  @NotNull
  private final String version;
  
  GamePackage$Companion$create$1(File paramFile, Function2 paramFunction2, String paramString1, String paramString2, String paramString3, String paramString4, GamePackage.Orientation paramOrientation, GamePackage.Environment paramEnvironment, Map paramMap, List paramList)
  {
    this.id = paramString2;
    this.name = paramString1;
    this.gameConfig = paramString4;
    this.orientation = paramOrientation;
    this.environment = paramEnvironment;
    this.optionConfig = paramMap;
    this.version = paramString3;
    this.plugins = paramList;
  }
  
  @NotNull
  public GamePackage.Environment getEnvironment()
  {
    return this.environment;
  }
  
  @NotNull
  public String getGameConfig()
  {
    return this.gameConfig;
  }
  
  @NotNull
  public String getId()
  {
    return this.id;
  }
  
  @NotNull
  public String getName()
  {
    return this.name;
  }
  
  @NotNull
  public Map<String, Object> getOptionConfig()
  {
    return this.optionConfig;
  }
  
  @NotNull
  public GamePackage.Orientation getOrientation()
  {
    return this.orientation;
  }
  
  @NotNull
  public List<GamePluginPackage> getPlugins()
  {
    return this.plugins;
  }
  
  @NotNull
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    File localFile1 = new File(this.$packageDir, paramString);
    File localFile2 = this.$packageDir;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".cc");
    return (ScriptFile)new ScriptFile.Path(paramString, localFile1, new File(localFile2, localStringBuilder.toString()));
  }
  
  public void getSubpackage(@NotNull String paramString, @NotNull GamePackage.SubpackageListener paramSubpackageListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramSubpackageListener, "callback");
    this.$subPackageDownloader.invoke(paramString, paramSubpackageListener);
  }
  
  @NotNull
  public String getVersion()
  {
    return this.version;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GamePackage{");
    localStringBuilder.append(this.$name);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.$id);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.$version);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GamePackage.Companion.create.1
 * JD-Core Version:    0.7.0.1
 */