package com.tencent.mobileqq.vas.troopnick.shop.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShopAdapter$ItemOnClickListener
  implements View.OnClickListener
{
  private final ShopAdapter.DataItem b;
  private final boolean c;
  
  public ShopAdapter$ItemOnClickListener(ShopAdapter paramShopAdapter, ShopAdapter.DataItem paramDataItem, boolean paramBoolean)
  {
    this.b = paramDataItem;
    this.c = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    this.a.a = this.b.e;
    ShopAdapter.a(this.a, this.b);
    ShopAdapter localShopAdapter = this.a;
    ShopAdapter.b(localShopAdapter, ShopAdapter.b(localShopAdapter));
    if (this.c) {
      ShopAdapter.a(this.a).a();
    }
    int j = this.b.e;
    int i;
    if (this.c) {
      i = 4;
    } else {
      i = this.b.g;
    }
    ReportHelper.a(2, j, i, 102);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter.ItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */