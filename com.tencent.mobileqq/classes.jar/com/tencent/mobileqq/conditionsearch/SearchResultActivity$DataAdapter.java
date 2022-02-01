package com.tencent.mobileqq.conditionsearch;

import SummaryCard.CondFitUser;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SearchResultActivity$DataAdapter
  extends BaseAdapter
{
  private SearchResultActivity$DataAdapter(SearchResultActivity paramSearchResultActivity) {}
  
  public int getCount()
  {
    int j = this.a.f.size();
    int i;
    if (this.a.j != 0) {
      i = 1;
    } else {
      i = 0;
    }
    return j + i;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.a.f.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (getItemViewType(paramInt) == 0)
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131627353, null);
        localView.setOnClickListener(this.a);
        paramView = new SearchResultActivity.ItemViewHolder();
        paramView.a = ((ImageView)localView.findViewById(2131434916));
        paramView.b = ((TextView)localView.findViewById(2131439319));
        paramView.c = ((TextView)localView.findViewById(2131446000));
        paramView.e = ((InterestLabelTextView)localView.findViewById(2131434144));
        paramView.f = ((InterestLabelTextView)localView.findViewById(2131450348));
        paramView.d = ((InterestLabelTextView)localView.findViewById(2131430381));
        paramView.g = ((InterestLabelTextView)localView.findViewById(2131437682));
        localView.setTag(paramView);
      }
      paramView = (SearchResultActivity.ItemViewHolder)localView.getTag();
      localObject = (CondFitUser)this.a.f.get(paramInt);
      localObject = this.a.a(paramView, (CondFitUser)localObject);
      paramView = localView;
      if (SearchResultActivity.a)
      {
        localView.setContentDescription((CharSequence)localObject);
        paramView = localView;
      }
    }
    else
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131625460, null);
        localView.setOnClickListener(this.a);
        paramView = new SearchResultActivity.MoreViewHolder();
        localView.setTag(paramView);
        paramView.a = ((ProgressBar)localView.findViewById(2131444560));
        localView.findViewById(2131437616).setVisibility(8);
        paramView.b = ((TextView)localView.findViewById(2131438894));
      }
      if (this.a.j == 1)
      {
        paramView = this.a;
        paramView.j = 2;
        SearchResultActivity.g(paramView);
      }
      localObject = (SearchResultActivity.MoreViewHolder)localView.getTag();
      if (this.a.j == 3)
      {
        ((SearchResultActivity.MoreViewHolder)localObject).a.setVisibility(8);
        ((SearchResultActivity.MoreViewHolder)localObject).b.setText(HardCodeUtil.a(2131911121));
        paramView = localView;
      }
      else if (this.a.j == 2)
      {
        ((SearchResultActivity.MoreViewHolder)localObject).a.setVisibility(0);
        ((SearchResultActivity.MoreViewHolder)localObject).b.setText(HardCodeUtil.a(2131911113));
        paramView = localView;
      }
      else
      {
        paramView = localView;
        if (this.a.j == 4)
        {
          ((SearchResultActivity.MoreViewHolder)localObject).a.setVisibility(8);
          ((SearchResultActivity.MoreViewHolder)localObject).b.setText(HardCodeUtil.a(2131911112));
          paramView = localView;
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity.DataAdapter
 * JD-Core Version:    0.7.0.1
 */