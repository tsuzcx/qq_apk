package com.tencent.mobileqq.vas.troopnick.shop.widget;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ShopLayout$1
  extends GridLayoutManager.SpanSizeLookup
{
  ShopLayout$1(ShopLayout paramShopLayout) {}
  
  public int getSpanSize(int paramInt)
  {
    if (ShopLayout.a(this.a).getItemViewType(paramInt) == 0) {
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout.1
 * JD-Core Version:    0.7.0.1
 */