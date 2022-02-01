package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;

public class NetSearchTemplateIndividuateOneView
  extends NetSearchTemplateHorizontalBaseView
{
  public static final String a = "NetSearchTemplateIndividuateOneView";
  public FrameLayout a;
  public RelativeLayout a;
  public TextView a;
  public TextView b;
  public ImageView c;
  
  public NetSearchTemplateIndividuateOneView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, 2131559822);
    a(paramInt);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131373086));
    this.c = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131373087));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131373090));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131373088));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371697));
    b(paramInt);
  }
  
  private void b(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramInt;
      localLayoutParams.height = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateIndividuateOneView
 * JD-Core Version:    0.7.0.1
 */