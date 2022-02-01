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
      localView = LayoutInflater.from(this.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity).inflate(2131560457, null);
      paramView = new SelectMemberFromFriendGroup.ListAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364613));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367819));
      paramView.b = ((TextView)localView.findViewById(2131367820));
      localView.setTag(paramView);
      localView.setOnClickListener(new SelectMemberFromFriendGroup.ListAdapter.1(this));
    }
    else
    {
      localObject = (SelectMemberFromFriendGroup.ListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    paramView.jdField_a_of_type_Int = paramInt;
    paramView.jdField_a_of_type_ComTencentMobileqqDataGroups = ((Groups)getItem(paramInt));
    int i = paramView.jdField_a_of_type_ComTencentMobileqqDataGroups.group_friend_count;
    Object localObject = paramView.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ((TextView)localObject).setText(localStringBuilder.toString());
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups.group_name);
    paramView.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramView);
    if (this.a.a(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups))
    {
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    else
    {
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.a.jdField_a_of_type_JavaUtilList.contains(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups));
    }
    if (SelectMemberFromFriendGroup.a(this.a).size() == 1) {
      localView.setBackgroundResource(2130839440);
    } else if (SelectMemberFromFriendGroup.a(this.a).size() == 2)
    {
      if (paramInt == 0) {
        localView.setBackgroundResource(2130839449);
      } else {
        localView.setBackgroundResource(2130839440);
      }
    }
    else if (paramInt == 0) {
      localView.setBackgroundResource(2130839449);
    } else if (paramInt == SelectMemberFromFriendGroup.a(this.a).size() - 1) {
      localView.setBackgroundResource(2130839440);
    } else {
      localView.setBackgroundResource(2130839443);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberFromFriendGroup.ListAdapter
 * JD-Core Version:    0.7.0.1
 */