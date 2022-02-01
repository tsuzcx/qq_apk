package com.tencent.mobileqq.qqfeatureswitch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class SwitchManageAdapter
  extends BaseAdapter
{
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private List<FeatureSwitch> jdField_a_of_type_JavaUtilList;
  
  public SwitchManageAdapter(QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
  }
  
  private void a(int paramInt, FormSwitchItem paramFormSwitchItem)
  {
    a(paramFormSwitchItem);
    FeatureSwitch localFeatureSwitch = (FeatureSwitch)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setText(localFeatureSwitch.mSwitchName);
    paramFormSwitchItem.setChecked(localFeatureSwitch.mSwitchEnable);
    paramFormSwitchItem.setOnCheckedChangeListener(new SwitchManageAdapter.1(this, localFeatureSwitch));
  }
  
  private void a(FormSwitchItem paramFormSwitchItem)
  {
    paramFormSwitchItem.setEnabled(false);
    paramFormSwitchItem.setClickable(false);
  }
  
  public void a(List<FeatureSwitch> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).inflate(2131562904, paramViewGroup, false);
    }
    a(paramInt, (FormSwitchItem)localView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.SwitchManageAdapter
 * JD-Core Version:    0.7.0.1
 */