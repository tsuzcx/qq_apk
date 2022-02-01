package com.tencent.mobileqq.olympic.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.av.VideoUtils;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class PromotionEntry$UpdateOperateBtnStatusRunnable$1$1
  implements ImageAssetDelegate
{
  PromotionEntry$UpdateOperateBtnStatusRunnable$1$1(PromotionEntry.UpdateOperateBtnStatusRunnable.1 param1) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = (ImageView)PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.a.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable).get();
    if (localObject != null)
    {
      paramLottieImageAsset = paramLottieImageAsset.getFileName();
      int i = ((ImageView)localObject).getResources().getDisplayMetrics().densityDpi;
      int j = ((ImageView)localObject).getResources().getDisplayMetrics().densityDpi;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("entry_images");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramLottieImageAsset);
      localObject = ((StringBuilder)localObject).toString();
      try
      {
        paramLottieImageAsset = VideoUtils.a((String)localObject, i, j);
      }
      catch (Exception paramLottieImageAsset)
      {
        if (QQAudioHelper.c())
        {
          String str = PromotionEntry.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("UpdateOperateBtnStatusRunnable Exception, imagePath[");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("]");
          QLog.w(str, 1, localStringBuilder.toString(), paramLottieImageAsset);
        }
      }
    }
    else
    {
      paramLottieImageAsset = null;
    }
    localObject = paramLottieImageAsset;
    if (paramLottieImageAsset == null) {
      localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry.UpdateOperateBtnStatusRunnable.1.1
 * JD-Core Version:    0.7.0.1
 */