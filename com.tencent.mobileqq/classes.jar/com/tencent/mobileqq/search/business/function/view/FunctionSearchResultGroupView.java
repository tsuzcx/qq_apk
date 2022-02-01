package com.tencent.mobileqq.search.business.function.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchResultGroupView
  implements ISearchResultGroupView
{
  protected View a;
  private TextView b;
  private TextView c;
  private LinearLayout d;
  private List<ISearchResultView> e;
  private ViewGroup f;
  
  public FunctionSearchResultGroupView(ViewGroup paramViewGroup)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629229, paramViewGroup, false);
    this.c = ((TextView)this.a.findViewById(2131438844));
    this.e = new ArrayList();
    this.d = ((LinearLayout)this.a.findViewById(2131437396));
    this.f = paramViewGroup;
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
    return this.e;
  }
  
  public LinearLayout d()
  {
    return this.d;
  }
  
  public ViewGroup e()
  {
    return this.f;
  }
  
  public View h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.function.view.FunctionSearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */