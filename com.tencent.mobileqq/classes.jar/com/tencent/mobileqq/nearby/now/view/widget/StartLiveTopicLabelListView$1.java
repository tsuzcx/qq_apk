package com.tencent.mobileqq.nearby.now.view.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class StartLiveTopicLabelListView$1
  extends BaseAdapter
{
  StartLiveTopicLabelListView$1(StartLiveTopicLabelListView paramStartLiveTopicLabelListView) {}
  
  public int getCount()
  {
    if ((StartLiveTopicLabelListView.a(this.a) == null) || (StartLiveTopicLabelListView.a(this.a).size() == 0)) {
      return 0;
    }
    return StartLiveTopicLabelListView.a(this.a).size();
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
    Object localObject;
    if (paramView == null)
    {
      paramView = new StartLiveTopicLabelListView.ViewHolder(this.a, null);
      localObject = new TopicViewItem(StartLiveTopicLabelListView.a(this.a));
      ((View)localObject).setTag(paramView);
      paramView.a = ((String)StartLiveTopicLabelListView.a(this.a).get(paramInt));
      if (!HardCodeUtil.a(2131714226).equals(paramView.a)) {
        break label162;
      }
      ((View)localObject).setBackgroundResource(StartLiveTopicLabelListView.a(this.a));
      ((TopicViewItem)localObject).setTextColor(StartLiveTopicLabelListView.b(this.a));
    }
    for (;;)
    {
      ((View)localObject).setOnClickListener(new StartLiveTopicLabelListView.1.1(this));
      ((TopicViewItem)localObject).setText(paramView.a);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      StartLiveTopicLabelListView.ViewHolder localViewHolder = (StartLiveTopicLabelListView.ViewHolder)paramView.getTag();
      localObject = paramView;
      paramView = localViewHolder;
      break;
      label162:
      ((View)localObject).setBackgroundResource(StartLiveTopicLabelListView.c(this.a));
      ((TopicViewItem)localObject).setTextColor(StartLiveTopicLabelListView.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView.1
 * JD-Core Version:    0.7.0.1
 */