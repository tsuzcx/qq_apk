package com.tencent.mobileqq.olympic.activity;

import android.graphics.Bitmap;
import com.tencent.av.VideoUtils;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PromotionGuide$1$1
  implements ImageAssetDelegate
{
  PromotionGuide$1$1(PromotionGuide.1 param1) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.a);
    ((StringBuilder)localObject).append("guide_images");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramLottieImageAsset);
    paramLottieImageAsset = ((StringBuilder)localObject).toString();
    try
    {
      localObject = VideoUtils.a(paramLottieImageAsset, this.a.b, this.a.c);
      return localObject;
    }
    catch (Exception localException)
    {
      if (QQAudioHelper.f())
      {
        String str = PromotionGuide.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PromotionGuide Exception, imagePath[");
        localStringBuilder.append(paramLottieImageAsset);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString(), localException);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionGuide.1.1
 * JD-Core Version:    0.7.0.1
 */