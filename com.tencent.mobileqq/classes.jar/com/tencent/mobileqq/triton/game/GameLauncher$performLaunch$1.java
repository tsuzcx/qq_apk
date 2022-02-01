package com.tencent.mobileqq.triton.game;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.init.ScriptLoader;
import com.tencent.mobileqq.triton.internal.script.ScriptRuntime;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameLauncher$performLaunch$1
  implements Runnable
{
  GameLauncher$performLaunch$1(GameLauncher paramGameLauncher, Function0 paramFunction0) {}
  
  public final void run()
  {
    long l = SystemClock.uptimeMillis();
    Throwable localThrowable1 = (Throwable)null;
    try
    {
      this.$onLaunchBegin.invoke();
      GameLauncher.access$injectGameInfo(this.this$0);
      Object localObject1 = ScriptLoader.INSTANCE.getGameScripts(GameLauncher.access$getMTritonEngine$p(this.this$0).getEngineContext().getGamePackage());
      Object localObject2 = (ScriptFile)((Map)localObject1).get(ScriptContextType.OPEN_DATA);
      if ((localObject2 != null) && (((ScriptFile)localObject2).getValid() == true))
      {
        localObject3 = GameLauncher.access$getMTritonEngine$p(this.this$0).getEngineContext().getScriptSystem().getScriptEngine(ScriptContextType.OPEN_DATA);
        GameLauncher.access$getMGameScriptLoadStatics$p(this.this$0).add(((ScriptRuntime)localObject3).loadScript((ScriptFile)localObject2));
      }
      localObject2 = GameLauncher.access$getMTritonEngine$p(this.this$0).getEngineContext().getScriptSystem().getScriptEngine(ScriptContextType.MAIN);
      Object localObject3 = GameLauncher.access$getMGameScriptLoadStatics$p(this.this$0);
      localObject1 = MapsKt.getValue((Map)localObject1, ScriptContextType.MAIN);
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((ArrayList)localObject3).add(((ScriptRuntime)localObject2).loadScript((ScriptFile)localObject1));
    }
    catch (Throwable localThrowable2)
    {
      label185:
      break label185;
    }
    l = SystemClock.uptimeMillis() - l;
    Logger.i$default("GameLauncher", "launch game [" + GameLauncher.access$getMTritonEngine$p(this.this$0).getEngineContext().getGamePackage().getId() + "] cost time: " + l + " ms", null, 4, null);
    GameLauncher.access$notifyGameLaunched(this.this$0, l, (List)GameLauncher.access$getMGameScriptLoadStatics$p(this.this$0), localThrowable1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.performLaunch.1
 * JD-Core Version:    0.7.0.1
 */