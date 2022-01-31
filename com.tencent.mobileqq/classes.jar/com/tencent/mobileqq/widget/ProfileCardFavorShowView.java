package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileCardFavorShowView
  extends FrameLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  public ProfileCardFavorItemView a;
  private LinearLayout b;
  
  public ProfileCardFavorShowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileCardFavorShowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969137, this, true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365302));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365299));
    this.b = ((LinearLayout)findViewById(2131365303));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131494207));
  }
  
  public int a()
  {
    return this.b.getChildCount();
  }
  
  public View a(int paramInt)
  {
    return this.b.getChildAt(paramInt);
  }
  
  public void addView(View paramView)
  {
    this.b.addView(paramView);
  }
  
  public void removeAllViews()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardFavorItemView = null;
    this.b.removeAllViews();
  }
  
  public void removeView(View paramView)
  {
    if (this.b.indexOfChild(paramView) >= 0) {
      this.b.removeView(paramView);
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardFavorShowView
 * JD-Core Version:    0.7.0.1
 */