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
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131559723, paramViewGroup, false);
      paramView = new DataReportViewer.ViewHolder(this.a, localView);
      localView.setTag(paramView);
      localObject = (ReportData)this.a.a.get(paramInt);
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
      if (!((ReportData)localObject).isLightBlueBg) {
        break label249;
      }
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131166602));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (DataReportViewer.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label249:
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167374));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.DataAdapter
 * JD-Core Version:    0.7.0.1
 */