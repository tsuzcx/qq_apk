package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Environment;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Orientation;
import com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/api/QQMiniGamePackage;", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "gamePackage", "(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Lcom/tencent/mobileqq/triton/filesystem/GamePackage;)V", "environment", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "getEnvironment", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "gameConfig", "", "getGameConfig", "()Ljava/lang/String;", "id", "getId", "getMiniAppInfo", "()Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "name", "getName", "optionConfig", "", "", "getOptionConfig", "()Ljava/util/Map;", "orientation", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "getOrientation", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "plugins", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "getPlugins", "()Ljava/util/List;", "version", "getVersion", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "getSubpackage", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQMiniGamePackage
  implements GamePackage
{
  @NotNull
  private final MiniAppConfig miniAppInfo;
  
  public QQMiniGamePackage(@NotNull MiniAppConfig paramMiniAppConfig, @NotNull GamePackage paramGamePackage)
  {
    this.$$delegate_0 = paramGamePackage;
    this.miniAppInfo = paramMiniAppConfig;
  }
  
  @NotNull
  public GamePackage.Environment getEnvironment()
  {
    return this.$$delegate_0.getEnvironment();
  }
  
  @NotNull
  public String getGameConfig()
  {
    return this.$$delegate_0.getGameConfig();
  }
  
  @NotNull
  public String getId()
  {
    return this.$$delegate_0.getId();
  }
  
  @NotNull
  public final MiniAppConfig getMiniAppInfo()
  {
    return this.miniAppInfo;
  }
  
  @NotNull
  public String getName()
  {
    return this.$$delegate_0.getName();
  }
  
  @NotNull
  public Map<String, Object> getOptionConfig()
  {
    return this.$$delegate_0.getOptionConfig();
  }
  
  @NotNull
  public GamePackage.Orientation getOrientation()
  {
    return this.$$delegate_0.getOrientation();
  }
  
  @NotNull
  public List<GamePluginPackage> getPlugins()
  {
    return this.$$delegate_0.getPlugins();
  }
  
  @NotNull
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return this.$$delegate_0.getScript(paramString);
  }
  
  public void getSubpackage(@NotNull String paramString, @NotNull GamePackage.SubpackageListener paramSubpackageListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramSubpackageListener, "callback");
    this.$$delegate_0.getSubpackage(paramString, paramSubpackageListener);
  }
  
  @NotNull
  public String getVersion()
  {
    return this.$$delegate_0.getVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniGamePackage
 * JD-Core Version:    0.7.0.1
 */