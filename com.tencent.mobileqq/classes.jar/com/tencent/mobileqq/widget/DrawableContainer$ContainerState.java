package com.tencent.mobileqq.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class DrawableContainer$ContainerState
  extends Drawable.ConstantState
{
  public Drawable a;
  public int b;
  private boolean c;
  private boolean d;
  
  public boolean a()
  {
    if (!this.c)
    {
      boolean bool;
      if (this.a.getConstantState() != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.d = bool;
      this.c = true;
    }
    return this.d;
  }
  
  public int getChangingConfigurations()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawableContainer.ContainerState
 * JD-Core Version:    0.7.0.1
 */