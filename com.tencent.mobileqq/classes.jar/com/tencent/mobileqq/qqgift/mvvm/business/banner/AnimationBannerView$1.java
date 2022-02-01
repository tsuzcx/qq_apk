package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.qphone.base.util.QLog;
import org.libpag.PAGFile;
import org.libpag.PAGImage;

class AnimationBannerView$1
  implements LoadHeadListener
{
  AnimationBannerView$1(AnimationBannerView paramAnimationBannerView, GiftAnimData paramGiftAnimData, PAGFile paramPAGFile) {}
  
  public void a() {}
  
  public void a(Bitmap paramBitmap)
  {
    if (this.c.f != this.a)
    {
      QLog.e("Gift_Banner_BannerView", 1, "head onLoadSuccess but not match");
      return;
    }
    this.b.replaceImage(1, PAGImage.FromBitmap(paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.AnimationBannerView.1
 * JD-Core Version:    0.7.0.1
 */