package com.tencent.mobileqq.gesturelock;

import java.lang.reflect.Array;

public class LockPatternView$Cell
{
  static Cell[][] c = (Cell[][])Array.newInstance(Cell.class, new int[] { 3, 3 });
  int a;
  int b;
  
  static
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        c[i][j] = new Cell(i, j);
        j += 1;
      }
      i += 1;
    }
  }
  
  private LockPatternView$Cell(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static Cell a(int paramInt1, int paramInt2)
  {
    try
    {
      b(paramInt1, paramInt2);
      Cell localCell = c[paramInt1][paramInt2];
      return localCell;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= 2))
    {
      if ((paramInt2 >= 0) && (paramInt2 <= 2)) {
        return;
      }
      throw new IllegalArgumentException("column must be in range 0-2");
    }
    throw new IllegalArgumentException("row must be in range 0-2");
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(row=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",clmn=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.LockPatternView.Cell
 * JD-Core Version:    0.7.0.1
 */