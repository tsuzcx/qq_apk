package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class AudioAnimationView
  extends View
{
  volatile boolean a = false;
  private int b;
  private int c;
  private int d;
  private Resources e;
  private Paint f;
  private int g = 7;
  private Rect[] h;
  private int[] i;
  private int j = 1;
  private Handler k = new Handler();
  private Drawable l;
  
  public AudioAnimationView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AudioAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static int a(int paramInt, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  void a()
  {
    this.e = getResources();
    this.b = a(2, getResources());
    this.c = a(2, getResources());
    this.d = a(12, getResources());
    this.f = new Paint();
    this.f.setColor(-1);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setStrokeWidth(4.0F);
    this.f.setAlpha(204);
  }
  
  void b()
  {
    int n = (int)(this.d * 0.6777F);
    int m = 0;
    while (m < this.g)
    {
      int[] arrayOfInt = this.i;
      double d1 = n;
      double d2 = Math.random();
      Double.isNaN(d1);
      arrayOfInt[m] = ((int)(d1 * d2));
      m += 1;
    }
  }
  
  public void c()
  {
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startAnimation(), mRunning= ");
      localStringBuilder.append(this.a);
      QLog.d("AudioAnimationView", 2, localStringBuilder.toString());
    }
    if (!this.a)
    {
      this.a = true;
      this.k.removeCallbacksAndMessages(null);
      this.k.post(new AudioAnimationView.Animator(this, null));
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopAnimation(), mRunning= ");
      localStringBuilder.append(this.a);
      QLog.d("AudioAnimationView", 2, localStringBuilder.toString());
    }
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (this.a)
    {
      this.a = false;
      this.k.removeCallbacksAndMessages(null);
      requestLayout();
      invalidate();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Handler localHandler = this.k;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a)
    {
      int i1;
      for (int m = 0; m < this.g; m = i1)
      {
        localObject = this.h[m];
        int i3 = this.b;
        int i4 = this.c;
        int[] arrayOfInt = this.i;
        int i5 = arrayOfInt[m];
        i1 = m + 1;
        int i2 = this.d;
        int n = i2;
        if (this.j == 1) {
          n = i2 - arrayOfInt[m];
        }
        ((Rect)localObject).set((i3 + i4) * m, i5, i3 * i1 + i4 * m, n);
        paramCanvas.drawRect((Rect)localObject, this.f);
      }
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((Drawable)localObject).draw(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    boolean bool = this.a;
    paramInt2 = 0;
    if (bool)
    {
      paramInt1 = this.g;
      paramInt2 = this.b * paramInt1 + (paramInt1 - 1) * this.c;
      paramInt1 = this.d;
    }
    else
    {
      Drawable localDrawable = this.l;
      if (localDrawable != null)
      {
        paramInt2 = localDrawable.getIntrinsicWidth();
        paramInt1 = this.l.getIntrinsicHeight();
      }
      else
      {
        paramInt1 = 0;
      }
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setColor(int paramInt)
  {
    Paint localPaint = this.f;
    if (localPaint != null) {
      localPaint.setColor(paramInt);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.l = paramDrawable;
    paramDrawable = this.l;
    if (paramDrawable != null) {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.l.getIntrinsicHeight());
    }
    requestLayout();
    invalidate();
  }
  
  public void setRectCount(int paramInt)
  {
    this.g = paramInt;
    paramInt = this.g;
    this.h = new Rect[paramInt];
    this.i = new int[paramInt];
    paramInt = 0;
    while (paramInt <= this.g - 1)
    {
      this.h[paramInt] = new Rect();
      this.i[paramInt] = 0;
      paramInt += 1;
    }
    b();
    requestLayout();
    invalidate();
  }
  
  public void setRectHeightMax(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setRectInterval(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setRectWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setSyle(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AudioAnimationView
 * JD-Core Version:    0.7.0.1
 */