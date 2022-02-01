package com.tencent.mobileqq.troopgift;

import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopUtils;

class TroopGiftAnimationController$6$2
  implements URLDrawable.DownloadListener
{
  TroopGiftAnimationController$6$2(TroopGiftAnimationController.6 param6, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (this.b.this$0.a == null) {
      return;
    }
    Bitmap localBitmap = TroopUtils.a(this.a);
    this.b.this$0.a.b(new TroopGiftAnimationController.6.2.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.6.2
 * JD-Core Version:    0.7.0.1
 */