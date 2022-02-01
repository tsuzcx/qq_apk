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
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.filecommon.api.R.styleable;

public class CircleFileStateView
  extends View
{
  private float jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  private int d = -16776961;
  private int e = -16776961;
  private int f = -7829368;
  private int g;
  private int h = -7829368;
  private int i = -3355444;
  private int j;
  private int k = 3;
  private int l = 0;
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
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.B);
      this.d = paramContext.getColor(R.styleable.k, -16776961);
      this.jdField_a_of_type_Int = paramContext.getColor(R.styleable.h, -1);
      this.h = paramContext.getColor(R.styleable.jdField_a_of_type_Int, -7829368);
      this.e = paramContext.getColor(R.styleable.l, -16776961);
      this.f = paramContext.getColor(R.styleable.i, -7829368);
      this.i = paramContext.getColor(R.styleable.jdField_b_of_type_Int, -3355444);
      this.g = paramContext.getInteger(R.styleable.j, 255);
      this.c = paramContext.getInteger(R.styleable.g, 51);
      this.k = paramContext.getDimensionPixelOffset(R.styleable.m, 3);
      this.jdField_b_of_type_Float = paramContext.getInteger(R.styleable.c, 50);
      this.l = paramContext.getInteger(R.styleable.d, 0);
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramContext.getDrawable(R.styleable.e));
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(paramContext.getDrawable(R.styleable.f));
      paramContext.recycle();
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130844331);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130844332);
    }
    this.jdField_a_of_type_Boolean = true;
    this.m = this.d;
    this.n = this.h;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    setClickable(true);
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {
      localObject = Bitmap.Config.ARGB_8888;
    } else {
      localObject = Bitmap.Config.RGB_565;
    }
    Object localObject = Bitmap.createBitmap(i1, i2, (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, i1, i2);
    paramDrawable.draw(localCanvas);
    return localObject;
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
    int i1 = this.j;
    paramCanvas.drawCircle(i1 / 2, i1 / 2, i1 / 2 - this.k, this.jdField_a_of_type_AndroidGraphicsPaint);
    i1 = this.l;
    if (i1 != 0) {
      if (i1 != 1)
      {
        if ((i1 == 2) || (i1 == 3))
        {
          localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
          break label131;
        }
      }
      else
      {
        localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
        break label131;
      }
    }
    Bitmap localBitmap = null;
    label131:
    float f1;
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.k);
      i1 = this.k;
      f1 = i1 / 2;
      float f2 = i1 / 2;
      int i2 = this.j;
      paramCanvas.drawArc(new RectF(f1, f2, i2 - i1 / 2, i2 - i1 / 2), -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.m);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(9.0F, 0.0F, 0.0F, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.k);
      i1 = this.k;
      f1 = i1 / 2;
      f2 = i1 / 2;
      i2 = this.j;
      localObject = new RectF(f1, f2, i2 - i1 / 2, i2 - i1 / 2);
      double d1 = this.jdField_b_of_type_Float;
      Double.isNaN(d1);
      paramCanvas.drawArc((RectF)localObject, -90.0F, (float)(d1 * 3.6D), false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (localBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      f1 = (this.j - this.k * 2.0F) / localBitmap.getWidth();
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f1, f1);
      i1 = this.k;
      ((Matrix)localObject).postTranslate(i1, i1);
      if (this.l == 2)
      {
        i1 = this.j;
        ((Matrix)localObject).postRotate(180.0F, i1 / 2, i1 / 2);
      }
      paramCanvas.drawBitmap(localBitmap, (Matrix)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.j = Math.min(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt1));
    paramInt1 = this.j;
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 0) && (i1 != 2))
    {
      this.m = this.d;
      if (this.l != 1) {
        this.m = this.f;
      }
      this.n = this.h;
      invalidate();
    }
    else
    {
      this.m = this.e;
      this.n = this.i;
      invalidate();
    }
    return super.onTouchEvent(paramMotionEvent);
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
    float f1;
    if (paramInt > 100) {
      f1 = 100.0F;
    } else {
      f1 = paramInt;
    }
    this.jdField_b_of_type_Float = f1;
    if (paramInt < 0) {
      f1 = 0.0F;
    } else {
      f1 = paramInt;
    }
    this.jdField_b_of_type_Float = f1;
    invalidate();
  }
  
  public void setProgressColor(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.g = paramInt2;
    invalidate();
  }
  
  public void setProgressRingWidth(float paramFloat)
  {
    double d1 = paramFloat * this.jdField_a_of_type_Float;
    Double.isNaN(d1);
    this.k = ((int)(d1 + 0.5D));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleFileStateView
 * JD-Core Version:    0.7.0.1
 */