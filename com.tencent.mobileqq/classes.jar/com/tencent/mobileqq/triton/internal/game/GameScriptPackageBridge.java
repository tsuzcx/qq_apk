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
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Iterator localIterator = ((Iterable)this.gamePackage.getPlugins()).iterator();
        if (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          if (!Intrinsics.areEqual(((GamePluginPackage)localObject2).getName(), paramString)) {
            continue;
          }
          paramString = (String)localObject2;
          localObject2 = (GamePluginPackage)paramString;
          paramString = localObject1;
          if (localObject2 != null) {
            paramString = ScriptPackageBridgesKt.access$toNativeType(((GamePluginPackage)localObject2).getScript("plugin.js"), ((GamePluginPackage)localObject2).getId());
          }
          return paramString;
        }
      }
      catch (TritonException paramString)
      {
        return null;
      }
      paramString = null;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.game.GameScriptPackageBridge
 * JD-Core Version:    0.7.0.1
 */