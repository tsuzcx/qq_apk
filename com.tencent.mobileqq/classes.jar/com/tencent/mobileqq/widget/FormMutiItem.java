package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class FormMutiItem
  extends FormSimpleItem
{
  protected int a;
  protected LinearLayout a;
  protected TextView a;
  protected CharSequence a;
  protected TextView b;
  protected CharSequence b;
  protected int g = 2;
  protected int h;
  protected int i;
  
  public FormMutiItem(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    d();
  }
  
  public FormMutiItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    Context localContext1 = null;
    Context localContext2 = null;
    try
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(5);
        localContext2 = paramContext;
        localContext1 = paramContext;
        this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(18);
        if (paramContext == null) {
          break label89;
        }
      }
      finally
      {
        if (localContext2 != null) {
          localContext2.recycle();
        }
      }
    }
    catch (Throwable paramContext)
    {
      label79:
      break label79;
    }
    if (localContext1 != null)
    {
      paramContext = localContext1;
      paramContext.recycle();
    }
    label89:
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(FormResHelper.a(getResources(), this.jdField_a_of_type_Int));
    int j = getResources().getDimensionPixelSize(2131296764);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, j);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (this.c)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131296758);
    }
    j = getResources().getDimensionPixelSize(2131296773);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(FormResHelper.a(getResources(), this.g));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, j);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelOffset(2131296747);
    if (!this.c) {
      ((LinearLayout.LayoutParams)localObject).bottomMargin = getResources().getDimensionPixelOffset(2131296753);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131367173);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131367175);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
    setCustomHeight(getResources().getDimensionPixelSize(2131298363));
  }
  
  public void setFirstLineRightDrawalbe(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramDrawable, null);
  }
  
  public void setFirstLineText(int paramInt)
  {
    this.jdField_a_of_type_JavaLangCharSequence = getResources().getString(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void setFirstLineText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void setFirstLineTextColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
  }
  
  public void setFirstLineTextSize(int paramInt)
  {
    this.h = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.h);
  }
  
  public void setSecondLineText(int paramInt)
  {
    this.jdField_b_of_type_JavaLangCharSequence = getResources().getString(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
  }
  
  public void setSecondLineText(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
  }
  
  public void setSecondLineTextColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.g);
  }
  
  public void setSecondLineTextSize(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(this.i);
  }
  
  public void setSecondLineTextViewPaddingRight(int paramInt)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    localTextView.setPadding(localTextView.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetTextView.getPaddingTop(), paramInt, this.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
  }
  
  public void setSecondLineVisible(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_b_of_type_AndroidWidgetTextView.getVisibility();
    boolean bool2 = false;
    if (!bool1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool1 ^ paramBoolean))
    {
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      int j;
      if (paramBoolean) {
        bool1 = bool2;
      } else {
        j = 8;
      }
      localTextView.setVisibility(j);
      if (paramBoolean) {
        j = getResources().getDimensionPixelSize(2131298363);
      } else {
        j = getResources().getDimensionPixelSize(2131298273);
      }
      setCustomHeight(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiItem
 * JD-Core Version:    0.7.0.1
 */