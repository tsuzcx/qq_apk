package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.View;

public class QuickSendProgressView
  extends View
{
  private int a = 0;
  private int b = 0;
  private Drawable c;
  private Drawable d;
  private Drawable e;
  private int f;
  private int g;
  private int h;
  private int i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private RectF n;
  private Rect o;
  private Path p;
  private Paint q;
  private Paint r;
  private int s;
  private int t;
  private int u;
  private int v;
  private String w;
  private boolean x = false;
  private QuickSendProgressView.RefreshProgressRunnable y;
  
  public QuickSendProgressView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QuickSendProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QuickSendProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 + paramFloat1 * (paramFloat3 - paramFloat2);
  }
  
  private int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(float paramFloat)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if (i1 > 0)
    {
      if (i2 <= 0) {
        return;
      }
      i1 = Math.min(i1, i2);
      this.v = ((int)Math.ceil(a(paramFloat, -i1 / 2.0F, i1 / 2.0F)));
      invalidate();
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.w != null)
    {
      int i1 = getWidth();
      int i2 = getHeight();
      if (i1 > 0)
      {
        if (i2 <= 0) {
          return;
        }
        i1 = Math.min(i1, i2);
        paramCanvas.drawText(this.w, 0.0F, i1 / 2.0F, this.r);
      }
    }
  }
  
  private void a(Canvas paramCanvas, @ColorInt int paramInt)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if (i1 > 0)
    {
      if (i2 <= 0) {
        return;
      }
      i1 = Math.min(i1, i2);
      this.q.setColor(paramInt);
      RectF localRectF = this.n;
      paramInt = this.t;
      localRectF.set(paramInt, paramInt, i1 - paramInt, i1 - paramInt);
      paramCanvas.drawArc(this.n, -90.0F, this.b * 1.0F / 100.0F * 360.0F, false, this.q);
    }
  }
  
  private void a(Canvas paramCanvas, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int i1 = getWidth();
      int i2 = getHeight();
      if (i1 > 0)
      {
        if (i2 <= 0) {
          return;
        }
        this.m = paramDrawable;
        i1 = Math.min(i1, i2);
        paramCanvas.save();
        this.p.reset();
        Rect localRect = this.o;
        i2 = this.s;
        int i3 = this.t;
        localRect.set(0, 0, i1 - i2 * 2 - i3 * 2, i1 - i2 * 2 - i3 * 2);
        localRect = this.o;
        localRect.offset((i1 - localRect.width()) / 2, (i1 - this.o.height()) / 2);
        this.p.addCircle(this.o.centerX(), this.o.centerY(), this.o.width() * 1.0F / 2.0F, Path.Direction.CCW);
        paramCanvas.clipPath(this.p);
        if (this.a == 0)
        {
          localRect = this.o;
          i2 = this.t;
          i3 = this.u;
          localRect.set(0, 0, i1 - i2 * 2 - i3 * 2, i1 - i2 * 2 - i3 * 2);
        }
        else
        {
          localRect = this.o;
          i2 = this.s;
          i3 = this.t;
          int i4 = this.u;
          localRect.set(0, 0, i1 - i2 * 2 - i3 * 2 - i4 * 2, i1 - i2 * 2 - i3 * 2 - i4 * 2);
        }
        localRect = this.o;
        localRect.offset((i1 - localRect.width()) / 2, (i1 - this.o.height()) / 2);
        paramDrawable.setBounds(this.o);
        i1 = this.v;
        paramCanvas.translate(i1, -i1);
        paramDrawable.draw(paramCanvas);
        paramCanvas.restore();
      }
    }
  }
  
  private boolean a(Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.isStateful()) && (paramDrawable.setState(StateSet.NOTHING));
  }
  
  private void b()
  {
    b(this.c);
    b(this.d);
    b(this.e);
    b(this.m);
  }
  
  private void b(Canvas paramCanvas)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if (i1 > 0)
    {
      if (i2 <= 0) {
        return;
      }
      i1 = Math.min(i1, i2);
      if (this.a == 0)
      {
        localObject = this.o;
        i2 = this.t;
        ((Rect)localObject).set(0, 0, i1 - i2 * 2, i1 - i2 * 2);
      }
      else
      {
        localObject = this.o;
        i2 = this.s;
        int i3 = this.t;
        ((Rect)localObject).set(0, 0, i1 - i2 * 2 - i3 * 2, i1 - i2 * 2 - i3 * 2);
      }
      Object localObject = this.o;
      ((Rect)localObject).offset((i1 - ((Rect)localObject).width()) / 2, (i1 - this.o.height()) / 2);
      paramCanvas.save();
      localObject = null;
      i1 = this.a;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 == 2) {
            localObject = this.e;
          }
        }
        else {
          localObject = this.d;
        }
      }
      else {
        localObject = this.c;
      }
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(this.o);
        this.p.reset();
        this.p.addCircle(this.o.centerX(), this.o.centerY(), this.o.width() * 1.0F / 2.0F, Path.Direction.CCW);
        paramCanvas.clipPath(this.p);
        ((Drawable)localObject).draw(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  private void b(Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (paramDrawable.isStateful()) && (paramDrawable.setState(getDrawableState()))) {
      invalidateDrawable(paramDrawable);
    }
  }
  
  private void c()
  {
    a(this.c);
    a(this.d);
    a(this.e);
    a(this.m);
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = getWidth();
    int i2 = getHeight();
    if (i1 > 0)
    {
      if (i2 <= 0) {
        return;
      }
      int i3 = this.a;
      if ((i3 != 1) && (i3 != 2)) {
        return;
      }
      i3 = this.a;
      if (i3 != 1)
      {
        if (i3 == 2) {
          this.q.setColor(this.i);
        }
      }
      else {
        this.q.setColor(this.h);
      }
      i1 = Math.min(i1, i2);
      RectF localRectF = this.n;
      i2 = this.t;
      localRectF.set(i2, i2, i1 - i2, i1 - i2);
      paramCanvas.drawArc(this.n, 0.0F, 360.0F, false, this.q);
    }
  }
  
  public void a()
  {
    this.x = false;
    this.t = a(2.0F, getResources());
    this.s = a(3.0F, getResources());
    this.u = a(1.0F, getResources());
    this.w = getResources().getString(2131913952);
    this.c = getResources().getDrawable(2130847764);
    this.f = Color.parseColor("#19BAFF");
    this.d = getResources().getDrawable(2130847766);
    this.h = Color.parseColor("#3300CAFC");
    this.i = Color.parseColor("#33FF596A");
    this.e = getResources().getDrawable(2130847762);
    this.g = Color.parseColor("#FF596A");
    this.q = new Paint();
    this.q.setStrokeWidth(this.t);
    this.q.setStyle(Paint.Style.STROKE);
    this.q.setAntiAlias(true);
    this.q.setStrokeCap(Paint.Cap.ROUND);
    this.r = new Paint();
    this.r.setStyle(Paint.Style.FILL);
    this.r.setAntiAlias(true);
    this.r.setTextSize(a(14.0F, getResources()));
    this.r.setColor(getResources().getColor(2131165905));
    this.o = new Rect();
    this.n = new RectF();
    this.p = new Path();
    this.j = getResources().getDrawable(2130847765);
    this.k = getResources().getDrawable(2130847768);
    this.l = getResources().getDrawable(2130847763);
    setContentDescription(getResources().getString(2131913951));
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    b();
  }
  
  public int getCurrentStatus()
  {
    return this.a;
  }
  
  public int getProgress()
  {
    return this.b;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.m;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.d;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QuickSendProgressView.RefreshProgressRunnable localRefreshProgressRunnable = this.y;
    if (localRefreshProgressRunnable != null)
    {
      localRefreshProgressRunnable.b();
      this.y = null;
    }
    if (this.a == 1)
    {
      this.y = new QuickSendProgressView.RefreshProgressRunnable();
      this.y.a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QuickSendProgressView.RefreshProgressRunnable localRefreshProgressRunnable = this.y;
    if (localRefreshProgressRunnable != null)
    {
      localRefreshProgressRunnable.b();
      this.y = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.m = null;
    b(paramCanvas);
    c(paramCanvas);
    int i1 = this.a;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          a(paramCanvas, this.j);
          return;
        }
        a(paramCanvas);
        return;
      }
      a(paramCanvas, this.l);
      a(paramCanvas, this.g);
      return;
    }
    a(paramCanvas, this.k);
    a(paramCanvas, this.f);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = this.j;
    int i1 = 1;
    if (localObject == null)
    {
      i2 = 0;
      i1 = 0;
    }
    else
    {
      i4 = ((Drawable)localObject).getIntrinsicWidth();
      i3 = this.j.getIntrinsicHeight();
      i2 = i4;
      if (i4 <= 0) {
        i2 = 1;
      }
      if (i3 > 0) {
        i1 = i3;
      }
    }
    int i8 = getPaddingLeft();
    int i9 = getPaddingRight();
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    int i5 = this.s;
    int i6 = this.t;
    int i7 = this.u;
    int i2 = Math.max(i2 + (i8 + i9 + i5 * 2 + i6 * 2 + i7 * 2), getSuggestedMinimumWidth());
    i3 = Math.max(i1 + (i3 + i4 + i5 * 2 + i6 * 2 + i7 * 2), getSuggestedMinimumHeight());
    i1 = resolveSizeAndState(i2, paramInt1, 0);
    paramInt2 = resolveSizeAndState(i3, paramInt2, 0);
    paramInt1 = i1;
    if (this.x)
    {
      localObject = this.w;
      paramInt1 = i1;
      if (localObject != null)
      {
        Paint localPaint = this.r;
        paramInt1 = i1;
        if (localPaint != null) {
          paramInt1 = Math.max(i1, (int)localPaint.measureText((String)localObject) + this.t);
        }
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setProgress(@IntRange(from=0L, to=100L) int paramInt)
  {
    if (this.b == paramInt) {
      return;
    }
    this.b = paramInt;
    if (this.b >= 100) {
      this.b = 100;
    }
    invalidate();
  }
  
  public void setSpacing(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    setStatus(paramInt, true);
  }
  
  public void setStatus(int paramInt, boolean paramBoolean)
  {
    if (this.a == paramInt) {
      return;
    }
    boolean bool = false;
    this.v = 0;
    this.a = paramInt;
    paramInt = this.a;
    if (paramInt == 0)
    {
      setContentDescription(getResources().getString(2131913951));
    }
    else if (paramInt == 1)
    {
      setContentDescription(getResources().getString(2131913950));
    }
    else if (paramInt == 2)
    {
      setContentDescription(getResources().getString(2131915708));
    }
    else
    {
      localObject = this.w;
      if (localObject != null) {
        setContentDescription((CharSequence)localObject);
      }
    }
    c();
    Object localObject = this.y;
    if (localObject != null)
    {
      ((QuickSendProgressView.RefreshProgressRunnable)localObject).b();
      this.y = null;
    }
    if (this.a == 1)
    {
      this.y = new QuickSendProgressView.RefreshProgressRunnable();
      this.y.a(this);
    }
    if (this.a == 3) {
      bool = true;
    }
    if (this.x != bool)
    {
      this.x = bool;
      requestLayout();
    }
    if (paramBoolean) {
      invalidate();
    }
  }
  
  public void setSuccessText(String paramString)
  {
    this.w = paramString;
  }
  
  public void setmArcStrokeWidth(int paramInt)
  {
    this.t = paramInt;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool = true;
    int i1;
    if ((paramDrawable != null) && ((this.c == paramDrawable) || (this.d == paramDrawable) || (this.e == paramDrawable) || (this.m == paramDrawable))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      if (super.verifyDrawable(paramDrawable)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QuickSendProgressView
 * JD-Core Version:    0.7.0.1
 */