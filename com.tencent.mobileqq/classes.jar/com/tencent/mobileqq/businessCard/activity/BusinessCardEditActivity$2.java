package com.tencent.mobileqq.businessCard.activity;

import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class BusinessCardEditActivity$2
  implements Runnable
{
  BusinessCardEditActivity$2(BusinessCardEditActivity paramBusinessCardEditActivity, EditText paramEditText) {}
  
  public void run()
  {
    this.a.requestFocusFromTouch();
    AIOUtils.showKeyboard(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.2
 * JD-Core Version:    0.7.0.1
 */