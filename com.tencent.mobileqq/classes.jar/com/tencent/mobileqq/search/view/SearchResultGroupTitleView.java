package com.tencent.mobileqq.search.view;

import ahiu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class SearchResultGroupTitleView
  extends SearchResultGroupView
{
  public View a;
  private TextView a;
  private TextView b;
  private View c;
  
  public SearchResultGroupTitleView(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969023, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new ahiu(this));
    paramViewGroup = (LinearLayout)((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131364741)).getParent();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      paramViewGroup.setBackgroundResource(2130838576);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363360));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362697));
      if (paramBoolean2) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131363905);
      if (paramBoolean1) {
        this.c.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131364742);
      return;
      paramViewGroup.setBackgroundResource(2130838575);
    }
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.c;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultGroupTitleView
 * JD-Core Version:    0.7.0.1
 */