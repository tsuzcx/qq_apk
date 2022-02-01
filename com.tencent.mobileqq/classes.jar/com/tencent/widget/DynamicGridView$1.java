package com.tencent.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DynamicGridView$1
  implements AdapterView.OnItemClickListener
{
  DynamicGridView$1(DynamicGridView paramDynamicGridView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!this.a.a()) && (this.a.isEnabled()) && (DynamicGridView.a(this.a) != null)) {
      DynamicGridView.a(this.a).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.1
 * JD-Core Version:    0.7.0.1
 */