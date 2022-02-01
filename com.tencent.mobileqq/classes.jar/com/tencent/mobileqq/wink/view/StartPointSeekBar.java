package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wink.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class StartPointSeekBar
  extends View
{
  private static final String b = StartPointSeekBar.class.getSimpleName();
  private float A = 0.7F;
  private long B = -1L;
  private boolean C;
  private boolean D;
  private float E;
  private float F;
  private StartPointSeekBar.OnSeekBarChangeListener G;
  private boolean H;
  private boolean I;
  private Vibrator J;
  private final int K;
  private int L;
  private boolean M;
  private boolean N;
  private float O;
  private int P = 255;
  private final int c = 200;
  private final float d;
  private final float e;
  private final int f;
  private double g;
  private double h;
  private double i;
  private boolean j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private Drawable n;
  private boolean o;
  private Drawable p;
  private Drawable q;
  private Drawable r;
  private boolean s;
  private Rect t;
  private Rect u;
  private Rect v;
  private double w = 0.0D;
  private float x;
  private float y;
  private boolean z;
  
  public StartPointSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StartPointSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StartPointSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.dP, paramInt, 0);
    this.m = paramContext.getDrawable(R.styleable.ec);
    if (this.m == null) {
      this.m = ResourcesCompat.getDrawable(getResources(), 2130853620, null);
    }
    this.n = paramContext.getDrawable(R.styleable.ed);
    this.g = paramContext.getFloat(R.styleable.dT, -100.0F);
    this.h = paramContext.getFloat(R.styleable.dS, 100.0F);
    this.i = paramContext.getFloat(R.styleable.dV, (float)this.g);
    setProgress(this.i);
    this.r = paramContext.getDrawable(R.styleable.dQ);
    this.p = paramContext.getDrawable(R.styleable.dR);
    this.q = paramContext.getDrawable(R.styleable.dU);
    if ((!a) && (this.r == null)) {
      throw new AssertionError();
    }
    this.j = paramContext.getBoolean(R.styleable.ea, false);
    this.z = paramContext.getBoolean(R.styleable.eb, true);
    this.H = paramContext.getBoolean(R.styleable.ee, false);
    this.o = paramContext.getBoolean(R.styleable.dY, true);
    this.k = paramContext.getDrawable(R.styleable.dX);
    this.l = paramContext.getDrawable(R.styleable.dZ);
    this.s = paramContext.getBoolean(R.styleable.dW, true);
    paramContext.recycle();
    this.J = ((Vibrator)getContext().getSystemService("vibrator"));
    if (!this.z) {
      this.A = 1.0F;
    }
    this.d = (this.m.getIntrinsicWidth() >> 1);
    this.e = (this.m.getIntrinsicHeight() >> 1);
    float f1 = this.d;
    float f2 = this.A;
    this.E = (f1 * f2);
    this.F = (this.e * f2);
    this.K = this.r.getIntrinsicHeight();
    this.t = new Rect();
    this.u = new Rect();
    this.v = new Rect();
    this.f = ((int)this.d);
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.L = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private double a(double paramDouble)
  {
    double d1 = this.g;
    return d1 + paramDouble * (this.h - d1);
  }
  
  private double a(float paramFloat)
  {
    int i1 = getWidth();
    int i2 = this.f;
    if (i1 <= i2 * 2) {
      return 0.0D;
    }
    return Math.min(1.0D, Math.max(0.0D, (paramFloat - i2) / (i1 - i2 * 2)));
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + (paramFloat2 - paramFloat1) * paramFloat3;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i1) == this.P)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.O = paramMotionEvent.getX(i1);
      this.P = paramMotionEvent.getPointerId(i1);
    }
  }
  
  public static void a(StartPointSeekBar paramStartPointSeekBar, int paramInt, TextView paramTextView)
  {
    a(paramStartPointSeekBar, String.valueOf(paramInt), paramTextView);
  }
  
  public static void a(StartPointSeekBar paramStartPointSeekBar, String paramString, TextView paramTextView)
  {
    if ((paramStartPointSeekBar != null) && ((paramStartPointSeekBar instanceof StartPointSeekBar)) && (paramTextView != null))
    {
      paramTextView.setText(paramString);
      int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramTextView.measure(i1, i1);
      i1 = paramTextView.getMeasuredWidth();
      paramString = new RelativeLayout.LayoutParams(-2, -2);
      Object localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateBubble] location[0] = ");
      localStringBuilder.append(paramStartPointSeekBar.getX());
      localStringBuilder.append(", seekBar .getThumbImageRelativeLocation() = ");
      localStringBuilder.append(paramStartPointSeekBar.getThumbRltCenterLoc());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      i1 = (int)(paramStartPointSeekBar.getX() + paramStartPointSeekBar.getThumbRltCenterLoc() - i1 / 2);
      int i2 = (int)(paramStartPointSeekBar.getY() - DisplayUtil.a(paramStartPointSeekBar.getContext(), 14.0F));
      paramStartPointSeekBar = b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[updateBubble] left = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", top = ");
      ((StringBuilder)localObject).append(i2);
      QLog.d(paramStartPointSeekBar, 2, ((StringBuilder)localObject).toString());
      paramString.leftMargin = i1;
      paramString.topMargin = i2;
      paramTextView.setLayoutParams(paramString);
    }
  }
  
  private boolean a(float paramFloat, double paramDouble)
  {
    return Math.abs(paramFloat - c(paramDouble)) <= this.d + 100.0F;
  }
  
  private double b(double paramDouble)
  {
    double d1 = this.h;
    double d2 = this.g;
    if (0.0D == d1 - d2) {
      return 0.0D;
    }
    return (paramDouble - d2) / (d1 - d2);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.P));
    if ((this.s) && (Math.abs(f1 - c(this.y)) < this.L))
    {
      setNormalizedValue(this.y);
      if ((this.I) && (this.H) && (this.J != null))
      {
        int i1 = Build.VERSION.SDK_INT;
        this.I = false;
      }
    }
    else
    {
      setNormalizedValue(a(f1));
      this.I = true;
    }
  }
  
  private boolean b(float paramFloat)
  {
    return a(paramFloat, this.w);
  }
  
  private float c(double paramDouble)
  {
    double d1 = this.f;
    double d2 = getWidth() - this.f * 2;
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (float)(d1 + paramDouble * d2);
  }
  
  private void c()
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    if (!this.o) {
      return;
    }
    float f1 = c(this.y);
    int i2 = paramCanvas.save();
    int i1;
    if (((this.x >= 0.0F) && (this.w >= this.y)) || ((this.x <= 0.0F) && (this.w <= this.y))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = this.k;
    if ((localObject != null) && (i1 == 0))
    {
      localObject = new Rect((int)(f1 - ((Drawable)localObject).getIntrinsicWidth() / 2), (getHeight() - this.k.getIntrinsicHeight()) / 2, (int)(this.k.getIntrinsicWidth() / 2 + f1), (getHeight() + this.k.getIntrinsicHeight()) / 2);
      this.k.setBounds((Rect)localObject);
      this.k.draw(paramCanvas);
    }
    localObject = this.l;
    if ((localObject != null) && (i1 != 0))
    {
      localObject = new Rect((int)(f1 - ((Drawable)localObject).getIntrinsicWidth() / 2), (getHeight() - this.l.getIntrinsicHeight()) / 2, (int)(f1 + this.l.getIntrinsicWidth() / 2), (getHeight() + this.l.getIntrinsicHeight()) / 2);
      this.l.setBounds((Rect)localObject);
      this.l.draw(paramCanvas);
    }
    paramCanvas.restoreToCount(i2);
  }
  
  private void d(Canvas paramCanvas)
  {
    int i1 = paramCanvas.save();
    if ((!this.D) && (this.N))
    {
      Drawable localDrawable = this.n;
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.v);
        this.n.draw(paramCanvas);
        break label66;
      }
    }
    this.m.setBounds(this.v);
    this.m.draw(paramCanvas);
    label66:
    paramCanvas.restoreToCount(i1);
  }
  
  private float getThumbRltCenterLoc()
  {
    return c(this.w);
  }
  
  private void setNormalizedValue(double paramDouble)
  {
    this.w = Math.max(0.0D, paramDouble);
    invalidate();
  }
  
  void a()
  {
    this.M = true;
    StartPointSeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.G;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.a(this);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i1 = paramCanvas.save();
    this.r.setBounds(this.t);
    if (this.j) {
      paramCanvas.clipRect(this.v, Region.Op.DIFFERENCE);
    }
    this.r.draw(paramCanvas);
    paramCanvas.restoreToCount(i1);
  }
  
  void a(boolean paramBoolean)
  {
    this.B = System.currentTimeMillis();
    this.C = paramBoolean;
  }
  
  void b()
  {
    this.M = false;
    StartPointSeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.G;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.b(this);
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (this.p == null) {
      return;
    }
    int i1 = paramCanvas.save();
    this.u.set(this.t);
    if (c(b(0.0D)) < c(this.w))
    {
      this.u.left = ((int)c(b(0.0D)));
      this.u.right = ((int)c(this.w));
    }
    else
    {
      this.u.right = ((int)c(b(0.0D)));
      this.u.left = ((int)c(this.w));
    }
    if (this.j) {
      paramCanvas.clipRect(this.v, Region.Op.DIFFERENCE);
    }
    this.p.setBounds(this.u);
    this.p.draw(paramCanvas);
    paramCanvas.restoreToCount(i1);
  }
  
  public float getProgress()
  {
    return (float)a(this.w);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.D = false;
    if ((this.B != -1L) && (this.z))
    {
      long l1 = System.currentTimeMillis() - this.B;
      if ((l1 > 0L) && (l1 < 200L))
      {
        this.D = true;
        f2 = (float)l1 * 1.0F / 200.0F;
        f1 = f2;
        if (this.C) {
          f1 = 1.0F - f2;
        }
        f1 = a(this.A, 1.0F, f1);
        this.E = (this.d * f1);
        this.F = (this.e * f1);
        invalidate();
      }
    }
    this.t.set(this.f, (getHeight() - this.K) / 2, getWidth() - this.f, (getHeight() + this.K) / 2);
    int i2 = (int)c(this.w);
    int i1 = getHeight() / 2;
    Rect localRect = this.v;
    float f1 = i2;
    float f2 = this.E;
    i2 = (int)(f1 - f2);
    float f3 = i1;
    float f4 = this.F;
    localRect.set(i2, (int)(f3 - f4), (int)(f1 + f2), (int)(f3 + f4));
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
    d(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      int i1 = Math.max(this.m.getIntrinsicWidth(), this.r.getIntrinsicWidth());
      if (View.MeasureSpec.getMode(paramInt1) != 0) {
        i1 = View.MeasureSpec.getSize(paramInt1);
      }
      int i2 = Math.max(this.m.getIntrinsicHeight(), this.r.getIntrinsicHeight());
      paramInt1 = i2;
      if (View.MeasureSpec.getMode(paramInt2) != 0) {
        paramInt1 = Math.max(i2, View.MeasureSpec.getSize(paramInt2));
      }
      setMeasuredDimension(i1, paramInt1);
      return;
    }
    finally {}
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 5)
            {
              if (i1 != 6) {
                return true;
              }
              a(paramMotionEvent);
              invalidate();
              return true;
            }
            i1 = paramMotionEvent.getPointerCount() - 1;
            this.O = paramMotionEvent.getX(i1);
            this.P = paramMotionEvent.getPointerId(i1);
            invalidate();
            return true;
          }
          if (this.M)
          {
            b();
            setPressed(false);
          }
          invalidate();
          return true;
        }
        if (this.N)
        {
          if (this.M)
          {
            b(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.P)) - this.O) > this.L)
          {
            setPressed(true);
            invalidate();
            a();
            b(paramMotionEvent);
            c();
          }
          paramMotionEvent = this.G;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.a(this, (int)Math.round(a(this.w)));
            return true;
          }
        }
      }
      else
      {
        if (this.M)
        {
          a(true);
          b(paramMotionEvent);
          b();
          setPressed(false);
        }
        else
        {
          a();
          b(paramMotionEvent);
          b();
        }
        this.N = false;
        invalidate();
        return true;
      }
    }
    else
    {
      this.P = paramMotionEvent.getPointerId(paramMotionEvent.getPointerCount() - 1);
      this.O = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.P));
      this.N = b(this.O);
      if (!this.N) {
        return super.onTouchEvent(paramMotionEvent);
      }
      setPressed(false);
      invalidate();
      a();
      b(paramMotionEvent);
      c();
      a(false);
    }
    return true;
  }
  
  public void setAbsoluteMinMaxValue(double paramDouble1, double paramDouble2)
  {
    this.g = paramDouble1;
    this.h = paramDouble2;
  }
  
  public void setBackgroundDrawable(int paramInt)
  {
    this.r = ResourcesCompat.getDrawable(getResources(), paramInt, null);
  }
  
  public void setDefaultValue(float paramFloat)
  {
    this.x = paramFloat;
    this.y = ((float)b(paramFloat));
    invalidate();
  }
  
  public void setOnSeekBarChangeListener(StartPointSeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.G = paramOnSeekBarChangeListener;
  }
  
  public void setProgress(double paramDouble)
  {
    paramDouble = b(paramDouble);
    if ((paramDouble <= this.h) && (paramDouble >= this.g))
    {
      this.w = paramDouble;
      invalidate();
      return;
    }
    throw new IllegalArgumentException("Value should be in the middle of max and min value");
  }
  
  public void setSectionEnable(boolean paramBoolean)
  {
    this.o = paramBoolean;
    invalidate();
  }
  
  public void setThumbDrawable(int paramInt)
  {
    this.m = ResourcesCompat.getDrawable(getResources(), paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.StartPointSeekBar
 * JD-Core Version:    0.7.0.1
 */