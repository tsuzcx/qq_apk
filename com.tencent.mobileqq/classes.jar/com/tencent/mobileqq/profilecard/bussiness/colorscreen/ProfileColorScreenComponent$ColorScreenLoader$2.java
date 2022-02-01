package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

class ProfileColorScreenComponent$ColorScreenLoader$2
  implements ImageAssetDelegate
{
  ProfileColorScreenComponent$ColorScreenLoader$2(ProfileColorScreenComponent.ColorScreenLoader paramColorScreenLoader) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    return (Bitmap)GlobalImageCache.a.get(paramLottieImageAsset.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader.2
 * JD-Core Version:    0.7.0.1
 */