package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class CircleProgressView
  extends View
{
  private Paint a;
  private int b;
  private int c;
  private RectF d;
  private int e;
  private int f = 10;
  private int g = 0;
  private boolean h = true;
  private boolean i = true;
  private int j = 40;
  private int k = 3;
  private Paint l;
  private boolean m = false;
  private int n = 4;
  private Handler o = new Handler();
  
  public CircleProgressView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private int a(int paramInt)
  {
    return (int)(paramInt / 100.0F * 360.0F);
  }
  
  private void e()
  {
    this.f = ((int)(getResources().getDisplayMetrics().density * 3.0F + 0.5F));
    this.n = ((int)(getResources().getDisplayMetrics().density * 2.0F + 0.5F));
    this.a = new Paint();
    this.a.setColor(-15550475);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.f);
    this.a.setFlags(1);
    this.d = new RectF();
    this.l = new Paint();
    this.l.setColor(-1);
    this.l.setStyle(Paint.Style.STROKE);
    this.l.setStrokeWidth(this.f);
    this.l.setFlags(1);
    setBackgroundColor(0);
  }
  
  public boolean a()
  {
    return getVisibility() == 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showLoading() mIndeterminate = ");
      localStringBuilder.append(this.i);
      localStringBuilder.append(",mAnimationRuning = ");
      localStringBuilder.append(this.m);
      QLog.e("CircleProgressView", 2, localStringBuilder.toString());
    }
    if ((this.i) && (!this.m))
    {
      setVisibility(0);
      this.o.removeCallbacksAndMessages(null);
      this.m = true;
      this.g = 0;
      this.e = 0;
      this.o.post(new CircleProgressView.Animator(this, null));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("CircleProgressView", 2, "showLoading()  just return");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismissLoading() mIndeterminate = ");
      localStringBuilder.append(this.i);
      QLog.e("CircleProgressView", 2, localStringBuilder.toString());
    }
    if (!this.i)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CircleProgressView", 2, "dismissLoading() mIndeterminate = false, just return");
      }
      return;
    }
    setVisibility(4);
    this.o.removeCallbacksAndMessages(null);
    this.m = false;
    this.g = 0;
    this.e = 0;
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hide() mIndeterminate = ");
      localStringBuilder.append(this.i);
      QLog.e("CircleProgressView", 2, localStringBuilder.toString());
    }
    setVisibility(4);
    if (this.i)
    {
      c();
      return;
    }
    this.e = 0;
    this.g = 0;
    this.m = false;
  }
  
  public int getProgress()
  {
    return this.e;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (!this.i)
    {
      paramCanvas.save();
      if (this.h)
      {
        paramCanvas.rotate(-36.0F, this.b / 2, this.c / 2);
        paramCanvas.drawArc(this.d, 0.0F, this.g, false, this.a);
      }
      else
      {
        paramCanvas.rotate(222.0F, this.b / 2, this.c / 2);
        paramCanvas.drawArc(this.d, 0.0F, this.g, false, this.a);
      }
      paramCanvas.restore();
      return;
    }
    paramCanvas.save();
    paramCanvas.rotate(this.g, this.b / 2, this.c / 2);
    paramCanvas.drawArc(this.d, 0.0F, this.j, false, this.l);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = paramInt1;
    this.c = paramInt2;
    this.f -= this.n;
    RectF localRectF = this.d;
    paramInt1 = this.f;
    localRectF.set(paramInt1, paramInt1, this.b - paramInt1, this.c - paramInt1);
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    if (this.i != paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setIndeterminate() change mIndeterminate = ");
        localStringBuilder.append(this.i);
        QLog.e("CircleProgressView", 2, localStringBuilder.toString());
      }
      this.i = paramBoolean;
    }
  }
  
  public void setIndeterminate(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.i != paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setIndeterminate() change mIndeterminate = ");
        localStringBuilder.append(this.i);
        QLog.e("CircleProgressView", 2, localStringBuilder.toString());
      }
      this.i = paramBoolean;
    }
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setProgress() progress = ");
      localStringBuilder.append(paramInt);
      QLog.e("CircleProgressView", 2, localStringBuilder.toString());
    }
    if (paramInt >= 0)
    {
      if (paramInt > 100) {
        return;
      }
      if (this.i)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CircleProgressView", 2, "setProgress() mIndeterminate = true, just return");
        }
        return;
      }
      if (!a()) {
        setVisibility(0);
      }
      if (this.m) {
        this.o.removeCallbacksAndMessages(null);
      }
      int i1 = paramInt;
      if (paramInt <= 2) {
        i1 = 2;
      }
      this.e = i1;
      this.g = a(this.e);
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */