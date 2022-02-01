package com.tencent.viola.ui.view.vloading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class VARotateDrawable
  extends Drawable
  implements Animatable
{
  private Drawable _mDrawable;
  public long frameDuration = 70L;
  public float frameRotateDeg = 30.0F;
  private float mCurrentDeg;
  private final Runnable mNextFrame = new VARotateDrawable.1(this);
  private boolean mRunning;
  
  public VARotateDrawable(Drawable paramDrawable)
  {
    this._mDrawable = paramDrawable;
  }
  
  private void nextFrame()
  {
    unscheduleSelf(this.mNextFrame);
    scheduleSelf(this.mNextFrame, SystemClock.uptimeMillis() + this.frameDuration);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this._mDrawable;
    Rect localRect = localDrawable.getBounds();
    int i = localRect.right;
    int j = localRect.left;
    int k = localRect.bottom;
    int m = localRect.top;
    float f1 = i - j;
    float f2 = k - m;
    i = paramCanvas.save();
    paramCanvas.rotate(this.mCurrentDeg, f1 * 0.5F + localRect.left, localRect.top + f2 * 0.5F);
    localDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.mRunning;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this._mDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(@NonNull Rect paramRect)
  {
    super.setBounds(paramRect);
    this._mDrawable.setBounds(paramRect);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if ((bool) || (paramBoolean2)) {
        nextFrame();
      }
      return bool;
    }
    unscheduleSelf(this.mNextFrame);
    return bool;
  }
  
  public void start()
  {
    if (!this.mRunning)
    {
      this.mRunning = true;
      nextFrame();
    }
  }
  
  public void stop()
  {
    this.mRunning = false;
    unscheduleSelf(this.mNextFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.vloading.VARotateDrawable
 * JD-Core Version:    0.7.0.1
 */