package com.tencent.mobileqq.vas.troopnick.shop.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShopAdapter$1
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  ShopAdapter$1(ShopAdapter paramShopAdapter) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long == 0L) || (l - this.jdField_a_of_type_Long > 2000L))
    {
      ShopAdapter.a(this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter).b();
      this.jdField_a_of_type_Long = l;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter.1
 * JD-Core Version:    0.7.0.1
 */