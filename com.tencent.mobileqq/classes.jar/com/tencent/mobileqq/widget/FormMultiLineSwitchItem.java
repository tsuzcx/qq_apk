package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;

public class FormMultiLineSwitchItem
  extends FormSwitchItem
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  TextView b;
  
  public FormMultiLineSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormMultiLineSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem).getString(21);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = a();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.addRule(15, 0);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131296778);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.b = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.b.setText(this.jdField_a_of_type_JavaLangString);
    }
    if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 16))
    {
      AccessibilityUtil.a(this.b, false);
      setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + " " + this.jdField_a_of_type_JavaLangString);
    }
    this.b.setSingleLine(false);
    this.b.setDuplicateParentStateEnabled(true);
    int i = ViewUtils.a();
    int j = ViewUtils.a(96.0F);
    this.b.setMaxWidth(i - j);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131296767);
    localLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(2131296773);
    localLayoutParams.leftMargin = getResources().getDimensionPixelSize(2131298280);
    localLayoutParams.addRule(3, 2131367395);
    i = getResources().getDimensionPixelSize(2131296793);
    this.b.setTextColor(getResources().getColorStateList(2131167113));
    this.b.setTextSize(0, i);
    this.b.setGravity(19);
    addView(this.b, localLayoutParams);
  }
  
  public void setSecendLineClick(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public void setSecendLineText(Spanned paramSpanned)
  {
    this.b.setText(paramSpanned);
    if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 16)) {
      setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + " " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void setSecendLineText(String paramString)
  {
    this.b.setText(paramString);
    if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 16)) {
      setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + " " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void setSecondLineTextViewVisibility(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.b != null)
    {
      this.b.setVisibility(paramInt);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramInt == 8)
      {
        setMinimumHeight(getResources().getDimensionPixelSize(2131296786));
        localLayoutParams.addRule(15, -1);
      }
    }
    else
    {
      return;
    }
    localLayoutParams.addRule(15, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMultiLineSwitchItem
 * JD-Core Version:    0.7.0.1
 */