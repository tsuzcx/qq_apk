package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultGroupView;

public class SearchResultGroupMessageView
  extends SearchResultGroupView
{
  public View e;
  public TextView f;
  public ImageView g;
  public TextView h;
  public LinearLayout i;
  
  public SearchResultGroupMessageView() {}
  
  public SearchResultGroupMessageView(ViewGroup paramViewGroup)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629230, paramViewGroup, false);
    this.e = this.a.findViewById(2131438867);
    this.f = ((TextView)this.e.findViewById(2131436787));
    this.g = ((ImageView)this.e.findViewById(2131435357));
    this.h = ((TextView)this.e.findViewById(2131431757));
    this.i = ((LinearLayout)this.a.findViewById(2131437396));
  }
  
  public LinearLayout d()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultGroupMessageView
 * JD-Core Version:    0.7.0.1
 */