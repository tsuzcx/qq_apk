package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class ProfileCardScrollImageView
  extends ImageView
{
  private int a = 1500;
  private int b = 0;
  private int c = 0;
  private long d;
  private boolean e = false;
  private DecelerateInterpolator f;
  private int g = 3;
  private boolean h = false;
  private boolean i = false;
  
  public ProfileCardScrollImageView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ProfileCardScrollImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ProfileCardScrollImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    if (this.f == null) {
      this.f = new DecelerateInterpolator(1.0F);
    }
  }
  
  public void a()
  {
    this.g = 3;
    invalidate();
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    this.g = 0;
    this.i = false;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.e)
    {
      super.onDraw(paramCanvas);
      return;
    }
    int j = this.g;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 3)
        {
          if (j == 4)
          {
            paramCanvas.save();
            paramCanvas.translate(0.0F, 0.0F);
            super.onDraw(paramCanvas);
            paramCanvas.restore();
          }
        }
        else {
          super.onDraw(paramCanvas);
        }
      }
      else
      {
        if (this.d >= 0L)
        {
          float f1 = (float)(SystemClock.uptimeMillis() - this.d) / this.a;
          if (f1 >= 1.0F)
          {
            if (!this.h)
            {
              this.h = true;
              this.d = SystemClock.uptimeMillis();
            }
            else
            {
              this.i = true;
            }
          }
          else
          {
            f1 = Math.min(f1, 1.0F);
            if (!this.h)
            {
              this.b = ((int)(this.c * this.f.getInterpolation(f1)));
            }
            else
            {
              j = this.c;
              this.b = (j - (int)(j * this.f.getInterpolation(f1)));
            }
          }
          if (this.i) {
            this.g = 4;
          }
        }
        paramCanvas.save();
        paramCanvas.translate(0.0F, this.b);
        super.onDraw(paramCanvas);
        paramCanvas.restore();
        if (this.i) {
          invalidate();
        }
      }
    }
    else
    {
      this.b = 0;
      this.d = SystemClock.uptimeMillis();
      this.g = 1;
      this.h = false;
      super.onDraw(paramCanvas);
    }
    if (!this.i) {
      invalidate();
    }
  }
  
  public void setIsScroll(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setScrollDuration(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardScrollImageView
 * JD-Core Version:    0.7.0.1
 */