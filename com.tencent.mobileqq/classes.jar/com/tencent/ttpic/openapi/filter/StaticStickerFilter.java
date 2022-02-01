package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaticStickerFilter
  extends NormalVideoFilter
{
  private long fabbyStartTime = 0L;
  private boolean initialized = false;
  private float ratio = 0.75F;
  private List<PointF> relativePivotsPts;
  private List<PointF> relativePosPts;
  private float scaleFactor = 1.0F;
  
  public StaticStickerFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  private void initFabbyPositionAdjust()
  {
    if (this.item.aspectMode == 1)
    {
      setPositions(GlUtil.ORIGIN_POSITION_COORDS);
      return;
    }
    double d1 = this.width;
    double d2 = this.height;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    d2 = this.item.width;
    double d3 = this.item.height;
    Double.isNaN(d2);
    Double.isNaN(d3);
    d2 /= d3;
    if (d1 >= d2)
    {
      d1 = this.width;
      Double.isNaN(d1);
      d1 /= 720.0D;
      d3 = this.width;
      Double.isNaN(d3);
      j = (int)(d3 / d2);
      d2 = j;
      d3 = this.item.position[1];
      Double.isNaN(d2);
      int k = (int)(d2 * d3);
      d2 = this.width;
      d3 = this.item.position[0];
      Double.isNaN(d2);
      i = (int)(d2 * d3);
      j = k - (j - this.height) / 2;
      f1 = i;
      d2 = j;
      d3 = this.item.height;
      Double.isNaN(d3);
      Double.isNaN(d2);
      f2 = (float)(d2 + d3 * d1);
      d2 = i;
      d3 = this.item.width;
      Double.isNaN(d3);
      Double.isNaN(d2);
      setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 + d3 * d1), j, this.width, this.height));
      return;
    }
    d1 = this.height;
    Double.isNaN(d1);
    d1 = d1 / 720.0D * d2;
    d3 = this.height;
    Double.isNaN(d3);
    int j = (int)(d3 * d2);
    d2 = this.height;
    d3 = this.item.position[1];
    Double.isNaN(d2);
    int i = (int)(d2 * d3);
    d2 = j;
    d3 = this.item.position[0];
    Double.isNaN(d2);
    j = (int)(d2 * d3) - (j - this.width) / 2;
    float f1 = j;
    d2 = i;
    d3 = this.item.height;
    Double.isNaN(d3);
    Double.isNaN(d2);
    float f2 = (float)(d2 + d3 * d1);
    d2 = j;
    d3 = this.item.width;
    Double.isNaN(d3);
    Double.isNaN(d2);
    setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 + d3 * d1), i, this.width, this.height));
  }
  
  private void updateRelativeParams(int paramInt, float paramFloat)
  {
    if (this.relativePivotsPts == null) {
      this.relativePivotsPts = new ArrayList();
    }
    if (this.relativePosPts == null) {
      this.relativePosPts = new ArrayList();
    }
    this.relativePivotsPts.clear();
    this.relativePosPts.clear();
    if ((paramInt != 0) && (paramInt != 180)) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    int j = 720;
    int i;
    if (paramInt != 0) {
      i = 720;
    } else {
      i = 960;
    }
    if (paramInt != 0) {
      j = 960;
    }
    float f1;
    if (paramInt != 0) {
      f1 = 0.75F;
    } else {
      f1 = 1.333333F;
    }
    if (paramInt == 0) {
      paramFloat = 1.0F / paramFloat;
    }
    float f2;
    float f3;
    float f4;
    if (paramFloat < f1)
    {
      f1 = j;
      localObject = this.relativePivotsPts;
      f2 = i / 2;
      f3 = j / 2;
      ((List)localObject).add(new PointF(f2, f3));
      localObject = this.relativePivotsPts;
      f4 = i;
      paramFloat = (f4 - paramFloat * f1) / 2.0F;
      ((List)localObject).add(new PointF(paramFloat, 0.0F));
      this.relativePivotsPts.add(new PointF(f2, 0.0F));
      localObject = this.relativePivotsPts;
      f4 -= paramFloat;
      ((List)localObject).add(new PointF(f4, 0.0F));
      this.relativePivotsPts.add(new PointF(paramFloat, f3));
      this.relativePivotsPts.add(new PointF(f4, f3));
      this.relativePivotsPts.add(new PointF(paramFloat, f1));
      this.relativePivotsPts.add(new PointF(f2, f1));
      this.relativePivotsPts.add(new PointF(f4, f1));
    }
    else
    {
      f1 = i;
      f4 = f1 / paramFloat;
      localObject = this.relativePivotsPts;
      paramFloat = i / 2;
      f2 = j / 2;
      ((List)localObject).add(new PointF(paramFloat, f2));
      localObject = this.relativePivotsPts;
      f3 = j;
      f4 = (f3 - f4) / 2.0F;
      ((List)localObject).add(new PointF(0.0F, f4));
      this.relativePivotsPts.add(new PointF(paramFloat, f4));
      this.relativePivotsPts.add(new PointF(f1, f4));
      this.relativePivotsPts.add(new PointF(0.0F, f2));
      this.relativePivotsPts.add(new PointF(f1, f2));
      localObject = this.relativePivotsPts;
      f2 = f3 - f4;
      ((List)localObject).add(new PointF(0.0F, f2));
      this.relativePivotsPts.add(new PointF(paramFloat, f2));
      this.relativePivotsPts.add(new PointF(f1, f2));
    }
    Object localObject = this.relativePivotsPts.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PointF localPointF = (PointF)((Iterator)localObject).next();
      this.relativePosPts.add(new PointF(localPointF.x / i, localPointF.y / j));
    }
  }
  
  public void clearTextureParam()
  {
    super.clearTextureParam();
    this.initialized = false;
  }
  
  public void initParams()
  {
    super.initParams();
    addParam(new UniformParam.IntParam("texNeedTransform", -1));
    updateRelativeParams(0, this.ratio);
  }
  
  public void initPositionAdjusted(int paramInt)
  {
    if ((this.item != null) && (this.item.position != null) && (this.item.position.length >= 2))
    {
      if (!this.item.orienting) {
        paramInt = 0;
      }
      updateRelativeParams(paramInt, this.ratio);
      int i1 = this.item.width;
      int n = this.item.height;
      int j;
      int i;
      Object localObject1;
      float f1;
      float f2;
      double d2;
      double d1;
      double d3;
      if (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)
      {
        int k = 960;
        int m = 720;
        j = k;
        i = m;
        if (paramInt != 90) {
          if (paramInt == 270)
          {
            j = k;
            i = m;
          }
          else
          {
            j = 720;
            i = 960;
          }
        }
        localObject1 = this.relativePivotsPts;
        List localList = this.relativePosPts;
        Object localObject2 = this.item.scalePivots;
        f1 = 1.0F;
        if ((localObject2 != null) && (this.item.relativeScaleType == 0)) {
          f1 = AlgoUtils.getDistance((PointF)((List)localObject1).get(this.item.scalePivots[0]), (PointF)((List)localObject1).get(this.item.scalePivots[1])) / this.item.scaleFactor;
        }
        f2 = f1 * this.scaleFactor;
        float f3 = this.width / this.height;
        d2 = 1.333333333333333D;
        if ((paramInt != 90) && (paramInt != 270)) {
          d1 = 0.75D;
        } else {
          d1 = 1.333333333333333D;
        }
        float f4 = (float)d1;
        f1 = f2;
        if (this.item.relativeScaleType == 1)
        {
          f1 = f2;
          if (f3 < f4) {
            f1 = f2 * (f3 / f4);
          }
        }
        k = (int)(i1 * f1);
        m = (int)(n * f1);
        localObject2 = new float[2];
        localObject1 = localObject2;
        if (this.item.alignFacePoints != null)
        {
          localObject1 = localObject2;
          if (this.item.alignFacePoints.length >= 1) {
            if (this.item.alignFacePoints.length == 1)
            {
              localObject1 = localObject2;
              if (this.item.alignFacePoints[0] < localList.size())
              {
                localObject1 = new float[2];
                localObject1[0] = ((PointF)localList.get(this.item.alignFacePoints[0])).x;
                localObject1[1] = ((PointF)localList.get(this.item.alignFacePoints[0])).y;
              }
            }
            else
            {
              localObject1 = localObject2;
              if (this.item.alignFacePoints.length == 2)
              {
                localObject1 = localObject2;
                if (this.item.alignFacePoints[0] < localList.size())
                {
                  localObject1 = localObject2;
                  if (this.item.alignFacePoints[1] < localList.size())
                  {
                    localObject1 = new float[2];
                    localObject1[0] = ((((PointF)localList.get(this.item.alignFacePoints[0])).x + ((PointF)localList.get(this.item.alignFacePoints[1])).x) / 2.0F);
                    localObject1[1] = ((((PointF)localList.get(this.item.alignFacePoints[0])).y + ((PointF)localList.get(this.item.alignFacePoints[1])).y) / 2.0F);
                  }
                }
              }
            }
          }
        }
        if ((this.item.anchorPoint != null) && (this.item.anchorPoint.length >= 2))
        {
          this.item.position[0] = (localObject1[0] - this.item.anchorPoint[0] * f1 / j);
          this.item.position[1] = (localObject1[1] - this.item.anchorPoint[1] * f1 / i);
        }
        d3 = f3;
        d1 = d2;
        if (paramInt != 90) {
          if (paramInt == 270) {
            d1 = d2;
          } else {
            d1 = 0.75D;
          }
        }
        if (d3 >= d1)
        {
          f1 = this.width / j;
          if ((paramInt != 90) && (paramInt != 270))
          {
            d1 = this.width;
            Double.isNaN(d1);
            d1 /= 0.75D;
          }
          else
          {
            d1 = this.width;
            Double.isNaN(d1);
            d1 *= 0.75D;
          }
          j = (int)d1;
          d1 = j;
          d2 = this.item.position[1];
          Double.isNaN(d1);
          paramInt = (int)(d1 * d2);
          d1 = this.width;
          d2 = this.item.position[0];
          Double.isNaN(d1);
          i = (int)(d1 * d2);
          j = (j - this.height) / 2;
          f2 = i;
          f3 = paramInt - j;
          localObject1 = AlgoUtils.calPositions(f2, f3 + m * f1, f2 + k * f1, f3, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor));
          } else {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor, this.item.anchorPointAudio, this.item.scaleDirection));
          }
        }
        else
        {
          f1 = this.height / i;
          if ((paramInt != 90) && (paramInt != 270))
          {
            d1 = this.height;
            Double.isNaN(d1);
            d1 *= 0.75D;
          }
          else
          {
            d1 = this.height;
            Double.isNaN(d1);
            d1 /= 0.75D;
          }
          paramInt = (int)d1;
          d1 = this.height;
          d2 = this.item.position[1];
          Double.isNaN(d1);
          i = (int)(d1 * d2);
          d1 = paramInt;
          d2 = this.item.position[0];
          Double.isNaN(d1);
          f2 = (int)(d1 * d2) - (paramInt - this.width) / 2;
          f3 = i;
          localObject1 = AlgoUtils.calPositions(f2, f3 + m * f1, f2 + k * f1, f3, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor));
          } else {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor, this.item.anchorPointAudio, this.item.scaleDirection));
          }
        }
        if (this.item.angle > 0.0F)
        {
          addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, this.item.angle));
          addParam(new UniformParam.IntParam("texNeedTransform", 1));
        }
      }
      else
      {
        d1 = this.width;
        d2 = this.height;
        Double.isNaN(d1);
        Double.isNaN(d2);
        if (d1 / d2 >= 0.75D)
        {
          d1 = this.width;
          Double.isNaN(d1);
          d1 /= 720.0D;
          d2 = this.width;
          Double.isNaN(d2);
          i = (int)(d2 / 0.75D);
          d2 = i;
          d3 = this.item.position[1];
          Double.isNaN(d2);
          j = (int)(d2 * d3);
          d2 = this.width;
          d3 = this.item.position[0];
          Double.isNaN(d2);
          paramInt = (int)(d2 * d3);
          i = j - (i - this.height) / 2;
          f1 = paramInt;
          d2 = i;
          d3 = n;
          Double.isNaN(d3);
          Double.isNaN(d2);
          f2 = (float)(d2 + d3 * d1);
          d2 = paramInt;
          d3 = i1;
          Double.isNaN(d3);
          Double.isNaN(d2);
          localObject1 = AlgoUtils.calPositions(f1, f2, (float)(d2 + d3 * d1), i, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor));
          } else {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor, this.item.anchorPointAudio, this.item.scaleDirection));
          }
        }
        else
        {
          d1 = this.height;
          Double.isNaN(d1);
          d1 /= 960.0D;
          d2 = this.height;
          Double.isNaN(d2);
          i = (int)(d2 * 0.75D);
          d2 = this.height;
          d3 = this.item.position[1];
          Double.isNaN(d2);
          paramInt = (int)(d2 * d3);
          d2 = i;
          d3 = this.item.position[0];
          Double.isNaN(d2);
          i = (int)(d2 * d3) - (i - this.width) / 2;
          f1 = i;
          d2 = paramInt;
          d3 = n;
          Double.isNaN(d3);
          Double.isNaN(d2);
          f2 = (float)(d2 + d3 * d1);
          d2 = i;
          d3 = i1;
          Double.isNaN(d3);
          Double.isNaN(d2);
          localObject1 = AlgoUtils.calPositions(f1, f2, (float)(d2 + d3 * d1), paramInt, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor));
          } else {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor, this.item.anchorPointAudio, this.item.scaleDirection));
          }
        }
        if (this.item.angle > 0.0F)
        {
          d1 = this.height;
          d2 = this.item.position[1];
          Double.isNaN(d1);
          d3 = this.item.height * 0.5F;
          Double.isNaN(d3);
          paramInt = (int)(d1 * (d2 - 0.5D) + d3);
          d1 = this.width;
          d2 = this.item.position[0];
          Double.isNaN(d1);
          d3 = this.item.width * 0.5F;
          Double.isNaN(d3);
          addParam(new UniformParam.Float2fParam("texAnchor", (int)(d1 * (d2 - 0.5D) + d3), paramInt));
          addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, this.item.angle));
          addParam(new UniformParam.IntParam("texNeedTransform", 1));
        }
      }
      return;
    }
    setPositions(GlUtil.EMPTY_POSITIONS);
  }
  
  public void initPositions()
  {
    if ((this.item != null) && (this.item.position != null) && (this.item.position.length >= 2))
    {
      double d1 = this.width;
      Double.isNaN(d1);
      d1 /= 720.0D;
      double d2 = this.height;
      double d3 = this.item.position[1];
      Double.isNaN(d2);
      int i = (int)(d2 * (1.0D - d3));
      d2 = this.width;
      d3 = this.item.position[0];
      Double.isNaN(d2);
      int j = (int)(d2 * d3);
      float f1 = j;
      float f2 = i;
      d2 = this.item.width;
      Double.isNaN(d2);
      float f3 = j + (int)(d2 * d1);
      d2 = i;
      d3 = this.item.height;
      Double.isNaN(d3);
      Double.isNaN(d2);
      setPositions(AlgoUtils.calPositions(f1, f2, f3, (int)(d2 - d3 * d1), this.width, this.height));
      this.initialized = true;
      return;
    }
    setPositions(GlUtil.EMPTY_POSITIONS);
  }
  
  public void resetFabbyProgress()
  {
    this.fabbyStartTime = 0L;
    this.triggered = false;
  }
  
  public void setPostScale(float paramFloat)
  {
    this.scaleFactor = paramFloat;
  }
  
  public void setRatio(float paramFloat)
  {
    this.ratio = paramFloat;
  }
  
  public void updateFabbyProgress(long paramLong)
  {
    if (!this.triggered) {
      this.fabbyStartTime = paramLong;
    }
    this.triggered = true;
    double d1 = paramLong - this.fabbyStartTime;
    double d2 = Math.max(this.item.frameDuration, 1.0D);
    Double.isNaN(d1);
    updateTextureParam((int)((d1 / d2) % Math.max(this.item.frames, 1)), paramLong);
    initFabbyPositionAdjust();
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if (this.initialized) {
      return;
    }
    if (this.item.isFabbyMvItem)
    {
      initFabbyPositionAdjust();
      return;
    }
    initPositionAdjusted((int)paramFloat);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if ((this.width != paramInt1) || (this.height != paramInt2)) {
      if (this.item.isFabbyMvItem) {
        initFabbyPositionAdjust();
      } else {
        initPositionAdjusted(0);
      }
    }
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StaticStickerFilter
 * JD-Core Version:    0.7.0.1
 */