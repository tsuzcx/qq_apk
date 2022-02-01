package com.tencent.ttpic.model;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class FastDynamicSticker
  extends FastSticker
{
  private Point canvasCenter;
  public float[] position = new float[12];
  public float[] texCords = new float[12];
  
  public FastDynamicSticker(StickerItem paramStickerItem, String paramString)
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
  
  public void updatePositions(List<PointF> paramList)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    if (this.item.alignFacePoints.length == 1) {}
    for (int i = this.item.alignFacePoints[0];; i = this.item.alignFacePoints[1])
    {
      PointF localPointF2 = (PointF)paramList.get(i);
      PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      float f1 = localPointF3.x - this.item.anchorPoint[0];
      float f2 = localPointF3.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      float f4 = this.item.height;
      this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f4 + f2, f1 + f3, f2, this.width, this.height);
      this.renderParam.texAnchor[0] = (localPointF3.x - this.canvasCenter.x);
      this.renderParam.texAnchor[1] = (localPointF3.y - this.canvasCenter.y);
      localPointF3 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      double d = Math.pow(localPointF3.x - paramList.x, 2.0D);
      d = Math.sqrt(Math.pow(localPointF3.y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
      this.renderParam.texScale = ((float)d);
      if (this.item.alignFacePoints.length <= 1) {
        break;
      }
      f1 = (float)Math.atan2(localPointF1.y - localPointF2.y, localPointF1.x - localPointF2.x);
      this.renderParam.texRotate[0] = 0.0F;
      this.renderParam.texRotate[1] = 0.0F;
      this.renderParam.texRotate[2] = (f1 - this.item.angle);
      return;
    }
  }
  
  protected void updatePositions(List<PointF> paramList, int paramInt)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    if (this.item.alignFacePoints.length == 1) {}
    for (paramInt = this.item.alignFacePoints[0];; paramInt = this.item.alignFacePoints[1])
    {
      PointF localPointF2 = (PointF)paramList.get(paramInt);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      float f1 = localPointF1.x - this.item.anchorPoint[0];
      float f2 = localPointF1.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      float f4 = this.item.height;
      this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f4 + f2, f1 + f3, f2, this.width, this.height);
      this.renderParam.texAnchor[0] = (localPointF1.x - this.canvasCenter.x);
      this.renderParam.texAnchor[1] = (localPointF1.y - this.canvasCenter.y);
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      double d = Math.pow(localPointF1.x - paramList.x, 2.0D);
      d = Math.sqrt(Math.pow(localPointF1.y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
      this.renderParam.texScale = ((float)d);
      this.renderParam.texRotate[0] = 0.0F;
      this.renderParam.texRotate[1] = 0.0F;
      this.renderParam.texRotate[2] = 0.0F;
      return;
    }
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3) || (!isValidItem(this.item)))
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
      float f1 = localPointF1.x - this.item.anchorPoint[0];
      float f2 = localPointF1.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      float f4 = this.item.height;
      this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f4 + f2, f1 + f3, f2, this.width, this.height);
      this.renderParam.texAnchor[0] = (localPointF1.x - this.canvasCenter.x);
      this.renderParam.texAnchor[1] = (localPointF1.y - this.canvasCenter.y);
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      localPointF1.x = ((float)(localPointF1.x * (1.0D / this.mScreenScale)));
      localPointF1.y = ((float)(localPointF1.y * (1.0D / this.mScreenScale)));
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      paramList.x = ((float)(paramList.x * (1.0D / this.mScreenScale)));
      paramList.y = ((float)(paramList.y * (1.0D / this.mScreenScale)));
      double d = Math.pow(localPointF1.x - paramList.x, 2.0D);
      d = Math.sqrt(Math.pow(localPointF1.y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
      this.renderParam.texScale = ((float)d);
      if (this.item.support3D != 1) {
        break;
      }
      this.renderParam.texRotate[0] = paramArrayOfFloat[0];
      this.renderParam.texRotate[1] = paramArrayOfFloat[1];
      this.renderParam.texRotate[2] = (-paramArrayOfFloat[2]);
      return;
    }
    this.renderParam.texRotate[0] = 0.0F;
    this.renderParam.texRotate[1] = 0.0F;
    this.renderParam.texRotate[2] = (-paramArrayOfFloat[2]);
  }
  
  protected void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1;
    if (paramInt == 4)
    {
      paramInt = 0;
      int i;
      int j;
      while (paramInt < 3)
      {
        i = this.item.anchorPoint[(paramInt * 2)];
        j = this.item.anchorPoint[(paramInt * 2 + 1)];
        this.texCords[(paramInt * 2)] = (i / this.item.width);
        this.texCords[(paramInt * 2 + 1)] = (j / this.item.height);
        paramInt += 1;
      }
      paramInt = 3;
      if (paramInt < 6)
      {
        if (paramInt == 3) {}
        for (i = 0;; i = paramInt - 2)
        {
          j = this.item.anchorPoint[(i * 2)];
          i = this.item.anchorPoint[(i * 2 + 1)];
          this.texCords[(paramInt * 2)] = (j / this.item.width);
          this.texCords[(paramInt * 2 + 1)] = (i / this.item.height);
          paramInt += 1;
          break;
        }
      }
      paramInt = 0;
      while (paramInt < 3)
      {
        localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[paramInt]);
        this.position[(paramInt * 2)] = (localPointF1.x / this.width * 2.0F - 1.0F);
        this.position[(paramInt * 2 + 1)] = (localPointF1.y / this.height * 2.0F - 1.0F);
        paramInt += 1;
      }
      paramInt = 3;
      if (paramInt < 6)
      {
        if (paramInt == 3) {}
        for (i = 0;; i = paramInt - 2)
        {
          localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[i]);
          this.position[(paramInt * 2)] = (localPointF1.x / this.width * 2.0F - 1.0F);
          this.position[(paramInt * 2 + 1)] = (localPointF1.y / this.height * 2.0F - 1.0F);
          paramInt += 1;
          break;
        }
      }
    }
    else if (paramInt == 2)
    {
      localPointF1 = new PointF(this.item.anchorPoint[0], this.item.anchorPoint[1]);
      Object localObject1 = new PointF(this.item.anchorPoint[2], this.item.anchorPoint[3]);
      PointF localPointF2 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      Object localObject2 = (PointF)paramList.get(this.item.alignFacePoints[1]);
      paramList = new PointF(localPointF2.x, localPointF2.y);
      localPointF2 = new PointF(((PointF)localObject2).x, ((PointF)localObject2).y);
      float f2 = AlgoUtils.getDistance(paramList, localPointF2) / AlgoUtils.getDistance(localPointF1, (PointF)localObject1);
      this.position[0] = 0.0F;
      this.position[1] = 0.0F;
      this.position[2] = 0.0F;
      this.position[3] = (this.item.height * f2);
      this.position[4] = (this.item.width * f2);
      this.position[5] = (this.item.height * f2);
      this.position[6] = 0.0F;
      this.position[7] = 0.0F;
      this.position[8] = (this.item.width * f2);
      this.position[9] = (this.item.height * f2);
      this.position[10] = (this.item.width * f2);
      this.position[11] = 0.0F;
      paramInt = 0;
      if (paramInt < 11)
      {
        localObject2 = this.texCords;
        if (this.position[paramInt] > 0.0F) {}
        for (f1 = 1.0F;; f1 = 0.0F)
        {
          localObject2[paramInt] = f1;
          paramInt += 1;
          break;
        }
      }
      paramInt = 0;
      while (paramInt < 6)
      {
        this.position[(paramInt * 2 + 1)] = (this.item.height * f2 - this.position[(paramInt * 2 + 1)]);
        paramInt += 1;
      }
      float f1 = (float)Math.atan2(((PointF)localObject1).y - localPointF1.y, ((PointF)localObject1).x - localPointF1.x);
      float f3 = (float)Math.atan2(localPointF2.y - paramList.y, localPointF2.x - paramList.x);
      localObject1 = new Matrix();
      ((Matrix)localObject1).postTranslate(-localPointF1.x * f2, -localPointF1.y * f2);
      ((Matrix)localObject1).postRotate((float)((f3 - f1) * 180.0F / 3.141592653589793D));
      ((Matrix)localObject1).postTranslate(paramList.x, paramList.y);
      ((Matrix)localObject1).mapPoints(this.position);
      paramInt = 0;
      while (paramInt < 6)
      {
        this.position[(paramInt * 2)] = (this.position[(paramInt * 2)] / this.width * 2.0F - 1.0F);
        this.position[(paramInt * 2 + 1)] = (this.position[(paramInt * 2 + 1)] / this.height * 2.0F - 1.0F);
        paramInt += 1;
      }
    }
    this.renderParam.position = this.position;
    this.renderParam.texCords = this.texCords;
    this.renderParam.texAnchor[0] = 0.0F;
    this.renderParam.texAnchor[1] = 0.0F;
    this.renderParam.texScale = 1.0F;
    this.renderParam.texRotate[0] = 0.0F;
    this.renderParam.texRotate[1] = 0.0F;
    this.renderParam.texRotate[2] = 0.0F;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.FastDynamicSticker
 * JD-Core Version:    0.7.0.1
 */