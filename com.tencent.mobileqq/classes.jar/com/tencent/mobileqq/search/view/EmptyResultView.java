package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class EmptyResultView
  implements ISearchResultGroupView
{
  protected View a;
  
  public EmptyResultView(ViewGroup paramViewGroup)
  {
    this.a = new LinearLayout(paramViewGroup.getContext());
    this.a.setVisibility(8);
  }
  
  public View a()
  {
    return this.a;
  }
  
  public TextView a()
  {
    return null;
  }
  
  public List a()
  {
    return null;
  }
  
  public TextView b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.EmptyResultView
 * JD-Core Version:    0.7.0.1
 */