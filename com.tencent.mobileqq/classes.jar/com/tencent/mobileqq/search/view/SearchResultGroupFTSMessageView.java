package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class SearchResultGroupFTSMessageView
  extends SearchResultGroupMessageView
{
  public LinearLayout d;
  
  public SearchResultGroupFTSMessageView(ViewGroup paramViewGroup)
  {
    this.a = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629228, paramViewGroup, false);
    this.b = ((TextView)this.a.findViewById(2131438844));
    this.d = ((LinearLayout)this.a.findViewById(2131437396));
    this.c = new ArrayList();
    this.e = this.a.findViewById(2131438867);
    this.f = ((TextView)this.e.findViewById(2131436787));
  }
  
  public LinearLayout d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultGroupFTSMessageView
 * JD-Core Version:    0.7.0.1
 */