package com.tencent.theme;

import android.graphics.Paint;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class BaseConstantState
  extends Drawable.ConstantState
{
  public static final int BITMAP = 0;
  static final int INDEX_DENSITY = 2;
  static final int INDEX_HEIGHT = 1;
  static final int INDEX_WIDTH = 0;
  public static final int SCALE_BITMAP = 1;
  static final Paint sColorPaint;
  static final Paint sPaint = new Paint();
  int bitmapType = 0;
  boolean hasProblem;
  int[] mImageSizeWhenOOM;
  public SkinData skinData;
  
  static
  {
    sColorPaint = new Paint();
    sPaint.setColor(-65536);
    sPaint.setStrokeWidth(4.0F);
    sColorPaint.setColor(1358888960);
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      i = paramInt1;
      if (paramInt3 != 0)
      {
        if (paramInt2 == paramInt3) {
          return paramInt1;
        }
        i = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.theme.BaseConstantState
 * JD-Core Version:    0.7.0.1
 */