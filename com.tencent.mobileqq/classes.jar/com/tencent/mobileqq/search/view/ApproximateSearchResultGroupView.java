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
  private TextView b;
  private TextView c;
  private List<ISearchResultView> d;
  private ISearchResultView e;
  
  public ApproximateSearchResultGroupView() {}
  
  public ApproximateSearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.a.findViewById(2131438844));
    this.d = new ArrayList();
    this.d.add(new ContactSearchResultView(this.a.findViewById(2131435922)));
    this.d.add(new ContactSearchResultView(this.a.findViewById(2131435928)));
    this.d.add(new ContactSearchResultView(this.a.findViewById(2131435934)));
    this.d.add(new ContactSearchResultView(this.a.findViewById(2131435940)));
    this.d.add(new ContactSearchResultView(this.a.findViewById(2131435941)));
    this.e = new ContactSearchResultView(this.a.findViewById(2131435942));
  }
  
  public TextView a()
  {
    return this.b;
  }
  
  public TextView b()
  {
    return this.c;
  }
  
  public List<ISearchResultView> c()
  {
    return this.d;
  }
  
  public View h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ApproximateSearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */