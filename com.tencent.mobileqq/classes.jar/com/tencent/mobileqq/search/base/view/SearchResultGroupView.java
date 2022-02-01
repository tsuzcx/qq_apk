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
  protected TextView b;
  protected List<ISearchResultView> c;
  private TextView d;
  
  public SearchResultGroupView() {}
  
  public SearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.a.findViewById(2131438844));
    this.c = new ArrayList();
    this.c.add(new SearchResultView(this.a.findViewById(2131435922)));
    this.c.add(new SearchResultView(this.a.findViewById(2131435928)));
    this.c.add(new SearchResultView(this.a.findViewById(2131435934)));
    if ((paramInt == 2131625656) || (paramInt == 2131629225))
    {
      this.c.add(new SearchResultView(this.a.findViewById(2131435940)));
      this.c.add(new SearchResultView(this.a.findViewById(2131435941)));
    }
  }
  
  public TextView a()
  {
    return this.d;
  }
  
  public TextView b()
  {
    return this.b;
  }
  
  public List<ISearchResultView> c()
  {
    return this.c;
  }
  
  public View h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.view.SearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */