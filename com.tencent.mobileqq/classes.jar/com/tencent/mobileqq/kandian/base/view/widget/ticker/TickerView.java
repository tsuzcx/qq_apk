package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.kandian.api.R.styleable;
import java.util.ArrayList;

public class TickerView
  extends View
{
  private static final Interpolator b = new AccelerateDecelerateInterpolator();
  protected final Paint a = new TextPaint(1);
  private final TickerDrawMetrics c = new TickerDrawMetrics(this.a);
  private final TickerColumnManager d = new TickerColumnManager(this.c);
  private final ValueAnimator e = ValueAnimator.ofFloat(new float[] { 1.0F });
  private final Rect f = new Rect();
  private String g;
  private int h;
  private int i;
  private int j;
  private int k;
  private float l;
  private int m;
  private long n;
  private long o;
  private Interpolator p;
  private boolean q;
  private String r;
  
  public TickerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0, 0);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0, 0);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  private void a(Canvas paramCanvas)
  {
    float f1 = this.d.d();
    float f2 = this.c.b();
    a(paramCanvas, this.j, this.f, f1, f2);
  }
  
  static void a(Canvas paramCanvas, int paramInt, Rect paramRect, float paramFloat1, float paramFloat2)
  {
    int i1 = paramRect.width();
    int i2 = paramRect.height();
    float f2;
    if ((paramInt & 0x10) == 16) {
      f2 = paramRect.top + (i2 - paramFloat2) / 2.0F;
    } else {
      f2 = 0.0F;
    }
    float f1;
    if ((paramInt & 0x1) == 1) {
      f1 = paramRect.left + (i1 - paramFloat1) / 2.0F;
    } else {
      f1 = 0.0F;
    }
    if ((paramInt & 0x30) == 48) {
      f2 = 0.0F;
    }
    if ((paramInt & 0x50) == 80) {
      f2 = paramRect.top + (i2 - paramFloat2);
    }
    if ((paramInt & 0x800003) == 8388611) {
      f1 = 0.0F;
    }
    if ((paramInt & 0x800005) == 8388613) {
      f1 = paramRect.left + (i1 - paramFloat1);
    }
    paramCanvas.translate(f1, f2);
    paramCanvas.clipRect(0.0F, 0.0F, paramFloat1, paramFloat2);
  }
  
  private void b()
  {
    int i1 = this.h;
    int i3 = c();
    int i2 = 1;
    if (i1 != i3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.i == d()) {
      i2 = 0;
    }
    if ((i1 != 0) || (i2 != 0)) {
      requestLayout();
    }
  }
  
  private int c()
  {
    float f1;
    if (this.q) {
      f1 = this.d.d();
    } else {
      f1 = this.d.c();
    }
    return (int)f1 + getPaddingLeft() + getPaddingRight();
  }
  
  private int d()
  {
    return (int)this.c.b() + getPaddingTop() + getPaddingBottom();
  }
  
  private void e()
  {
    this.c.a();
    b();
    invalidate();
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    TickerView.StyledAttributes localStyledAttributes = new TickerView.StyledAttributes(this, paramContext.getResources());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cq, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.getResourceId(R.styleable.cr, -1);
    if (paramInt1 != -1)
    {
      paramContext = paramContext.obtainStyledAttributes(paramInt1, R.styleable.cq);
      localStyledAttributes.a(paramContext);
      paramContext.recycle();
    }
    localStyledAttributes.a(paramAttributeSet);
    this.p = b;
    this.o = paramAttributeSet.getInt(R.styleable.cC, 350);
    this.q = paramAttributeSet.getBoolean(R.styleable.cB, false);
    this.j = localStyledAttributes.a;
    if (localStyledAttributes.b != 0) {
      this.a.setShadowLayer(localStyledAttributes.e, localStyledAttributes.c, localStyledAttributes.d, localStyledAttributes.b);
    }
    if (localStyledAttributes.i != 0)
    {
      this.m = localStyledAttributes.i;
      setTypeface(this.a.getTypeface());
    }
    setTextColor(localStyledAttributes.g);
    setTextSize(localStyledAttributes.h);
    paramInt1 = paramAttributeSet.getInt(R.styleable.cD, 0);
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (isInEditMode()) {
          setCharacterLists(new String[] { TickerUtils.a() });
        }
      }
      else {
        setCharacterLists(new String[] { TickerUtils.b() });
      }
    }
    else {
      setCharacterLists(new String[] { TickerUtils.a() });
    }
    paramInt1 = paramAttributeSet.getInt(R.styleable.cE, 0);
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2)
        {
          this.c.a(2);
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("Unsupported ticker_defaultPreferredScrollingDirection: ");
          paramContext.append(paramInt1);
          throw new IllegalArgumentException(paramContext.toString());
        }
      }
      else {
        this.c.a(1);
      }
    }
    else {
      this.c.a(0);
    }
    if (a()) {
      setText(localStyledAttributes.f, false);
    } else {
      this.r = localStyledAttributes.f;
    }
    paramAttributeSet.recycle();
    this.e.addUpdateListener(new TickerView.1(this));
    this.e.addListener(new TickerView.2(this));
  }
  
  public boolean a()
  {
    return this.d.a() != null;
  }
  
  public boolean getAnimateMeasurementChange()
  {
    return this.q;
  }
  
  public long getAnimationDelay()
  {
    return this.n;
  }
  
  public long getAnimationDuration()
  {
    return this.o;
  }
  
  public Interpolator getAnimationInterpolator()
  {
    return this.p;
  }
  
  public int getGravity()
  {
    return this.j;
  }
  
  public String getText()
  {
    return this.g;
  }
  
  public int getTextColor()
  {
    return this.k;
  }
  
  public float getTextSize()
  {
    return this.l;
  }
  
  public Typeface getTypeface()
  {
    return this.a.getTypeface();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    a(paramCanvas);
    paramCanvas.translate(0.0F, this.c.c());
    this.d.a(paramCanvas, this.a);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.h = c();
    this.i = d();
    setMeasuredDimension(resolveSize(this.h, paramInt1), resolveSize(this.i, paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.f.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
  }
  
  public void setAnimateMeasurementChange(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setAnimationDelay(long paramLong)
  {
    this.n = paramLong;
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.o = paramLong;
  }
  
  public void setAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.p = paramInterpolator;
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    this.d.a(paramVarArgs);
    paramVarArgs = this.r;
    if (paramVarArgs != null)
    {
      setText(paramVarArgs, false);
      this.r = null;
    }
  }
  
  public void setCustomCharacterList(ArrayList<String> paramArrayList)
  {
    this.d.a(paramArrayList);
  }
  
  public void setDigitalAnimWidthSpeedIncrement(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      invalidate();
    }
  }
  
  public void setIgnoreWidthAnim(boolean paramBoolean)
  {
    this.d.b(paramBoolean);
  }
  
  public void setPreferredScrollingDirection(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void setText(String paramString)
  {
    setText(paramString, TextUtils.isEmpty(this.g) ^ true);
  }
  
  public void setText(String paramString, boolean paramBoolean)
  {
    if (TextUtils.equals(paramString, this.g)) {
      return;
    }
    this.g = paramString;
    char[] arrayOfChar;
    if (paramString == null) {
      arrayOfChar = new char[0];
    } else {
      arrayOfChar = paramString.toCharArray();
    }
    this.d.a(arrayOfChar);
    setContentDescription(paramString);
    if (paramBoolean)
    {
      if (this.e.isRunning()) {
        this.e.cancel();
      }
      this.e.setStartDelay(this.n);
      this.e.setDuration(this.o);
      this.e.setInterpolator(this.p);
      this.e.start();
      return;
    }
    this.d.a(1.0F);
    this.d.b();
    b();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      this.a.setColor(this.k);
      invalidate();
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    if (this.l != paramFloat)
    {
      this.l = paramFloat;
      this.a.setTextSize(paramFloat);
      e();
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    int i1 = this.m;
    Typeface localTypeface;
    if (i1 == 3)
    {
      localTypeface = Typeface.create(paramTypeface, 3);
    }
    else if (i1 == 1)
    {
      localTypeface = Typeface.create(paramTypeface, 1);
    }
    else
    {
      localTypeface = paramTypeface;
      if (i1 == 2) {
        localTypeface = Typeface.create(paramTypeface, 2);
      }
    }
    this.a.setTypeface(localTypeface);
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView
 * JD-Core Version:    0.7.0.1
 */