package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import baww;
import bbll;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;

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
    this.jdField_a_of_type_JavaLangString = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem).getString(22);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = a();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.addRule(15, 0);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131296631);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.b = new TextView(getContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.b.setText(this.jdField_a_of_type_JavaLangString);
    }
    if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 16))
    {
      baww.a(this.b, false);
      setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + " " + this.jdField_a_of_type_JavaLangString);
    }
    this.b.setSingleLine(false);
    this.b.setDuplicateParentStateEnabled(true);
    int i = bbll.a();
    int j = bbll.a(96.0F);
    this.b.setMaxWidth(i - j);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131296621);
    localLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(2131296627);
    localLayoutParams.leftMargin = getResources().getDimensionPixelSize(2131298015);
    localLayoutParams.addRule(3, 2131366629);
    i = getResources().getDimensionPixelSize(2131296646);
    this.b.setTextColor(getResources().getColorStateList(2131166928));
    this.b.setTextSize(0, i);
    this.b.setGravity(19);
    addView(this.b, localLayoutParams);
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
        setMinimumHeight(getResources().getDimensionPixelSize(2131296639));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMultiLineSwitchItem
 * JD-Core Version:    0.7.0.1
 */