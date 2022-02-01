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
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
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
    if (!this.jdField_a_of_type_Boolean) {
      super.onDraw(paramCanvas);
    }
    for (;;)
    {
      return;
      switch (this.d)
      {
      }
      while (!this.jdField_c_of_type_Boolean)
      {
        invalidate();
        return;
        super.onDraw(paramCanvas);
        continue;
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        this.d = 1;
        this.jdField_b_of_type_Boolean = false;
        super.onDraw(paramCanvas);
        continue;
        float f1;
        if (this.jdField_a_of_type_Long >= 0L)
        {
          f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Int;
          if (f1 < 1.0F) {
            break label210;
          }
          if (this.jdField_b_of_type_Boolean) {
            break label202;
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        }
        for (;;)
        {
          if (this.jdField_c_of_type_Boolean) {
            this.d = 4;
          }
          paramCanvas.save();
          paramCanvas.translate(0.0F, this.jdField_b_of_type_Int);
          super.onDraw(paramCanvas);
          paramCanvas.restore();
          if (!this.jdField_c_of_type_Boolean) {
            break;
          }
          invalidate();
          break;
          label202:
          this.jdField_c_of_type_Boolean = true;
          continue;
          label210:
          f1 = Math.min(f1, 1.0F);
          float f2;
          if (!this.jdField_b_of_type_Boolean)
          {
            f2 = this.jdField_c_of_type_Int;
            this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator.getInterpolation(f1) * f2));
          }
          else
          {
            int i = this.jdField_c_of_type_Int;
            f2 = this.jdField_c_of_type_Int;
            this.jdField_b_of_type_Int = (i - (int)(this.jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator.getInterpolation(f1) * f2));
          }
        }
        paramCanvas.save();
        paramCanvas.translate(0.0F, 0.0F);
        super.onDraw(paramCanvas);
        paramCanvas.restore();
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardScrollImageView
 * JD-Core Version:    0.7.0.1
 */