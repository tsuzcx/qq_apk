package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialog$1
  extends BaseAdapter
{
  QQCustomDialog$1(QQCustomDialog paramQQCustomDialog) {}
  
  public int getCount()
  {
    if (this.a.items != null) {
      return this.a.items.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a.inflater == null)
    {
      localObject = this.a;
      ((QQCustomDialog)localObject).inflater = ((LayoutInflater)((QQCustomDialog)localObject).getContext().getSystemService("layout_inflater"));
    }
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = this.a.inflater.inflate(this.a.getDialogListItemLayout(), null);
      paramView = new QQCustomDialog.Holder(this.a, null);
      paramView.a = ((TextView)((View)localObject).findViewById(2131436134));
      ((View)localObject).setTag(paramView);
    }
    paramView = (QQCustomDialog.Holder)((View)localObject).getTag();
    if (paramView.a != null)
    {
      paramView.a.setText(this.a.items[paramInt]);
      paramView.a.setOnClickListener(new QQCustomDialog.CustomDialogItemOnClickListener(this.a, paramInt));
      int i = paramView.a.getPaddingTop();
      int j = paramView.a.getPaddingLeft();
      int k = paramView.a.getPaddingRight();
      int m = paramView.a.getPaddingBottom();
      if (this.a.items.length == 1) {
        paramView.a.setBackgroundResource(2130839740);
      } else if (paramInt == 0) {
        paramView.a.setBackgroundResource(2130839741);
      } else if (paramInt == this.a.items.length - 1) {
        paramView.a.setBackgroundResource(2130839739);
      }
      paramView.a.setPadding(j, i, k, m);
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.1
 * JD-Core Version:    0.7.0.1
 */