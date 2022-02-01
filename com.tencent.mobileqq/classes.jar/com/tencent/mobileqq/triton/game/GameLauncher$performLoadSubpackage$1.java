package com.tencent.mobileqq.triton.game;

import com.tencent.mobileqq.triton.internal.script.ScriptRuntime;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameLauncher$performLoadSubpackage$1
  implements Runnable
{
  GameLauncher$performLoadSubpackage$1(GameLauncher paramGameLauncher, ScriptRuntime paramScriptRuntime, ScriptFile paramScriptFile, String paramString, Function1 paramFunction1) {}
  
  public final void run()
  {
    ScriptLoadStatistic localScriptLoadStatistic = this.$scriptEngine.loadScript(this.$scriptFile);
    GameLauncher.access$onSubpackageLoaded(this.this$0, this.$name, this.$onComplete, localScriptLoadStatistic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.performLoadSubpackage.1
 * JD-Core Version:    0.7.0.1
 */