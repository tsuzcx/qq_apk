package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Paint;

public abstract interface ISkinTint
{
  public abstract void clear();
  
  public abstract boolean isTint(String paramString);
  
  public abstract void loadConfig(Resources paramResources, String paramString);
  
  public abstract void tint(Paint paramPaint, String paramString);
  
  public abstract void tintColorState(int[] paramArrayOfInt, int[][] paramArrayOfInt1, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.ISkinTint
 * JD-Core Version:    0.7.0.1
 */