package com.tencent.mobileqq.search.view;

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
  public TextView d;
  
  public NetSearchTemplateBigImageView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131370057));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131363602));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368603));
    this.b = ((TextView)localView.findViewById(2131367021));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377669));
    this.d = ((TextView)localView.findViewById(2131362012));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateBigImageView
 * JD-Core Version:    0.7.0.1
 */