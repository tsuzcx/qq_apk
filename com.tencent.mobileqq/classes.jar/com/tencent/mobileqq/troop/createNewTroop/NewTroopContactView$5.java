package com.tencent.mobileqq.troop.createNewTroop;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewTroopContactView$5
  implements AdapterView.OnItemClickListener
{
  NewTroopContactView$5(NewTroopContactView paramNewTroopContactView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = ((ResultRecord)paramView.getTag()).uin;
    if (this.a.a(str))
    {
      NewTroopContactView.a(this.a, str);
      this.a.a.notifyDataSetChanged();
      this.a.b(false);
      NewTroopContactView.a(this.a);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView.5
 * JD-Core Version:    0.7.0.1
 */