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
  private float a = getResources().getDisplayMetrics().density;
  private int b = -1;
  private int c;
  private int d;
  private int e = -16776961;
  private int f = -16776961;
  private int g = -7829368;
  private int h;
  private int i = -7829368;
  private int j = -3355444;
  private int k;
  private int l = 3;
  private Paint m;
  private float n = 0.0F;
  private int o = 0;
  private boolean p = false;
  private int q;
  private int r;
  private Bitmap s;
  private Bitmap t;
  private boolean u = false;
  
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
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.A);
      this.e = paramContext.getColor(R.styleable.L, -16776961);
      this.b = paramContext.getColor(R.styleable.I, -1);
      this.i = paramContext.getColor(R.styleable.B, -7829368);
      this.f = paramContext.getColor(R.styleable.M, -16776961);
      this.g = paramContext.getColor(R.styleable.J, -7829368);
      this.j = paramContext.getColor(R.styleable.C, -3355444);
      this.h = paramContext.getInteger(R.styleable.K, 255);
      this.d = paramContext.getInteger(R.styleable.H, 51);
      this.l = paramContext.getDimensionPixelOffset(R.styleable.N, 3);
      this.n = paramContext.getInteger(R.styleable.D, 50);
      this.o = paramContext.getInteger(R.styleable.E, 0);
      this.s = a(paramContext.getDrawable(R.styleable.F));
      this.t = a(paramContext.getDrawable(R.styleable.G));
      paramContext.recycle();
    }
    else
    {
      this.s = BitmapFactory.decodeResource(paramContext.getResources(), 2130845648);
      this.t = BitmapFactory.decodeResource(paramContext.getResources(), 2130845649);
    }
    this.p = true;
    this.q = this.e;
    this.r = this.i;
    this.m = new Paint();
    this.m.setAntiAlias(true);
    this.m.setStyle(Paint.Style.STROKE);
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
    this.p = paramBoolean;
    invalidate();
  }
  
  public float getProgress()
  {
    return this.n;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.m.setColor(this.r);
    this.m.setAntiAlias(true);
    this.m.setAlpha(255);
    this.m.setStyle(Paint.Style.FILL);
    int i1 = this.k;
    paramCanvas.drawCircle(i1 / 2, i1 / 2, i1 / 2 - this.l, this.m);
    i1 = this.o;
    if (i1 != 0) {
      if (i1 != 1)
      {
        if ((i1 == 2) || (i1 == 3))
        {
          localBitmap = this.s;
          break label131;
        }
      }
      else
      {
        localBitmap = this.t;
        break label131;
      }
    }
    Bitmap localBitmap = null;
    label131:
    float f1;
    Object localObject;
    if (this.p)
    {
      this.m.setColor(this.b);
      this.m.setShadowLayer(9.0F, 0.0F, 0.0F, this.c);
      this.m.setStyle(Paint.Style.STROKE);
      this.m.setStrokeWidth(this.l);
      i1 = this.l;
      f1 = i1 / 2;
      float f2 = i1 / 2;
      int i2 = this.k;
      paramCanvas.drawArc(new RectF(f1, f2, i2 - i1 / 2, i2 - i1 / 2), -90.0F, 360.0F, false, this.m);
      this.m.setColor(this.q);
      this.m.setShadowLayer(9.0F, 0.0F, 0.0F, this.c);
      this.m.setStyle(Paint.Style.STROKE);
      this.m.setStrokeWidth(this.l);
      i1 = this.l;
      f1 = i1 / 2;
      f2 = i1 / 2;
      i2 = this.k;
      localObject = new RectF(f1, f2, i2 - i1 / 2, i2 - i1 / 2);
      double d1 = this.n;
      Double.isNaN(d1);
      paramCanvas.drawArc((RectF)localObject, -90.0F, (float)(d1 * 3.6D), false, this.m);
    }
    if (localBitmap != null)
    {
      this.m.setAntiAlias(true);
      f1 = (this.k - this.l * 2.0F) / localBitmap.getWidth();
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f1, f1);
      i1 = this.l;
      ((Matrix)localObject).postTranslate(i1, i1);
      if (this.o == 2)
      {
        i1 = this.k;
        ((Matrix)localObject).postRotate(180.0F, i1 / 2, i1 / 2);
      }
      paramCanvas.drawBitmap(localBitmap, (Matrix)localObject, this.m);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.k = Math.min(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt1));
    paramInt1 = this.k;
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 0) && (i1 != 2))
    {
      this.q = this.e;
      if (this.o != 1) {
        this.q = this.g;
      }
      this.r = this.i;
      invalidate();
    }
    else
    {
      this.q = this.f;
      this.r = this.j;
      invalidate();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackGroundColor(int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
    this.d = paramInt1;
  }
  
  public void setCenterBgColor(int paramInt)
  {
    this.i = paramInt;
    this.r = this.i;
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
    this.n = f1;
    if (paramInt < 0) {
      f1 = 0.0F;
    } else {
      f1 = paramInt;
    }
    this.n = f1;
    invalidate();
  }
  
  public void setProgressColor(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.h = paramInt2;
    invalidate();
  }
  
  public void setProgressRingWidth(float paramFloat)
  {
    double d1 = paramFloat * this.a;
    Double.isNaN(d1);
    this.l = ((int)(d1 + 0.5D));
    this.m.setStrokeWidth(this.l);
    invalidate();
  }
  
  public void setState(int paramInt)
  {
    this.o = paramInt;
    this.q = this.e;
    if (this.o != 1) {
      this.q = this.g;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleFileStateView
 * JD-Core Version:    0.7.0.1
 */