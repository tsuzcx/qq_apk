package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchResultGroupMessageView
  extends SearchResultGroupView
{
  public View a;
  public ImageView a;
  public TextView a;
  public LinearLayout b;
  public TextView b;
  
  public SearchResultGroupMessageView() {}
  
  public SearchResultGroupMessageView(ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562966, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131371870);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369991));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368729));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365699));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370553));
  }
  
  public LinearLayout a()
  {
    return this.jdField_b_of_type_AndroidWidgetLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultGroupMessageView
 * JD-Core Version:    0.7.0.1
 */