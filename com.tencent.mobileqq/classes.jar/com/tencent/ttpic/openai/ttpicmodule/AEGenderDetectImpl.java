package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTGenderAttr;
import com.tencent.ttpic.openapi.initializer.TNNGenderDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;

public class AEGenderDetectImpl
{
  private static final int GENDER_POINTS_LENTH = 2;
  private static final String TAG = "AEGenderDetectImpl";
  private long frameCount = 0L;
  private PTGenderAttr genderAttr = new PTGenderAttr();
  private int height = 0;
  private long lastClassifyTimeStamp = 0L;
  private float lastConfidence = 0.0F;
  private int lastGenderType = -1;
  private boolean needDetectBonePoint = false;
  private int width = 0;
  
  public void destroy() {}
  
  public float[] detectFrame(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    float[] arrayOfFloat2 = new float[2];
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (FeatureManager.Features.RAPID_NET_GENDER_DETECT.isModelLoaded(5))
    {
      arrayOfFloat1 = arrayOfFloat2;
      if (BitmapUtils.isLegal(paramBitmap))
      {
        paramBitmap = BitmapUtils.rotateBitmap(paramBitmap, (-paramInt1 + 360) % 360);
        this.width = ((int)(paramBitmap.getWidth() / paramFloat));
        this.height = ((int)(paramBitmap.getHeight() / paramFloat));
        AEProfiler.getInstance().start("GENDERDETECT");
        if (this.frameCount % 2L != 0L) {
          break label179;
        }
        paramInt1 = 1;
        arrayOfFloat1 = AEGenderDetector.GENDER_DETECTOR.retrieveGenderInfo(paramBitmap, paramInt2, paramInt3, paramInt4, paramInt5);
        if (arrayOfFloat1 != null)
        {
          if (paramInt1 == 0) {
            break label184;
          }
          this.lastGenderType = Float.valueOf(arrayOfFloat1[0]).intValue();
          this.lastConfidence = arrayOfFloat1[1];
        }
      }
    }
    for (;;)
    {
      long l = AEProfiler.getInstance().end("GENDERDETECT");
      AEProfiler.getInstance().add(1, "GENDERDETECT", l);
      BitmapUtils.recycle(paramBitmap);
      this.frameCount += 1L;
      return arrayOfFloat1;
      label179:
      paramInt1 = 0;
      break;
      label184:
      if (System.currentTimeMillis() - this.lastClassifyTimeStamp < 300L)
      {
        arrayOfFloat1[0] = this.lastGenderType;
        arrayOfFloat1[1] = this.lastConfidence;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEGenderDetectImpl
 * JD-Core Version:    0.7.0.1
 */