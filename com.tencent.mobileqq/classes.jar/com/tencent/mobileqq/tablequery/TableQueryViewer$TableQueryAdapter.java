package com.tencent.mobileqq.tablequery;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class TableQueryViewer$TableQueryAdapter
  extends BaseAdapter
{
  protected TableQueryViewer$TableQueryAdapter(TableQueryViewer paramTableQueryViewer) {}
  
  private int a()
  {
    return b().size();
  }
  
  private List<QueryData> b()
  {
    return TableQueryViewer.a(this.a);
  }
  
  public int getCount()
  {
    return a();
  }
  
  public Object getItem(int paramInt)
  {
    return b().get(paramInt);
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
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131629368, paramViewGroup, false);
      paramView = new TableQueryViewer.QueryViewHolder(this.a, localView);
      localView.setTag(paramView);
    }
    else
    {
      localObject = (TableQueryViewer.QueryViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (QueryData)b().get(paramInt);
    paramView.a.setText(((QueryData)localObject).b);
    paramView.d.setText(((QueryData)localObject).k);
    paramView.b.setText(((QueryData)localObject).c);
    paramView.c.setText(((QueryData)localObject).f);
    if (paramInt % 2 == 0) {
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167537));
    } else {
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131168464));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer.TableQueryAdapter
 * JD-Core Version:    0.7.0.1
 */