package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;

public class ImageAlphaSwitchView
  extends View
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  public Bitmap a;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Transformation a;
  ValueAnimation<Float> jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = null;
  int b;
  public Bitmap b;
  int c = 3;
  
  public ImageAlphaSwitchView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public ImageAlphaSwitchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  private void a()
  {
    ValueAnimation localValueAnimation1 = new ValueAnimation(Float.valueOf(0.0F), Float.valueOf(255.0F), new ImageAlphaSwitchView.1(this));
    ValueAnimation localValueAnimation2 = this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation;
    if (localValueAnimation2 != null) {
      localValueAnimation2.cancel();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = localValueAnimation1;
    localValueAnimation1.setDuration(500L);
    localValueAnimation1.start();
    invalidate();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_Float = 0.0F;
      invalidate();
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_Int = getWidth();
    this.jdField_b_of_type_Int = getHeight();
    Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    boolean bool = false;
    int k;
    int n;
    int j;
    int m;
    int i;
    if (localBitmap != null)
    {
      k = localBitmap.getWidth();
      n = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
      j = this.jdField_b_of_type_Int;
      m = j * k / n;
      i = this.jdField_a_of_type_Int;
      if (m > i)
      {
        k = n * i / k;
        n = (j - k) / 2;
        m = i;
        j = k;
        k = n;
      }
      else
      {
        k = 0;
      }
      i = this.c;
      if (i == 3) {}
      do
      {
        i = 0;
        break;
        if (i == 17)
        {
          i = (this.jdField_a_of_type_Int - m) / 2;
          break;
        }
      } while (i != 5);
      i = this.jdField_a_of_type_Int - m;
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsRect.set(i, k, m + i, j);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      k = localBitmap.getWidth();
      n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      j = this.jdField_b_of_type_Int;
      m = j * k / n;
      i = this.jdField_a_of_type_Int;
      if (m > i)
      {
        k = n * i / k;
        n = (j - k) / 2;
        m = i;
        j = k;
        k = n;
      }
      else
      {
        k = 0;
      }
      i = this.c;
      if (i == 3) {}
      do
      {
        i = 0;
        break;
        if (i == 17)
        {
          i = (this.jdField_a_of_type_Int - m) / 2;
          break;
        }
      } while (i != 5);
      i = this.jdField_a_of_type_Int - m;
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255 - (int)this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsRect.set(i, k, m + i, j);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    paramCanvas = this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation;
    if (paramCanvas != null) {
      bool = paramCanvas.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation);
    }
    if (bool) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setGravity(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    ValueAnimation localValueAnimation = this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation;
    if (localValueAnimation != null) {
      localValueAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Float = 0.0F;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageAlphaSwitchView
 * JD-Core Version:    0.7.0.1
 */