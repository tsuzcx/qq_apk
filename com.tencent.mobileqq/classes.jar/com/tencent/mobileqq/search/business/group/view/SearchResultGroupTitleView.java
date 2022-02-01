package com.tencent.mobileqq.search.business.group.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultGroupView;

public class SearchResultGroupTitleView
  extends SearchResultGroupView
{
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public SearchResultGroupTitleView(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559213, paramViewGroup, false);
    this.a.setOnTouchListener(new SearchResultGroupTitleView.1(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.a.findViewById(2131378784));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.c = ((TextView)this.a.findViewById(2131371472));
    if (paramBoolean2) {
      this.c.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidViewView = this.a.findViewById(2131365776);
    if (paramBoolean1) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.view.SearchResultGroupTitleView
 * JD-Core Version:    0.7.0.1
 */