package com.tencent.mobileqq.troop.enterEffect;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.surfaceviewaction.ISprite;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.utils.TroopUtils;

class TroopEnterEffectController$3$3$1
  implements FaceDrawable.OnLoadingStateChangeListener
{
  TroopEnterEffectController$3$3$1(TroopEnterEffectController.3.3 param3, ISprite paramISprite) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1) && (this.b.b.this$0.b != null))
    {
      Bitmap localBitmap = Bitmap.createScaledBitmap(TroopUtils.a(FaceDrawable.getFaceDrawable(this.b.a, 1, this.b.b.a.b)), ((Sprite)this.a).o(), ((Sprite)this.a).p(), true);
      this.b.b.this$0.b.b(new TroopEnterEffectController.3.3.1.1(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3.3.1
 * JD-Core Version:    0.7.0.1
 */