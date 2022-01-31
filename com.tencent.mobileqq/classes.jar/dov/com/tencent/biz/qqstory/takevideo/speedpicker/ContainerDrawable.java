package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import aodq;
import aodr;
import aods;
import com.tencent.qphone.base.util.QLog;

public class ContainerDrawable
  extends Drawable
  implements Animatable
{
  private int jdField_a_of_type_Int = 127;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  Property jdField_a_of_type_AndroidUtilProperty = new aodq(this, Integer.class, "backAlpha");
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  
  private int a()
  {
    return this.jdField_a_of_type_Int;
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
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_a_of_type_AndroidUtilProperty, new int[] { 0, 127 }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aodr(this));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new aods(this));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      return;
      if (paramInt1 == 2)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(this.jdField_a_of_type_AndroidUtilProperty, new int[] { 127, 0 }) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidUtilProperty = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Int == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_a_of_type_Int);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
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
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    }
  }
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("HintDrawable", 2, "start :" + this.jdField_b_of_type_Int);
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      j = this.jdField_b_of_type_Int;
      if (this.jdField_b_of_type_Boolean)
      {
        i = 150;
        a(j, i);
      }
    }
    while (this.jdField_b_of_type_Int != 2) {
      for (;;)
      {
        int j;
        return;
        int i = 300;
      }
    }
    a(this.jdField_b_of_type_Int, 200);
  }
  
  public void stop()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_b_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.ContainerDrawable
 * JD-Core Version:    0.7.0.1
 */