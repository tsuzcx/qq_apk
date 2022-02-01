package com.tencent.mobileqq.data;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;

public class ThumbWidthHeightDP
{
  public boolean mLimitSizeByServer;
  public int mMaxHeight;
  public int mMaxWidth;
  public int mMinHeight;
  public int mMinWidth;
  
  public ThumbWidthHeightDP(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, false);
  }
  
  public ThumbWidthHeightDP(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.mMinWidth = paramInt1;
    this.mMinHeight = paramInt2;
    this.mMaxWidth = paramInt3;
    this.mMaxHeight = paramInt4;
    this.mLimitSizeByServer = paramBoolean;
  }
  
  public static ThumbWidthHeightDP getThumbWidthHeightDP(boolean paramBoolean)
  {
    int i = CommonImgThumbHelper.getImgThumbMinDp(paramBoolean);
    int j = CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean);
    return new ThumbWidthHeightDP(i, i, j, j);
  }
  
  public static ThumbWidthHeightDP getThumbWidthHeightDPForPicMsg(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!paramBoolean2) {
      return getThumbWidthHeightDP(paramBoolean1);
    }
    int i = AIOImgThumbHelper.getAioThumbMinDp(paramBoolean1, paramBoolean2, paramInt);
    paramInt = AIOImgThumbHelper.getAioThumbMaxDp(paramBoolean1, paramBoolean2, paramInt);
    return new ThumbWidthHeightDP(i, i, paramInt, paramInt);
  }
  
  public static RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, DownloadParams paramDownloadParams, ThumbWidthHeightDP paramThumbWidthHeightDP, boolean paramBoolean)
  {
    float f3;
    int j;
    int i;
    int i6;
    int i7;
    int i5;
    int i4;
    int i3;
    int i2;
    int i1;
    int n;
    try
    {
      f3 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
      i8 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi;
      j = CommonImgThumbHelper.getImgThumbMinPx(paramBoolean);
      i = CommonImgThumbHelper.getImgThumbMinPx(paramBoolean);
      k = CommonImgThumbHelper.getImgThumbMaxPx(paramBoolean);
      m = CommonImgThumbHelper.getImgThumbMaxPx(paramBoolean);
      if (paramThumbWidthHeightDP != null)
      {
        j = AIOUtils.dp2px(paramThumbWidthHeightDP.mMinWidth, BaseApplicationImpl.getApplication().getResources());
        i = AIOUtils.dp2px(paramThumbWidthHeightDP.mMinHeight, BaseApplicationImpl.getApplication().getResources());
        k = AIOUtils.dp2px(paramThumbWidthHeightDP.mMaxWidth, BaseApplicationImpl.getApplication().getResources());
        m = AIOUtils.dp2px(paramThumbWidthHeightDP.mMaxHeight, BaseApplicationImpl.getApplication().getResources());
      }
      i6 = paramBitmap.getWidth();
      i7 = paramBitmap.getHeight();
      paramDownloadParams = new Paint(1);
      paramDownloadParams.setColor(-16777216);
      i5 = CommonImgThumbHelper.getImgThumbMinDp(paramBoolean);
      i4 = CommonImgThumbHelper.getImgThumbMinDp(paramBoolean);
      i3 = CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean);
      i2 = CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean);
      if (paramThumbWidthHeightDP == null) {
        break label449;
      }
      i5 = paramThumbWidthHeightDP.mMinWidth;
      i4 = paramThumbWidthHeightDP.mMinHeight;
      i3 = paramThumbWidthHeightDP.mMaxWidth;
      i2 = paramThumbWidthHeightDP.mMaxHeight;
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      int i8;
      int k;
      int m;
      return new RoundRectBitmap(paramBitmap, 12.0F);
    }
    if (i1 < n)
    {
      i = (int)(j / i1 * n + 0.5F);
      if (i <= m) {
        break label532;
      }
      i = m;
    }
    for (;;)
    {
      label240:
      paramThumbWidthHeightDP = Bitmap.createBitmap(j, i, URLDrawableHelper.mThumbConfig);
      paramThumbWidthHeightDP.setDensity(i8);
      new Canvas(paramThumbWidthHeightDP).drawBitmap(paramBitmap, new Rect(0, 0, i1, n), new Rect(0, 0, j, i), paramDownloadParams);
      return new RoundRectBitmap(paramThumbWidthHeightDP, 12.0F * f3);
      m = (int)(i / n * i1 + 0.5F);
      j = m;
      if (m > k) {
        j = k;
      }
      label361:
      do
      {
        float f1;
        if (i1 > n)
        {
          f1 = k / i1;
          if (i1 <= n) {
            break label425;
          }
        }
        for (float f2 = i / n;; f2 = j / i1)
        {
          f1 = Math.max(f1, f2);
          j = (int)(i1 * f1 + 0.5F);
          i = (int)(f1 * n + 0.5F);
          break;
          f1 = m / n;
          break label361;
        }
        if (i6 > i7 * 3.0F)
        {
          i1 = (int)(i7 * 3.0F);
          n = i7;
          if (i1 < i5) {
            break;
          }
          if (n >= i4) {
            continue;
          }
          break;
        }
        for (;;)
        {
          break;
          n = i7;
          i1 = i6;
          if (i7 <= i6 * 3.0F) {
            break label475;
          }
          n = (int)(i6 * 3.0F);
          i1 = i6;
          break label475;
        }
        break label240;
      } while ((i1 >= i3) || (n >= i2));
      label425:
      label449:
      label475:
      j = (int)(i1 * f3 + 0.5F);
      label532:
      i = (int)(n * f3 + 0.5F);
    }
  }
  
  public int maxPx()
  {
    return AIOUtils.dp2px((this.mMaxWidth + this.mMaxHeight) / 2, BaseApplicationImpl.getContext().getResources());
  }
  
  public int minPx()
  {
    return AIOUtils.dp2px((this.mMinWidth + this.mMinHeight) / 2, BaseApplicationImpl.getContext().getResources());
  }
  
  public String toString()
  {
    return this.mMinWidth + ", " + this.mMinHeight + ", " + this.mMaxWidth + ", " + this.mMaxHeight;
  }
  
  public boolean useCustomSize()
  {
    return (this.mMinWidth != 0) && (this.mMinHeight != 0) && (this.mMaxWidth != 0) && (this.mMaxHeight != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.ThumbWidthHeightDP
 * JD-Core Version:    0.7.0.1
 */