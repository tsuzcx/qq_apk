package com.tencent.mobileqq.selectmember;

import android.os.Message;
import mqq.os.MqqHandler;

class PhoneContactTabView$2
  extends MqqHandler
{
  PhoneContactTabView$2(PhoneContactTabView paramPhoneContactTabView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2))
    {
      if (i != 3) {
        return;
      }
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.PhoneContactTabView.2
 * JD-Core Version:    0.7.0.1
 */