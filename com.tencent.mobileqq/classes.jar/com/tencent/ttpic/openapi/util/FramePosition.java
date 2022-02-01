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
    return paramFloat2 + (paramFloat3 - paramFloat2) * paramFloat1;
  }
  
  private int[] updateArr(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = paramArrayOfInt1;
    if (paramArrayOfInt2 != null)
    {
      arrayOfInt = paramArrayOfInt1;
      if (paramArrayOfInt2.length > 0) {
        arrayOfInt = paramArrayOfInt2;
      }
    }
    return arrayOfInt;
  }
  
  private int updateInter(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      paramInt1 = paramInt2;
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
    Object localObject = paramFramePosition.position;
    if ((localObject != null) && (localObject.length > 0))
    {
      this.position = new double[localObject.length];
      localObject = paramFramePosition.position;
      System.arraycopy(localObject, 0, this.position, 0, localObject.length);
    }
    localObject = paramFramePosition.alignFacePoints;
    if ((localObject != null) && (localObject.length > 0))
    {
      this.alignFacePoints = new int[localObject.length];
      localObject = paramFramePosition.alignFacePoints;
      System.arraycopy(localObject, 0, this.alignFacePoints, 0, localObject.length);
      localObject = paramFramePosition.anchorPoint;
      if ((localObject != null) && (localObject.length > 0))
      {
        this.anchorPoint = new int[localObject.length];
        localObject = paramFramePosition.anchorPoint;
        System.arraycopy(localObject, 0, this.anchorPoint, 0, localObject.length);
      }
    }
    paramFramePosition = paramFramePosition.scalePivots;
    if ((paramFramePosition != null) && (paramFramePosition.length > 0)) {
      System.arraycopy(paramFramePosition, 0, this.scalePivots, 0, paramFramePosition.length);
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
    float f2 = this.scale;
    float f1 = f2;
    if (f2 + 1.0F > 99999.0F) {
      f1 = paramStickerItem.scale;
    }
    paramStickerItem.scale = f1;
    f2 = this.angle;
    f1 = f2;
    if (1.0F + f2 > 99999.0F) {
      f1 = paramStickerItem.angle;
    }
    paramStickerItem.angle = f1;
    int j = this.dx;
    int i = j;
    if (j + 1 > 99999) {
      i = paramStickerItem.dx;
    }
    paramStickerItem.dx = i;
    j = this.dy;
    i = j;
    if (j + 1 > 99999) {
      i = paramStickerItem.dy;
    }
    paramStickerItem.dy = i;
    paramStickerItem.scaleFactor = updateInter(paramStickerItem.scaleFactor, this.scaleFactor);
    double[] arrayOfDouble = this.position;
    if ((arrayOfDouble != null) && (arrayOfDouble.length > 0)) {
      paramStickerItem.position = arrayOfDouble;
    }
    paramStickerItem.anchorPoint = updateArr(paramStickerItem.anchorPoint, this.anchorPoint);
    paramStickerItem.alignFacePoints = updateArr(paramStickerItem.alignFacePoints, this.alignFacePoints);
    paramStickerItem.scalePivots = updateArr(paramStickerItem.scalePivots, this.scalePivots);
  }
  
  public void updateValue(FramePosition paramFramePosition1, FramePosition paramFramePosition2)
  {
    int j = paramFramePosition2.index;
    int i = paramFramePosition1.index;
    j -= i;
    if (j == 0) {
      return;
    }
    float f = (this.index - i) * 1.0F / j;
    this.width = insertData(f, paramFramePosition1.width, paramFramePosition2.width);
    this.height = insertData(f, paramFramePosition1.height, paramFramePosition2.height);
    this.maxScaledWidth = insertData(f, paramFramePosition1.maxScaledWidth, paramFramePosition2.maxScaledWidth);
    this.minScaledWidth = insertData(f, paramFramePosition1.minScaledWidth, paramFramePosition2.minScaledWidth);
    this.scale = insertData(f, paramFramePosition1.scale, paramFramePosition2.scale);
    this.angle = insertData(f, paramFramePosition1.angle, paramFramePosition2.angle);
    this.dx = insertData(f, paramFramePosition1.dx, paramFramePosition2.dx);
    this.dy = insertData(f, paramFramePosition1.dy, paramFramePosition2.dy);
    this.scaleFactor = insertData(f, paramFramePosition1.scaleFactor, paramFramePosition2.scaleFactor);
    double[] arrayOfDouble1 = paramFramePosition1.position;
    if ((arrayOfDouble1 != null) && (arrayOfDouble1.length > 0))
    {
      double[] arrayOfDouble2 = paramFramePosition2.position;
      if ((arrayOfDouble2 != null) && (arrayOfDouble2.length > 0) && (arrayOfDouble1.length == arrayOfDouble2.length))
      {
        this.position = new double[arrayOfDouble2.length];
        i = 0;
        for (;;)
        {
          arrayOfDouble1 = paramFramePosition2.position;
          if (i >= arrayOfDouble1.length) {
            break;
          }
          arrayOfDouble2 = this.position;
          double[] arrayOfDouble3 = paramFramePosition1.position;
          double d1 = arrayOfDouble3[i];
          double d2 = arrayOfDouble1[i];
          double d3 = arrayOfDouble3[i];
          double d4 = f;
          Double.isNaN(d4);
          arrayOfDouble2[i] = (d1 + (d2 - d3) * d4);
          i += 1;
        }
      }
    }
    paramFramePosition2 = paramFramePosition1.alignFacePoints;
    if ((paramFramePosition2 != null) && (paramFramePosition2.length > 0))
    {
      this.alignFacePoints = new int[paramFramePosition2.length];
      paramFramePosition2 = paramFramePosition1.alignFacePoints;
      System.arraycopy(paramFramePosition2, 0, this.alignFacePoints, 0, paramFramePosition2.length);
      paramFramePosition2 = paramFramePosition1.anchorPoint;
      if ((paramFramePosition2 != null) && (paramFramePosition2.length > 0))
      {
        this.anchorPoint = new int[paramFramePosition2.length];
        paramFramePosition2 = paramFramePosition1.anchorPoint;
        System.arraycopy(paramFramePosition2, 0, this.anchorPoint, 0, paramFramePosition2.length);
      }
    }
    paramFramePosition1 = paramFramePosition1.scalePivots;
    if ((paramFramePosition1 != null) && (paramFramePosition1.length > 0)) {
      System.arraycopy(paramFramePosition1, 0, this.scalePivots, 0, paramFramePosition1.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.FramePosition
 * JD-Core Version:    0.7.0.1
 */