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
    return this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.b();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GroupListOpenFrame.GroupListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new GroupListOpenFrame.GroupListAdapter.ViewHolder(this);
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559675, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363819));
      localViewHolder.b = ((TextView)paramView.findViewById(2131367832));
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367831));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (GroupListOpenFrame.GroupListAdapter.ViewHolder)paramView.getTag();
    }
    String str = this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramInt);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localViewHolder.b.setText(String.valueOf(this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramInt)));
    int i = (int)(this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a * 10.0F);
    if (paramInt == 0) {
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839449);
    } else if (paramInt == getCount() - 1) {
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839440);
    } else {
      localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839443);
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, 0, i, 0);
    localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new GroupListOpenFrame.GroupListAdapter.1(this, paramInt, str));
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame.GroupListAdapter
 * JD-Core Version:    0.7.0.1
 */