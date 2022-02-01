package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.model.StickerItem;

public class FramePosition
{
  private static final int BIG_NUM = 99999;
  public int[] alignFacePoints;
  public int[] anchorPoint;
  public float angle = 99999.0F;
  public int dx = 99999;
  public int dy = 99999;
  public int height = -1;
  public int index = -1;
  public int maxScaledWidth = -1;
  public int minScaledWidth = -1;
  public double[] position;
  public float scale = 99999.0F;
  public int scaleFactor = -1;
  public int[] scalePivots;
  public int width = -1;
  
  private float insertData(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat2) * paramFloat1 + paramFloat2;
  }
  
  private int[] updateArr(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt2 != null) && (paramArrayOfInt2.length > 0)) {
      return paramArrayOfInt2;
    }
    return paramArrayOfInt1;
  }
  
  private int updateInter(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public void copy(FramePosition paramFramePosition)
  {
    this.width = paramFramePosition.width;
    this.height = paramFramePosition.height;
    this.maxScaledWidth = paramFramePosition.maxScaledWidth;
    this.minScaledWidth = paramFramePosition.minScaledWidth;
    this.scale = paramFramePosition.scale;
    this.angle = paramFramePosition.angle;
    this.dx = paramFramePosition.dx;
    this.dy = paramFramePosition.dy;
    this.scaleFactor = paramFramePosition.scaleFactor;
    if ((paramFramePosition.position != null) && (paramFramePosition.position.length > 0))
    {
      this.position = new double[paramFramePosition.position.length];
      System.arraycopy(paramFramePosition.position, 0, this.position, 0, paramFramePosition.position.length);
    }
    if ((paramFramePosition.alignFacePoints != null) && (paramFramePosition.alignFacePoints.length > 0))
    {
      this.alignFacePoints = new int[paramFramePosition.alignFacePoints.length];
      System.arraycopy(paramFramePosition.alignFacePoints, 0, this.alignFacePoints, 0, paramFramePosition.alignFacePoints.length);
      if ((paramFramePosition.anchorPoint != null) && (paramFramePosition.anchorPoint.length > 0))
      {
        this.anchorPoint = new int[paramFramePosition.anchorPoint.length];
        System.arraycopy(paramFramePosition.anchorPoint, 0, this.anchorPoint, 0, paramFramePosition.anchorPoint.length);
      }
    }
    if ((paramFramePosition.scalePivots != null) && (paramFramePosition.scalePivots.length > 0)) {
      System.arraycopy(paramFramePosition.scalePivots, 0, this.scalePivots, 0, paramFramePosition.scalePivots.length);
    }
  }
  
  public int insertData(float paramFloat, int paramInt1, int paramInt2)
  {
    return (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
  }
  
  public void updateFramePosition(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {
      return;
    }
    paramStickerItem.width = updateInter(paramStickerItem.width, this.width);
    paramStickerItem.height = updateInter(paramStickerItem.height, this.height);
    paramStickerItem.maxScaledWidth = updateInter(paramStickerItem.maxScaledWidth, this.maxScaledWidth);
    paramStickerItem.minScaledWidth = updateInter(paramStickerItem.minScaledWidth, this.minScaledWidth);
    float f;
    if (this.scale + 1.0F > 99999.0F)
    {
      f = paramStickerItem.scale;
      paramStickerItem.scale = f;
      if (this.angle + 1.0F <= 99999.0F) {
        break label251;
      }
      f = paramStickerItem.angle;
      label108:
      paramStickerItem.angle = f;
      if (this.dx + 1 <= 99999) {
        break label259;
      }
      i = paramStickerItem.dx;
      label129:
      paramStickerItem.dx = i;
      if (this.dy + 1 <= 99999) {
        break label267;
      }
    }
    label259:
    label267:
    for (int i = paramStickerItem.dy;; i = this.dy)
    {
      paramStickerItem.dy = i;
      paramStickerItem.scaleFactor = updateInter(paramStickerItem.scaleFactor, this.scaleFactor);
      if ((this.position != null) && (this.position.length > 0)) {
        paramStickerItem.position = this.position;
      }
      paramStickerItem.anchorPoint = updateArr(paramStickerItem.anchorPoint, this.anchorPoint);
      paramStickerItem.alignFacePoints = updateArr(paramStickerItem.alignFacePoints, this.alignFacePoints);
      paramStickerItem.scalePivots = updateArr(paramStickerItem.scalePivots, this.scalePivots);
      return;
      f = this.scale;
      break;
      label251:
      f = this.angle;
      break label108;
      i = this.dx;
      break label129;
    }
  }
  
  public void updateValue(FramePosition paramFramePosition1, FramePosition paramFramePosition2)
  {
    int i = paramFramePosition2.index - paramFramePosition1.index;
    if (i == 0) {}
    do
    {
      return;
      float f = (this.index - paramFramePosition1.index) * 1.0F / i;
      this.width = insertData(f, paramFramePosition1.width, paramFramePosition2.width);
      this.height = insertData(f, paramFramePosition1.height, paramFramePosition2.height);
      this.maxScaledWidth = insertData(f, paramFramePosition1.maxScaledWidth, paramFramePosition2.maxScaledWidth);
      this.minScaledWidth = insertData(f, paramFramePosition1.minScaledWidth, paramFramePosition2.minScaledWidth);
      this.scale = insertData(f, paramFramePosition1.scale, paramFramePosition2.scale);
      this.angle = insertData(f, paramFramePosition1.angle, paramFramePosition2.angle);
      this.dx = insertData(f, paramFramePosition1.dx, paramFramePosition2.dx);
      this.dy = insertData(f, paramFramePosition1.dy, paramFramePosition2.dy);
      this.scaleFactor = insertData(f, paramFramePosition1.scaleFactor, paramFramePosition2.scaleFactor);
      if ((paramFramePosition1.position != null) && (paramFramePosition1.position.length > 0) && (paramFramePosition2.position != null) && (paramFramePosition2.position.length > 0) && (paramFramePosition1.position.length == paramFramePosition2.position.length))
      {
        this.position = new double[paramFramePosition2.position.length];
        i = 0;
        while (i < paramFramePosition2.position.length)
        {
          paramFramePosition1.position[i] += (paramFramePosition2.position[i] - paramFramePosition1.position[i]) * f;
          i += 1;
        }
      }
      if ((paramFramePosition1.alignFacePoints != null) && (paramFramePosition1.alignFacePoints.length > 0))
      {
        this.alignFacePoints = new int[paramFramePosition1.alignFacePoints.length];
        System.arraycopy(paramFramePosition1.alignFacePoints, 0, this.alignFacePoints, 0, paramFramePosition1.alignFacePoints.length);
        if ((paramFramePosition1.anchorPoint != null) && (paramFramePosition1.anchorPoint.length > 0))
        {
          this.anchorPoint = new int[paramFramePosition1.anchorPoint.length];
          System.arraycopy(paramFramePosition1.anchorPoint, 0, this.anchorPoint, 0, paramFramePosition1.anchorPoint.length);
        }
      }
    } while ((paramFramePosition1.scalePivots == null) || (paramFramePosition1.scalePivots.length <= 0));
    System.arraycopy(paramFramePosition1.scalePivots, 0, this.scalePivots, 0, paramFramePosition1.scalePivots.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.FramePosition
 * JD-Core Version:    0.7.0.1
 */