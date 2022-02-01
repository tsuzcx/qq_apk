package com.tencent.mobileqq.triton.internal.utils;

import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Environment;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Orientation;
import com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/utils/Utils$decorate$2", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "environment", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "getEnvironment", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "gameConfig", "", "getGameConfig", "()Ljava/lang/String;", "id", "getId", "name", "getName", "optionConfig", "", "", "getOptionConfig", "()Ljava/util/Map;", "orientation", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "getOrientation", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "plugins", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "getPlugins", "()Ljava/util/List;", "version", "getVersion", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "getSubpackage", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class Utils$decorate$2
  implements GamePackage
{
  @NotNull
  private final List<GamePluginPackage> plugins;
  
  Utils$decorate$2(GamePackage paramGamePackage, boolean paramBoolean)
  {
    paramGamePackage = this.$this_decorate;
    this.$$delegate_0 = paramGamePackage;
    Object localObject = (Iterable)paramGamePackage.getPlugins();
    paramGamePackage = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramGamePackage.add(Utils.access$decorate((GamePluginPackage)((Iterator)localObject).next(), this.$enableCodeCache));
    }
    this.plugins = ((List)paramGamePackage);
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
    return this.plugins;
  }
  
  @NotNull
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return Utils.access$decorate(this.$this_decorate.getScript(paramString), this.$enableCodeCache, "/game/", paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.utils.Utils.decorate.2
 * JD-Core Version:    0.7.0.1
 */