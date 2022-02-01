package com.tencent.mobileqq.businessCard.activity;

import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;

class BusinessCardEditActivity$11
  implements Runnable
{
  BusinessCardEditActivity$11(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void run()
  {
    BusinessCardEditActivity localBusinessCardEditActivity;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      localBusinessCardEditActivity = this.this$0;
      BusinessCardEditActivity.a(localBusinessCardEditActivity, localBusinessCardEditActivity.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum);
      return;
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null)
    {
      localBusinessCardEditActivity = this.this$0;
      BusinessCardEditActivity.a(localBusinessCardEditActivity, localBusinessCardEditActivity.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.a, null, this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.11
 * JD-Core Version:    0.7.0.1
 */