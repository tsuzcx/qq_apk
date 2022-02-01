package com.tencent.mobileqq.chat.ui;

import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.qphone.base.util.QLog;

class MessageNotificationSettingFragment$2
  extends TroopSettingObserver
{
  MessageNotificationSettingFragment$2(MessageNotificationSettingFragment paramMessageNotificationSettingFragment) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("onOIDB0XA80_0_Ret: invoked.  isSuccess : ");
      paramString2.append(paramBoolean);
      paramString2.append(" op: ");
      paramString2.append(paramInt1);
      paramString2.append(" type: ");
      paramString2.append(Integer.toHexString(paramInt2));
      QLog.i("MessageNotificationSettingFragment", 2, paramString2.toString());
    }
    if (paramBoolean) {
      MessageNotificationSettingFragment.a(this.a).a(paramString1, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */