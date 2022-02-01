package com.tencent.mobileqq.chat.ui;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.qphone.base.util.QLog;

class MessageNotificationSettingFragment$2
  extends TroopBusinessObserver
{
  MessageNotificationSettingFragment$2(MessageNotificationSettingFragment paramMessageNotificationSettingFragment) {}
  
  public void onOIDB0XA80_0_Ret(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageNotificationSettingFragment", 2, "onOIDB0XA80_0_Ret: invoked.  isSuccess : " + paramBoolean + " op: " + paramInt1 + " type: " + Integer.toHexString(paramInt2));
    }
    if (paramBoolean) {
      MessageNotificationSettingFragment.a(this.a).a(paramString1, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */