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
    return b().size();
  }
  
  private ArrayList<QQStayTimeInfo> b()
  {
    return UECPageStayViewer.f(this.a);
  }
  
  public QQStayTimeInfo a(int paramInt)
  {
    return (QQStayTimeInfo)b().get(paramInt);
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131627861, paramViewGroup, false);
      localObject = new UECPageStayViewer.QueryViewHolder(this.a, paramView);
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (UECPageStayViewer.QueryViewHolder)paramView.getTag();
    }
    QQStayTimeInfo localQQStayTimeInfo = (QQStayTimeInfo)b().get(paramInt);
    ((UECPageStayViewer.QueryViewHolder)localObject).a.setText(localQQStayTimeInfo.page_info);
    ((UECPageStayViewer.QueryViewHolder)localObject).b.setText(localQQStayTimeInfo.page_info_ext);
    Object localObject = ((UECPageStayViewer.QueryViewHolder)localObject).c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localQQStayTimeInfo.stay_time);
    localStringBuilder.append("");
    ((TextView)localObject).setText(localStringBuilder.toString());
    if (paramInt % 2 == 0) {
      paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167537));
    } else {
      paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131168464));
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayViewer.TableQueryAdapter
 * JD-Core Version:    0.7.0.1
 */