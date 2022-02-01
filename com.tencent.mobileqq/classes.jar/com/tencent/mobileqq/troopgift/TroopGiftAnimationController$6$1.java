package com.tencent.mobileqq.troopgift;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopUtils;

class TroopGiftAnimationController$6$1
  implements FaceDrawable.OnLoadingStateChangeListener
{
  TroopGiftAnimationController$6$1(TroopGiftAnimationController.6 param6) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = TroopUtils.a(this.a.this$0.a(String.valueOf(this.a.a.senderUin), null));
    if ((paramInt1 == 0) && (paramInt2 == 1) && (this.a.this$0.a != null)) {
      this.a.this$0.a.b(new TroopGiftAnimationController.6.1.1(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.6.1
 * JD-Core Version:    0.7.0.1
 */