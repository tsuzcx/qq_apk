package com.tencent.mobileqq.widget;

import ajya;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
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
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  
  public PadQQCheckBox(Context paramContext)
  {
    super(paramContext);
  }
  
  public PadQQCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PadQQCheckBox);
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(0, true);
    this.jdField_a_of_type_JavaLangCharSequence = paramAttributeSet.getString(1);
    LayoutInflater.from(paramContext).inflate(2131559359, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364183));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364191));
    setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
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
    for (String str = ajya.a(2131707874);; str = ajya.a(2131707873))
    {
      paramAccessibilityNodeInfo.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence + str);
      return;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840286);
    }
    for (;;)
    {
      refreshDrawableState();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840284);
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PadQQCheckBox
 * JD-Core Version:    0.7.0.1
 */