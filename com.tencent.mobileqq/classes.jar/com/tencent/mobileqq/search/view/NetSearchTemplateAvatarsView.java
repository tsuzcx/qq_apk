package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.SquareImageView;

public class NetSearchTemplateAvatarsView
  extends NetSearchTemplateBaseView
{
  public int a;
  public LinearLayout a;
  public TextView a;
  public SquareImageView a;
  
  public NetSearchTemplateAvatarsView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    View localView = a(this.b);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363360));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)localView.findViewById(2131363525));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131366344));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateAvatarsView
 * JD-Core Version:    0.7.0.1
 */