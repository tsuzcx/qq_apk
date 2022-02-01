package com.tencent.mobileqq.vas.troopnick.shop.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShopAdapter$ItemOnClickListener
  implements View.OnClickListener
{
  private final ShopAdapter.DataItem jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$DataItem;
  private final boolean jdField_a_of_type_Boolean;
  
  public ShopAdapter$ItemOnClickListener(ShopAdapter paramShopAdapter, ShopAdapter.DataItem paramDataItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$DataItem = paramDataItem;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter.a = this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$DataItem.b;
    ShopAdapter.a(this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter, this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$DataItem);
    ShopAdapter localShopAdapter = this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter;
    ShopAdapter.a(localShopAdapter, ShopAdapter.a(localShopAdapter));
    if (this.jdField_a_of_type_Boolean) {
      ShopAdapter.a(this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter).a();
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$DataItem.b;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 4;
    } else {
      i = this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter$DataItem.d;
    }
    ReportHelper.a(2, j, i, 102);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter.ItemOnClickListener
 * JD-Core Version:    0.7.0.1
 */