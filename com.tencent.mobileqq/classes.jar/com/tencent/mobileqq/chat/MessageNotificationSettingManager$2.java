package com.tencent.mobileqq.chat;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.quickupdate.RingUpdateCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;

class MessageNotificationSettingManager$2
  implements QuickUpdateListener
{
  MessageNotificationSettingManager$2(MessageNotificationSettingManager paramMessageNotificationSettingManager, int paramInt) {}
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    paramString1 = RingUpdateCallback.getWavPath(this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a.getApp(), this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playRingId.onCompleted: invoked. ", " wavPath: ", paramString1 });
    }
    MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager, paramString1);
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.chat.MessageNotificationSettingManager.2
 * JD-Core Version:    0.7.0.1
 */