package com.tencent.mobileqq.vastrash.uec;

import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class UECPageStayViewer$TableQueryAdapter
  extends BaseAdapter
{
  protected UECPageStayViewer$TableQueryAdapter(UECPageStayViewer paramUECPageStayViewer) {}
  
  private int a()
  {
    return a().size();
  }
  
  private ArrayList<QQStayTimeInfo> a()
  {
    return UECPageStayViewer.a(this.a);
  }
  
  public QQStayTimeInfo a(int paramInt)
  {
    return (QQStayTimeInfo)a().get(paramInt);
  }
  
  public int getCount()
  {
    return a();
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
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131561652, paramViewGroup, false);
      paramView = new UECPageStayViewer.QueryViewHolder(this.a, localView);
      localView.setTag(paramView);
      localObject = (QQStayTimeInfo)a().get(paramInt);
      paramView.a.setText(((QQStayTimeInfo)localObject).page_info);
      paramView.b.setText(((QQStayTimeInfo)localObject).page_info_ext);
      paramView.c.setText(((QQStayTimeInfo)localObject).stay_time + "");
      if (paramInt % 2 != 0) {
        break label172;
      }
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131166602));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (UECPageStayViewer.QueryViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label172:
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167374));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayViewer.TableQueryAdapter
 * JD-Core Version:    0.7.0.1
 */