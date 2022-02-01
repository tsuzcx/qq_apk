package com.tencent.mobileqq.vip.diy.common;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;

class DIYLottieLoader$1
  extends MQLruCache<String, Object>
{
  DIYLottieLoader$1(DIYLottieLoader paramDIYLottieLoader, int paramInt)
  {
    super(paramInt);
  }
  
  protected int sizeOfObj(String paramString, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Bitmap)))
    {
      paramString = (Bitmap)paramObject;
      return paramString.getRowBytes() * paramString.getHeight();
    }
    return super.sizeOfObj(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.common.DIYLottieLoader.1
 * JD-Core Version:    0.7.0.1
 */