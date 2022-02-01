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
  protected float a;
  ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(getContext());
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VariableSizeTextView.OnSizeChangedListener jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVariableSizeTextView$OnSizeChangedListener;
  protected boolean a;
  protected float b;
  private boolean b;
  float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean = false;
  float d;
  float e;
  float f;
  private float g;
  private float h;
  private float i = 0.0F;
  private float j = 0.0F;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.atlas.");
    localStringBuilder.append(VariableSizeTextView.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public VariableSizeTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public VariableSizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    setClickable(true);
    setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#E8E8E8"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(DisplayUtil.a(paramContext, 3.0F), 1.0F);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(10);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
  }
  
  public int a(int paramInt)
  {
    int m = 1;
    int k = paramInt;
    paramInt = m;
    for (;;)
    {
      k /= 10;
      if (k == 0) {
        break;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public void a()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    float f1 = this.jdField_b_of_type_Float;
    if (f1 == 0.0F) {
      localLayoutParams.height = ((int)(this.jdField_a_of_type_Float + 0.5F));
    } else {
      localLayoutParams.height = Math.min((int)(this.jdField_a_of_type_Float + 0.5F), (int)(f1 + 0.5F));
    }
    setLayoutParams(localLayoutParams);
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.i = this.jdField_a_of_type_AndroidWidgetTextView.getLineSpacingMultiplier();
      this.j = this.jdField_a_of_type_AndroidWidgetTextView.getLineSpacingExtra();
      return;
    }
    if ((this.i == 0.0F) && (this.j == 0.0F)) {}
    try
    {
      Field localField = TextView.class.getDeclaredField("mSpacingMult");
      localField.setAccessible(true);
      this.i = localField.getFloat(this);
      localField = TextView.class.getDeclaredField("mSpacingAdd");
      localField.setAccessible(true);
      this.j = localField.getFloat(this);
      return;
    }
    catch (Exception localException)
    {
      label94:
      break label94;
    }
    this.i = 1.0F;
    this.j = 3.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b();
    int m = getMeasuredWidth();
    int k = m;
    if (m == 0) {
      k = (int)DeviceInfoUtil.k();
    }
    paramCanvas = new StaticLayout(this.jdField_a_of_type_AndroidWidgetTextView.getText(), this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), k - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.i, this.j, true);
    float f1 = paramCanvas.getHeight() + getPaddingTop() + getPaddingBottom();
    k = paramCanvas.getLineCount();
    if (f1 != this.jdField_b_of_type_Float)
    {
      this.jdField_b_of_type_Float = f1;
      a();
    }
    boolean bool;
    if (k > 5) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onTouchEvent()  action=");
      ((StringBuilder)localObject2).append(k);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = getLayoutParams();
    if (k == 0)
    {
      this.g = paramMotionEvent.getRawX();
      this.h = paramMotionEvent.getRawY();
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
      this.d = this.jdField_c_of_type_Float;
      this.f = ((ViewGroup.LayoutParams)localObject1).height;
      getParent().requestDisallowInterceptTouchEvent(true);
      return true;
    }
    float f1;
    float f2;
    if (k == 1)
    {
      this.d = paramMotionEvent.getRawY();
      f1 = ((ViewGroup.LayoutParams)localObject1).height;
      if (f1 != this.jdField_b_of_type_Float)
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVariableSizeTextView$OnSizeChangedListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a();
        }
      }
      f2 = this.jdField_b_of_type_Float;
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
    else if (k == 2)
    {
      f1 = paramMotionEvent.getRawX() - this.g;
      f2 = paramMotionEvent.getRawY() - this.h;
      if ((Math.max(Math.abs(f1), Math.abs(f2)) > this.jdField_a_of_type_AndroidViewViewConfiguration.getScaledTouchSlop()) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && ((f1 != 0.0F) || (f2 != 0.0F)))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onTouchEvent()  action=");
          localStringBuilder.append(k);
          localStringBuilder.append(" distanceX=");
          localStringBuilder.append(f1);
          localStringBuilder.append(" distanceY=");
          localStringBuilder.append(f2);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        if (Math.abs(f1) >= Math.abs(f2)) {
          this.jdField_c_of_type_Boolean = true;
        } else {
          this.jdField_b_of_type_Boolean = true;
        }
      }
      if (this.jdField_b_of_type_Boolean)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        this.e = this.d;
        this.d = paramMotionEvent.getRawY();
        f1 = this.e - this.d;
        int m = ((ViewGroup.LayoutParams)localObject1).height;
        f2 = m;
        k = (int)(f2 + f1);
        float f3 = k;
        float f4 = this.jdField_b_of_type_Float;
        if (f3 > f4)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            if (f1 < 0.0F) {
              k = -1;
            } else {
              k = 1;
            }
            double d1 = m;
            double d2 = k;
            double d3 = Math.pow(Math.abs(f1), 0.7D);
            Double.isNaN(d2);
            Double.isNaN(d1);
            k = (int)(d1 + d2 * d3);
          }
          else
          {
            k = (int)(f4 + 0.5F);
          }
          ((ViewGroup.LayoutParams)localObject1).height = k;
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVariableSizeTextView$OnSizeChangedListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(m, k);
          }
          setLayoutParams((ViewGroup.LayoutParams)localObject1);
          return true;
        }
        if (((f2 < this.jdField_a_of_type_Float) && (f1 > 0.0F)) || (f3 >= this.jdField_a_of_type_Float))
        {
          ((ViewGroup.LayoutParams)localObject1).height = k;
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVariableSizeTextView$OnSizeChangedListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(m, k);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVariableSizeTextView$OnSizeChangedListener = paramOnSizeChangedListener;
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.VariableSizeTextView
 * JD-Core Version:    0.7.0.1
 */