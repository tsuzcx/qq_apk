package com.tencent.mobileqq.businessCard.activity;

import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;

class BusinessCardEditActivity$11
  implements Runnable
{
  BusinessCardEditActivity$11(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
      BusinessCardEditActivity.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum);
    }
    while (this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo == null) {
      return;
    }
    BusinessCardEditActivity.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.a, null, this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.11
 * JD-Core Version:    0.7.0.1
 */