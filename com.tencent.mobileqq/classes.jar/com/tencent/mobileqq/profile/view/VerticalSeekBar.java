package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class VerticalSeekBar
  extends View
{
  Paint a;
  Bitmap b;
  int c;
  Rect d;
  int e;
  int f;
  float g;
  boolean h;
  int i = 100;
  int j = 0;
  SeekBar.OnSeekBarChangeListener k;
  long l;
  
  public VerticalSeekBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VerticalSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public VerticalSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  void a()
  {
    Resources localResources = super.getResources();
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setColor(-1);
    this.a.setStrokeWidth(2.0F);
    this.a.setStyle(Paint.Style.STROKE);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = localResources.getDisplayMetrics().densityDpi;
    try
    {
      this.b = BitmapFactory.decodeResource(localResources, 2130849306, localOptions);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label90:
      break label90;
    }
    QLog.e("VerticalSeekBar", 1, "thumb picture decode failed");
    this.d = new Rect();
    this.e = DisplayUtil.a(getContext(), 5.0F);
    this.f = DisplayUtil.a(getContext(), 30.0F);
  }
  
  public int getProgress()
  {
    return this.j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int n = getMeasuredWidth();
    int m = getMeasuredHeight();
    if (this.c <= 0) {
      this.c = ((int)((m - this.b.getHeight()) / this.i * this.j));
    }
    float f4 = n / 2;
    int i2 = this.c;
    int i3 = this.b.getHeight();
    int i1 = this.e;
    float f2 = i2 + i3 + i1;
    i2 = this.c;
    float f1;
    if (i2 < i1) {
      f1 = 0.0F;
    } else {
      f1 = i2 - i1;
    }
    paramCanvas.drawLine(f4, 0.0F, f4, f1, this.a);
    n = (n - this.b.getWidth()) / 2;
    this.d.set(n, this.c, this.b.getWidth() + n, this.c + this.b.getHeight());
    paramCanvas.drawBitmap(this.b, null, this.d, this.a);
    float f3 = m;
    if (f2 > f3) {
      f1 = f3;
    } else {
      f1 = f2;
    }
    paramCanvas.drawLine(f4, f1, f4, f3, this.a);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getMeasuredWidth();
    int m = getMeasuredHeight();
    paramInt1 = paramInt2;
    if (paramInt2 < this.b.getWidth()) {
      paramInt1 = this.b.getWidth();
    }
    paramInt2 = m;
    if (m < this.b.getHeight()) {
      paramInt2 = this.b.getHeight();
    }
    int n = this.f;
    m = paramInt1;
    if (paramInt1 < n) {
      m = n;
    }
    setMeasuredDimension(m, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int m = paramMotionEvent.getAction();
    float f1;
    if (m != 0)
    {
      float f2;
      SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener;
      if (m != 1)
      {
        if (m != 2) {
          return true;
        }
        if (this.h)
        {
          f1 = paramMotionEvent.getY() - this.g;
          f2 = getMeasuredHeight() - this.b.getHeight();
          m = this.c;
          if ((m + f1 <= f2) && (m + f1 >= 0.0F))
          {
            this.c = ((int)(m + f1));
            localOnSeekBarChangeListener = this.k;
            if (localOnSeekBarChangeListener != null)
            {
              this.j = ((int)(this.c / f2 * this.i));
              localOnSeekBarChangeListener.onProgressChanged(null, this.j, false);
            }
          }
          this.g = paramMotionEvent.getY();
          invalidate();
          return true;
        }
      }
      else
      {
        if (this.h)
        {
          localOnSeekBarChangeListener = this.k;
          if (localOnSeekBarChangeListener != null) {
            localOnSeekBarChangeListener.onStopTrackingTouch(null);
          }
        }
        this.h = false;
        if (System.currentTimeMillis() - this.l < 100L)
        {
          float f3 = getMeasuredHeight() - this.b.getHeight();
          f2 = paramMotionEvent.getY() - this.b.getHeight() / 2;
          f1 = f2;
          if (f2 > f3) {
            f1 = f3;
          }
          f2 = f1;
          if (f1 < 0.0F) {
            f2 = 0.0F;
          }
          this.c = ((int)f2);
          paramMotionEvent = this.k;
          if (paramMotionEvent != null)
          {
            this.j = ((int)(this.c / f3 * this.i));
            paramMotionEvent.onProgressChanged(null, this.j, false);
          }
          invalidate();
          return true;
        }
      }
    }
    else
    {
      this.g = paramMotionEvent.getY();
      f1 = this.g;
      m = this.c;
      if ((f1 > m - this.e) && (f1 < m + this.b.getHeight() + this.e))
      {
        this.h = true;
        paramMotionEvent = this.k;
        if (paramMotionEvent != null) {
          paramMotionEvent.onStartTrackingTouch(null);
        }
      }
      this.l = System.currentTimeMillis();
    }
    return true;
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.k = paramOnSeekBarChangeListener;
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.i))
    {
      this.j = paramInt;
      if (getMeasuredHeight() >= 0) {
        this.c = ((int)((getMeasuredHeight() - this.b.getHeight()) / this.i * this.j));
      }
      SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.k;
      if (localOnSeekBarChangeListener != null) {
        localOnSeekBarChangeListener.onProgressChanged(null, paramInt, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VerticalSeekBar
 * JD-Core Version:    0.7.0.1
 */