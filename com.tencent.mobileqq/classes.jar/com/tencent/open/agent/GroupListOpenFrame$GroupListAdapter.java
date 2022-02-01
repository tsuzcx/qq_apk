package com.tencent.open.agent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GroupListOpenFrame$GroupListAdapter
  extends AgentBaseAdapter
{
  protected GroupListOpenFrame$GroupListAdapter(GroupListOpenFrame paramGroupListOpenFrame) {}
  
  public int getCount()
  {
    return this.a.i.c();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GroupListOpenFrame.GroupListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new GroupListOpenFrame.GroupListAdapter.ViewHolder(this);
      paramView = this.a.m.inflate(2131625706, this.a.a, false);
      localViewHolder.a = ((TextView)paramView.findViewById(2131429754));
      localViewHolder.b = ((TextView)paramView.findViewById(2131434411));
      localViewHolder.c = ((RelativeLayout)paramView.findViewById(2131434410));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (GroupListOpenFrame.GroupListAdapter.ViewHolder)paramView.getTag();
    }
    String str = this.a.i.c(paramInt);
    localViewHolder.a.setText(str);
    localViewHolder.b.setText(String.valueOf(this.a.i.b(paramInt)));
    int i = (int)(this.a.j.D * 10.0F);
    if (paramInt == 0) {
      localViewHolder.c.setBackgroundResource(2130839638);
    } else if (paramInt == getCount() - 1) {
      localViewHolder.c.setBackgroundResource(2130839629);
    } else {
      localViewHolder.c.setBackgroundResource(2130839632);
    }
    localViewHolder.c.setPadding(i, 0, i, 0);
    localViewHolder.c.setOnClickListener(new GroupListOpenFrame.GroupListAdapter.1(this, paramInt, str));
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame.GroupListAdapter
 * JD-Core Version:    0.7.0.1
 */