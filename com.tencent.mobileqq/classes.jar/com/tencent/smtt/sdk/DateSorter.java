package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter
{
  public static int DAY_COUNT = 5;
  private android.webkit.DateSorter mSystemDateSorter;
  private IX5DateSorter mX5DateSorter;
  
  static
  {
    if (isX5Core()) {}
  }
  
  public DateSorter(Context paramContext)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      this.mX5DateSorter = localX5CoreEngine.wizard().createDateSorter(paramContext);
      return;
    }
    this.mSystemDateSorter = new android.webkit.DateSorter(paramContext);
  }
  
  private static boolean isX5Core()
  {
    boolean bool2 = false;
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    boolean bool1 = bool2;
    if (localX5CoreEngine != null)
    {
      bool1 = bool2;
      if (localX5CoreEngine.isX5Core()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public long getBoundary(int paramInt)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return this.mX5DateSorter.getBoundary(paramInt);
    }
    return this.mSystemDateSorter.getBoundary(paramInt);
  }
  
  public int getIndex(long paramLong)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return this.mX5DateSorter.getIndex(paramLong);
    }
    return this.mSystemDateSorter.getIndex(paramLong);
  }
  
  public String getLabel(int paramInt)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return this.mX5DateSorter.getLabel(paramInt);
    }
    return this.mSystemDateSorter.getLabel(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.DateSorter
 * JD-Core Version:    0.7.0.1
 */