package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class NetSearchTemplateBannerTitleView
  extends NetSearchTemplateBaseView
{
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public ImageView b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public NetSearchTemplateBannerTitleView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379432));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131370287));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368754));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365430));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378921));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378729));
    this.d = ((TextView)localView.findViewById(2131365699));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166963));
      }
      if (this.d != null) {
        this.d.setTextColor(this.d.getContext().getResources().getColor(2131166963));
      }
    }
    do
    {
      return;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      }
    } while (this.d == null);
    this.d.setTextColor(Color.parseColor("#737373"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateBannerTitleView
 * JD-Core Version:    0.7.0.1
 */