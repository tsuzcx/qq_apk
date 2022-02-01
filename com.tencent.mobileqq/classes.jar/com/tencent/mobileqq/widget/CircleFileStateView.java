package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.R.styleable;

public class CircleFileStateView
  extends View
{
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int c;
  private int d = -16776961;
  private int e = -16776961;
  private int f = -7829368;
  private int g;
  private int h = -7829368;
  private int i = -3355444;
  private int j;
  private int k = 3;
  private int l;
  private int m;
  private int n;
  
  public CircleFileStateView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircleFileStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleFileStateView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleFileState);
      this.d = paramContext.getColor(10, -16776961);
      this.jdField_a_of_type_Int = paramContext.getColor(7, -1);
      this.h = paramContext.getColor(0, -7829368);
      this.e = paramContext.getColor(11, -16776961);
      this.f = paramContext.getColor(8, -7829368);
      this.i = paramContext.getColor(1, -3355444);
      this.g = paramContext.getInteger(9, 255);
      this.c = paramContext.getInteger(6, 51);
      this.k = paramContext.getDimensionPixelOffset(12, 3);
      this.jdField_b_of_type_Float = paramContext.getInteger(2, 50);
      this.l = paramContext.getInteger(3, 0);
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramContext.getDrawable(4));
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(paramContext.getDrawable(5));
      paramContext.recycle();
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      this.m = this.d;
      this.n = this.h;
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      setClickable(true);
      return;
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130844236);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130844237);
    }
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i1, i2, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i1, i2);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.n);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.j / 2, this.j / 2, this.j / 2 - this.k, this.jdField_a_of_type_AndroidGraphicsPaint);
    Bitmap localBitmap;
    switch (this.l)
    {
    default: 
      localBitmap = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.k);
        paramCanvas.drawArc(new RectF(this.k / 2, this.k / 2, this.j - this.k / 2, this.j - this.k / 2), -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.m);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.k);
        paramCanvas.drawArc(new RectF(this.k / 2, this.k / 2, this.j - this.k / 2, this.j - this.k / 2), -90.0F, (float)(3.6D * this.jdField_b_of_type_Float), false, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (localBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        float f1 = (this.j - this.k * 2.0F) / localBitmap.getWidth();
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(f1, f1);
        localMatrix.postTranslate(this.k, this.k);
        if (this.l == 2) {
          localMatrix.postRotate(180.0F, this.j / 2, this.j / 2);
        }
        paramCanvas.drawBitmap(localBitmap, localMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
      localBitmap = null;
      continue;
      localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      continue;
      localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.j = Math.min(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt1));
    setMeasuredDimension(this.j, this.j);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      this.m = this.d;
      if (this.l != 1) {
        this.m = this.f;
      }
      this.n = this.h;
      invalidate();
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.m = this.e;
      this.n = this.i;
      invalidate();
    }
  }
  
  public void setBackGroundColor(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.c = paramInt1;
  }
  
  public void setCenterBgColor(int paramInt)
  {
    this.h = paramInt;
    this.n = this.h;
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt > 100)
    {
      f1 = 100.0F;
      this.jdField_b_of_type_Float = f1;
      if (paramInt >= 0) {
        break label37;
      }
    }
    label37:
    for (float f1 = 0.0F;; f1 = paramInt)
    {
      this.jdField_b_of_type_Float = f1;
      invalidate();
      return;
      f1 = paramInt;
      break;
    }
  }
  
  public void setProgressColor(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.g = paramInt2;
    invalidate();
  }
  
  public void setProgressRingWidth(float paramFloat)
  {
    this.k = ((int)(this.jdField_a_of_type_Float * paramFloat + 0.5D));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.k);
    invalidate();
  }
  
  public void setState(int paramInt)
  {
    this.l = paramInt;
    this.m = this.d;
    if (this.l != 1) {
      this.m = this.f;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleFileStateView
 * JD-Core Version:    0.7.0.1
 */