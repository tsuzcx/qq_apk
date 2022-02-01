package com.tencent.mobileqq.search.business.net.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;

public class NetSearchTemplateBigImageView
  extends NetSearchTemplateBaseView
{
  public RelativeLayout a;
  public TextView a;
  public URLImageView a;
  public TextView b;
  public TextView c;
  public TextView h;
  
  public NetSearchTemplateBigImageView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    View localView = a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131369736));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131363530));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368343));
    this.b = ((TextView)localView.findViewById(2131366872));
    this.c = ((TextView)localView.findViewById(2131377106));
    this.h = ((TextView)localView.findViewById(2131362028));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBigImageView
 * JD-Core Version:    0.7.0.1
 */