package com.tencent.mobileqq.richstatus;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;

class SignatureHistoryFragment$DataAdapter
  extends BaseAdapter
{
  private SignatureHistoryFragment$DataAdapter(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public int getCount()
  {
    int i = SignatureHistoryFragment.g(this.a).size();
    if (i == 0) {
      return 1;
    }
    return i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= SignatureHistoryFragment.g(this.a).size()) {
      return null;
    }
    return SignatureHistoryFragment.g(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = SignatureHistoryFragment.g(this.a).size();
    if (i == 0) {
      return 2;
    }
    if (paramInt < i) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 2)
    {
      SignatureHistoryFragment.j(this.a).setLayoutParams(new AbsListView.LayoutParams(this.a.a.getWidth(), this.a.a.getHeight()));
      paramView = SignatureHistoryFragment.j(this.a);
    }
    else if (i == 0)
    {
      paramView = SignatureHistoryFragment.a(this.a, paramInt, paramView);
    }
    else
    {
      paramView = SignatureHistoryFragment.a(this.a, paramView);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return 2 != getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.DataAdapter
 * JD-Core Version:    0.7.0.1
 */