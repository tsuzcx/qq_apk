package com.tencent.mobileqq.widget;

import akvp;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969134, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365309));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365310));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365312));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365313));
    this.d = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365315));
    this.e = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365316));
    this.f = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365318));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365311));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365314));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365317));
  }
  
  public void a(Drawable paramDrawable, String paramString, int paramInt1, int paramInt2)
  {
    paramDrawable = new akvp(this, this.jdField_a_of_type_AndroidContentContext, paramDrawable, paramString, paramInt1);
    paramString = new LinearLayout.LayoutParams(-2, AIOUtils.a(15.0F, getResources()));
    paramString.leftMargin = AIOUtils.a(4.0F, getResources());
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
    localURLDrawableOptions.mRequestHeight = AIOUtils.a(15.0F, getResources());
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      localURLImageView.setVisibility(8);
    }
    localURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localURLImageView.setImageDrawable(paramString);
    localURLImageView.setMaxHeight(AIOUtils.a(15.0F, getResources()));
    localURLImageView.setAdjustViewBounds(true);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.leftMargin = AIOUtils.a(4.0F, getResources());
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
  
  public void setTitle(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardFavorItemDetailView
 * JD-Core Version:    0.7.0.1
 */