package com.tencent.mobileqq.nearby;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class MyDrawable
  extends Drawable
{
  public Drawable a;
  
  @TargetApi(11)
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.setCallback(getCallback());
      this.a.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.MyDrawable
 * JD-Core Version:    0.7.0.1
 */