package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.Nullable;

public abstract interface DrawingContent
  extends Content
{
  public abstract void addColorFilter(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter);
  
  public abstract void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  public abstract void getBounds(RectF paramRectF, Matrix paramMatrix);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.DrawingContent
 * JD-Core Version:    0.7.0.1
 */