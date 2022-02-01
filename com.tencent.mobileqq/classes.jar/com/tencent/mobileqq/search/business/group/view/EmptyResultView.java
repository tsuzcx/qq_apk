package com.tencent.mobileqq.search.business.group.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
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
  
  public List<ISearchResultView> a()
  {
    return null;
  }
  
  public TextView b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.view.EmptyResultView
 * JD-Core Version:    0.7.0.1
 */