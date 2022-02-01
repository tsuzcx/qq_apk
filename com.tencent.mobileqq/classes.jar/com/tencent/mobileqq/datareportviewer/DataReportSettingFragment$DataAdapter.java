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
    return (BaseReportDataConfig)this.a.d.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.d.size();
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
      localView = LayoutInflater.from(this.a.getBaseActivity()).inflate(2131625624, paramViewGroup, false);
      paramView = new DataReportSettingFragment.ViewHolder(this.a);
      paramView.a = ((FormSwitchItem)localView.findViewById(2131436133));
      paramView.b = new DataReportSettingFragment.ItemListener(this.a);
      paramView.a.setOnCheckedChangeListener(paramView.b);
      paramView.a.setOnLongClickListener(paramView.b);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (DataReportSettingFragment.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = a(paramInt);
    paramView.a.setChecked(((BaseReportDataConfig)localObject).b);
    if ((localObject instanceof ReportDataConfig))
    {
      FormSwitchItem localFormSwitchItem = paramView.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((BaseReportDataConfig)localObject).a);
      localStringBuilder.append(" - ");
      localStringBuilder.append(((ReportDataConfig)localObject).c);
      localFormSwitchItem.setText(localStringBuilder.toString());
    }
    else
    {
      paramView.a.setText(((BaseReportDataConfig)localObject).a);
    }
    paramView.b.a = ((BaseReportDataConfig)localObject);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.DataAdapter
 * JD-Core Version:    0.7.0.1
 */