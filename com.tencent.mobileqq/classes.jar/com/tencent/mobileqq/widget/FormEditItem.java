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
import bixx;
import bixy;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.theme.ThemeUtil;

public class FormEditItem
  extends RelativeLayout
  implements bixy
{
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new bixx(this);
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
  private int p;
  
  public FormEditItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormEditItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = getResources().getDimensionPixelSize(2131298132);
    int i2 = getResources().getDimensionPixelSize(2131296710);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
    this.i = paramAttributeSet.getDimensionPixelSize(2, i1);
    this.h = paramAttributeSet.getDimensionPixelSize(1, i2);
    this.jdField_a_of_type_JavaLangCharSequence = paramAttributeSet.getString(9);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(6);
    this.j = paramAttributeSet.getDimensionPixelSize(8, 0);
    this.k = paramAttributeSet.getDimensionPixelSize(7, 0);
    this.k = Math.min(this.h, this.k);
    this.jdField_b_of_type_JavaLangCharSequence = paramAttributeSet.getString(16);
    this.g = paramAttributeSet.getInt(17, 0);
    this.jdField_a_of_type_Int = paramAttributeSet.getInt(0, -1);
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(12, true);
    i1 = 300;
    this.jdField_c_of_type_JavaLangCharSequence = paramAttributeSet.getString(3);
    try
    {
      i2 = paramContext.getResources().getDimensionPixelSize(2131296703);
      i1 = i2;
    }
    catch (Resources.NotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        continue;
        boolean bool = false;
      }
    }
    this.n = paramAttributeSet.getDimensionPixelSize(4, i1);
    paramAttributeSet.recycle();
    paramContext = ThemeUtil.getCurrentThemeId();
    if (("1000".equals(paramContext)) || ("999".equals(paramContext)))
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_c_of_type_Int);
      a();
      return;
    }
  }
  
  @TargetApi(16)
  private void a()
  {
    setFocusable(true);
    setClickable(true);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131367072);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(FormSimpleItem.b(getResources(), this.g));
    int i1 = getContext().getResources().getDimensionPixelSize(2131296708);
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
      addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetEditText = new EditText(getContext());
      this.jdField_a_of_type_AndroidWidgetEditText.setId(2131367069);
      this.jdField_a_of_type_AndroidWidgetEditText.setMinWidth(this.n);
      i1 = getContext().getResources().getDimensionPixelSize(2131296708);
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(0, i1);
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetEditText.setGravity(21);
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundDrawable(null);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
      localLayoutParams.leftMargin = this.i;
      localLayoutParams.addRule(0, 2131367072);
      localLayoutParams.addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetEditText, localLayoutParams);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHintTextColor(-7829368);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_c_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367070);
      i1 = getContext().getResources().getDimensionPixelSize(2131296708);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166990));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, i1);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
      setLeftIcon(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.j, this.k);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
      localLayoutParams.leftMargin = this.i;
      if (!this.jdField_a_of_type_Boolean) {
        break label552;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    for (;;)
    {
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(0, 2131367069);
      localLayoutParams.addRule(15);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.l);
      addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      if (this.jdField_a_of_type_Int >= 0) {
        setBackgroundDrawable(FormSimpleItem.a(getResources(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean));
      }
      return;
      localLayoutParams.topMargin = this.i;
      localLayoutParams.bottomMargin = this.i;
      break;
      label552:
      localLayoutParams.topMargin = this.i;
      localLayoutParams.bottomMargin = this.i;
      setMinimumHeight(this.h);
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
    int i1;
    CharSequence localCharSequence;
    if (this.p > 0)
    {
      c();
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      i1 = this.l;
      localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, i1, localCharSequence, bool);
      a(this.jdField_b_of_type_AndroidWidgetTextView, this.m, this.jdField_b_of_type_JavaLangCharSequence, false);
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxWidth(this.o);
      return;
    }
  }
  
  private void c()
  {
    int i6 = 0;
    int i3 = this.p - this.n - this.i * 2;
    int i1;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      if (this.j == 0)
      {
        i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        i1 += this.i;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {}
      for (int i2 = (int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangCharSequence.toString());; i2 = 0)
      {
        i2 = i1 + i2;
        if (i2 > 0) {}
        for (i1 = i3 - this.i;; i1 = i3)
        {
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {}
          for (int i4 = (int)this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangCharSequence.toString());; i4 = 0)
          {
            i3 = i1 / 2;
            int i5;
            if ((i2 >= i3) && (i4 >= i3))
            {
              i5 = i3;
              i1 = i3;
              i3 = i6;
            }
            for (;;)
            {
              this.l = i1;
              this.m = i5;
              this.o = (this.n + i3);
              return;
              i1 = this.j;
              break;
              if ((i2 > i3) && (i4 < i3))
              {
                int i7 = i1 - i4;
                i3 = i6;
                i5 = i4;
                i1 = i7;
                if (i2 < i7)
                {
                  i3 = i7 - i2;
                  i1 = i2;
                  i5 = i4;
                }
              }
              else if ((i2 < i3) && (i4 > i3))
              {
                i5 = i1 - i2;
                if (i4 < i5)
                {
                  i3 = i5 - i4;
                  i1 = i2;
                  i5 = i4;
                }
                else
                {
                  i1 = i2;
                  i3 = i6;
                }
              }
              else
              {
                i3 = i1 - i2 - i4;
                i1 = i2;
                i5 = i4;
              }
            }
          }
        }
      }
      i1 = 0;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)))
    {
      int i1 = getMeasuredWidth();
      int i2 = getMeasuredHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(d, i2 - jdField_b_of_type_Int, i1, i2);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.h, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.h);
        return;
      }
      catch (Exception localException)
      {
        setMinimumHeight(this.h);
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
    if (paramDrawable.getIntrinsicHeight() > this.h)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.h);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.i);
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
        this.j = paramInt1;
        this.k = Math.min(this.h, paramInt2);
        paramDrawable.setBounds(0, 0, this.j, this.k);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormEditItem
 * JD-Core Version:    0.7.0.1
 */