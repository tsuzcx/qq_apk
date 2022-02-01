package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;

class OnlineStatusPanel$1$1
  implements Runnable
{
  OnlineStatusPanel$1$1(OnlineStatusPanel.1 param1, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.jdField_a_of_type_JavaUtilArrayList = this.b;
    OnlineStatusPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.notifyDataSetChanged();
    if (OnlineStatusPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0) == null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.setCurrentItem();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(OnlineStatusPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0));
    }
    QQViewPager localQQViewPager = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    int i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$1.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount();
    boolean bool = true;
    if (i <= 1) {
      bool = false;
    }
    localQQViewPager.disableGesture(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.1.1
 * JD-Core Version:    0.7.0.1
 */