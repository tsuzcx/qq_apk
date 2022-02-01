package com.tencent.mobileqq.triton.internal.game;

import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/game/GameScriptPackageBridge;", "", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "(Lcom/tencent/mobileqq/triton/filesystem/GamePackage;)V", "getPluginScript", "", "", "pluginName", "(Ljava/lang/String;)[Ljava/lang/String;", "getScript", "name", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeProxy(allFields=false, allMethods=true, namespace="triton::jni")
public final class GameScriptPackageBridge
{
  private final GamePackage gamePackage;
  
  public GameScriptPackageBridge(@NotNull GamePackage paramGamePackage)
  {
    this.gamePackage = paramGamePackage;
  }
  
  @Nullable
  public final String[] getPluginScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pluginName");
    try
    {
      Iterator localIterator = ((Iterable)this.gamePackage.getPlugins()).iterator();
      Object localObject;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!Intrinsics.areEqual(((GamePluginPackage)localObject).getName(), paramString));
      for (paramString = localObject;; paramString = null)
      {
        paramString = (GamePluginPackage)paramString;
        if (paramString == null) {
          break;
        }
        paramString = ScriptPackageBridgesKt.access$toNativeType(paramString.getScript("plugin.js"), paramString.getId());
        return paramString;
      }
      return null;
    }
    catch (TritonException paramString) {}
    return null;
  }
  
  @Nullable
  public final String[] getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    try
    {
      paramString = ScriptPackageBridgesKt.access$toNativeType(this.gamePackage.getScript(paramString), null);
      return paramString;
    }
    catch (TritonException paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.game.GameScriptPackageBridge
 * JD-Core Version:    0.7.0.1
 */