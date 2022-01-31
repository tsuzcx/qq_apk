package com.tencent.open.agent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import java.util.List;

public class CardContainer$PermissionAdapter
  extends AgentBaseAdapter
{
  public int getCount()
  {
    if (this.a.getTag() != null) {
      return 1;
    }
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969255, paramViewGroup, false);
      paramViewGroup = new BindGroupActivity.ViewHolder();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131365770));
      paramView.setTag(paramViewGroup);
    }
    while (this.a.getTag() != null)
    {
      paramViewGroup.a.setText("● 获得你与QQ通讯录绑定的电话号码");
      return paramView;
      paramViewGroup = (BindGroupActivity.ViewHolder)paramView.getTag();
    }
    CardContainer.Permission localPermission = (CardContainer.Permission)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.a.setText("● " + localPermission.a);
    return paramView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer.PermissionAdapter
 * JD-Core Version:    0.7.0.1
 */