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
import avoy;
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
      QLog.i("AutoScrollImageView", 1, "error=" + paramBitmap.toString());
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
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new avoy(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      b(paramCanvas);
      return;
    }
    int j = getMeasuredWidth();
    int k = getMeasuredHeight();
    RectF localRectF = new RectF(0.0F, 0.0F, j, k);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (int i = paramCanvas.saveLayer(localRectF, null);; i = paramCanvas.saveLayer(localRectF, null, 31))
    {
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, j, k), this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      b(paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.restoreToCount(i);
      return;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.right = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    this.jdField_a_of_type_AndroidGraphicsRect.top = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_AndroidGraphicsRect.top + getMeasuredHeight());
    this.jdField_b_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_b_of_type_AndroidGraphicsRect.right = getMeasuredWidth();
    this.jdField_b_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = getMeasuredHeight();
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AutoScrollImageView
 * JD-Core Version:    0.7.0.1
 */