package com.tencent.mobileqq.olympic.activity;

import android.graphics.Bitmap;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PromotionGuide$1$1
  implements ImageAssetDelegate
{
  PromotionGuide$1$1(PromotionGuide.1 param1) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = null;
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    String str = this.a.jdField_a_of_type_JavaLangString + "guide_images" + File.separator + paramLottieImageAsset;
    try
    {
      paramLottieImageAsset = RedBagUtil.a(str, this.a.jdField_a_of_type_Int, this.a.b);
      return paramLottieImageAsset;
    }
    catch (Exception localException)
    {
      do
      {
        paramLottieImageAsset = localObject;
      } while (!AudioHelper.e());
      QLog.w(PromotionGuide.jdField_a_of_type_JavaLangString, 1, "PromotionGuide Exception, imagePath[" + str + "]", localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionGuide.1.1
 * JD-Core Version:    0.7.0.1
 */