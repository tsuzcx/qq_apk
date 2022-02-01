package com.tencent.mobileqq.datareportviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class DataReportSettingFragment$DataAdapter
  extends BaseAdapter
{
  protected DataReportSettingFragment$DataAdapter(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public BaseReportDataConfig a(int paramInt)
  {
    return (BaseReportDataConfig)this.a.a.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.a.size();
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
      localView = LayoutInflater.from(this.a.getBaseActivity()).inflate(2131559595, paramViewGroup, false);
      paramView = new DataReportSettingFragment.ViewHolder(this.a);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131369160));
      paramView.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$ItemListener = new DataReportSettingFragment.ItemListener(this.a);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(paramView.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$ItemListener);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(paramView.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$ItemListener);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (DataReportSettingFragment.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = a(paramInt);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((BaseReportDataConfig)localObject).jdField_a_of_type_Boolean);
    if ((localObject instanceof ReportDataConfig))
    {
      FormSwitchItem localFormSwitchItem = paramView.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((BaseReportDataConfig)localObject).jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" - ");
      localStringBuilder.append(((ReportDataConfig)localObject).b);
      localFormSwitchItem.setText(localStringBuilder.toString());
    }
    else
    {
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(((BaseReportDataConfig)localObject).jdField_a_of_type_JavaLangString);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$ItemListener.a = ((BaseReportDataConfig)localObject);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.DataAdapter
 * JD-Core Version:    0.7.0.1
 */