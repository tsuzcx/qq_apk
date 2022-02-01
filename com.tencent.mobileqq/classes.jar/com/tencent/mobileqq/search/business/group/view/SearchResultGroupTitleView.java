package com.tencent.mobileqq.search.business.group.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultGroupView;

public class SearchResultGroupTitleView
  extends SearchResultGroupView
{
  private TextView d;
  private TextView e;
  private View f;
  
  public SearchResultGroupTitleView(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624970, paramViewGroup, false);
    this.a.setOnTouchListener(new SearchResultGroupTitleView.1(this));
    this.d = ((TextView)this.a.findViewById(2131447463));
    this.d.setVisibility(0);
    this.e = ((TextView)this.a.findViewById(2131438844));
    if (paramBoolean2) {
      this.e.setVisibility(0);
    }
    this.f = this.a.findViewById(2131432033);
    if (paramBoolean1) {
      this.f.setVisibility(0);
    }
  }
  
  public TextView a()
  {
    return this.d;
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.f;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public TextView b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.view.SearchResultGroupTitleView
 * JD-Core Version:    0.7.0.1
 */