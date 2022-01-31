package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.SquareImageView;

public class NetSearchTemplateUpdatesView
  extends NetSearchTemplateBaseView
{
  public int a;
  public FrameLayout a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public SquareImageView a;
  public ImageView b;
  public ImageView d;
  
  public NetSearchTemplateUpdatesView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    View localView = a(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366346));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362701));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364423));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131366309));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131366375));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366353));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366315));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateUpdatesView
 * JD-Core Version:    0.7.0.1
 */