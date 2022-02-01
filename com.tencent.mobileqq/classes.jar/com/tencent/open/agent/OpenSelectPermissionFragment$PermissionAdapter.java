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
  List<Permission> a;
  
  private OpenSelectPermissionFragment$PermissionAdapter(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void a(List<Permission> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Permission localPermission = (Permission)this.a.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.b.getQBaseActivity().getLayoutInflater().inflate(2131625710, paramViewGroup, false);
      paramView = new OpenSelectPermissionFragment.PermissionViewHolder(null);
      paramView.a = ((TextView)localView.findViewById(2131439984));
      paramView.b = ((Switch)localView.findViewById(2131439983));
      localView.setTag(paramView);
    }
    else
    {
      OpenSelectPermissionFragment.PermissionViewHolder localPermissionViewHolder = (OpenSelectPermissionFragment.PermissionViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localPermissionViewHolder;
    }
    paramView.b.setChecked(localPermission.f);
    paramView.b.setOnCheckedChangeListener(new OpenSelectPermissionFragment.PermissionAdapter.1(this, localPermission));
    paramView.a.setText(localPermission.b);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.PermissionAdapter
 * JD-Core Version:    0.7.0.1
 */