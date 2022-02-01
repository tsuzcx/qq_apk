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
    if (this.this$0.C != null)
    {
      localBusinessCardEditActivity = this.this$0;
      BusinessCardEditActivity.a(localBusinessCardEditActivity, localBusinessCardEditActivity.C.cardName, this.this$0.C.company, this.this$0.C.mobilesNum);
      return;
    }
    if (this.this$0.D != null)
    {
      localBusinessCardEditActivity = this.this$0;
      BusinessCardEditActivity.a(localBusinessCardEditActivity, localBusinessCardEditActivity.D.a, null, this.this$0.D.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.11
 * JD-Core Version:    0.7.0.1
 */