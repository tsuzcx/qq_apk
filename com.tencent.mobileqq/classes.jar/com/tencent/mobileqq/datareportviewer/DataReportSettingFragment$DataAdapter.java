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
    DataReportSettingFragment.ViewHolder localViewHolder;
    BaseReportDataConfig localBaseReportDataConfig;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131559719, paramViewGroup, false);
      localViewHolder = new DataReportSettingFragment.ViewHolder(this.a);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131369432));
      localViewHolder.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$ItemListener = new DataReportSettingFragment.ItemListener(this.a);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(localViewHolder.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$ItemListener);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(localViewHolder.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$ItemListener);
      paramView.setTag(localViewHolder);
      localBaseReportDataConfig = a(paramInt);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localBaseReportDataConfig.jdField_a_of_type_Boolean);
      if (!(localBaseReportDataConfig instanceof ReportDataConfig)) {
        break label205;
      }
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localBaseReportDataConfig.jdField_a_of_type_JavaLangString + " - " + ((ReportDataConfig)localBaseReportDataConfig).b);
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$ItemListener.a = localBaseReportDataConfig;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localViewHolder = (DataReportSettingFragment.ViewHolder)paramView.getTag();
      break;
      label205:
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localBaseReportDataConfig.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.DataAdapter
 * JD-Core Version:    0.7.0.1
 */