package com.tencent.mobileqq.triton.game;

import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/triton/game/GameLauncher$launchGame$1$launchAfterInit$1"}, k=3, mv={1, 1, 16})
final class GameLauncher$launchGame$$inlined$synchronized$lambda$1
  implements Runnable
{
  GameLauncher$launchGame$$inlined$synchronized$lambda$1(GameLauncher paramGameLauncher, GameLaunchCallback paramGameLaunchCallback, GameLaunchParam paramGameLaunchParam, Function0 paramFunction0) {}
  
  public final void run()
  {
    GameLauncher.access$performLaunch(this.this$0, this.$callback$inlined, this.$param$inlined, this.$onLaunchBegin$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.launchGame..inlined.synchronized.lambda.1
 * JD-Core Version:    0.7.0.1
 */