package com.tencent.theme;

import android.graphics.Paint;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class a
  extends Drawable.ConstantState
{
  static final Paint a = new Paint();
  static final Paint b = new Paint();
  public static final int c = 0;
  public static final int d = 1;
  static final int f = 0;
  static final int g = 1;
  static final int h = 2;
  int e = 0;
  j i;
  boolean j;
  int[] k;
  
  static
  {
    a.setColor(-65536);
    a.setStrokeWidth(4.0F);
    b.setColor(1358888960);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt3 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.a
 * JD-Core Version:    0.7.0.1
 */