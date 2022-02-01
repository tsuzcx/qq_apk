package com.tencent.mobileqq.triton.game;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameLauncher$loadSubpackage$1
  implements Runnable
{
  GameLauncher$loadSubpackage$1(GameLauncher paramGameLauncher, String paramString, Function2 paramFunction2, Function1 paramFunction1) {}
  
  public final void run()
  {
    GameLauncher.access$getMTritonEngine$p(this.this$0).getEngineContext().getGamePackage().getSubpackage(this.$name, (GamePackage.SubpackageListener)new GameLauncher.loadSubpackage.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.loadSubpackage.1
 * JD-Core Version:    0.7.0.1
 */