package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.math.BitUtils;
import com.tencent.ttpic.fabby.FabbyUtil.TransformType;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.openapi.model.Rect;
import com.tencent.ttpic.util.AlgoUtils;

public class CanvasFilters
{
  private BaseFilter mDrawFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  
  private float[] calculateTexPosTriangles(GridModel paramGridModel, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramGridModel.positionMode == 0)
    {
      paramInt3 = paramInt3 * paramInt5 / paramInt1;
      paramInt1 = paramInt4 * paramInt6 / paramInt2;
    }
    else
    {
      paramInt1 = paramInt4;
    }
    if (paramGridModel.aspectMode == 1) {
      return new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
    }
    float f1 = paramInt3;
    float f2 = paramInt1;
    float f3 = f1 / f2;
    float f4 = paramInt5 / paramInt6;
    if (f3 > f4)
    {
      f2 = f2 * 0.5F / (f1 / f4);
      f1 = f2 + 0.5F;
      paramGridModel = new PointF(0.0F, f1);
      f2 = 0.5F - f2;
      localPointF1 = new PointF(0.0F, f2);
      localPointF2 = new PointF(1.0F, f2);
      localPointF3 = new PointF(1.0F, f1);
      return new float[] { localPointF1.x, localPointF1.y, paramGridModel.x, paramGridModel.y, localPointF3.x, localPointF3.y, localPointF1.x, localPointF1.y, localPointF3.x, localPointF3.y, localPointF2.x, localPointF2.y };
    }
    f1 = f1 * 0.5F / (f2 * f4);
    f2 = 0.5F - f1;
    paramGridModel = new PointF(f2, 1.0F);
    PointF localPointF1 = new PointF(f2, 0.0F);
    f1 += 0.5F;
    PointF localPointF2 = new PointF(f1, 0.0F);
    PointF localPointF3 = new PointF(f1, 1.0F);
    return new float[] { localPointF1.x, localPointF1.y, paramGridModel.x, paramGridModel.y, localPointF3.x, localPointF3.y, localPointF1.x, localPointF1.y, localPointF3.x, localPointF3.y, localPointF2.x, localPointF2.y };
  }
  
  private float[] calculateVerPosTriangles(GridModel paramGridModel, int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = paramInt1;
    float f2 = paramInt2;
    float f3 = f1 / f2;
    Object localObject1 = new float[12];
    if ((Math.abs(f3 - paramFloat) >= 0.0001D) && (paramGridModel.positionMode != 0))
    {
      if (f3 > paramFloat)
      {
        paramFloat = f2 * paramFloat;
        f1 = (f1 - paramFloat) / 2.0F;
        f1 = paramGridModel.canvasRect.x - f1;
        f2 = paramGridModel.canvasRect.y;
        localObject1 = AlgoUtils.calPositionsTriangles(f1, f2, paramGridModel.canvasRect.width + f1, paramGridModel.canvasRect.height + f2, (int)paramFloat, paramInt2);
      }
      else
      {
        paramFloat = f1 / paramFloat;
        f2 = (f2 - paramFloat) / 2.0F;
        f1 = paramGridModel.canvasRect.x;
        f2 = paramGridModel.canvasRect.y - f2;
        localObject1 = AlgoUtils.calPositionsTriangles(f1, f2, paramGridModel.canvasRect.width + f1, paramGridModel.canvasRect.height + f2, paramInt1, (int)paramFloat);
      }
    }
    else {
      localObject1 = AlgoUtils.calPositionsTriangles(paramGridModel.canvasRect.x, paramGridModel.canvasRect.y, paramGridModel.canvasRect.x + paramGridModel.canvasRect.width, paramGridModel.canvasRect.y + paramGridModel.canvasRect.height, paramInt1, paramInt2);
    }
    Object localObject2 = localObject1;
    if (BitUtils.checkBit(paramGridModel.transformType, FabbyUtil.TransformType.MIRROR_TOP_BOTTOM.value))
    {
      paramFloat = localObject1[0];
      f1 = localObject1[1];
      f2 = localObject1[3];
      f3 = localObject1[4];
      localObject2 = new float[] { paramFloat, f2, paramFloat, f1, f3, f1, paramFloat, f2, f3, f1, f3, f2 };
    }
    localObject1 = localObject2;
    if (BitUtils.checkBit(paramGridModel.transformType, FabbyUtil.TransformType.MIRROR_LEFT_RIGHT.value))
    {
      paramFloat = localObject2[0];
      f1 = localObject2[1];
      f2 = localObject2[3];
      f3 = localObject2[4];
      localObject1 = new float[] { f3, f1, f3, f2, paramFloat, f2, f3, f1, paramFloat, f2, paramFloat, f1 };
    }
    return localObject1;
  }
  
  public void ApplyGLSLFilter()
  {
    this.mDrawFilter.apply();
  }
  
  public void clearGLSLSelf()
  {
    this.mDrawFilter.clearGLSLSelf();
  }
  
  public RenderParam drawOnFrame(GridModel paramGridModel, Frame paramFrame, int paramInt1, int paramInt2)
  {
    if ((paramGridModel != null) && (paramGridModel.canvasRect != null))
    {
      RenderParam localRenderParam = new RenderParam();
      localRenderParam.texture = paramFrame.getTextureId();
      localRenderParam.texCords = calculateTexPosTriangles(paramGridModel, paramInt1, paramInt2, paramGridModel.canvasRect.width, paramGridModel.canvasRect.height, paramFrame.width, paramFrame.height);
      localRenderParam.position = calculateVerPosTriangles(paramGridModel, paramInt1, paramInt2, paramFrame.width / paramFrame.height);
      localRenderParam.texScale = 1.0F;
      localRenderParam.texAnchor = new float[] { -(paramInt1 / 2 - (paramGridModel.canvasRect.x + paramGridModel.canvasRect.width / 2)), -(paramInt2 / 2 - (paramGridModel.canvasRect.y + paramGridModel.canvasRect.height / 2)) };
      localRenderParam.texRotate = new float[] { 0.0F, 0.0F, paramGridModel.rotate * 3.1415F / 180.0F };
      return localRenderParam;
    }
    return null;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mDrawFilter.setRenderMode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.CanvasFilters
 * JD-Core Version:    0.7.0.1
 */