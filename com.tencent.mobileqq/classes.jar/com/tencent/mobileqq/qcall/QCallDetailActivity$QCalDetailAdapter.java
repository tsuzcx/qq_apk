package com.tencent.mobileqq.qcall;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class QCallDetailActivity$QCalDetailAdapter
  extends BaseAdapter
{
  public List<QCallRecord> a = new CopyOnWriteArrayList();
  
  public QCallDetailActivity$QCalDetailAdapter(QCallDetailActivity paramQCallDetailActivity) {}
  
  public int getCount()
  {
    if (this.a == null) {
      this.a = new CopyOnWriteArrayList();
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((QCallRecord)this.a.get(paramInt)).type == QCallRecord.TYPE_DATE) {
      return QCallRecord.TYPE_DATE;
    }
    return QCallRecord.TYPE_REALRECORD;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallDetailActivity.QCalDetailAdapter
 * JD-Core Version:    0.7.0.1
 */