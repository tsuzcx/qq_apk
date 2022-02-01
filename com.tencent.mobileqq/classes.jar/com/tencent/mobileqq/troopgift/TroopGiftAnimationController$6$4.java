package com.tencent.mobileqq.troopgift;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

class TroopGiftAnimationController$6$4
  implements FaceDrawable.OnLoadingStateChangeListener
{
  TroopGiftAnimationController$6$4(TroopGiftAnimationController.6 param6) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1) && ((this.a.this$0.a instanceof TroopGiftToPersonalSurfaceView)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onLoadingStateChanged: curState = ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("TroopGiftAnimationController", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = TroopUtils.a(this.a.this$0.a(String.valueOf(this.a.a.receiverUin), null));
      this.a.this$0.a.b(new TroopGiftAnimationController.6.4.1(this, (Bitmap)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.6.4
 * JD-Core Version:    0.7.0.1
 */