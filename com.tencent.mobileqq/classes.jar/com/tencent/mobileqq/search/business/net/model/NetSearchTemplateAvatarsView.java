package com.tencent.mobileqq.search.business.net.model;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;

public class NetSearchTemplateAvatarsView
  extends NetSearchTemplateBaseView
{
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public int b;
  public LinearLayout b;
  public int c;
  public LinearLayout c;
  public LinearLayout d;
  
  public NetSearchTemplateAvatarsView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    View localView = a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378784));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368552));
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131369956));
    this.jdField_c_of_type_Int = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount();
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368555));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131372731));
    this.d = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131372732));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateAvatarsView
 * JD-Core Version:    0.7.0.1
 */