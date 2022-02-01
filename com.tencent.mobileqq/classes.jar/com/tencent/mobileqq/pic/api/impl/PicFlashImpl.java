package com.tencent.mobileqq.pic.api.impl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PicFlashImpl
  implements IPicFlash
{
  public final DownloadParams.DecodeHandler flashPicDecodeHandler = new PicFlashImpl.1(this);
  public Drawable mReadedDrawable;
  
  static void dimBlock(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt1 + paramInt3 - 1;
    int j = paramInt3 + paramInt2 - 1;
    paramInt3 = i;
    if (i > paramInt4) {
      paramInt3 = paramInt4;
    }
    i = j;
    if (j > paramInt5) {
      i = paramInt5;
    }
    paramInt5 = (paramInt3 - paramInt1 + 1) / 2;
    j = paramArrayOfInt[(((i - paramInt2 + 1) / 2 + paramInt2 - 1) * paramInt4 + (paramInt5 + paramInt1) - 1)];
    while (paramInt2 <= i)
    {
      paramInt5 = paramInt1;
      while (paramInt5 <= paramInt3)
      {
        paramArrayOfInt[((paramInt2 - 1) * paramInt4 + paramInt5 - 1)] = j;
        paramInt5 += 1;
      }
      paramInt2 += 1;
    }
  }
  
  public float getDensity()
  {
    return BaseApplication.getContext().getResources().getDisplayMetrics().density;
  }
  
  public DownloadParams.DecodeHandler getFlashPicDecodeHandler()
  {
    return this.flashPicDecodeHandler;
  }
  
  public Drawable getFlashPicReadedDrawable()
  {
    if (this.mReadedDrawable == null) {}
    try
    {
      Resources localResources = BaseApplication.getContext().getResources();
      int i = localResources.getDisplayMetrics().densityDpi;
      i = (int)(((IPicAIO)QRoute.api(IPicAIO.class)).getRoundCorner() * (i / 160));
      this.mReadedDrawable = new RoundedColorDrawable(localResources.getColor(2131167240), Utils.a(130.0F, localResources), Utils.a(102.0F, localResources), i);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label77:
      break label77;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicFlashImpl", 2, "getReadedDrawable OOM");
    }
    return this.mReadedDrawable;
  }
  
  public Bitmap getMosaicBitmap(Bitmap paramBitmap, int paramInt)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    Object localObject = new int[k * m];
    paramBitmap.getPixels((int[])localObject, 0, k, 0, 0, k, m);
    float f1 = m;
    float f2 = paramInt;
    int n = (int)Math.ceil(f1 / f2);
    int i1 = (int)Math.ceil(k / f2);
    int i = 0;
    while (i < n)
    {
      int j = 0;
      while (j < i1)
      {
        dimBlock((int[])localObject, j * paramInt + 1, i * paramInt + 1, paramInt, k, m);
        j += 1;
      }
      i += 1;
    }
    paramBitmap.recycle();
    paramBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
    paramBitmap.setPixels((int[])localObject, 0, k, 0, 0, k, m);
    localObject = new Canvas();
    ((Canvas)localObject).setBitmap(paramBitmap);
    ((Canvas)localObject).drawARGB(89, 0, 0, 0);
    return paramBitmap;
  }
  
  public boolean isFlashPicMsg(MessageRecord paramMessageRecord)
  {
    return FlashPicHelper.a(paramMessageRecord);
  }
  
  public boolean isFlashPicMsgReaded(MessageRecord paramMessageRecord)
  {
    return FlashPicHelper.b(paramMessageRecord);
  }
  
  public void setFlashPicFlag(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    FlashPicHelper.a(paramMessageRecord, paramBoolean);
  }
  
  public void setFlashPicMsgReaded(MessageRecord paramMessageRecord)
  {
    FlashPicHelper.c(paramMessageRecord);
  }
  
  public boolean showFlashPicOption(int paramInt, String paramString)
  {
    return FlashPicHelper.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicFlashImpl
 * JD-Core Version:    0.7.0.1
 */