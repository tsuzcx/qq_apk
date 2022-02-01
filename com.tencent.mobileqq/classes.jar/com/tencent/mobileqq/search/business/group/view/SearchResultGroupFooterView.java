package com.tencent.mobileqq.search.business.group.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultGroupView;

public class SearchResultGroupFooterView
  extends SearchResultGroupView
{
  public LinearLayout d;
  public TextView e;
  public View f;
  
  public SearchResultGroupFooterView(ViewGroup paramViewGroup)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624968, paramViewGroup, false);
    this.d = ((LinearLayout)this.a.findViewById(2131433591));
    this.e = ((TextView)this.a.findViewById(2131433593));
    this.f = this.a.findViewById(2131432033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.view.SearchResultGroupFooterView
 * JD-Core Version:    0.7.0.1
 */