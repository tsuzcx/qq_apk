package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileCardFavorShowView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  public ViewGroup a;
  public ImageView a;
  protected LinearLayout a;
  public TextView a;
  
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
  
  public ProfileCardFavorShowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return this.jdField_a_of_type_Int;
    }
    return 2131493773;
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected void a()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(a(), this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131298997));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311372));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302196));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131306286));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131101260));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838988);
  }
  
  public void addView(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
  }
  
  public void removeAllViews()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  public void removeView(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.indexOfChild(paramView) >= 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(paramView);
    }
  }
  
  public void setShowArrow(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardFavorShowView
 * JD-Core Version:    0.7.0.1
 */