package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.game.GameLauncher;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

class TTEngine$4
  implements Function1<Boolean, Unit>
{
  TTEngine$4(TTEngine paramTTEngine) {}
  
  public Unit invoke(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.this$0.getGameLauncher().onFirstRender();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTEngine.4
 * JD-Core Version:    0.7.0.1
 */