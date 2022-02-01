package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.initializer.TNNGestureInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEHandDetectImpl
{
  private static final int GESTURE_BONE_POINTS_LENTH = 48;
  private static final int GESTURE_BOX_POINTS_LENTH = 7;
  private static final String TAG = "AEHandDetectImpl";
  private long frameCount = 0L;
  private PTHandAttr handAttr = new PTHandAttr();
  private int height = 0;
  private long lastClassifyTimeStamp = 0L;
  private float lastConfidence = 0.0F;
  private int lastHandType = -1;
  private boolean needDetectBonePoint = false;
  private int width = 0;
  
  private PTHandAttr genHandAttr(boolean paramBoolean, float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    if (isValid(paramArrayOfFloat, paramBoolean)) {
      if (paramBoolean)
      {
        this.handAttr.setHandType(Float.valueOf(paramArrayOfFloat[46]).intValue() + 201);
        this.handAttr.setConfidence(paramArrayOfFloat[47]);
        this.handAttr.setHandPointList(genHandPointList(paramBoolean, paramArrayOfFloat, paramFloat, paramInt));
        AIActionCounter.updateAction(this.handAttr.getHandType());
      }
    }
    for (;;)
    {
      return this.handAttr;
      this.handAttr.setHandType(Float.valueOf(paramArrayOfFloat[5]).intValue() + 201);
      this.handAttr.setConfidence(paramArrayOfFloat[6]);
      break;
      this.handAttr.setHandType(-1);
      this.handAttr.setConfidence(0.0F);
      this.handAttr.setHandPointList(new ArrayList());
    }
  }
  
  private List<PointF> genHandPointList(boolean paramBoolean, float[] paramArrayOfFloat, float paramFloat, int paramInt)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      paramArrayOfFloat[i] /= paramFloat;
      i += 1;
    }
    if (paramBoolean)
    {
      localPointF1 = new PointF(paramArrayOfFloat[21], paramArrayOfFloat[44]);
      PointF localPointF2 = new PointF(paramArrayOfFloat[22], paramArrayOfFloat[45]);
      localArrayList.add(new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F));
      localArrayList.add(localPointF1);
      localArrayList.add(new PointF((localPointF1.x + localPointF2.x) / 2.0F, localPointF1.y));
      localArrayList.add(new PointF(localPointF2.x, localPointF1.y));
      localArrayList.add(new PointF(localPointF1.x, (localPointF1.y + localPointF2.y) / 2.0F));
      localArrayList.add(new PointF(localPointF2.x, (localPointF1.y + localPointF2.y) / 2.0F));
      localArrayList.add(new PointF(localPointF1.x, localPointF2.y));
      localArrayList.add(new PointF((localPointF1.x + localPointF2.x) / 2.0F, localPointF2.y));
      localArrayList.add(localPointF2);
      i = j;
      while (i < 23)
      {
        localArrayList.add(new PointF(paramArrayOfFloat[i], paramArrayOfFloat[(i + 23)]));
        i += 1;
      }
    }
    PointF localPointF1 = new PointF(paramArrayOfFloat[0], paramArrayOfFloat[1]);
    i = Float.valueOf(paramArrayOfFloat[2]).intValue();
    j = Float.valueOf(paramArrayOfFloat[3]).intValue();
    localArrayList.add(new PointF(localPointF1.x + i / 2, localPointF1.y + j / 2));
    localArrayList.add(localPointF1);
    localArrayList.add(new PointF(localPointF1.x + i / 2, localPointF1.y));
    localArrayList.add(new PointF(localPointF1.x + i, localPointF1.y));
    localArrayList.add(new PointF(localPointF1.x, localPointF1.y + j / 2));
    localArrayList.add(new PointF(localPointF1.x + i, localPointF1.y + j / 2));
    localArrayList.add(new PointF(localPointF1.x, localPointF1.y + j));
    localArrayList.add(new PointF(localPointF1.x + i / 2, localPointF1.y + j));
    paramFloat = localPointF1.x;
    localArrayList.add(new PointF(i + paramFloat, localPointF1.y + j));
    rotatePoints(localArrayList, this.width, this.height, paramInt);
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
  
  private boolean isValid(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if ((paramArrayOfFloat == null) || (!isDataValid(paramArrayOfFloat))) {}
    do
    {
      return false;
      if ((paramBoolean) && (paramArrayOfFloat.length == 48)) {
        return true;
      }
    } while ((paramBoolean) || (paramArrayOfFloat.length != 7));
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
  
  public PTHandAttr detectFrame(Bitmap paramBitmap, float paramFloat, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject2 = new float[48];
    Object localObject1 = localObject2;
    boolean bool;
    if (FeatureManager.Features.RAPID_NET_GESTURE.isModelLoaded(3))
    {
      localObject1 = localObject2;
      if (BitmapUtils.isLegal(paramBitmap))
      {
        localObject2 = BitmapUtils.rotateBitmap(paramBitmap, (-paramInt + 360) % 360);
        this.width = ((int)(((Bitmap)localObject2).getWidth() / paramFloat));
        this.height = ((int)(((Bitmap)localObject2).getHeight() / paramFloat));
        BitmapUtils.recycle(paramBitmap);
        AEProfiler.getInstance().start(AEDetectorType.HAND.value);
        if (this.frameCount % 2L != 0L) {
          break label270;
        }
        bool = true;
        if (!this.needDetectBonePoint) {
          break label319;
        }
        localObject1 = AEHandDetector.HAND_DETECTOR.retrieveGestureInfo((Bitmap)localObject2, bool);
        paramBitmap = (Bitmap)localObject1;
        if (localObject1 == null) {
          break label430;
        }
        paramBitmap = (Bitmap)localObject1;
        if (localObject1.length != 48) {
          break label430;
        }
        if (!bool) {
          break label276;
        }
        this.lastHandType = Float.valueOf(localObject1[46]).intValue();
        this.lastConfidence = localObject1[47];
        this.lastClassifyTimeStamp = System.currentTimeMillis();
        paramBitmap = (Bitmap)localObject1;
      }
    }
    label270:
    label276:
    label430:
    for (;;)
    {
      long l2 = AEProfiler.getInstance().end(AEDetectorType.HAND.value);
      AEProfiler.getInstance().add(1, AEDetectorType.HAND.value, l2);
      BitmapUtils.recycle((Bitmap)localObject2);
      this.frameCount += 1L;
      localObject1 = paramBitmap;
      this.handAttr = genHandAttr(this.needDetectBonePoint, (float[])localObject1, paramFloat, paramInt);
      this.handAttr.setGestureTime(System.currentTimeMillis() - l1);
      return this.handAttr;
      bool = false;
      break;
      paramBitmap = (Bitmap)localObject1;
      if (System.currentTimeMillis() - this.lastClassifyTimeStamp < 300L)
      {
        localObject1[46] = this.lastHandType;
        localObject1[47] = this.lastConfidence;
        paramBitmap = (Bitmap)localObject1;
        continue;
        label319:
        localObject1 = AEHandDetector.HAND_DETECTOR.retrieveGestureBoxAndType((Bitmap)localObject2, bool);
        paramBitmap = (Bitmap)localObject1;
        if (localObject1 != null)
        {
          paramBitmap = (Bitmap)localObject1;
          if (localObject1.length == 7) {
            if (bool)
            {
              this.lastHandType = Float.valueOf(localObject1[5]).intValue();
              this.lastConfidence = localObject1[6];
              this.lastClassifyTimeStamp = System.currentTimeMillis();
              paramBitmap = (Bitmap)localObject1;
            }
            else
            {
              paramBitmap = (Bitmap)localObject1;
              if (System.currentTimeMillis() - this.lastClassifyTimeStamp < 300L)
              {
                localObject1[5] = this.lastHandType;
                localObject1[6] = this.lastConfidence;
                paramBitmap = (Bitmap)localObject1;
              }
            }
          }
        }
      }
    }
  }
  
  public boolean isNeedDetectBonePoint()
  {
    return this.needDetectBonePoint;
  }
  
  public void setNeedDetectBonePoint(boolean paramBoolean)
  {
    this.needDetectBonePoint = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEHandDetectImpl
 * JD-Core Version:    0.7.0.1
 */