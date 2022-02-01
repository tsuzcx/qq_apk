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
    boolean bool2 = false;
    if (paramStickerItem == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramStickerItem.alignFacePoints != null)
    {
      bool1 = bool2;
      if (paramStickerItem.alignFacePoints.length > 0)
      {
        bool1 = bool2;
        if (paramStickerItem.anchorPoint != null)
        {
          bool1 = bool2;
          if (paramStickerItem.anchorPoint.length >= 2)
          {
            bool1 = bool2;
            if (paramStickerItem.scalePivots != null)
            {
              bool1 = bool2;
              if (paramStickerItem.scalePivots.length >= 2) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void updatePositions(List<PointF> paramList)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (isValidItem(this.item)))
    {
      PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      int i;
      if (this.item.alignFacePoints.length == 1) {
        i = this.item.alignFacePoints[0];
      } else {
        i = this.item.alignFacePoints[1];
      }
      PointF localPointF2 = (PointF)paramList.get(i);
      PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      float f1 = localPointF3.x - this.item.anchorPoint[0];
      float f2 = localPointF3.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      float f4 = this.item.height;
      this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f2 + f4, f1 + f3, f2, this.width, this.height);
      this.renderParam.texAnchor[0] = (localPointF3.x - this.canvasCenter.x);
      this.renderParam.texAnchor[1] = (localPointF3.y - this.canvasCenter.y);
      localPointF3 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      double d1 = Math.sqrt(Math.pow(localPointF3.x - paramList.x, 2.0D) + Math.pow(localPointF3.y - paramList.y, 2.0D));
      double d2 = this.item.scaleFactor;
      Double.isNaN(d2);
      d1 /= d2;
      this.renderParam.texScale = ((float)d1);
      if (this.item.alignFacePoints.length > 1)
      {
        f1 = (float)Math.atan2(localPointF1.y - localPointF2.y, localPointF1.x - localPointF2.x);
        this.renderParam.texRotate[0] = 0.0F;
        this.renderParam.texRotate[1] = 0.0F;
        this.renderParam.texRotate[2] = (f1 - this.item.angle);
      }
      return;
    }
    clearTextureParam();
  }
  
  protected void updatePositions(List<PointF> paramList, int paramInt)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (isValidItem(this.item)))
    {
      PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      if (this.item.alignFacePoints.length == 1) {
        paramInt = this.item.alignFacePoints[0];
      } else {
        paramInt = this.item.alignFacePoints[1];
      }
      PointF localPointF2 = (PointF)paramList.get(paramInt);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      float f1 = localPointF1.x - this.item.anchorPoint[0];
      float f2 = localPointF1.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      float f4 = this.item.height;
      this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f2 + f4, f1 + f3, f2, this.width, this.height);
      this.renderParam.texAnchor[0] = (localPointF1.x - this.canvasCenter.x);
      this.renderParam.texAnchor[1] = (localPointF1.y - this.canvasCenter.y);
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      double d1 = Math.sqrt(Math.pow(localPointF1.x - paramList.x, 2.0D) + Math.pow(localPointF1.y - paramList.y, 2.0D));
      double d2 = this.item.scaleFactor;
      Double.isNaN(d2);
      d1 /= d2;
      this.renderParam.texScale = ((float)d1);
      this.renderParam.texRotate[0] = 0.0F;
      this.renderParam.texRotate[1] = 0.0F;
      this.renderParam.texRotate[2] = 0.0F;
      return;
    }
    clearTextureParam();
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3) && (isValidItem(this.item)))
    {
      PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      int i;
      if (this.item.alignFacePoints.length == 1) {
        i = this.item.alignFacePoints[0];
      } else {
        i = this.item.alignFacePoints[1];
      }
      PointF localPointF2 = (PointF)paramList.get(i);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      double d1 = localPointF1.x;
      double d2 = 1.0D / this.mScreenScale;
      Double.isNaN(d1);
      localPointF1.x = ((float)(d1 * d2));
      d1 = localPointF1.y;
      d2 = 1.0D / this.mScreenScale;
      Double.isNaN(d1);
      localPointF1.y = ((float)(d1 * d2));
      float f1 = localPointF1.x - this.item.anchorPoint[0];
      float f2 = localPointF1.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      float f4 = this.item.height;
      this.renderParam.position = AlgoUtils.calPositionsTriangles(f1, f2 + f4, f1 + f3, f2, this.width, this.height);
      this.renderParam.texAnchor[0] = (localPointF1.x - this.canvasCenter.x);
      this.renderParam.texAnchor[1] = (localPointF1.y - this.canvasCenter.y);
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      d1 = localPointF1.x;
      d2 = 1.0D / this.mScreenScale;
      Double.isNaN(d1);
      localPointF1.x = ((float)(d1 * d2));
      d1 = localPointF1.y;
      d2 = 1.0D / this.mScreenScale;
      Double.isNaN(d1);
      localPointF1.y = ((float)(d1 * d2));
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      d1 = paramList.x;
      d2 = 1.0D / this.mScreenScale;
      Double.isNaN(d1);
      paramList.x = ((float)(d1 * d2));
      d1 = paramList.y;
      d2 = 1.0D / this.mScreenScale;
      Double.isNaN(d1);
      paramList.y = ((float)(d1 * d2));
      d1 = Math.sqrt(Math.pow(localPointF1.x - paramList.x, 2.0D) + Math.pow(localPointF1.y - paramList.y, 2.0D));
      d2 = this.item.scaleFactor;
      Double.isNaN(d2);
      d1 /= d2;
      this.renderParam.texScale = ((float)d1);
      if (this.item.support3D == 1)
      {
        this.renderParam.texRotate[0] = paramArrayOfFloat[0];
        this.renderParam.texRotate[1] = paramArrayOfFloat[1];
        this.renderParam.texRotate[2] = (-paramArrayOfFloat[2]);
        return;
      }
      this.renderParam.texRotate[0] = 0.0F;
      this.renderParam.texRotate[1] = 0.0F;
      this.renderParam.texRotate[2] = (-paramArrayOfFloat[2]);
      return;
    }
    clearTextureParam();
  }
  
  protected void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (isValidItem(this.item)))
    {
      Object localObject1;
      int i;
      Object localObject2;
      if (paramInt == 4)
      {
        paramInt = 0;
        int j;
        int k;
        while (paramInt < 3)
        {
          localObject1 = this.item.anchorPoint;
          i = paramInt * 2;
          j = localObject1[i];
          localObject1 = this.item.anchorPoint;
          k = i + 1;
          int m = localObject1[k];
          this.texCords[i] = (j / this.item.width);
          this.texCords[k] = (m / this.item.height);
          paramInt += 1;
        }
        paramInt = 3;
        while (paramInt < 6)
        {
          if (paramInt == 3) {
            i = 0;
          } else {
            i = paramInt - 2;
          }
          localObject1 = this.item.anchorPoint;
          j = i * 2;
          i = localObject1[j];
          j = this.item.anchorPoint[(j + 1)];
          localObject1 = this.texCords;
          k = paramInt * 2;
          localObject1[k] = (i / this.item.width);
          this.texCords[(k + 1)] = (j / this.item.height);
          paramInt += 1;
        }
        paramInt = 0;
        while (paramInt < 3)
        {
          localObject1 = (PointF)paramList.get(this.item.alignFacePoints[paramInt]);
          localObject2 = this.position;
          i = paramInt * 2;
          localObject2[i] = (((PointF)localObject1).x / this.width * 2.0F - 1.0F);
          this.position[(i + 1)] = (((PointF)localObject1).y / this.height * 2.0F - 1.0F);
          paramInt += 1;
        }
        paramInt = 3;
        while (paramInt < 6)
        {
          if (paramInt == 3) {
            i = 0;
          } else {
            i = paramInt - 2;
          }
          localObject1 = (PointF)paramList.get(this.item.alignFacePoints[i]);
          localObject2 = this.position;
          i = paramInt * 2;
          localObject2[i] = (((PointF)localObject1).x / this.width * 2.0F - 1.0F);
          this.position[(i + 1)] = (((PointF)localObject1).y / this.height * 2.0F - 1.0F);
          paramInt += 1;
        }
      }
      if (paramInt == 2)
      {
        localObject1 = new PointF(this.item.anchorPoint[0], this.item.anchorPoint[1]);
        localObject2 = new PointF(this.item.anchorPoint[2], this.item.anchorPoint[3]);
        PointF localPointF = (PointF)paramList.get(this.item.alignFacePoints[0]);
        Object localObject3 = (PointF)paramList.get(this.item.alignFacePoints[1]);
        paramList = new PointF(localPointF.x, localPointF.y);
        localPointF = new PointF(((PointF)localObject3).x, ((PointF)localObject3).y);
        float f2 = AlgoUtils.getDistance(paramList, localPointF) / AlgoUtils.getDistance((PointF)localObject1, (PointF)localObject2);
        localObject3 = this.position;
        localObject3[0] = 0.0F;
        localObject3[1] = 0.0F;
        localObject3[2] = 0.0F;
        localObject3[3] = (this.item.height * f2);
        this.position[4] = (this.item.width * f2);
        this.position[5] = (this.item.height * f2);
        localObject3 = this.position;
        localObject3[6] = 0.0F;
        localObject3[7] = 0.0F;
        localObject3[8] = (this.item.width * f2);
        this.position[9] = (this.item.height * f2);
        this.position[10] = (this.item.width * f2);
        this.position[11] = 0.0F;
        paramInt = 0;
        while (paramInt < 11)
        {
          localObject3 = this.texCords;
          if (this.position[paramInt] > 0.0F) {
            f1 = 1.0F;
          } else {
            f1 = 0.0F;
          }
          localObject3[paramInt] = f1;
          paramInt += 1;
        }
        paramInt = 0;
        while (paramInt < 6)
        {
          localObject3 = this.position;
          i = paramInt * 2 + 1;
          localObject3[i] = (this.item.height * f2 - this.position[i]);
          paramInt += 1;
        }
        float f1 = (float)Math.atan2(((PointF)localObject2).y - ((PointF)localObject1).y, ((PointF)localObject2).x - ((PointF)localObject1).x);
        float f3 = (float)Math.atan2(localPointF.y - paramList.y, localPointF.x - paramList.x);
        localObject2 = new Matrix();
        ((Matrix)localObject2).postTranslate(-((PointF)localObject1).x * f2, -((PointF)localObject1).y * f2);
        double d = (f3 - f1) * 180.0F;
        Double.isNaN(d);
        ((Matrix)localObject2).postRotate((float)(d / 3.141592653589793D));
        ((Matrix)localObject2).postTranslate(paramList.x, paramList.y);
        ((Matrix)localObject2).mapPoints(this.position);
        paramInt = 0;
        while (paramInt < 6)
        {
          paramList = this.position;
          i = paramInt * 2;
          paramList[i] = (paramList[i] / this.width * 2.0F - 1.0F);
          paramList = this.position;
          i += 1;
          paramList[i] = (paramList[i] / this.height * 2.0F - 1.0F);
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
      return;
    }
    clearTextureParam();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.model.FastDynamicSticker
 * JD-Core Version:    0.7.0.1
 */