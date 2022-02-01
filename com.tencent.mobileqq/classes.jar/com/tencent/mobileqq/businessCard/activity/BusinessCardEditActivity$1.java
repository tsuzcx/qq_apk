package com.tencent.mobileqq.businessCard.activity;

import com.tencent.mobileqq.businessCard.BusinessCardManager;

class BusinessCardEditActivity$1
  implements Runnable
{
  BusinessCardEditActivity$1(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void run()
  {
    BusinessCardEditActivity localBusinessCardEditActivity = this.this$0;
    localBusinessCardEditActivity.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = localBusinessCardEditActivity.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.d(this.this$0.jdField_a_of_type_JavaLangString);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
      this.this$0.runOnUiThread(new BusinessCardEditActivity.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.1
 * JD-Core Version:    0.7.0.1
 */