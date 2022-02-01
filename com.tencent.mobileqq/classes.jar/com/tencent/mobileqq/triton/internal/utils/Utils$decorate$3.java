package com.tencent.mobileqq.triton.internal.utils;

import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/utils/Utils$decorate$3", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "version", "getVersion", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class Utils$decorate$3
  implements GamePluginPackage
{
  Utils$decorate$3(GamePluginPackage paramGamePluginPackage, boolean paramBoolean) {}
  
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
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return Utils.access$decorate(this.$this_decorate.getScript(paramString), this.$enableCodeCache, "/game_plugin/", paramString);
  }
  
  @NotNull
  public String getVersion()
  {
    return this.$$delegate_0.getVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.utils.Utils.decorate.3
 * JD-Core Version:    0.7.0.1
 */