package com.tencent.mobileqq.troop.enterEffect;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;

class TroopEnterEffectController$3
  implements Runnable
{
  TroopEnterEffectController$3(TroopEnterEffectController paramTroopEnterEffectController, TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    TroopEnterEffectController.d();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    SceneBuilder localSceneBuilder = new SceneBuilder().a(this.this$0.b.getWidth());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TroopEnterEffectController.a);
    localStringBuilder.append(this.a.a);
    localSceneBuilder.a(localStringBuilder.toString()).a(new TroopEnterEffectController.3.4(this)).a(new TroopEnterEffectController.TroopEnterEffectLabelTextHandle(this.this$0, localQQAppInterface, this.a)).a(new TroopEnterEffectController.3.3(this, localQQAppInterface)).a(new TroopEnterEffectController.3.2(this)).a(this.this$0.b, new TroopEnterEffectController.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3
 * JD-Core Version:    0.7.0.1
 */