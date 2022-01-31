package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ContactSearchResultGroupView
  implements ISearchResultGroupView
{
  protected View a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ISearchResultView jdField_a_of_type_ComTencentMobileqqSearchViewISearchResultView;
  private List jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public ContactSearchResultGroupView() {}
  
  public ContactSearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362697));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131374829));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewISearchResultView = new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131374830));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public ISearchResultView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchViewISearchResultView;
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
 * Qualified Name:     com.tencent.mobileqq.search.view.ContactSearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */