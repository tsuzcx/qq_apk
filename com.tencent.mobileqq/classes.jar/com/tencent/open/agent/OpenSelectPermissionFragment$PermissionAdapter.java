package com.tencent.open.agent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import com.tencent.open.agent.entity.Permission;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.List;

class OpenSelectPermissionFragment$PermissionAdapter
  extends AgentBaseAdapter
{
  List<Permission> jdField_a_of_type_JavaUtilList;
  
  private OpenSelectPermissionFragment$PermissionAdapter(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void a(List<Permission> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Permission localPermission = (Permission)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment.getQBaseActivity().getLayoutInflater().inflate(2131559679, paramViewGroup, false);
      paramView = new OpenSelectPermissionFragment.PermissionViewHolder(null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372462));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131372461));
      localView.setTag(paramView);
    }
    else
    {
      OpenSelectPermissionFragment.PermissionViewHolder localPermissionViewHolder = (OpenSelectPermissionFragment.PermissionViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localPermissionViewHolder;
    }
    paramView.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(localPermission.b);
    paramView.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new OpenSelectPermissionFragment.PermissionAdapter.1(this, localPermission));
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localPermission.a);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.PermissionAdapter
 * JD-Core Version:    0.7.0.1
 */