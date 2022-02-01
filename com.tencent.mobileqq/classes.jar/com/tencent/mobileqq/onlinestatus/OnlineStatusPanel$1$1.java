package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;

class OnlineStatusPanel$1$1
  implements Runnable
{
  OnlineStatusPanel$1$1(OnlineStatusPanel.1 param1, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.jdField_a_of_type_JavaUtilArrayList = this.b;
    OnlineStatusPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(), false);
    QQViewPager localQQViewPager = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {}
    for (;;)
    {
      localQQViewPager.b(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.1.1
 * JD-Core Version:    0.7.0.1
 */