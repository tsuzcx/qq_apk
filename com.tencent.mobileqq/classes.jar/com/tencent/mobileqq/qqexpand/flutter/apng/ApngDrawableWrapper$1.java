package com.tencent.mobileqq.qqexpand.flutter.apng;

import com.peterlmeng.animate_image.support.common.BitmapAnimatorParams;
import com.peterlmeng.animate_image.support.common.IBitmapAnimator;
import com.peterlmeng.animate_image.support.common.IBitmapAnimatorFactory;

final class ApngDrawableWrapper$1
  implements IBitmapAnimatorFactory
{
  public IBitmapAnimator create(BitmapAnimatorParams paramBitmapAnimatorParams)
  {
    return new ApngDrawableWrapper(paramBitmapAnimatorParams.url, paramBitmapAnimatorParams.size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.apng.ApngDrawableWrapper.1
 * JD-Core Version:    0.7.0.1
 */