package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class DrawableContainer
  extends Drawable
  implements Drawable.Callback
{
  private DrawableContainer.ContainerState a;
  private boolean b;
  
  public Drawable a()
  {
    return this.a.a;
  }
  
  protected void a(DrawableContainer.ContainerState paramContainerState)
  {
    this.a = paramContainerState;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.a.a.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.a.b | this.a.a.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.a.a())
    {
      this.a.b = getChangingConfigurations();
      return this.a;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return this.a.a.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.a.a.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return this.a.a.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.a.a.getPadding(paramRect);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return this.a.a.isStateful();
  }
  
  public Drawable mutate()
  {
    if ((!this.b) && (super.mutate() == this))
    {
      this.a.a.mutate();
      this.b = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.a.a.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.a.a.setLevel(paramInt);
    invalidateSelf();
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = this.a.a.setState(paramArrayOfInt);
    onBoundsChange(getBounds());
    return bool;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.a.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawableContainer
 * JD-Core Version:    0.7.0.1
 */