package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastStaticSticker
  extends FastSticker
{
  private boolean initialized = false;
  private float ratio = 0.75F;
  private List<PointF> relativePivotsPts = new ArrayList();
  private List<PointF> relativePosPts = new ArrayList();
  
  public FastStaticSticker(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
    updateRelativeParams(0, this.ratio);
    this.renderParam.texScale = 1.0F;
  }
  
  private void updateRelativeParams(int paramInt, float paramFloat)
  {
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
  
  public void initPositionAdjusted(int paramInt)
  {
    if ((this.item != null) && (this.item.position != null) && (this.item.position.length >= 2))
    {
      int i;
      if (this.item.orienting) {
        i = paramInt;
      } else {
        i = 0;
      }
      updateRelativeParams(i, this.ratio);
      int i1 = this.item.width;
      int n = this.item.height;
      int j;
      Object localObject;
      float f1;
      double d2;
      double d1;
      float f2;
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
        localObject = this.relativePivotsPts;
        List localList = this.relativePosPts;
        if (this.item.relativeScaleType == 0) {
          f1 = AlgoUtils.getDistance((PointF)((List)localObject).get(this.item.scalePivots[0]), (PointF)((List)localObject).get(this.item.scalePivots[1])) / this.item.scaleFactor;
        } else {
          f1 = 1.0F;
        }
        k = (int)(i1 * f1);
        m = (int)(n * f1);
        float[] arrayOfFloat = new float[2];
        localObject = arrayOfFloat;
        if (this.item.alignFacePoints != null)
        {
          localObject = arrayOfFloat;
          if (this.item.alignFacePoints.length >= 1) {
            if (this.item.alignFacePoints.length == 1)
            {
              localObject = arrayOfFloat;
              if (this.item.alignFacePoints[0] < localList.size())
              {
                localObject = new float[2];
                localObject[0] = ((PointF)localList.get(this.item.alignFacePoints[0])).x;
                localObject[1] = ((PointF)localList.get(this.item.alignFacePoints[0])).y;
              }
            }
            else
            {
              localObject = arrayOfFloat;
              if (this.item.alignFacePoints.length == 2)
              {
                localObject = arrayOfFloat;
                if (this.item.alignFacePoints[0] < localList.size())
                {
                  localObject = arrayOfFloat;
                  if (this.item.alignFacePoints[1] < localList.size())
                  {
                    localObject = new float[2];
                    localObject[0] = ((((PointF)localList.get(this.item.alignFacePoints[0])).x + ((PointF)localList.get(this.item.alignFacePoints[1])).x) / 2.0F);
                    localObject[1] = ((((PointF)localList.get(this.item.alignFacePoints[0])).y + ((PointF)localList.get(this.item.alignFacePoints[1])).y) / 2.0F);
                  }
                }
              }
            }
          }
        }
        if ((this.item.anchorPoint != null) && (this.item.anchorPoint.length >= 2))
        {
          this.item.position[0] = (localObject[0] - this.item.anchorPoint[0] * f1 / j);
          this.item.position[1] = (localObject[1] - this.item.anchorPoint[1] * f1 / i);
        }
        d2 = this.width / this.height;
        if ((paramInt != 90) && (paramInt != 270)) {
          d1 = 0.75D;
        } else {
          d1 = 1.333333333333333D;
        }
        float f3;
        if (d2 >= d1)
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
          i = (int)d1;
          d1 = i;
          d2 = this.item.position[1];
          Double.isNaN(d1);
          j = (int)(d1 * d2);
          d1 = this.width;
          d2 = this.item.position[0];
          Double.isNaN(d1);
          paramInt = (int)(d1 * d2);
          i = j - (i - this.height) / 2;
          if (this.item.scaleDirection == 0)
          {
            localObject = this.renderParam;
            f2 = paramInt;
            f3 = i;
            ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f2, f3 + m * f1, f2 + k * f1, f3, this.width, this.height);
            return;
          }
          f2 = paramInt;
          f3 = i;
          localObject = AlgoUtils.calPositionsTriangles(f2, f3 + m * f1, f2 + k * f1, f3, this.width, this.height);
          if (this.triggerCtrlItem != null) {
            this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
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
          i = (int)d1;
          d1 = this.height;
          d2 = this.item.position[1];
          Double.isNaN(d1);
          paramInt = (int)(d1 * d2);
          d1 = i;
          d2 = this.item.position[0];
          Double.isNaN(d1);
          i = (int)(d1 * d2) - (i - this.width) / 2;
          if (this.item.scaleDirection == 0)
          {
            localObject = this.renderParam;
            f2 = i;
            f3 = paramInt;
            ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f2, f3 + m * f1, f2 + k * f1, f3, this.width, this.height);
            return;
          }
          f2 = i;
          f3 = paramInt;
          localObject = AlgoUtils.calPositionsTriangles(f2, m * f1 + f3, f2 + k * f1, f3, this.width, this.height);
          if (this.triggerCtrlItem != null) {
            this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
          }
        }
      }
      else
      {
        d1 = this.width;
        d2 = this.height;
        Double.isNaN(d1);
        Double.isNaN(d2);
        double d3;
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
          if (this.item.scaleDirection == 0)
          {
            localObject = this.renderParam;
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
            ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d2 + d3 * d1), i, this.width, this.height);
            return;
          }
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
          localObject = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d2 + d3 * d1), i, this.width, this.height);
          if (this.triggerCtrlItem != null) {
            this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
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
          if (this.item.scaleDirection == 0)
          {
            localObject = this.renderParam;
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
            ((RenderParam)localObject).position = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d2 + d3 * d1), paramInt, this.width, this.height);
            return;
          }
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
          localObject = AlgoUtils.calPositionsTriangles(f1, f2, (float)(d2 + d3 * d1), paramInt, this.width, this.height);
          if (this.triggerCtrlItem != null) {
            this.renderParam.position = AlgoUtils.adjustPositionTriangles((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection);
          }
        }
      }
      return;
    }
    this.renderParam.position = GlUtil.EMPTY_POSITIONS_TRIANGLES;
  }
  
  public void setRatio(float paramFloat)
  {
    this.ratio = paramFloat;
  }
  
  public void updatePositions(List<PointF> paramList)
  {
    if (this.initialized) {
      return;
    }
    initPositionAdjusted(0);
  }
  
  protected void updatePositions(List<PointF> paramList, int paramInt) {}
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    if (this.initialized) {
      return;
    }
    initPositionAdjusted(0);
  }
  
  protected void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt)
  {
    if (this.initialized) {
      return;
    }
    initPositionAdjusted(0);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if ((this.width != paramInt1) || (this.height != paramInt2)) {
      initPositionAdjusted(0);
    }
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.FastStaticSticker
 * JD-Core Version:    0.7.0.1
 */