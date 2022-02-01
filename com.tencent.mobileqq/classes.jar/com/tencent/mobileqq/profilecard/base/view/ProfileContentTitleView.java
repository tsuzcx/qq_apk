package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class ProfileContentTitleView
  extends FrameLayout
{
  public Context a;
  protected ViewGroup a;
  public FrameLayout a;
  public ImageView a;
  public TextView a;
  public ViewGroup b;
  public ImageView b;
  public ViewGroup c;
  public ViewGroup d;
  
  public ProfileContentTitleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileContentTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      return this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildAt(0);
    }
    return null;
  }
  
  protected void a()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559590, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376935));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378977));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378983));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379030));
    this.c = ((ViewGroup)findViewById(2131379031));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378953));
    this.d = ((RelativeLayout)findViewById(2131378981));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131365056));
    setIconEnable(false);
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildCount() > 0) {
        QLog.e("ProfileContentTitleView", 1, "addContentView add fail, already exit.");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    }
  }
  
  public void setArrowEnable(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
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
  
  public void setIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setIconEnable(boolean paramBoolean)
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
  
  public void setMarginBottomEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      if (!paramBoolean) {
        break label50;
      }
    }
    label50:
    for (int i = getResources().getDimensionPixelSize(2131297478);; i = 0)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.bottomMargin = i;
        this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void setTitleBackground(Drawable paramDrawable)
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView
 * JD-Core Version:    0.7.0.1
 */