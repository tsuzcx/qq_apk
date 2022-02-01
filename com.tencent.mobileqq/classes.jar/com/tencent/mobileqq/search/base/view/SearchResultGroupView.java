package com.tencent.mobileqq.search.base.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class SearchResultGroupView
  implements ISearchResultGroupView
{
  protected View a;
  protected TextView a;
  protected List<ISearchResultView> a;
  private TextView b;
  
  public SearchResultGroupView() {}
  
  public SearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371472));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368969)));
    this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368975)));
    this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368981)));
    if ((paramInt == 2131559627) || (paramInt == 2131562780))
    {
      this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368987)));
      this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.jdField_a_of_type_AndroidViewView.findViewById(2131368988)));
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.b;
  }
  
  public List<ISearchResultView> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.view.SearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */