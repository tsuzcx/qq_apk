package com.tencent.mobileqq.search.business.miniprogram.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import java.util.ArrayList;
import java.util.List;

public class MiniProgramSearchResultGroupView
  implements ISearchResultGroupView
{
  protected View a;
  private TextView b;
  private LinearLayout c;
  private List<ISearchResultView> d;
  
  public MiniProgramSearchResultGroupView(ViewGroup paramViewGroup, int paramInt)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.a.findViewById(2131438844));
    this.d = new ArrayList();
    this.c = ((LinearLayout)this.a.findViewById(2131437396));
  }
  
  public TextView a()
  {
    return a();
  }
  
  public TextView b()
  {
    return this.b;
  }
  
  public List<ISearchResultView> c()
  {
    return this.d;
  }
  
  public LinearLayout d()
  {
    return this.c;
  }
  
  public View h()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.miniprogram.view.MiniProgramSearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */