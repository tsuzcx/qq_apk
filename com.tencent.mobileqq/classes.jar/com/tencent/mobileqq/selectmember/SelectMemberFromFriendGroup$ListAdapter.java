package com.tencent.mobileqq.selectmember;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.data.Groups;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class SelectMemberFromFriendGroup$ListAdapter
  extends BaseAdapter
{
  SelectMemberFromFriendGroup$ListAdapter(SelectMemberFromFriendGroup paramSelectMemberFromFriendGroup) {}
  
  public int getCount()
  {
    return SelectMemberFromFriendGroup.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return SelectMemberFromFriendGroup.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.f).inflate(2131626502, null);
      paramView = new SelectMemberFromFriendGroup.ListAdapter.ViewHolder(this);
      paramView.e = ((CheckBox)localView.findViewById(2131430688));
      paramView.c = ((TextView)localView.findViewById(2131434398));
      paramView.d = ((TextView)localView.findViewById(2131434399));
      localView.setTag(paramView);
      localView.setOnClickListener(new SelectMemberFromFriendGroup.ListAdapter.1(this));
    }
    else
    {
      localObject = (SelectMemberFromFriendGroup.ListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    paramView.a = paramInt;
    paramView.b = ((Groups)getItem(paramInt));
    int i = paramView.b.group_friend_count;
    Object localObject = paramView.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ((TextView)localObject).setText(localStringBuilder.toString());
    paramView.c.setText(paramView.b.group_name);
    paramView.e.setTag(paramView);
    if (this.a.a(paramView.b))
    {
      paramView.e.setEnabled(false);
      paramView.e.setChecked(false);
    }
    else
    {
      paramView.e.setEnabled(true);
      paramView.e.setChecked(this.a.a.contains(paramView.b));
    }
    if (SelectMemberFromFriendGroup.a(this.a).size() == 1) {
      localView.setBackgroundResource(2130839629);
    } else if (SelectMemberFromFriendGroup.a(this.a).size() == 2)
    {
      if (paramInt == 0) {
        localView.setBackgroundResource(2130839638);
      } else {
        localView.setBackgroundResource(2130839629);
      }
    }
    else if (paramInt == 0) {
      localView.setBackgroundResource(2130839638);
    } else if (paramInt == SelectMemberFromFriendGroup.a(this.a).size() - 1) {
      localView.setBackgroundResource(2130839629);
    } else {
      localView.setBackgroundResource(2130839632);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberFromFriendGroup.ListAdapter
 * JD-Core Version:    0.7.0.1
 */