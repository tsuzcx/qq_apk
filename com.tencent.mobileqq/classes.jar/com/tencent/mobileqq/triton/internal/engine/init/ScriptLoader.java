package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/init/ScriptLoader;", "", "()V", "ENGINE_SCRIPT_MAIN_NAME", "", "ENGINE_SCRIPT_OPEN_DATA_NAME", "ENGINE_SCRIPT_WORKER_NAME", "GAME_MAIN_ENTRY_SCRIPT", "GAME_OPEN_DATA_ENTRY_SCRIPT", "GAME_PLUGIN_ENTRY_SCRIPT", "GAME_SUB_PACKAGE_ENTRY_SCRIPT", "GAME_WORKER_ENTRY_SCRIPT", "getEngineScripts", "", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getGameScripts", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getSubPackageScripts", "subPackageScriptPackage", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "getScriptOrNull", "name", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ScriptLoader
{
  @NotNull
  public static final String ENGINE_SCRIPT_MAIN_NAME = "QGame.js";
  @NotNull
  public static final String ENGINE_SCRIPT_OPEN_DATA_NAME = "QGameOpenDataContext.js";
  @NotNull
  public static final String ENGINE_SCRIPT_WORKER_NAME = "QGameWorkerContext.js";
  @NotNull
  public static final String GAME_MAIN_ENTRY_SCRIPT = "game.js";
  @NotNull
  public static final String GAME_OPEN_DATA_ENTRY_SCRIPT = "subContext.js";
  @NotNull
  public static final String GAME_PLUGIN_ENTRY_SCRIPT = "plugin.js";
  @NotNull
  public static final String GAME_SUB_PACKAGE_ENTRY_SCRIPT = "game.js";
  @NotNull
  public static final String GAME_WORKER_ENTRY_SCRIPT = "workers.js";
  public static final ScriptLoader INSTANCE = new ScriptLoader();
  
  private final ScriptFile getScriptOrNull(@NotNull ScriptPackage paramScriptPackage, String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = paramScriptPackage.getScript(paramString);
      boolean bool = paramString.getValid();
      paramScriptPackage = localObject;
      if (bool) {
        paramScriptPackage = paramString;
      }
      return paramScriptPackage;
    }
    catch (TritonException paramScriptPackage) {}
    return null;
  }
  
  @NotNull
  public final Map<ScriptContextType, ScriptFile> getEngineScripts(@NotNull EnginePackage paramEnginePackage)
  {
    Intrinsics.checkParameterIsNotNull(paramEnginePackage, "enginePackage");
    return MapsKt.mapOf(new Pair[] { TuplesKt.to(ScriptContextType.MAIN, paramEnginePackage.getScript("QGame.js")), TuplesKt.to(ScriptContextType.OPEN_DATA, paramEnginePackage.getScript("QGameOpenDataContext.js")), TuplesKt.to(ScriptContextType.WORKER, paramEnginePackage.getScript("QGameWorkerContext.js")) });
  }
  
  @NotNull
  public final Map<ScriptContextType, ScriptFile> getGameScripts(@NotNull GamePackage paramGamePackage)
  {
    Intrinsics.checkParameterIsNotNull(paramGamePackage, "gamePackage");
    Object localObject1 = ScriptContextType.MAIN;
    Object localObject2 = paramGamePackage.getScript("game.js");
    if (((ScriptFile)localObject2).getValid())
    {
      localObject1 = TuplesKt.to(localObject1, localObject2);
      localObject2 = ScriptContextType.OPEN_DATA;
      paramGamePackage = (ScriptPackage)paramGamePackage;
      return MapsKt.mapOf(new Pair[] { localObject1, TuplesKt.to(localObject2, getScriptOrNull(paramGamePackage, "subContext.js")), TuplesKt.to(ScriptContextType.WORKER, getScriptOrNull(paramGamePackage, "workers.js")) });
    }
    throw ((Throwable)new TritonException("GamePackage don't have valid game.js", ErrorCodes.SCRIPT_LOAD_FAIL, null, 4, null));
  }
  
  @NotNull
  public final Map<ScriptContextType, ScriptFile> getSubPackageScripts(@NotNull ScriptPackage paramScriptPackage)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptPackage, "subPackageScriptPackage");
    return MapsKt.mapOf(TuplesKt.to(ScriptContextType.MAIN, getScriptOrNull(paramScriptPackage, "game.js")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.ScriptLoader
 * JD-Core Version:    0.7.0.1
 */