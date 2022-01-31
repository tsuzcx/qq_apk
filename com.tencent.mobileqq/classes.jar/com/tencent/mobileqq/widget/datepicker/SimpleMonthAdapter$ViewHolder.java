package com.tencent.mobileqq.widget.datepicker;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AbsListView.LayoutParams;

public class SimpleMonthAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  final SimpleMonthView a;
  
  public SimpleMonthAdapter$ViewHolder(View paramView, SimpleMonthView.OnDayClickListener paramOnDayClickListener)
  {
    super(paramView);
    this.a = ((SimpleMonthView)paramView);
    this.a.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    this.a.setClickable(true);
    this.a.setOnDayClickListener(paramOnDayClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.SimpleMonthAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */