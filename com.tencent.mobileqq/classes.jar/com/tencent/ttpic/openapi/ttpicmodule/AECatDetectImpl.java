package com.tencent.ttpic.openapi.ttpicmodule;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AECatAttr;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AECatDetectImpl
{
  private static final int CAT_POINTS_LENTH = 40;
  private static final int CAT_POINTS_TOTAL_LENTH = 43;
  private static final String TAG = "AECatDetectImpl";
  private AECatAttr catAttr = new AECatAttr();
  private int height = 0;
  private int width = 0;
  
  private float[] genAngles(float[] paramArrayOfFloat, float paramFloat)
  {
    float[] arrayOfFloat = new float[3];
    float[] tmp5_4 = arrayOfFloat;
    tmp5_4[0] = 0.0F;
    float[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0.0F;
    float[] tmp13_9 = tmp9_5;
    tmp13_9[2] = 0.0F;
    tmp13_9;
    if (isValid(paramArrayOfFloat))
    {
      arrayOfFloat[1] = paramArrayOfFloat[40];
      arrayOfFloat[2] = paramArrayOfFloat[41];
      arrayOfFloat[0] = paramArrayOfFloat[42];
      LogUtils.d("AECatDetectImpl", "angles Pitch = " + paramArrayOfFloat[40] + " Row = " + paramArrayOfFloat[41] + " YAW = " + paramArrayOfFloat[42] + " PhoneRotation = " + paramFloat);
    }
    return arrayOfFloat;
  }
  
  private AECatAttr genCatAttr(float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    if (isValid(paramArrayOfFloat))
    {
      this.catAttr.setCatPointList(genCatPointList(paramArrayOfFloat, 40, paramFloat, paramInt));
      this.catAttr.setAngles(genAngles(paramArrayOfFloat, paramInt));
    }
    for (;;)
    {
      return this.catAttr;
      this.catAttr.setCatPointList(new ArrayList());
      this.catAttr.setAngles(new float[] { 0.0F, 0.0F, 0.0F });
    }
  }
  
  private List<PointF> genCatPointList(float[] paramArrayOfFloat, int paramInt1, float paramFloat, int paramInt2)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt1)
    {
      paramArrayOfFloat[i] /= paramFloat;
      i += 1;
    }
    i = paramInt1 / 2;
    paramInt1 = j;
    while (paramInt1 < i)
    {
      localArrayList.add(new PointF(paramArrayOfFloat[paramInt1], paramArrayOfFloat[(paramInt1 + 20)]));
      paramInt1 += 1;
    }
    rotatePoints(localArrayList, this.width, this.height, paramInt2);
    return localArrayList;
  }
  
  private boolean isDataValid(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) && (paramArrayOfFloat.length <= 0)) {}
    float f;
    do
    {
      return false;
      int j = paramArrayOfFloat.length;
      f = 0.0F;
      int i = 0;
      while (i < j)
      {
        f += paramArrayOfFloat[i];
        i += 1;
      }
    } while (f / paramArrayOfFloat.length < 10.0F);
    return true;
  }
  
  private boolean isValid(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (!isDataValid(paramArrayOfFloat))) {}
    while (paramArrayOfFloat.length != 43) {
      return false;
    }
    return true;
  }
  
  public static List<PointF> rotatePoints(List<PointF> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = null;
      return localObject;
    }
    paramInt3 = (paramInt3 + 360) % 360;
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    if (paramInt3 == 90) {
      localMatrix.postTranslate(0.0F, -paramInt2);
    }
    localMatrix.postRotate(paramInt3, 0.0F, 0.0F);
    if (paramInt3 == 270) {
      localMatrix.postTranslate(0.0F, paramInt1);
    }
    for (;;)
    {
      float[] arrayOfFloat1 = new float[2];
      float[] arrayOfFloat2 = new float[2];
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        localObject = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PointF)localIterator.next();
        arrayOfFloat1[0] = ((PointF)localObject).x;
        arrayOfFloat1[1] = ((PointF)localObject).y;
        localMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
        ((PointF)localObject).x = arrayOfFloat2[0];
        ((PointF)localObject).y = arrayOfFloat2[1];
      }
      if (paramInt3 == 180) {
        localMatrix.postTranslate(paramInt1, paramInt2);
      }
    }
  }
  
  public void destroy() {}
  
  public AECatAttr detectFrame(Bitmap paramBitmap, float paramFloat, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    float[] arrayOfFloat = new float[43];
    if (BitmapUtils.isLegal(paramBitmap))
    {
      paramBitmap = BitmapUtils.rotateBitmap(paramBitmap, (-paramInt + 360) % 360);
      this.width = ((int)(paramBitmap.getWidth() / paramFloat));
      this.height = ((int)(paramBitmap.getHeight() / paramFloat));
      AEProfiler.getInstance().start(AEDetectorType.CAT.value);
      arrayOfFloat = AECatDetector.CAT_DETECTOR.retrieveCatKeyPoints(paramBitmap);
      long l2 = AEProfiler.getInstance().end(AEDetectorType.CAT.value);
      AEProfiler.getInstance().add(1, AEDetectorType.CAT.value, l2);
      BitmapUtils.recycle(paramBitmap);
    }
    this.catAttr = genCatAttr(arrayOfFloat, paramFloat, paramInt);
    this.catAttr.setDetectTime(System.currentTimeMillis() - l1);
    return this.catAttr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AECatDetectImpl
 * JD-Core Version:    0.7.0.1
 */