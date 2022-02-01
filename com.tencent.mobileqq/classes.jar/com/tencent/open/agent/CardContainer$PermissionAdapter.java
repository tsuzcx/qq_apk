package com.tencent.open.agent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    View localView;
    if (paramView == null)
    {
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559790, paramViewGroup, false);
      paramView = new CardContainer.ViewHolder();
      paramView.a = ((TextView)localView.findViewById(2131372863));
      localView.setTag(paramView);
      if (this.a.getTag() == null) {
        break label103;
      }
      paramView.a.setText("● 获得你与QQ通讯录绑定的电话号码");
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      Object localObject = (CardContainer.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label103:
      localObject = (CardContainer.Permission)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.a.setText("● " + ((CardContainer.Permission)localObject).a);
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer.PermissionAdapter
 * JD-Core Version:    0.7.0.1
 */