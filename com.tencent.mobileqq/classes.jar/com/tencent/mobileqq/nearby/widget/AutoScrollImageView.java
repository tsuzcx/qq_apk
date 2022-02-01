package com.tencent.mobileqq.nearby.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class AutoScrollImageView
  extends ImageView
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int c = 14000;
  
  public AutoScrollImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoScrollImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoScrollImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error=");
      localStringBuilder.append(paramBitmap.toString());
      QLog.i("AutoScrollImageView", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  @TargetApi(21)
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() - getMeasuredHeight() });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.c);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(2);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AutoScrollImageView.1(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      b(paramCanvas);
      return;
    }
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    float f1 = i;
    float f2 = j;
    RectF localRectF = new RectF(0.0F, 0.0F, f1, f2);
    if (Build.VERSION.SDK_INT >= 21) {
      i = paramCanvas.saveLayer(localRectF, null);
    } else {
      i = paramCanvas.saveLayer(localRectF, null, 31);
    }
    localRectF = new RectF(0.0F, 0.0F, f1, f2);
    j = this.jdField_a_of_type_Int;
    paramCanvas.drawRoundRect(localRectF, j, j, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    b(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    paramCanvas.restoreToCount(i);
  }
  
  private void b(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject == null) {
      return;
    }
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    localRect.left = 0;
    localRect.right = ((Bitmap)localObject).getWidth();
    localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    ((Rect)localObject).top = this.jdField_b_of_type_Int;
    ((Rect)localObject).bottom = (((Rect)localObject).top + getMeasuredHeight());
    localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    ((Rect)localObject).left = 0;
    ((Rect)localObject).right = getMeasuredWidth();
    localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    ((Rect)localObject).top = 0;
    ((Rect)localObject).bottom = getMeasuredHeight();
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      super.onDraw(paramCanvas);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      a(paramCanvas);
      return;
    }
    Object localObject = getDrawable();
    if ((localObject != null) && ((localObject instanceof BitmapDrawable)))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.jdField_a_of_type_AndroidGraphicsBitmap = a((Bitmap)localObject, getMeasuredWidth(), getMeasuredWidth() * ((Bitmap)localObject).getHeight() / ((Bitmap)localObject).getWidth());
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        a(paramCanvas);
        return;
      }
      super.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setAutoScroll(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt >= 0) {
      this.c = paramInt;
    }
  }
  
  public void setRadius(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AutoScrollImageView
 * JD-Core Version:    0.7.0.1
 */