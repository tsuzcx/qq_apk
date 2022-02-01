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
    return a().size();
  }
  
  private List<QueryData> a()
  {
    return TableQueryViewer.a(this.a);
  }
  
  public int getCount()
  {
    return a();
  }
  
  public Object getItem(int paramInt)
  {
    return a().get(paramInt);
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
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131563081, paramViewGroup, false);
      paramView = new TableQueryViewer.QueryViewHolder(this.a, localView);
      localView.setTag(paramView);
      localObject = (QueryData)a().get(paramInt);
      paramView.a.setText(((QueryData)localObject).b);
      paramView.d.setText(((QueryData)localObject).k);
      paramView.b.setText(((QueryData)localObject).c);
      paramView.c.setText(((QueryData)localObject).f);
      if (paramInt % 2 != 0) {
        break label168;
      }
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131166602));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (TableQueryViewer.QueryViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label168:
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167374));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer.TableQueryAdapter
 * JD-Core Version:    0.7.0.1
 */