package com.tencent.mobileqq.search.business.mostused.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import java.util.ArrayList;
import java.util.List;

public class MostUsedSearchResultGroupView
  implements ISearchResultGroupView
{
  protected View a;
  private LinearLayout b;
  private List<ISearchResultView> c;
  
  public MostUsedSearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = new ArrayList();
    this.b = ((LinearLayout)this.a.findViewById(2131437396));
  }
  
  public TextView a()
  {
    return a();
  }
  
  public TextView b()
  {
    return null;
  }
  
  public List<ISearchResultView> c()
  {
    return this.c;
  }
  
  public LinearLayout d()
  {
    return this.b;
  }
  
  public View h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.mostused.view.MostUsedSearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */