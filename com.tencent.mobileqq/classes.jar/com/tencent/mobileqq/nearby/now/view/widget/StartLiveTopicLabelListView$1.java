package com.tencent.mobileqq.nearby.now.view.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class StartLiveTopicLabelListView$1
  extends BaseAdapter
{
  StartLiveTopicLabelListView$1(StartLiveTopicLabelListView paramStartLiveTopicLabelListView) {}
  
  public int getCount()
  {
    if ((StartLiveTopicLabelListView.a(this.a) != null) && (StartLiveTopicLabelListView.a(this.a).size() != 0)) {
      return StartLiveTopicLabelListView.a(this.a).size();
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
    StartLiveTopicLabelListView.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new StartLiveTopicLabelListView.ViewHolder(this.a, null);
      paramView = new TopicViewItem(StartLiveTopicLabelListView.a(this.a));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (StartLiveTopicLabelListView.ViewHolder)paramView.getTag();
    }
    localViewHolder.a = ((String)StartLiveTopicLabelListView.a(this.a).get(paramInt));
    if (HardCodeUtil.a(((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQStrStartlivBe188c1d()).equals(localViewHolder.a))
    {
      paramView.setBackgroundResource(StartLiveTopicLabelListView.a(this.a));
      ((TopicViewItem)paramView).setTextColor(StartLiveTopicLabelListView.b(this.a));
    }
    else
    {
      paramView.setBackgroundResource(StartLiveTopicLabelListView.c(this.a));
      ((TopicViewItem)paramView).setTextColor(StartLiveTopicLabelListView.d(this.a));
    }
    paramView.setOnClickListener(new StartLiveTopicLabelListView.1.1(this));
    ((TopicViewItem)paramView).setText(localViewHolder.a);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView.1
 * JD-Core Version:    0.7.0.1
 */