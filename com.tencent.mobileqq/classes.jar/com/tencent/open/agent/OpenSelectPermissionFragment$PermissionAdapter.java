package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.List;

class OpenSelectPermissionFragment$PermissionAdapter
  extends AgentBaseAdapter
{
  List<CardContainer.Permission> jdField_a_of_type_JavaUtilList;
  
  private OpenSelectPermissionFragment$PermissionAdapter(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public List<CardContainer.Permission> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<CardContainer.Permission> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
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
    CardContainer.Permission localPermission = (CardContainer.Permission)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment.getActivity().getLayoutInflater().inflate(2131559802, paramViewGroup, false);
      paramView = new OpenSelectPermissionFragment.PermissionViewHolder(null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372880));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131372879));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(localPermission.b);
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new OpenSelectPermissionFragment.PermissionAdapter.1(this, localPermission));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localPermission.a);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      OpenSelectPermissionFragment.PermissionViewHolder localPermissionViewHolder = (OpenSelectPermissionFragment.PermissionViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localPermissionViewHolder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.PermissionAdapter
 * JD-Core Version:    0.7.0.1
 */