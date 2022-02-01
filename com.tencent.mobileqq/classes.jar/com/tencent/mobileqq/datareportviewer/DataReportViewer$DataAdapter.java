package com.tencent.mobileqq.datareportviewer;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class DataReportViewer$DataAdapter
  extends BaseAdapter
{
  protected DataReportViewer$DataAdapter(DataReportViewer paramDataReportViewer) {}
  
  public int getCount()
  {
    return this.a.h.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.h.get(paramInt);
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
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131625628, paramViewGroup, false);
      paramView = new DataReportViewer.ViewHolder(this.a, localView);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (DataReportViewer.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (ReportData)this.a.h.get(paramInt);
    paramView.a.setText(((ReportData)localObject).table);
    paramView.b.setText(((ReportData)localObject).mainAction);
    paramView.c.setText(((ReportData)localObject).subAction);
    paramView.d.setText(((ReportData)localObject).actionName);
    paramView.e.setText(String.valueOf(((ReportData)localObject).opType));
    paramView.f.setText(String.valueOf(((ReportData)localObject).result));
    paramView.g.setText(((ReportData)localObject).r2);
    paramView.h.setText(((ReportData)localObject).r3);
    paramView.i.setText(((ReportData)localObject).r4);
    paramView.j.setText(((ReportData)localObject).r5);
    if (((ReportData)localObject).isLightBlueBg) {
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167537));
    } else {
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131168464));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.DataAdapter
 * JD-Core Version:    0.7.0.1
 */