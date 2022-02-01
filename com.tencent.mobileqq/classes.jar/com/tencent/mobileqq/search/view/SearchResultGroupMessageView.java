package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultGroupView;

public class SearchResultGroupMessageView
  extends SearchResultGroupView
{
  public ImageView a;
  public View b;
  public LinearLayout b;
  public TextView b;
  public TextView c;
  
  public SearchResultGroupMessageView() {}
  
  public SearchResultGroupMessageView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562785, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371492);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369676));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368461));
    this.c = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365536));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370212));
  }
  
  public LinearLayout a()
  {
    return this.jdField_b_of_type_AndroidWidgetLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultGroupMessageView
 * JD-Core Version:    0.7.0.1
 */