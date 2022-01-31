package com.tencent.mobileqq.widget;

import akga;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class FormEditItem
  extends RelativeLayout
  implements FormItemConstants
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new akga(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private int jdField_c_of_type_Int;
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private int d;
  private int e;
  private int f;
  private int g = -2;
  private int h = -2;
  private int i;
  private int j;
  private int k;
  
  public FormEditItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormEditItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int m = getResources().getDimensionPixelSize(2131558914);
    int n = getResources().getDimensionPixelSize(2131559314);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
    this.d = paramAttributeSet.getDimensionPixelSize(6, m);
    this.jdField_c_of_type_Int = paramAttributeSet.getDimensionPixelSize(5, n);
    this.jdField_a_of_type_JavaLangCharSequence = paramAttributeSet.getString(7);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(8);
    this.e = paramAttributeSet.getDimensionPixelSize(3, 0);
    this.f = paramAttributeSet.getDimensionPixelSize(4, 0);
    this.f = Math.min(this.jdField_c_of_type_Int, this.f);
    this.jdField_b_of_type_JavaLangCharSequence = paramAttributeSet.getString(10);
    this.jdField_b_of_type_Int = paramAttributeSet.getInt(14, 0);
    this.jdField_a_of_type_Int = paramAttributeSet.getInt(0, -1);
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(2, true);
    m = 300;
    this.jdField_c_of_type_JavaLangCharSequence = paramAttributeSet.getString(18);
    try
    {
      n = paramContext.getResources().getDimensionPixelSize(2131559313);
      m = n;
    }
    catch (Resources.NotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    this.i = paramAttributeSet.getDimensionPixelSize(19, m);
    paramAttributeSet.recycle();
    a();
  }
  
  @TargetApi(16)
  private void a()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131362055);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(FormSimpleItem.a(getResources(), this.jdField_b_of_type_Int));
    int m = getContext().getResources().getDimensionPixelSize(2131559305);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, m);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.rightMargin = this.d;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
      addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetEditText = new EditText(getContext());
      this.jdField_a_of_type_AndroidWidgetEditText.setId(2131362053);
      this.jdField_a_of_type_AndroidWidgetEditText.setMinWidth(this.i);
      m = getContext().getResources().getDimensionPixelSize(2131559305);
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, m);
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetEditText.setGravity(21);
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundDrawable(null);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
      localLayoutParams.leftMargin = this.d;
      localLayoutParams.addRule(0, 2131362055);
      localLayoutParams.addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetEditText, localLayoutParams);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHintTextColor(-7829368);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_c_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131362054);
      m = getContext().getResources().getDimensionPixelSize(2131559305);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131494207));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, m);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
      setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.e, this.f);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
      localLayoutParams.leftMargin = this.d;
      if (!this.jdField_a_of_type_Boolean) {
        break label544;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    for (;;)
    {
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(0, 2131362053);
      localLayoutParams.addRule(15);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.g);
      addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      if (this.jdField_a_of_type_Int >= 0) {
        setBackgroundDrawable(FormSimpleItem.a(getResources(), this.jdField_a_of_type_Int));
      }
      return;
      localLayoutParams.topMargin = this.d;
      localLayoutParams.bottomMargin = this.d;
      break;
      label544:
      localLayoutParams.topMargin = this.d;
      localLayoutParams.bottomMargin = this.d;
      setMinimumHeight(this.jdField_c_of_type_Int);
    }
  }
  
  public static void a(TextView paramTextView, int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramTextView != null)
    {
      paramTextView.setWidth(paramInt);
      boolean bool = TextUtils.isEmpty(paramCharSequence);
      if (bool) {
        paramCharSequence = "";
      }
      if ((!bool) || (paramBoolean)) {
        break label52;
      }
    }
    label52:
    for (paramInt = 8;; paramInt = 0)
    {
      paramTextView.setText(paramCharSequence);
      paramTextView.setContentDescription(paramCharSequence);
      paramTextView.setVisibility(paramInt);
      return;
    }
  }
  
  private void b()
  {
    TextView localTextView;
    int m;
    CharSequence localCharSequence;
    if (this.k > 0)
    {
      c();
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      m = this.g;
      localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, m, localCharSequence, bool);
      a(this.jdField_b_of_type_AndroidWidgetTextView, this.h, this.jdField_b_of_type_JavaLangCharSequence, false);
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxWidth(this.j);
      return;
    }
  }
  
  private void c()
  {
    int i4 = 0;
    int i1 = this.k - this.i - this.d * 2;
    int m;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      if (this.e == 0)
      {
        m = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        m += this.d;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {}
      for (int n = (int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangCharSequence.toString());; n = 0)
      {
        n = m + n;
        if (n > 0) {}
        for (m = i1 - this.d;; m = i1)
        {
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {}
          for (int i2 = (int)this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangCharSequence.toString());; i2 = 0)
          {
            i1 = m / 2;
            int i3;
            if ((n >= i1) && (i2 >= i1))
            {
              i3 = i1;
              m = i1;
              i1 = i4;
            }
            for (;;)
            {
              this.g = m;
              this.h = i3;
              this.j = (this.i + i1);
              return;
              m = this.e;
              break;
              if ((n > i1) && (i2 < i1))
              {
                int i5 = m - i2;
                i1 = i4;
                i3 = i2;
                m = i5;
                if (n < i5)
                {
                  i1 = i5 - n;
                  m = n;
                  i3 = i2;
                }
              }
              else if ((n < i1) && (i2 > i1))
              {
                i3 = m - n;
                if (i2 < i3)
                {
                  i1 = i3 - i2;
                  m = n;
                  i3 = i2;
                }
                else
                {
                  m = n;
                  i1 = i4;
                }
              }
              else
              {
                i1 = m - n - i2;
                m = n;
                i3 = i2;
              }
            }
          }
        }
      }
      m = 0;
    }
  }
  
  public EditText a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.jdField_c_of_type_Int);
        return;
      }
      catch (Exception localException)
      {
        setMinimumHeight(this.jdField_c_of_type_Int);
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.jdField_a_of_type_Int = paramInt;
    setBackgroundDrawable(FormSwitchItem.a(getResources(), this.jdField_a_of_type_Int));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_c_of_type_Int = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.jdField_c_of_type_Int)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.d);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.e = paramInt1;
        this.f = Math.min(this.jdField_c_of_type_Int, paramInt2);
        paramDrawable.setBounds(0, 0, this.e, this.f);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.d);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      b();
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormEditItem
 * JD-Core Version:    0.7.0.1
 */