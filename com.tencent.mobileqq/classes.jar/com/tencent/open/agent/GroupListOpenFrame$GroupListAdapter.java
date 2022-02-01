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
    View localView;
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = new GroupListOpenFrame.GroupListAdapter.ViewHolder(this);
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559798, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363891));
      paramView.b = ((TextView)localView.findViewById(2131368080));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131368079));
      localView.setTag(paramView);
      localObject = this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.b.setText(String.valueOf(this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramInt)));
      i = (int)(10.0F * this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a);
      if (paramInt != 0) {
        break label222;
      }
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839591);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, 0, i, 0);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new GroupListOpenFrame.GroupListAdapter.1(this, paramInt, (String)localObject));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (GroupListOpenFrame.GroupListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label222:
      if (paramInt == getCount() - 1) {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839582);
      } else {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839585);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame.GroupListAdapter
 * JD-Core Version:    0.7.0.1
 */