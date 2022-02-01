package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;

class OnlineStatusPanel$2$1
  implements Runnable
{
  OnlineStatusPanel$2$1(OnlineStatusPanel.2 param2, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.a)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a())))
      {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a();
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.setCurrentItem();
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.jdField_a_of_type_JavaUtilArrayList = this.b;
    OnlineStatusPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.setCurrentItem();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    int i = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanel$2.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount();
    boolean bool = true;
    if (i <= 1) {
      bool = false;
    }
    ((QQViewPager)localObject).disableGesture(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.2.1
 * JD-Core Version:    0.7.0.1
 */