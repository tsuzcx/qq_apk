package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "invoke"}, k=3, mv={1, 1, 16})
final class EnginePlatform$launchGame$2
  extends Lambda
  implements Function1<Engine, Unit>
{
  EnginePlatform$launchGame$2(GameLaunchParam paramGameLaunchParam, GameLaunchCallback paramGameLaunchCallback)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Engine paramEngine)
  {
    if (paramEngine != null) {
      paramEngine.launchGame(this.$param, this.$gameLaunchCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EnginePlatform.launchGame.2
 * JD-Core Version:    0.7.0.1
 */