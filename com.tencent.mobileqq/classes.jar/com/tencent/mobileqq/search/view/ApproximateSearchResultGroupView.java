package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ApproximateSearchResultGroupView
  implements ISearchResultGroupView
{
  protected View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ISearchResultView jdField_a_of_type_ComTencentMobileqqSearchViewISearchResultView;
  private List jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public ApproximateSearchResultGroupView() {}
  
  public ApproximateSearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362720));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131365685)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131365686)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131365687)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131365688)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131365689)));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewISearchResultView = new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131375068));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ApproximateSearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */