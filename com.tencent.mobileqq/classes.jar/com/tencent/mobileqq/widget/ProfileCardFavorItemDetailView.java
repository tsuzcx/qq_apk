package com.tencent.mobileqq.widget;

import actj;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bcoz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class ProfileCardFavorItemDetailView
  extends LinearLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  private final String jdField_a_of_type_JavaLangString = "NEW_CARD_FAVOR";
  LinearLayout b;
  public TextView b;
  LinearLayout c;
  public TextView c;
  LinearLayout d;
  LinearLayout e;
  LinearLayout f;
  
  public ProfileCardFavorItemDetailView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public ProfileCardFavorItemDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559342, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365926));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364657));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364658));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364659));
    this.d = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364660));
    this.e = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364661));
    this.f = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364662));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379501));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379502));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379503));
  }
  
  public void a(Drawable paramDrawable, String paramString, int paramInt1, int paramInt2)
  {
    paramDrawable = new bcoz(this, this.jdField_a_of_type_AndroidContentContext, paramDrawable, paramString, paramInt1);
    paramString = new LinearLayout.LayoutParams(-2, actj.a(15.0F, getResources()));
    paramString.leftMargin = actj.a(4.0F, getResources());
    paramDrawable.setLayoutParams(paramString);
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramDrawable);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramDrawable);
      return;
    case 3: 
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(paramDrawable);
      return;
    case 4: 
      this.d.addView(paramDrawable);
      return;
    case 5: 
      this.e.addView(paramDrawable);
      return;
    }
    this.f.addView(paramDrawable);
  }
  
  public void a(String paramString, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(16777215);
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    localURLDrawableOptions.mRequestHeight = actj.a(15.0F, getResources());
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      localURLImageView.setVisibility(8);
    }
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setImageDrawable(paramString);
    localURLImageView.setMaxHeight(actj.a(15.0F, getResources()));
    localURLImageView.setAdjustViewBounds(true);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.leftMargin = actj.a(4.0F, getResources());
    localURLImageView.setLayoutParams(paramString);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localURLImageView);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localURLImageView);
      return;
    case 3: 
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localURLImageView);
      return;
    case 4: 
      this.d.addView(localURLImageView);
      return;
    case 5: 
      this.e.addView(localURLImageView);
      return;
    }
    this.f.addView(localURLImageView);
  }
  
  public void setContent(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setDesc(String paramString)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void setNeedTopMargin(boolean paramBoolean)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (localLayoutParams != null) {
      if (!paramBoolean) {
        break label43;
      }
    }
    label43:
    for (int i = actj.a(14.0F, getResources());; i = 0)
    {
      localLayoutParams.topMargin = i;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardFavorItemDetailView
 * JD-Core Version:    0.7.0.1
 */