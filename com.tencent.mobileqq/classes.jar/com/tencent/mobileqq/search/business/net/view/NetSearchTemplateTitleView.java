package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;

public class NetSearchTemplateTitleView
  extends NetSearchTemplateBaseView
{
  public TextView a;
  public URLImageView a;
  public TextView b;
  public ImageView c;
  public TextView c;
  
  public NetSearchTemplateTitleView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    View localView = a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131378828));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366885));
    this.b = ((TextView)localView.findViewById(2131371512));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131371487));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377114));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateTitleView
 * JD-Core Version:    0.7.0.1
 */