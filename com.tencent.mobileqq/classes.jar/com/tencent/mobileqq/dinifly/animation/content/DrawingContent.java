package com.tencent.mobileqq.dinifly.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

public abstract interface DrawingContent
  extends Content
{
  public abstract void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  public abstract void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.DrawingContent
 * JD-Core Version:    0.7.0.1
 */