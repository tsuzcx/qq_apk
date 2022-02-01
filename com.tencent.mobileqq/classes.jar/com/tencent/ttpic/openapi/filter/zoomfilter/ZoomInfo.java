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
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return 0.0F;
    }
    float f1 = paramPointF1.x - paramPointF2.x;
    float f2 = paramPointF1.y - paramPointF2.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void calculateFaceScale(List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    float f1 = calculateDistance2PointF((PointF)paramList.get(0), (PointF)paramList.get(18));
    float f3 = f1 * this.mZoomWidth;
    float f4 = f1 * this.mZoomHeight;
    if (f3 > 0.0F)
    {
      f1 = f4 / f3;
      paramInt1 = (int)(paramInt1 * paramDouble);
      paramInt2 = (int)(paramInt2 * paramDouble);
      if (paramInt1 <= 0) {
        break label104;
      }
    }
    label104:
    for (float f2 = paramInt2 / paramInt1;; f2 = 0.0F)
    {
      if ((f1 > 0.0F) && (f2 > 0.0F)) {
        break label110;
      }
      return;
      f1 = 0.0F;
      break;
    }
    label110:
    paramList = this.mCalcuInfo;
    if (f1 < f2) {}
    for (f1 = paramInt1 / f3;; f1 = paramInt2 / f4)
    {
      paramList.scaleValue = f1;
      return;
    }
  }
  
  private void calculateFocusFacePoint(List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble)
  {
    float f2 = 0.5F;
    if ((this.mCenterPoints == null) || (this.mCenterPoints.length == 0)) {
      return;
    }
    PointF localPointF1 = new PointF(0.0F, 0.0F);
    int i = 0;
    while (i < this.mCenterPoints.length)
    {
      PointF localPointF2 = (PointF)paramList.get((int)this.mCenterPoints[i]);
      localPointF1.x += localPointF2.x;
      f1 = localPointF1.y;
      localPointF2.y += f1;
      i += 1;
    }
    float f1 = localPointF1.x / this.mCenterPoints.length;
    float f3 = localPointF1.y / this.mCenterPoints.length;
    paramInt1 = (int)(paramInt1 * paramDouble);
    paramInt2 = (int)(paramInt2 * paramDouble);
    label158:
    label162:
    float f5;
    float f6;
    label221:
    float f4;
    if (paramInt1 == 0)
    {
      f1 = 0.5F;
      if (paramInt2 != 0) {
        break label345;
      }
      f3 = calculateDistance2PointF((PointF)paramList.get(0), (PointF)paramList.get(18));
      f5 = f3 * this.mZoomWidth;
      f6 = f3 * this.mZoomHeight;
      if (f5 <= 0.0F) {
        break label355;
      }
      f3 = f6 / f5;
      if (paramInt1 <= 0) {
        break label361;
      }
      f4 = paramInt2 / paramInt1;
      label231:
      if ((f3 <= 0.0F) || (f4 <= 0.0F)) {
        break label365;
      }
      this.mCalcuInfo.anchorPoint.x = f1;
      this.mCalcuInfo.anchorPoint.y = f2;
      this.mCalcuInfo.checkVaild(f5 / paramInt1, f6 / paramInt2);
      paramList = this.mCalcuInfo;
      if (f3 >= f4) {
        break label367;
      }
    }
    label345:
    label355:
    label361:
    label365:
    label367:
    for (f1 = paramInt1 / f5;; f1 = paramInt2 / f6)
    {
      paramList.scaleValue = f1;
      f1 = 1.0F / this.mCalcuInfo.scaleValue;
      this.mCalcuInfo.checkVaild(f1, f1);
      return;
      f1 /= paramInt1;
      break label158;
      f2 = f3 / paramInt2;
      break label162;
      f3 = 0.0F;
      break label221;
      f4 = 0.0F;
      break label231;
      break;
    }
  }
  
  private void calculateScale(PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2)
  {
    if (this.mPointType == ZoomInfo.POINT_TYPE.FACE_POINT.type) {
      updateInfoByFacePoints(paramPTFaceAttr);
    }
    while (this.mPointType != ZoomInfo.POINT_TYPE.ABSOLUT_POINT.type) {
      return;
    }
    updateInfoByFrame(paramInt1, paramInt2);
  }
  
  private void updateInfoByFacePoints(PTFaceAttr paramPTFaceAttr)
  {
    if ((this.mCalcuInfo == null) || (paramPTFaceAttr == null) || (paramPTFaceAttr.getAllFacePoints() == null) || (paramPTFaceAttr.getAllFacePoints().size() < 1)) {}
    Object localObject;
    int i;
    int j;
    do
    {
      return;
      localObject = paramPTFaceAttr.getOrigFrame();
      i = ((Frame)localObject).width;
      j = ((Frame)localObject).height;
      localObject = (List)paramPTFaceAttr.getAllFacePoints().get(0);
    } while ((localObject == null) || (((List)localObject).size() < 90));
    calculateFocusFacePoint((List)localObject, i, j, paramPTFaceAttr.getFaceDetectScale());
  }
  
  private void updateInfoByFrame(int paramInt1, int paramInt2)
  {
    if ((this.mCenterPoints == null) || (this.mZoomWidth <= 0.0F) || (this.mZoomHeight <= 0.0F) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    Object localObject = new PointF(0.0F, 0.0F);
    int i = 0;
    while (i < this.mCenterPoints.length - 1)
    {
      ((PointF)localObject).x += this.mCenterPoints[i];
      ((PointF)localObject).y += this.mCenterPoints[(i + 1)];
      i += 2;
    }
    i = this.mCenterPoints.length / 2;
    this.mCalcuInfo.anchorPoint.x = (((PointF)localObject).x / i);
    this.mCalcuInfo.anchorPoint.y = (((PointF)localObject).y / i);
    float f1 = this.mZoomHeight / this.mZoomWidth;
    float f2 = paramInt2 / paramInt1;
    localObject = this.mCalcuInfo;
    if (f1 < f2) {}
    for (f1 = 1.0F / this.mZoomWidth;; f1 = 1.0F / this.mZoomHeight)
    {
      ((TransScaleInfo)localObject).scaleValue = f1;
      return;
    }
  }
  
  public boolean checkVaild(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 - 0.5F / paramFloat3;
    float f2 = paramFloat2 - 0.5F / paramFloat4;
    paramFloat1 = 0.5F / paramFloat3 + paramFloat1;
    paramFloat2 = 0.5F / paramFloat4 + paramFloat2;
    Log.i("greatgao", "ltx:" + f1 + ",lty:" + f2 + ",rbx:" + paramFloat1 + ",rby:" + paramFloat2);
    return (f1 >= 0.0F) && (f2 >= 0.0F) && (paramFloat1 <= 1.0F) && (paramFloat2 <= 1.0F);
  }
  
  public boolean isInCurPart(int paramInt)
  {
    if ((this.mPartIndex == null) || (paramInt < 0)) {
      return true;
    }
    int[] arrayOfInt = this.mPartIndex;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label45;
      }
      if (arrayOfInt[i] == paramInt) {
        break;
      }
      i += 1;
    }
    label45:
    return false;
  }
  
  void reset()
  {
    this.mCalcuInfo.reset();
  }
  
  void updateInfoBy() {}
  
  public void updateZoomInfo(PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2, int paramInt3, TransScaleInfo paramTransScaleInfo)
  {
    if ((this.mFrames <= 0) || (paramTransScaleInfo == null)) {}
    do
    {
      return;
      float f1 = (float)FabbyUtil.getRangeValue(this.EASE_CURVE, paramInt3 * 1.0F / this.mFrames, this.mZoomScales, 1.0D);
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
      paramTransScaleInfo.scaleValue = (1.0F / (1.0F - f1 * (1.0F - 1.0F / this.mCalcuInfo.scaleValue)));
    } while (paramTransScaleInfo.scaleValue != 1.0F);
    paramTransScaleInfo.anchorPoint.x = 0.0F;
    paramTransScaleInfo.anchorPoint.y = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.zoomfilter.ZoomInfo
 * JD-Core Version:    0.7.0.1
 */