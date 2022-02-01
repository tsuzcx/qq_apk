package com.tencent.mobileqq.troop.enterEffect;

import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.ILayer;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.OnBuiltListener;

class TroopEnterEffectController$3$1
  implements SceneBuilder.OnBuiltListener
{
  TroopEnterEffectController$3$1(TroopEnterEffectController.3 param3) {}
  
  public void a(ILayer paramILayer)
  {
    if (this.a.this$0.b == null) {
      return;
    }
    this.a.this$0.f.post(new TroopEnterEffectController.3.1.1(this, paramILayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3.1
 * JD-Core Version:    0.7.0.1
 */