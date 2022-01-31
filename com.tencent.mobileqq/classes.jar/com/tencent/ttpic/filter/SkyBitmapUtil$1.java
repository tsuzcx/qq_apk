package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.string.StringUtils;
import java.util.HashMap;

class SkyBitmapUtil$1
  implements Runnable
{
  SkyBitmapUtil$1(SkyBitmapUtil paramSkyBitmapUtil, String paramString1, String paramString2, HashMap paramHashMap) {}
  
  public void run()
  {
    Bitmap localBitmap2 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.val$path, 1);
    Bitmap localBitmap1;
    if (!StringUtils.equals(this.val$side, "top"))
    {
      localBitmap1 = localBitmap2;
      if (!StringUtils.equals(this.val$side, "bottom")) {}
    }
    else
    {
      localBitmap1 = BitmapUtils.rotateBitmap(localBitmap2, 180, false);
      localBitmap2.recycle();
    }
    this.val$finalSkyBitmaps.put(this.val$side, localBitmap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.SkyBitmapUtil.1
 * JD-Core Version:    0.7.0.1
 */