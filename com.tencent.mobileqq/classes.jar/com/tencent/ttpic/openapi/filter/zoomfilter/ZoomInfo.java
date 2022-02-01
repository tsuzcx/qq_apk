package com.tencent.ttpic.openapi.filter.zoomfilter;

import android.graphics.PointF;
import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.List;

public class ZoomInfo
{
  int EASE_CURVE = 0;
  private final int FACE_INDEX_LINE_END = 18;
  private final int FACE_INDEX_LINE_START = 0;
  private final int MAX_FACE_POINT_SIZE = 90;
  private TransScaleInfo mCalcuInfo;
  private float[] mCenterPoints;
  private int mFrames;
  private int[] mPartIndex;
  private int mPointType = ZoomInfo.POINT_TYPE.FACE_POINT.type;
  private float mZoomHeight;
  private List<Pair<Float, Double>> mZoomScales;
  private float mZoomWidth;
  
  public ZoomInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt, float[] paramArrayOfFloat, List<Pair<Float, Double>> paramList, float paramFloat1, float paramFloat2)
  {
    this.mPointType = paramInt1;
    this.mCenterPoints = paramArrayOfFloat;
    this.mPartIndex = paramArrayOfInt;
    this.mZoomScales = paramList;
    this.mFrames = paramInt2;
    this.mCalcuInfo = new TransScaleInfo();
    this.mZoomWidth = paramFloat1;
    this.mZoomHeight = paramFloat2;
  }
  
  public ZoomInfo(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {
      return;
    }
    this.mPointType = paramStickerItem.zoomType;
    this.mPartIndex = paramStickerItem.activeParts;
    this.mCenterPoints = paramStickerItem.zoomFocusPoint;
    this.mZoomScales = paramStickerItem.zoomScale;
    this.mZoomWidth = paramStickerItem.zoomWidth;
    this.mZoomHeight = paramStickerItem.zoomHeight;
    this.mFrames = paramStickerItem.frames;
    this.mCalcuInfo = new TransScaleInfo();
  }
  
  private float calculateDistance2PointF(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 != null) && (paramPointF2 != null))
    {
      float f1 = paramPointF1.x - paramPointF2.x;
      float f2 = paramPointF1.y - paramPointF2.y;
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    return 0.0F;
  }
  
  private void calculateFaceScale(List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    float f1 = calculateDistance2PointF((PointF)paramList.get(0), (PointF)paramList.get(18));
    float f3 = this.mZoomWidth * f1;
    float f4 = f1 * this.mZoomHeight;
    if (f3 > 0.0F) {
      f1 = f4 / f3;
    } else {
      f1 = 0.0F;
    }
    double d = paramInt1;
    Double.isNaN(d);
    paramInt1 = (int)(d * paramDouble);
    d = paramInt2;
    Double.isNaN(d);
    paramInt2 = (int)(d * paramDouble);
    float f2;
    if (paramInt1 > 0) {
      f2 = paramInt2 / paramInt1;
    } else {
      f2 = 0.0F;
    }
    if (f1 > 0.0F)
    {
      if (f2 <= 0.0F) {
        return;
      }
      paramList = this.mCalcuInfo;
      if (f1 < f2) {
        f1 = paramInt1 / f3;
      } else {
        f1 = paramInt2 / f4;
      }
      paramList.scaleValue = f1;
    }
  }
  
  private void calculateFocusFacePoint(List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    Object localObject1 = this.mCenterPoints;
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return;
      }
      localObject1 = new PointF(0.0F, 0.0F);
      int i = 0;
      for (;;)
      {
        Object localObject2 = this.mCenterPoints;
        if (i >= localObject2.length) {
          break;
        }
        localObject2 = (PointF)paramList.get((int)localObject2[i]);
        ((PointF)localObject1).x += ((PointF)localObject2).x;
        ((PointF)localObject1).y += ((PointF)localObject2).y;
        i += 1;
      }
      float f1 = ((PointF)localObject1).x / this.mCenterPoints.length;
      float f3 = ((PointF)localObject1).y / this.mCenterPoints.length;
      double d = paramInt1;
      Double.isNaN(d);
      paramInt1 = (int)(d * paramDouble);
      d = paramInt2;
      Double.isNaN(d);
      paramInt2 = (int)(d * paramDouble);
      float f2 = 0.5F;
      if (paramInt1 == 0) {
        f1 = 0.5F;
      } else {
        f1 /= paramInt1;
      }
      if (paramInt2 != 0) {
        f2 = f3 / paramInt2;
      }
      f3 = calculateDistance2PointF((PointF)paramList.get(0), (PointF)paramList.get(18));
      float f5 = this.mZoomWidth * f3;
      float f6 = f3 * this.mZoomHeight;
      if (f5 > 0.0F) {
        f3 = f6 / f5;
      } else {
        f3 = 0.0F;
      }
      float f4;
      if (paramInt1 > 0) {
        f4 = paramInt2 / paramInt1;
      } else {
        f4 = 0.0F;
      }
      if (f3 > 0.0F)
      {
        if (f4 <= 0.0F) {
          return;
        }
        this.mCalcuInfo.anchorPoint.x = f1;
        this.mCalcuInfo.anchorPoint.y = f2;
        paramList = this.mCalcuInfo;
        f1 = paramInt1;
        f2 = f5 / f1;
        float f7 = paramInt2;
        paramList.checkVaild(f2, f6 / f7);
        paramList = this.mCalcuInfo;
        if (f3 < f4) {
          f1 /= f5;
        } else {
          f1 = f7 / f6;
        }
        paramList.scaleValue = f1;
        f1 = 1.0F / this.mCalcuInfo.scaleValue;
        this.mCalcuInfo.checkVaild(f1, f1);
      }
    }
  }
  
  private void calculateScale(PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2)
  {
    if (this.mPointType == ZoomInfo.POINT_TYPE.FACE_POINT.type)
    {
      updateInfoByFacePoints(paramPTFaceAttr);
      return;
    }
    if (this.mPointType == ZoomInfo.POINT_TYPE.ABSOLUT_POINT.type) {
      updateInfoByFrame(paramInt1, paramInt2);
    }
  }
  
  private void updateInfoByFacePoints(PTFaceAttr paramPTFaceAttr)
  {
    if ((this.mCalcuInfo != null) && (paramPTFaceAttr != null) && (paramPTFaceAttr.getAllFacePoints() != null))
    {
      if (paramPTFaceAttr.getAllFacePoints().size() < 1) {
        return;
      }
      Object localObject = paramPTFaceAttr.getOrigFrame();
      if (localObject == null) {
        return;
      }
      int i = ((Frame)localObject).width;
      int j = ((Frame)localObject).height;
      localObject = (List)paramPTFaceAttr.getAllFacePoints().get(0);
      if (localObject != null)
      {
        if (((List)localObject).size() < 90) {
          return;
        }
        calculateFocusFacePoint((List)localObject, i, j, paramPTFaceAttr.getFaceDetectScale());
      }
    }
  }
  
  private void updateInfoByFrame(int paramInt1, int paramInt2)
  {
    if ((this.mCenterPoints != null) && (this.mZoomWidth > 0.0F) && (this.mZoomHeight > 0.0F) && (paramInt1 > 0))
    {
      if (paramInt2 <= 0) {
        return;
      }
      Object localObject1 = new PointF(0.0F, 0.0F);
      int i = 0;
      for (;;)
      {
        localObject2 = this.mCenterPoints;
        if (i >= localObject2.length - 1) {
          break;
        }
        ((PointF)localObject1).x += this.mCenterPoints[i];
        ((PointF)localObject1).y += this.mCenterPoints[(i + 1)];
        i += 2;
      }
      i = localObject2.length / 2;
      Object localObject2 = this.mCalcuInfo.anchorPoint;
      float f1 = ((PointF)localObject1).x;
      float f2 = i;
      ((PointF)localObject2).x = (f1 / f2);
      this.mCalcuInfo.anchorPoint.y = (((PointF)localObject1).y / f2);
      f1 = this.mZoomHeight;
      f2 = this.mZoomWidth;
      float f3 = f1 / f2;
      float f4 = paramInt2 / paramInt1;
      localObject1 = this.mCalcuInfo;
      if (f3 < f4) {
        f1 = 1.0F / f2;
      } else {
        f1 = 1.0F / f1;
      }
      ((TransScaleInfo)localObject1).scaleValue = f1;
    }
  }
  
  public boolean checkVaild(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = 0.5F / paramFloat3;
    paramFloat3 = paramFloat1 - f1;
    float f2 = 0.5F / paramFloat4;
    paramFloat4 = paramFloat2 - f2;
    paramFloat1 += f1;
    paramFloat2 += f2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ltx:");
    localStringBuilder.append(paramFloat3);
    localStringBuilder.append(",lty:");
    localStringBuilder.append(paramFloat4);
    localStringBuilder.append(",rbx:");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(",rby:");
    localStringBuilder.append(paramFloat2);
    Log.i("greatgao", localStringBuilder.toString());
    return (paramFloat3 >= 0.0F) && (paramFloat4 >= 0.0F) && (paramFloat1 <= 1.0F) && (paramFloat2 <= 1.0F);
  }
  
  public boolean isInCurPart(int paramInt)
  {
    int[] arrayOfInt = this.mPartIndex;
    if (arrayOfInt != null)
    {
      if (paramInt < 0) {
        return true;
      }
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return true;
  }
  
  void reset()
  {
    this.mCalcuInfo.reset();
  }
  
  void updateInfoBy() {}
  
  public void updateZoomInfo(PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2, int paramInt3, TransScaleInfo paramTransScaleInfo)
  {
    int i = this.mFrames;
    if (i > 0)
    {
      if (paramTransScaleInfo == null) {
        return;
      }
      float f1 = (float)FabbyUtil.getRangeValue(this.EASE_CURVE, paramInt3 * 1.0F / i, this.mZoomScales, 1.0D);
      calculateScale(paramPTFaceAttr, paramInt1, paramInt2);
      if (f1 == 0.0F)
      {
        paramTransScaleInfo.reset();
        return;
      }
      float f2 = this.mCalcuInfo.anchorPoint.x;
      float f3 = this.mCalcuInfo.anchorPoint.y;
      paramTransScaleInfo.anchorPoint.x = ((f2 - 0.5F) * 2.0F * f1);
      paramTransScaleInfo.anchorPoint.y = ((f3 - 0.5F) * 2.0F * f1);
      paramTransScaleInfo.scaleValue = (1.0F / (1.0F - (1.0F - 1.0F / this.mCalcuInfo.scaleValue) * f1));
      if (paramTransScaleInfo.scaleValue == 1.0F)
      {
        paramTransScaleInfo.anchorPoint.x = 0.0F;
        paramTransScaleInfo.anchorPoint.y = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.zoomfilter.ZoomInfo
 * JD-Core Version:    0.7.0.1
 */