package com.tencent.mobileqq.nearby.now.view.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TopicLabelListView$1
  extends BaseAdapter
{
  TopicLabelListView$1(TopicLabelListView paramTopicLabelListView) {}
  
  public int getCount()
  {
    if ((TopicLabelListView.a(this.a) != null) && (TopicLabelListView.a(this.a).size() != 0)) {
      return TopicLabelListView.a(this.a).size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TopicLabelListView.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new TopicLabelListView.ViewHolder(this.a, null);
      paramView = new LabelViewItem(TopicLabelListView.a(this.a));
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (TopicLabelListView.ViewHolder)paramView.getTag();
    }
    localViewHolder.a = ((String)TopicLabelListView.a(this.a).get(paramInt));
    ((LabelViewItem)paramView).setText(localViewHolder.a);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView.1
 * JD-Core Version:    0.7.0.1
 */