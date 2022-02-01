package com.tencent.mobileqq.guild.pic.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.guild.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GuildPicAIOImpl
  implements IGuildPicAIO
{
  protected static final int AIO_IMAGE_DYNAMIC_MAX = (int)(getDensity() * 129.0F);
  protected static final int AIO_IMAGE_MAX_SIZE_H;
  protected static final int AIO_IMAGE_MAX_SIZE_W;
  protected static final int AIO_IMAGE_MIN_SIZE_H;
  protected static final int AIO_IMAGE_MIN_SIZE_W;
  private static final String TAG = "GuildPicAIOImpl";
  protected static float density = -1.0F;
  protected static int densityDpi = -1;
  
  static
  {
    Resources localResources = MobileQQ.getContext().getResources();
    AIO_IMAGE_MAX_SIZE_W = ViewUtils.getScreenWidth() - localResources.getDimensionPixelSize(2131297578) - localResources.getDimensionPixelSize(2131297580) - localResources.getDimensionPixelSize(2131297577) - localResources.getDimensionPixelSize(2131298142);
    int i = AIO_IMAGE_MAX_SIZE_W;
    AIO_IMAGE_MAX_SIZE_H = (int)(i * 1.25F);
    AIO_IMAGE_MIN_SIZE_W = (int)(i * 0.3F);
    AIO_IMAGE_MIN_SIZE_H = (int)(i * 0.3F);
  }
  
  private int[] fixPicSize(long paramLong1, long paramLong2)
  {
    int k = (int)paramLong1;
    int j = (int)paramLong2;
    float f1 = (float)paramLong1;
    float f2 = (float)paramLong2;
    int i;
    if (f1 >= f2 * 3.0F)
    {
      i = (int)(j * 16.0F / 9.0F);
    }
    else
    {
      i = k;
      if (f2 >= f1 * 3.0F)
      {
        j = (int)(k * 7.0F / 3.0F);
        i = k;
      }
    }
    return new int[] { i, j };
  }
  
  public static float getDensity()
  {
    if (density == -1.0F)
    {
      density = MobileQQ.getContext().getResources().getDisplayMetrics().density;
      if (density <= 0.0F) {
        density = 1.0F;
      }
    }
    return density;
  }
  
  private static int getDensityDpi()
  {
    if (densityDpi == -1)
    {
      densityDpi = MobileQQ.getContext().getResources().getDisplayMetrics().densityDpi;
      if (densityDpi <= 0) {
        densityDpi = 1;
      }
    }
    return densityDpi;
  }
  
  public Bitmap getThumbBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = paramInt1;
    int i = paramInt2;
    if (paramBitmap.getWidth() > paramBitmap.getHeight())
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1;
        j = paramInt2;
      }
    }
    int[] arrayOfInt = fixPicSize(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramInt1 = arrayOfInt[0];
    paramInt2 = arrayOfInt[1];
    arrayOfInt = getThumbSize(j, i, false);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-16777216);
    Bitmap localBitmap = Bitmap.createBitmap(arrayOfInt[0], arrayOfInt[1], paramBitmap.getConfig());
    localBitmap.setDensity(getDensityDpi());
    new Canvas(localBitmap).drawBitmap(paramBitmap, new Rect(0, 0, paramInt1, paramInt2), new Rect(0, 0, arrayOfInt[0], arrayOfInt[1]), localPaint);
    return localBitmap;
  }
  
  public int[] getThumbMaxDp(boolean paramBoolean)
  {
    int[] arrayOfInt = getThumbMaxPx(paramBoolean);
    return new int[] { (int)(arrayOfInt[0] / getDensity()), (int)(arrayOfInt[1] / getDensity()) };
  }
  
  public int[] getThumbMaxPx(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = AIO_IMAGE_DYNAMIC_MAX;
      return new int[] { i, i };
    }
    return new int[] { AIO_IMAGE_MAX_SIZE_W, AIO_IMAGE_MAX_SIZE_H };
  }
  
  public int[] getThumbMinDp(boolean paramBoolean)
  {
    int[] arrayOfInt = getThumbMaxPx(paramBoolean);
    return new int[] { (int)(arrayOfInt[0] / getDensity()), (int)(arrayOfInt[1] / getDensity()) };
  }
  
  public int[] getThumbMinPx(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = AIO_IMAGE_DYNAMIC_MAX;
      return new int[] { i, i };
    }
    return new int[] { AIO_IMAGE_MIN_SIZE_W, AIO_IMAGE_MIN_SIZE_H };
  }
  
  public int[] getThumbSize(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = CommonImgThumbHelper.getThumbWidthHeightDP(false);
    } else {
      localObject = getThumbWidthHeightDPForGuildPicMsg();
    }
    int j = (int)(((ThumbWidthHeightDP)localObject).mMinWidth * getDensity());
    int i = (int)(((ThumbWidthHeightDP)localObject).mMinHeight * getDensity());
    int n = (int)(((ThumbWidthHeightDP)localObject).mMaxWidth * getDensity());
    int i1 = (int)(((ThumbWidthHeightDP)localObject).mMaxHeight * getDensity());
    int k = AIO_IMAGE_MIN_SIZE_W;
    k = AIO_IMAGE_MIN_SIZE_H;
    Object localObject = fixPicSize(paramLong1, paramLong2);
    int m = localObject[0];
    k = localObject[1];
    if ((m > 0) && (k > 0))
    {
      float f1;
      if ((m >= j) && (k >= i))
      {
        if ((m < n) && (k < i1))
        {
          i = k;
          j = m;
        }
        else
        {
          float f2;
          if (m > k)
          {
            f2 = n;
            f1 = m;
          }
          else
          {
            f2 = i1;
            f1 = k;
          }
          float f3 = f2 / f1;
          if (m > k)
          {
            f1 = i;
            f2 = k;
          }
          else
          {
            f1 = j;
            f2 = m;
          }
          f1 = Math.max(f3, f1 / f2);
          j = (int)(m * f1 + 0.5F);
          i = (int)(k * f1 + 0.5F);
        }
      }
      else if (m < k)
      {
        f1 = j / m;
        i = Math.min((int)(k * f1 + 0.5F), i1);
      }
      else
      {
        f1 = i / k;
        j = Math.min((int)(m * f1 + 0.5F), n);
      }
    }
    else
    {
      i = k;
      j = m;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MessageForPic without width/height of thumb, width = ");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(", height = ");
        ((StringBuilder)localObject).append(k);
        QLog.d("GuildPicAIOImpl", 2, ((StringBuilder)localObject).toString());
        j = m;
        i = k;
      }
    }
    return new int[] { (int)(j + 0.5F), (int)(i + 0.5F) };
  }
  
  public ThumbWidthHeightDP getThumbWidthHeightDPForGuildPicMsg()
  {
    ThumbWidthHeightDP localThumbWidthHeightDP = new ThumbWidthHeightDP((int)(AIO_IMAGE_MIN_SIZE_H / getDensity()), (int)(AIO_IMAGE_MIN_SIZE_H / getDensity()), (int)(AIO_IMAGE_MAX_SIZE_H / getDensity()), (int)(AIO_IMAGE_MAX_SIZE_H / getDensity()));
    localThumbWidthHeightDP.setmLimitSizeByGuild(true);
    return localThumbWidthHeightDP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.pic.api.impl.GuildPicAIOImpl
 * JD-Core Version:    0.7.0.1
 */