package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class FormMutiItem
  extends FormSimpleItem
{
  protected int a;
  protected LinearLayout a;
  protected TextView a;
  protected CharSequence a;
  protected int b;
  protected TextView b;
  protected CharSequence b;
  protected int c;
  protected int d;
  
  public FormMutiItem(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 2;
    b();
  }
  
  public FormMutiItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 2;
    b();
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(b(getResources(), this.jdField_a_of_type_Int));
    int i = getResources().getDimensionPixelSize(2131559307);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    }
    for (;;)
    {
      i = getResources().getDimensionPixelSize(2131559308);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(b(getResources(), this.jdField_b_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, i);
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(19);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelOffset(2131559326);
      if (!this.jdField_c_of_type_Boolean) {
        ((LinearLayout.LayoutParams)localObject).bottomMargin = getResources().getDimensionPixelOffset(2131559314);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131362054);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131362055);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      setCustomHeight(getResources().getDimensionPixelSize(2131558915));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131559313);
    }
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
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
  }
  
  public void setFirstLineTextSize(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.jdField_c_of_type_Int);
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
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
  }
  
  public void setSecondLineTextSize(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(this.d);
  }
  
  public void setSecondLineVisible(boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      boolean bool1 = true;
      if ((bool1 ^ paramBoolean))
      {
        TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label63;
        }
        bool1 = bool2;
        label32:
        localTextView.setVisibility(bool1);
        if (!paramBoolean) {
          break label69;
        }
      }
    }
    label63:
    label69:
    for (int i = getResources().getDimensionPixelSize(2131558915);; i = getResources().getDimensionPixelSize(2131558913))
    {
      setCustomHeight(i);
      return;
      i = 0;
      break;
      i = 8;
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiItem
 * JD-Core Version:    0.7.0.1
 */