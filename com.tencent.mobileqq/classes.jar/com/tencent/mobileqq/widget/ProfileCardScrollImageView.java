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
  private int jdField_a_of_type_Int = 1500;
  private long jdField_a_of_type_Long;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = 3;
  
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
    if (this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator == null) {
      this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(1.0F);
    }
  }
  
  public void a()
  {
    this.d = 3;
    invalidate();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.d = 0;
    this.jdField_c_of_type_Boolean = false;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      super.onDraw(paramCanvas);
      return;
    }
    int i = this.d;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          if (i == 4)
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
        if (this.jdField_a_of_type_Long >= 0L)
        {
          float f = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Int;
          if (f >= 1.0F)
          {
            if (!this.jdField_b_of_type_Boolean)
            {
              this.jdField_b_of_type_Boolean = true;
              this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
            }
            else
            {
              this.jdField_c_of_type_Boolean = true;
            }
          }
          else
          {
            f = Math.min(f, 1.0F);
            if (!this.jdField_b_of_type_Boolean)
            {
              this.jdField_b_of_type_Int = ((int)(this.jdField_c_of_type_Int * this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator.getInterpolation(f)));
            }
            else
            {
              i = this.jdField_c_of_type_Int;
              this.jdField_b_of_type_Int = (i - (int)(i * this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator.getInterpolation(f)));
            }
          }
          if (this.jdField_c_of_type_Boolean) {
            this.d = 4;
          }
        }
        paramCanvas.save();
        paramCanvas.translate(0.0F, this.jdField_b_of_type_Int);
        super.onDraw(paramCanvas);
        paramCanvas.restore();
        if (this.jdField_c_of_type_Boolean) {
          invalidate();
        }
      }
    }
    else
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.d = 1;
      this.jdField_b_of_type_Boolean = false;
      super.onDraw(paramCanvas);
    }
    if (!this.jdField_c_of_type_Boolean) {
      invalidate();
    }
  }
  
  public void setIsScroll(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setScrollDuration(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardScrollImageView
 * JD-Core Version:    0.7.0.1
 */