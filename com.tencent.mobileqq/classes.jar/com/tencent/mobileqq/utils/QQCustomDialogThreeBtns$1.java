package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogThreeBtns$1
  extends BaseAdapter
{
  QQCustomDialogThreeBtns$1(QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns) {}
  
  public int getCount()
  {
    if (this.this$0.items != null) {
      return this.this$0.items.length;
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
    if (this.this$0.inflater == null) {
      this.this$0.inflater = ((LayoutInflater)this.this$0.getContext().getSystemService("layout_inflater"));
    }
    QQCustomDialogThreeBtns.Holder localHolder;
    if (paramView == null)
    {
      paramView = this.this$0.inflater.inflate(2131559004, null);
      localHolder = new QQCustomDialogThreeBtns.Holder(this.this$0, null);
      localHolder.text = ((TextView)paramView.findViewById(2131369017));
      paramView.setTag(localHolder);
    }
    for (;;)
    {
      localHolder = (QQCustomDialogThreeBtns.Holder)paramView.getTag();
      int i;
      int j;
      int k;
      int m;
      if (localHolder.text != null)
      {
        localHolder.text.setText(this.this$0.items[paramInt]);
        localHolder.text.setOnClickListener(new QQCustomDialogThreeBtns.CustomDialogItemOnClickListener(this.this$0, paramInt));
        i = localHolder.text.getPaddingTop();
        j = localHolder.text.getPaddingLeft();
        k = localHolder.text.getPaddingRight();
        m = localHolder.text.getPaddingBottom();
        if (this.this$0.items.length != 1) {
          break label232;
        }
        localHolder.text.setBackgroundResource(2130839583);
      }
      for (;;)
      {
        localHolder.text.setPadding(j, i, k, m);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label232:
        if (paramInt == 0) {
          localHolder.text.setBackgroundResource(2130839584);
        } else if (paramInt == this.this$0.items.length - 1) {
          localHolder.text.setBackgroundResource(2130839582);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogThreeBtns.1
 * JD-Core Version:    0.7.0.1
 */