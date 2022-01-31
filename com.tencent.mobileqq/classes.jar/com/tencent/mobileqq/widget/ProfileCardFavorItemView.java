package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileCardFavorItemView
  extends LinearLayout
{
  private Context a;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  
  public ProfileCardFavorItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public ProfileCardFavorItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969135, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365321));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131494214));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363443));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131365322));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131365320));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365323));
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365319);
  }
  
  public View a(int paramInt)
  {
    return this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
  }
  
  public void addView(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt);
  }
  
  public void removeViewAt(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeViewAt(paramInt);
  }
  
  public void setArrowVisiale(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardFavorItemView
 * JD-Core Version:    0.7.0.1
 */