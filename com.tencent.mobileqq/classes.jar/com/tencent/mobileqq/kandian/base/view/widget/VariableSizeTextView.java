package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class VariableSizeTextView
  extends RelativeLayout
{
  public static final String a;
  protected float b;
  protected float c = 0.0F;
  protected boolean d = false;
  ViewConfiguration e = ViewConfiguration.get(getContext());
  float f;
  float g;
  float h;
  float i;
  private TextView j;
  private float k;
  private float l;
  private boolean m = false;
  private boolean n = false;
  private VariableSizeTextView.OnSizeChangedListener o;
  private float p = 0.0F;
  private float q = 0.0F;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.atlas.");
    localStringBuilder.append(VariableSizeTextView.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public VariableSizeTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VariableSizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClickable(true);
    setFocusable(true);
    this.j = new TextView(getContext());
    this.j.setTextColor(Color.parseColor("#E8E8E8"));
    this.j.setTextSize(1, 16.0F);
    this.j.setIncludeFontPadding(false);
    this.j.setLineSpacing(DisplayUtil.a(paramContext, 3.0F), 1.0F);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(10);
    addView(this.j, paramContext);
  }
  
  public int a(int paramInt)
  {
    int i2 = 1;
    int i1 = paramInt;
    paramInt = i2;
    for (;;)
    {
      i1 /= 10;
      if (i1 == 0) {
        break;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public void a()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    float f1 = this.c;
    if (f1 == 0.0F) {
      localLayoutParams.height = ((int)(this.b + 0.5F));
    } else {
      localLayoutParams.height = Math.min((int)(this.b + 0.5F), (int)(f1 + 0.5F));
    }
    setLayoutParams(localLayoutParams);
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.p = this.j.getLineSpacingMultiplier();
      this.q = this.j.getLineSpacingExtra();
      return;
    }
    if ((this.p == 0.0F) && (this.q == 0.0F)) {}
    try
    {
      Field localField = TextView.class.getDeclaredField("mSpacingMult");
      localField.setAccessible(true);
      this.p = localField.getFloat(this);
      localField = TextView.class.getDeclaredField("mSpacingAdd");
      localField.setAccessible(true);
      this.q = localField.getFloat(this);
      return;
    }
    catch (Exception localException)
    {
      label94:
      break label94;
    }
    this.p = 1.0F;
    this.q = 3.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b();
    int i2 = getMeasuredWidth();
    int i1 = i2;
    if (i2 == 0) {
      i1 = (int)DeviceInfoUtil.F();
    }
    paramCanvas = new StaticLayout(this.j.getText(), this.j.getPaint(), i1 - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.p, this.q, true);
    float f1 = paramCanvas.getHeight() + getPaddingTop() + getPaddingBottom();
    i1 = paramCanvas.getLineCount();
    if (f1 != this.c)
    {
      this.c = f1;
      a();
    }
    boolean bool;
    if (i1 > 5) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onTouchEvent()  action=");
      ((StringBuilder)localObject2).append(i1);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = getLayoutParams();
    if (i1 == 0)
    {
      this.k = paramMotionEvent.getRawX();
      this.l = paramMotionEvent.getRawY();
      this.n = false;
      this.m = false;
      this.f = paramMotionEvent.getRawY();
      this.g = this.f;
      this.i = ((ViewGroup.LayoutParams)localObject1).height;
      getParent().requestDisallowInterceptTouchEvent(true);
      return true;
    }
    float f1;
    float f2;
    if (i1 == 1)
    {
      this.g = paramMotionEvent.getRawY();
      f1 = ((ViewGroup.LayoutParams)localObject1).height;
      if (f1 != this.c)
      {
        paramMotionEvent = this.o;
        if (paramMotionEvent != null) {
          paramMotionEvent.a();
        }
      }
      f2 = this.c;
      if (f1 > f2)
      {
        paramMotionEvent = ValueAnimator.ofFloat(new float[] { f1, f2 });
        paramMotionEvent.setDuration(300L);
        paramMotionEvent.setInterpolator(new DecelerateInterpolator());
        paramMotionEvent.addUpdateListener(new VariableSizeTextView.1(this, (ViewGroup.LayoutParams)localObject1));
        setFocusable(false);
        setClickable(false);
        paramMotionEvent.start();
        return true;
      }
    }
    else if (i1 == 2)
    {
      f1 = paramMotionEvent.getRawX() - this.k;
      f2 = paramMotionEvent.getRawY() - this.l;
      if ((Math.max(Math.abs(f1), Math.abs(f2)) > this.e.getScaledTouchSlop()) && (!this.n) && (!this.m) && ((f1 != 0.0F) || (f2 != 0.0F)))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onTouchEvent()  action=");
          localStringBuilder.append(i1);
          localStringBuilder.append(" distanceX=");
          localStringBuilder.append(f1);
          localStringBuilder.append(" distanceY=");
          localStringBuilder.append(f2);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        if (Math.abs(f1) >= Math.abs(f2)) {
          this.n = true;
        } else {
          this.m = true;
        }
      }
      if (this.m)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        this.h = this.g;
        this.g = paramMotionEvent.getRawY();
        f1 = this.h - this.g;
        int i2 = ((ViewGroup.LayoutParams)localObject1).height;
        f2 = i2;
        i1 = (int)(f2 + f1);
        float f3 = i1;
        float f4 = this.c;
        if (f3 > f4)
        {
          if (this.d)
          {
            if (f1 < 0.0F) {
              i1 = -1;
            } else {
              i1 = 1;
            }
            double d1 = i2;
            double d2 = i1;
            double d3 = Math.pow(Math.abs(f1), 0.7D);
            Double.isNaN(d2);
            Double.isNaN(d1);
            i1 = (int)(d1 + d2 * d3);
          }
          else
          {
            i1 = (int)(f4 + 0.5F);
          }
          ((ViewGroup.LayoutParams)localObject1).height = i1;
          paramMotionEvent = this.o;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(i2, i1);
          }
          setLayoutParams((ViewGroup.LayoutParams)localObject1);
          return true;
        }
        if (((f2 < this.b) && (f1 > 0.0F)) || (f3 >= this.b))
        {
          ((ViewGroup.LayoutParams)localObject1).height = i1;
          paramMotionEvent = this.o;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(i2, i1);
          }
          setLayoutParams((ViewGroup.LayoutParams)localObject1);
          return true;
        }
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return true;
  }
  
  public void setOnSizeChangedListener(VariableSizeTextView.OnSizeChangedListener paramOnSizeChangedListener)
  {
    this.o = paramOnSizeChangedListener;
  }
  
  public void setText(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    Object localObject = new StringBuilder();
    paramInt1 += 1;
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    paramInt1 = a(paramInt1);
    paramInt2 = a(paramInt2);
    localObject = new SpannableStringBuilder((CharSequence)localObject);
    ((SpannableStringBuilder)localObject).setSpan(new AbsoluteSizeSpan(DisplayUtil.a(getContext(), 17.0F)), 0, paramInt1, 33);
    AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(DisplayUtil.a(getContext(), 12.0F));
    paramInt2 = paramInt2 + paramInt1 + 1;
    ((SpannableStringBuilder)localObject).setSpan(localAbsoluteSizeSpan, paramInt1, paramInt2, 33);
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#E8E8E8")), paramInt1, paramInt2, 33);
    ((SpannableStringBuilder)localObject).append("  ");
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ((SpannableStringBuilder)localObject).append(paramCharSequence);
    }
    this.j.setText((CharSequence)localObject);
  }
  
  public void setText(String paramString)
  {
    this.j.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.VariableSizeTextView
 * JD-Core Version:    0.7.0.1
 */