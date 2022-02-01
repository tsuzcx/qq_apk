package com.tencent.mobileqq.qqgift.mvvm.business.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelBaseViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class QQGiftPanelPageAdapter$1
  implements AdapterView.OnItemClickListener
{
  QQGiftPanelPageAdapter$1(QQGiftPanelPageAdapter paramQQGiftPanelPageAdapter, int paramInt) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.b.d != null) && (this.b.c.size() > this.a))
    {
      GiftServiceData localGiftServiceData = (GiftServiceData)((List)this.b.c.get(this.a)).get(paramInt);
      int i = this.a;
      if (i > 0) {
        i = (i - 1) * 8;
      } else {
        i = 0;
      }
      this.b.d.a(localGiftServiceData, i + paramInt);
      this.b.d.b(localGiftServiceData, paramView);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelPageAdapter.1
 * JD-Core Version:    0.7.0.1
 */