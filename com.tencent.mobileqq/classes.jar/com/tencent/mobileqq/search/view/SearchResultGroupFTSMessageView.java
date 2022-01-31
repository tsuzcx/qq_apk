package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class SearchResultGroupFTSMessageView
  extends SearchResultGroupMessageView
{
  public LinearLayout a;
  
  public SearchResultGroupFTSMessageView(ViewGroup paramViewGroup)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130971528, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131362715));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.b.findViewById(2131375015));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131374319);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369923));
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultGroupFTSMessageView
 * JD-Core Version:    0.7.0.1
 */