package com.tencent.ttpic.openapi.ttpicmodule;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTSkyAttr;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.PTSkySegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.SkySegmentInitializer;

public class SkySegmentImpl
{
  private static final String TAG = SkySegmentImpl.class.getSimpleName();
  private volatile Bitmap outBitmap = null;
  private PTSkyAttr skyAttr = new PTSkyAttr();
  
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
    if ((PTSkySegmenter.SKY_SEGMENT.isFunctionReady()) && (BitmapUtils.isLegal(paramBitmap)))
    {
      AEProfiler.getInstance().start(AEDetectorType.SKY_SEGMENT.value);
      if (BitmapUtils.isLegal(paramBitmap)) {
        this.outBitmap = PTSkySegmenter.SKY_SEGMENT.forward(paramBitmap, (-paramInt + 360) % 360);
      }
      paramBitmap.recycle();
      paramLong = AEProfiler.getInstance().end(AEDetectorType.SKY_SEGMENT.value);
      AEProfiler.getInstance().add(1, AEDetectorType.SKY_SEGMENT.value, paramLong);
    }
    return genSegAttr(this.outBitmap, paramArrayOfFloat);
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.SkySegmentImpl
 * JD-Core Version:    0.7.0.1
 */