package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.DisplayUtils;

public class BezierSideBarView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  protected Paint a;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  protected Drawable a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private int c;
  private int d;
  
  public BezierSideBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BezierSideBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BezierSideBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_b_of_type_Float = ((int)DisplayUtils.a(paramContext, 18.0F));
    this.jdField_a_of_type_Int = -16777216;
    this.d = ((int)DisplayUtils.a(paramContext, 18.0F));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    paramAttributeSet = BitmapFactory.decodeResource(paramContext.getResources(), 2130843404);
    if (paramAttributeSet != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramAttributeSet, (int)DisplayUtils.a(paramContext, 7.0F), (int)DisplayUtils.a(paramContext, 12.0F), true);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_b_of_type_Int, a());
    int i = this.c;
    int j = this.d;
    i -= j * 2;
    double d1 = this.jdField_b_of_type_Int;
    double d2 = j;
    double d3 = Math.cos(0.7853981633974483D);
    Double.isNaN(d2);
    double d4 = this.jdField_a_of_type_Float;
    Double.isNaN(d4);
    Double.isNaN(d1);
    j = (int)(d1 - d2 * d3 * d4);
    d1 = i;
    d2 = this.d;
    d3 = Math.sin(0.7853981633974483D);
    Double.isNaN(d2);
    Double.isNaN(d1);
    int k = (int)(d1 + d2 * d3);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    float f1 = this.jdField_b_of_type_Int;
    float f2 = i;
    float f3 = j;
    ((Path)localObject).quadTo(f1, f2, f3, k);
    d1 = this.jdField_b_of_type_Int;
    d2 = a();
    Double.isNaN(d1);
    i = (int)(d1 - d2);
    j = this.c;
    int m = this.d;
    k = m * 2 + j;
    d1 = k;
    d2 = m;
    d3 = Math.cos(0.7853981633974483D);
    Double.isNaN(d2);
    Double.isNaN(d1);
    m = (int)(d1 - d2 * d3);
    this.jdField_a_of_type_AndroidGraphicsPath.quadTo(i, j, f3, m);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    m = this.jdField_b_of_type_Int;
    ((Path)localObject).quadTo(m, k, m, b());
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      k = ((Bitmap)localObject).getWidth();
      m = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      int n = i + 50;
      int i1 = j - m / 2;
      localObject = new Rect(0, 0, k, m);
      Rect localRect = new Rect(n, i1, k + n, m + i1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_a_of_type_Float * 255.0F));
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject, localRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      ((Drawable)localObject).getIntrinsicWidth();
      k = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
      paramCanvas.save();
      paramCanvas.translate(i + 50, j - k);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public double a()
  {
    double d1 = this.d * 1.8F;
    double d2 = Math.sin(1.570796326794897D);
    Double.isNaN(d1);
    double d3 = this.jdField_a_of_type_Float;
    Double.isNaN(d3);
    return d1 * d2 * d3;
  }
  
  protected int a()
  {
    return this.c - this.d * 3;
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(float paramFloat, int paramInt)
  {
    this.c = paramInt;
    if (paramFloat < 0.0F) {
      return;
    }
    float f2 = this.jdField_b_of_type_Float;
    float f1 = paramFloat;
    if (paramFloat > f2) {
      f1 = f2;
    }
    this.jdField_a_of_type_Float = (f1 / this.jdField_b_of_type_Float);
    invalidate();
  }
  
  public void a(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setFloatValues(new float[] { this.jdField_a_of_type_Float, 0.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new BezierSideBarView.1(this, paramAnimatorUpdateListener));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  protected int b()
  {
    int i = this.c;
    int j = this.d;
    return i + j * 2 + j;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_b_of_type_Int = getMeasuredWidth();
    this.c = (getMeasuredHeight() / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView
 * JD-Core Version:    0.7.0.1
 */