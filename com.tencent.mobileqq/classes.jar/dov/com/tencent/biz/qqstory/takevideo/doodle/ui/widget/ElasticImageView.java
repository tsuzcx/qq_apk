package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import bmol;
import bmtb;
import wsv;

@TargetApi(14)
public class ElasticImageView
  extends ImageView
{
  public float a;
  public int a;
  public final long a;
  public ValueAnimator a;
  private Matrix a;
  public boolean a;
  public float b;
  public int b;
  public ValueAnimator b;
  private Matrix b;
  public boolean b;
  public float c;
  public int c;
  public boolean c;
  public float d;
  public int d;
  public float e;
  public int e;
  public float f;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public ElasticImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_a_of_type_Long = 100L;
    this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
    this.jdField_e_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = 1.0F;
    this.jdField_c_of_type_Boolean = true;
    a();
  }
  
  public ElasticImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_a_of_type_Long = 100L;
    this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
    this.jdField_e_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = 1.0F;
    this.jdField_c_of_type_Boolean = true;
    a();
  }
  
  private ValueAnimator a(float paramFloat1, float paramFloat2, long paramLong)
  {
    return bmol.a(paramLong, paramFloat1, paramFloat2, new bmtb(this));
  }
  
  private void a()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix(getImageMatrix());
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  private void b()
  {
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = a(this.jdField_d_of_type_Float, this.jdField_c_of_type_Float, 100L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void b(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    wsv.b("ElasticImageView", "updateMatrix:" + paramFloat);
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.g, this.h);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramFloat, paramFloat, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    super.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = a(this.jdField_d_of_type_Float, this.jdField_a_of_type_Float, 100L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void d()
  {
    float f1 = 1.0F;
    if (getDrawable() != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (bool) {
        break;
      }
      return;
    }
    int j = getDrawable().getIntrinsicWidth();
    int k = getDrawable().getIntrinsicHeight();
    int m;
    int n;
    float f2;
    if (this.jdField_b_of_type_Boolean) {
      if (j < k)
      {
        this.jdField_f_of_type_Float = (j / k);
        this.jdField_e_of_type_Float = 1.0F;
        k = j;
        if ((k <= this.jdField_c_of_type_Int) && (j <= this.jdField_d_of_type_Int)) {
          break label388;
        }
        m = k - this.jdField_c_of_type_Int;
        n = j - this.jdField_d_of_type_Int;
        if ((m <= 0) || (n <= 0)) {
          break label352;
        }
        f1 = this.jdField_c_of_type_Int / k;
        f2 = this.jdField_d_of_type_Int / j;
        if (f1 >= f2) {
          break label347;
        }
      }
    }
    label388:
    for (;;)
    {
      wsv.b("ElasticImageView", "drawableWidth:" + k + ",drawableHeight:" + j + ",AvaliableWidth:" + this.jdField_c_of_type_Int + ",AvaliableHeight:" + this.jdField_d_of_type_Int + ",scaleValue:" + f1);
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * 0.9F);
      this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float * 0.5F);
      this.g = ((int)(this.jdField_e_of_type_Int - k / this.jdField_e_of_type_Float / 2.0F));
      this.h = ((int)(this.jdField_f_of_type_Int - j / this.jdField_f_of_type_Float / 2.0F));
      return;
      if (j > k)
      {
        this.jdField_e_of_type_Float = (k / j);
        this.jdField_f_of_type_Float = 1.0F;
        j = k;
        break;
      }
      this.jdField_e_of_type_Float = 1.0F;
      this.jdField_f_of_type_Float = 1.0F;
      m = j;
      j = k;
      k = m;
      break;
      label347:
      f1 = f2;
      continue;
      label352:
      if (m > 0)
      {
        f1 = this.jdField_c_of_type_Int / k;
      }
      else if (n > 0)
      {
        f1 = this.jdField_d_of_type_Int / j;
        continue;
        f2 = this.jdField_c_of_type_Int / k;
        float f3 = this.jdField_d_of_type_Int / j;
        f1 = f2;
        if (f2 >= f3) {
          f1 = f3;
        }
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_d_of_type_Float != paramFloat)
    {
      this.jdField_d_of_type_Float = paramFloat;
      b(this.jdField_d_of_type_Float);
      super.invalidate();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 2);
    this.jdField_f_of_type_Int = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 2);
    this.i = (this.jdField_f_of_type_Int * 2);
    this.jdField_c_of_type_Int = (this.jdField_e_of_type_Int * 2);
    this.jdField_d_of_type_Int = (this.jdField_f_of_type_Int * 2);
    wsv.b("ElasticImageView", "ImageViewWidth:" + this.jdField_a_of_type_Int + ",ImageViewHeight:" + this.jdField_b_of_type_Int + ",centerX:" + this.jdField_e_of_type_Int + ",centerY:" + this.jdField_f_of_type_Int + ",AvaliableWidth:" + this.jdField_c_of_type_Int + ",AvaliableHeight:" + this.jdField_d_of_type_Int);
    d();
    this.jdField_d_of_type_Float = this.jdField_a_of_type_Float;
    b(this.jdField_d_of_type_Float);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1;
    float f2;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      super.onTouchEvent(paramMotionEvent);
      return true;
      d();
      this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
      b();
      continue;
      if ((f1 < 0.0F) || (f1 > getWidth()) || (f2 < 0.0F) || (f2 > getHeight()))
      {
        c();
      }
      else
      {
        b();
        continue;
        c();
      }
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    d();
    this.jdField_d_of_type_Float = this.jdField_a_of_type_Float;
    b(this.jdField_d_of_type_Float);
  }
  
  public void setIsNeedAdjustDrawableToSquare(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView
 * JD-Core Version:    0.7.0.1
 */