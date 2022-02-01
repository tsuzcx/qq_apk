package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;

public class ImageShakeAnimView
  extends View
{
  float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = 0;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Transformation a;
  ValueAnimation<Float> jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = null;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 1.0F;
  int jdField_b_of_type_Int = 0;
  int c = 0;
  int d = 0;
  
  public ImageShakeAnimView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    a(null);
  }
  
  public ImageShakeAnimView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Integer paramInteger, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    a(paramInteger);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public ImageShakeAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    a(null);
  }
  
  private void a(Integer paramInteger)
  {
    for (;;)
    {
      try
      {
        if (paramInteger.intValue() == 2130845405)
        {
          paramInteger = "hb_luckybag_name_path";
          this.jdField_a_of_type_AndroidGraphicsBitmap = PortalManager.a(paramInteger, true);
          return;
        }
      }
      catch (OutOfMemoryError paramInteger)
      {
        paramInteger.printStackTrace();
        return;
      }
      paramInteger = "hb_luckybag_ing_name_path";
    }
  }
  
  public void a()
  {
    float f;
    if (this.jdField_a_of_type_Boolean) {
      f = 720.0F;
    } else {
      f = 500.0F;
    }
    ValueAnimation localValueAnimation1 = new ValueAnimation(Float.valueOf(0.0F), Float.valueOf(f), new ImageShakeAnimView.1(this));
    ValueAnimation localValueAnimation2 = this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation;
    if (localValueAnimation2 != null) {
      localValueAnimation2.cancel();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = localValueAnimation1;
    long l;
    if (this.jdField_a_of_type_Boolean) {
      l = 720L;
    } else {
      l = 500L;
    }
    localValueAnimation1.setDuration(l);
    localValueAnimation1.start();
    invalidate();
  }
  
  public boolean a(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = getWidth();
      this.jdField_b_of_type_Int = getHeight();
    }
    paramCanvas.save();
    paramCanvas.translate(this.c, this.d);
    paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Int / 2, 0.0F);
    localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    int i = this.jdField_a_of_type_Int;
    ((Rect)localObject).set(0, 0, i, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * i / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
    paramCanvas.restore();
    paramCanvas = this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation;
    if (paramCanvas != null) {
      bool = paramCanvas.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation);
    }
    return bool;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (a(paramCanvas)) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = getWidth();
      this.jdField_b_of_type_Int = getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageShakeAnimView
 * JD-Core Version:    0.7.0.1
 */