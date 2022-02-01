package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView;
import java.util.ArrayList;
import java.util.List;

public class ApproximateSearchResultGroupView
  implements ISearchResultGroupView
{
  protected View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ISearchResultView jdField_a_of_type_ComTencentMobileqqSearchBaseViewISearchResultView;
  private List<ISearchResultView> jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public ApproximateSearchResultGroupView() {}
  
  public ApproximateSearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371472));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368969)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368975)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368981)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368987)));
    this.jdField_a_of_type_JavaUtilList.add(new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368988)));
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseViewISearchResultView = new ContactSearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368989));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ApproximateSearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */