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
  private List<ISearchResultView> jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public ApproximateSearchResultGroupView() {}
  
  public ApproximateSearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371850));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131369240)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131369246)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131369252)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131369258)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131369259)));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewISearchResultView = new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131369260));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List<ISearchResultView> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ApproximateSearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */