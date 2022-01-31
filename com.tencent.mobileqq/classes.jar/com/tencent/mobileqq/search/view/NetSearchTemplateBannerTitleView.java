package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    View localView = a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363378));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131366372));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362767));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366373));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364447));
    this.c = ((TextView)localView.findViewById(2131366374));
    this.d = ((TextView)localView.findViewById(2131365659));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateBannerTitleView
 * JD-Core Version:    0.7.0.1
 */