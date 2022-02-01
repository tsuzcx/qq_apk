package com.tencent.ttpic.openapi.ttpicmodule;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTSkyAttr;
import com.tencent.ttpic.openapi.ttpicmodule.module_rgb_depth.PTRGBDepth;
import com.tencent.ttpic.openapi.ttpicmodule.module_rgb_depth.RGBDepthInitializer;

public class RGBDepthImpl
{
  private static final String TAG = RGBDepthImpl.class.getSimpleName();
  private volatile Bitmap outBitmap = null;
  private PTSkyAttr skyAttr = new PTSkyAttr();
  
  private void calculatePixelRange(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return;
    }
    int[] arrayOfInt = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(arrayOfInt, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    float f1 = 0.0F;
    float f3 = 256.0F;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      int j = arrayOfInt[i] & 0xFF;
      float f2 = f3;
      if (j < f3) {
        f2 = j;
      }
      float f4 = f1;
      if (j > f1) {
        f4 = j;
      }
      i += 1;
      f3 = f2;
      f1 = f4;
    }
    this.skyAttr.setPixelRange(new float[] { f3, f1 });
    LogUtils.i(TAG, "range:[" + f3 + "," + f1 + "]");
  }
  
  private PTSkyAttr genSegAttr(Bitmap paramBitmap, float[] paramArrayOfFloat)
  {
    this.skyAttr.setMaskBitmap(paramBitmap);
    this.skyAttr.setRotationMatrix(paramArrayOfFloat);
    return this.skyAttr;
  }
  
  public void clearCache()
  {
    if (this.outBitmap != null)
    {
      this.outBitmap.recycle();
      this.outBitmap = null;
    }
  }
  
  public void destroy()
  {
    clearCache();
  }
  
  public PTSkyAttr detectFrame(Bitmap paramBitmap, int paramInt, float[] paramArrayOfFloat, long paramLong)
  {
    if ((PTRGBDepth.RGB_DEPTH.isFunctionReady()) && (BitmapUtils.isLegal(paramBitmap)))
    {
      AEProfiler.getInstance().start(AEDetectorType.RGB_DEPTH.value);
      if (BitmapUtils.isLegal(paramBitmap))
      {
        this.outBitmap = PTRGBDepth.RGB_DEPTH.forward(paramBitmap, (-paramInt + 360) % 360);
        calculatePixelRange(this.outBitmap);
      }
      paramBitmap.recycle();
      paramLong = AEProfiler.getInstance().end(AEDetectorType.RGB_DEPTH.value);
      AEProfiler.getInstance().add(1, AEDetectorType.SKY_SEGMENT.value, paramLong);
    }
    return genSegAttr(this.outBitmap, paramArrayOfFloat);
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.RGBDepthImpl
 * JD-Core Version:    0.7.0.1
 */