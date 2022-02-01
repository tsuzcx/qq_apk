package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;

class OnlineStatusPanel$2$1
  implements Runnable
{
  OnlineStatusPanel$2$1(OnlineStatusPanel.2 param2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3) {}
  
  public void run()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.a) && (this.jdField_a_of_type_JavaUtilArrayList == this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(), false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(this.b);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.jdField_a_of_type_JavaUtilArrayList = this.c;
    OnlineStatusPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(), false);
    QQViewPager localQQViewPager = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {}
    for (;;)
    {
      localQQViewPager.b(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.2.1
 * JD-Core Version:    0.7.0.1
 */