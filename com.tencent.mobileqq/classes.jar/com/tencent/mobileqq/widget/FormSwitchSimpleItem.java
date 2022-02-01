package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.Switch;

public class FormSwitchSimpleItem
  extends FormSwitchItem
{
  private TextView a;
  
  public FormSwitchSimpleItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormSwitchSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167084));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = getResources().getDimensionPixelSize(2131297217);
      localLayoutParams.addRule(0, this.jdField_a_of_type_ComTencentWidgetSwitch.getId());
      localLayoutParams.addRule(15);
      addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    }
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormSwitchSimpleItem
 * JD-Core Version:    0.7.0.1
 */