package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SelectedAndSearchBar$1
  implements AdapterView.OnItemClickListener
{
  SelectedAndSearchBar$1(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ResultRecord localResultRecord = (ResultRecord)SelectedAndSearchBar.a(this.a).get(paramInt);
    if (SelectedAndSearchBar.a(this.a) != null) {
      SelectedAndSearchBar.a(this.a).a(localResultRecord);
    }
    this.a.a(false);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar.1
 * JD-Core Version:    0.7.0.1
 */