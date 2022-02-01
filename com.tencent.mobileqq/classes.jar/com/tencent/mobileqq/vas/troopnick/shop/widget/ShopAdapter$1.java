package com.tencent.mobileqq.vas.troopnick.shop.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShopAdapter$1
  implements View.OnClickListener
{
  long a = 0L;
  
  ShopAdapter$1(ShopAdapter paramShopAdapter) {}
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a;
    if ((l2 == 0L) || (l1 - l2 > 2000L))
    {
      ShopAdapter.a(this.b).b();
      this.a = l1;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter.1
 * JD-Core Version:    0.7.0.1
 */