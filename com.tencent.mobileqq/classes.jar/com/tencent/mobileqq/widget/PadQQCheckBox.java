package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class PadQQCheckBox
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public PadQQCheckBox(Context paramContext)
  {
    super(paramContext);
  }
  
  public PadQQCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PadQQCheckBox);
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(1, true);
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(0);
    LayoutInflater.from(paramContext).inflate(2130969150, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365415));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365416));
    setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    paramAttributeSet.recycle();
    setOnClickListener(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "已选中";; str = "未选中")
    {
      paramAccessibilityNodeInfo.setContentDescription(this.jdField_a_of_type_JavaLangString + str);
      return;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839298);
    }
    for (;;)
    {
      refreshDrawableState();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839296);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PadQQCheckBox
 * JD-Core Version:    0.7.0.1
 */