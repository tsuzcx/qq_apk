package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
import com.tencent.mobileqq.qqui.R.styleable;

public class FormEditItem
  extends RelativeLayout
  implements FormItemConstants
{
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new FormEditItem.1(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  protected boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private final boolean jdField_b_of_type_Boolean;
  private CharSequence c;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l = -2;
  private int m = -2;
  private int n;
  private int o;
  private int p = 0;
  
  public FormEditItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormEditItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = getResources().getDimensionPixelSize(2131298275);
    int i2 = getResources().getDimensionPixelSize(2131296766);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jdField_U_of_type_ArrayOfInt);
    this.i = paramAttributeSet.getDimensionPixelSize(R.styleable.P, i1);
    this.h = paramAttributeSet.getDimensionPixelSize(R.styleable.O, i2);
    this.jdField_a_of_type_JavaLangCharSequence = paramAttributeSet.getString(R.styleable.V);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(R.styleable.S);
    this.j = paramAttributeSet.getDimensionPixelSize(R.styleable.jdField_U_of_type_Int, 0);
    this.k = paramAttributeSet.getDimensionPixelSize(R.styleable.T, 0);
    this.k = Math.min(this.h, this.k);
    this.jdField_b_of_type_JavaLangCharSequence = paramAttributeSet.getString(R.styleable.ac);
    this.g = paramAttributeSet.getInt(R.styleable.ad, 0);
    this.jdField_a_of_type_Int = paramAttributeSet.getInt(R.styleable.N, -1);
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(R.styleable.Y, true);
    this.jdField_c_of_type_JavaLangCharSequence = paramAttributeSet.getString(R.styleable.Q);
    try
    {
      i1 = paramContext.getResources().getDimensionPixelSize(2131296759);
    }
    catch (Resources.NotFoundException paramContext)
    {
      paramContext.printStackTrace();
      i1 = 300;
    }
    this.n = paramAttributeSet.getDimensionPixelSize(R.styleable.R, i1);
    paramAttributeSet.recycle();
    QQUIDelegate.a();
    this.jdField_b_of_type_Boolean = QQUIDelegate.a();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_c_of_type_Int);
    a();
  }
  
  @TargetApi(16)
  private void a()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131367175);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(FormResHelper.a(getResources(), this.g));
    int i1 = getContext().getResources().getDimensionPixelSize(2131296764);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, i1);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.rightMargin = this.i;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    else
    {
      i1 = this.i;
      localLayoutParams.topMargin = i1;
      localLayoutParams.bottomMargin = i1;
    }
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetEditText = new EditText(getContext());
    this.jdField_a_of_type_AndroidWidgetEditText.setId(2131367172);
    this.jdField_a_of_type_AndroidWidgetEditText.setMinWidth(this.n);
    i1 = getContext().getResources().getDimensionPixelSize(2131296764);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, i1);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetEditText.setGravity(21);
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundDrawable(null);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.leftMargin = this.i;
    localLayoutParams.addRule(0, 2131367175);
    localLayoutParams.addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetEditText, localLayoutParams);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHintTextColor(-7829368);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_c_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367173);
    i1 = getContext().getResources().getDimensionPixelSize(2131296764);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167056));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.j, this.k);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i1 = this.i;
    localLayoutParams.leftMargin = i1;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    else
    {
      localLayoutParams.topMargin = i1;
      localLayoutParams.bottomMargin = i1;
      setMinimumHeight(this.h);
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(0, 2131367172);
    localLayoutParams.addRule(15);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.l);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    if (this.jdField_a_of_type_Int >= 0) {
      setBackgroundDrawable(FormResHelper.a(getResources(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean));
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
      if ((bool) && (!paramBoolean)) {
        paramInt = 8;
      } else {
        paramInt = 0;
      }
      paramTextView.setText(paramCharSequence);
      paramTextView.setContentDescription(paramCharSequence);
      paramTextView.setVisibility(paramInt);
    }
  }
  
  private void b()
  {
    if (this.p > 0)
    {
      c();
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      int i1 = this.l;
      CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
      boolean bool;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        bool = true;
      } else {
        bool = false;
      }
      a(localTextView, i1, localCharSequence, bool);
      a(this.jdField_b_of_type_AndroidWidgetTextView, this.m, this.jdField_b_of_type_JavaLangCharSequence, false);
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxWidth(this.o);
    }
  }
  
  private void c()
  {
    int i5 = this.p - this.n - this.i * 2;
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int i3 = 0;
    int i1;
    if (localDrawable != null)
    {
      i2 = this.j;
      i1 = i2;
      if (i2 == 0) {
        i1 = localDrawable.getIntrinsicWidth();
      }
      i1 = this.i + i1;
    }
    else
    {
      i1 = 0;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      i2 = (int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangCharSequence.toString());
    } else {
      i2 = 0;
    }
    int i4 = i1 + i2;
    int i2 = i5;
    if (i4 > 0) {
      i2 = i5 - this.i;
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
      i1 = (int)this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangCharSequence.toString());
    } else {
      i1 = 0;
    }
    i5 = i2 / 2;
    if ((i4 >= i5) && (i1 >= i5))
    {
      i2 = i5;
      i1 = i2;
    }
    else if ((i4 > i5) && (i1 < i5))
    {
      i2 -= i1;
      if (i4 < i2)
      {
        i3 = i2 - i4;
        i2 = i4;
      }
    }
    else
    {
      if ((i4 < i5) && (i1 > i5))
      {
        i2 -= i4;
        if (i1 >= i2)
        {
          i1 = i2;
          i2 = i4;
          break label262;
        }
      }
      else
      {
        i2 -= i4;
      }
      i3 = i2 - i1;
      i2 = i4;
    }
    label262:
    this.l = i2;
    this.m = i1;
    this.o = (this.n + i3);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      int i1 = this.jdField_a_of_type_Int;
      if ((i1 == 1) || (i1 == 2))
      {
        i1 = getMeasuredWidth();
        int i2 = getMeasuredHeight();
        this.jdField_a_of_type_AndroidGraphicsRect.set(d, i2 - jdField_b_of_type_Int, i1, i2);
        paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.h, 1073741824));
      setMeasuredDimension(getMeasuredWidth(), this.h);
      return;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    setMinimumHeight(this.h);
    super.onMeasure(paramInt1, paramInt2);
    return;
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.jdField_a_of_type_Int = paramInt;
    setBackgroundDrawable(FormSwitchItem.a(getResources(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_Boolean))
    {
      this.h = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      if (paramDrawable == null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      if (paramDrawable.getIntrinsicHeight() > this.h)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.h);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.i);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramInt1 >= 0))
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
        this.j = paramInt1;
        this.k = Math.min(this.h, paramInt2);
        paramDrawable.setBounds(0, 0, this.j, this.k);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.i);
        return;
      }
      if ((paramInt1 == 0) || (paramInt2 == 0)) {
        setLeftIcon(paramDrawable);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormEditItem
 * JD-Core Version:    0.7.0.1
 */