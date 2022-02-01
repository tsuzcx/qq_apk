package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;

public class HintDrawable
  extends Drawable
  implements Animatable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 255;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Property<HintDrawable, Float> jdField_a_of_type_AndroidUtilProperty = new HintDrawable.1(this, Float.class, "backScale");
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  Property<HintDrawable, Integer> jdField_b_of_type_AndroidUtilProperty = new HintDrawable.2(this, Integer.class, "backAlpha");
  private boolean jdField_b_of_type_Boolean = false;
  private float c;
  private float d;
  
  private float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  private Drawable a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    for (;;)
    {
      return null;
      try
      {
        if ("1/4".equals(paramString)) {
          return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841677);
        }
        if ("1/2".equals(paramString)) {
          return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841676);
        }
        if ("1x".equals(paramString)) {
          return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841678);
        }
        if ("2x".equals(paramString)) {
          return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841679);
        }
        if ("4x".equals(paramString)) {
          return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841680);
        }
        if (PickerContainer.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841681);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        QLog.e("HintDrawable", 2, "getDrawableByText exception:" + paramString.toString());
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("HintDrawable", 2, "getDrawableByText OOM!!");
      }
    }
    return null;
  }
  
  private void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    int i = this.jdField_a_of_type_AndroidGraphicsRect.centerX();
    int j = this.jdField_a_of_type_AndroidGraphicsRect.centerY();
    int k = (int)(this.jdField_b_of_type_Float * (paramFloat - 1.0F)) / 2;
    int m = (int)(this.c * (paramFloat - 1.0F)) / 2;
    this.jdField_a_of_type_AndroidGraphicsRect.set((int)(i - k - this.jdField_b_of_type_Float / 2.0F), (int)(j - m - this.c / 2.0F), (int)(i + k + this.jdField_b_of_type_Float / 2.0F), (int)(j + m + this.c / 2.0F));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    if (paramInt1 == 1)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.jdField_a_of_type_AndroidUtilProperty, new float[] { this.d, 1.0F }), PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { 0, 255 }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new HintDrawable.3(this));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new HintDrawable.4(this));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      return;
      if (paramInt1 == 2)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { 255, 0 }) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
      }
    }
  }
  
  private int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidUtilProperty = null;
    this.jdField_b_of_type_AndroidUtilProperty = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramContext == null) {
      return false;
    }
    this.jdField_b_of_type_Float = paramFloat1;
    this.c = paramFloat2;
    this.d = paramFloat3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramString);
    invalidateSelf();
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("HintDrawable", 2, "start :" + this.jdField_b_of_type_Int);
    }
    a(this.jdField_b_of_type_Int, 150);
  }
  
  public void stop()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_AndroidAnimationValueAnimator == null);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.HintDrawable
 * JD-Core Version:    0.7.0.1
 */