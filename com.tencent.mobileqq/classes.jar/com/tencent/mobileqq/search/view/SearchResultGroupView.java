package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class SearchResultGroupView
  implements ISearchResultGroupView
{
  private TextView a;
  protected List a;
  protected View b;
  protected TextView c;
  
  public SearchResultGroupView() {}
  
  public SearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131362715));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.b.findViewById(2131365680)));
    this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.b.findViewById(2131365681)));
    this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.b.findViewById(2131365682)));
    if ((paramInt == 2130969233) || (paramInt == 2130971525))
    {
      this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.b.findViewById(2131365683)));
      this.jdField_a_of_type_JavaUtilList.add(new SearchResultView(this.b.findViewById(2131365684)));
    }
  }
  
  public View a()
  {
    return this.b;
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
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */