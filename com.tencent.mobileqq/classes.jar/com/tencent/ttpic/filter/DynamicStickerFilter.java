package com.tencent.ttpic.filter;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.Float3fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.Mat4Param;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoUtil;
import java.util.List;

public class DynamicStickerFilter
  extends NormalVideoFilter
{
  private static final int LENTH_POINTS_ANGLE = 4;
  private String TAG = DynamicStickerFilter.class.getSimpleName();
  private Point canvasCenter;
  
  public DynamicStickerFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  public static boolean isValidItem(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {}
    while ((paramStickerItem.alignFacePoints == null) || (paramStickerItem.alignFacePoints.length <= 0) || (paramStickerItem.anchorPoint == null) || (paramStickerItem.anchorPoint.length < 2) || (paramStickerItem.scalePivots == null) || (paramStickerItem.scalePivots.length < 2)) {
      return false;
    }
    return true;
  }
  
  private boolean isValidPoint(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((paramPoint.x < 0) || (paramPoint.x > this.width) || (paramPoint.y < 0) || (paramPoint.y > this.height)) {
      return false;
    }
    return true;
  }
  
  public void initParams()
  {
    super.initParams();
    addParam(new Param.IntParam("texNeedTransform", 1));
    addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new Param.Float2fParam("texAnchor", 0.0F, 0.0F));
    addParam(new Param.FloatParam("texScale", 1.0F));
    addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new Param.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((VideoUtil.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    if (this.item.alignFacePoints.length == 1) {}
    for (int i = this.item.alignFacePoints[0];; i = this.item.alignFacePoints[1])
    {
      PointF localPointF2 = (PointF)paramList.get(i);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      localPointF1.x = ((float)(localPointF1.x * (1.0D / this.mScreenScale)));
      localPointF1.y = ((float)(localPointF1.y * (1.0D / this.mScreenScale)));
      paramFloat = localPointF1.x - this.item.anchorPoint[0];
      float f1 = localPointF1.y - this.item.anchorPoint[1];
      float f2 = this.item.width;
      setPositions(AlgoUtils.calPositions(paramFloat, f1 + this.item.height, paramFloat + f2, f1, this.width, this.height));
      addParam(new Param.Float2fParam("texAnchor", localPointF1.x - this.canvasCenter.x, localPointF1.y - this.canvasCenter.y));
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      localPointF1.x = ((float)(localPointF1.x * (1.0D / this.mScreenScale)));
      localPointF1.y = ((float)(localPointF1.y * (1.0D / this.mScreenScale)));
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      paramList.x = ((float)(paramList.x * (1.0D / this.mScreenScale)));
      paramList.y = ((float)(paramList.y * (1.0D / this.mScreenScale)));
      addParam(new Param.FloatParam("texScale", (float)(Math.sqrt(Math.pow(localPointF1.x - paramList.x, 2.0D) + Math.pow(localPointF1.y - paramList.y, 2.0D)) / this.item.scaleFactor)));
      if (this.item.support3D != 1) {
        break;
      }
      addParam(new Param.Float3fParam("texRotate", paramArrayOfFloat[0], paramArrayOfFloat[1], -paramArrayOfFloat[2]));
      return;
    }
    addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, -paramArrayOfFloat[2]));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.DynamicStickerFilter
 * JD-Core Version:    0.7.0.1
 */