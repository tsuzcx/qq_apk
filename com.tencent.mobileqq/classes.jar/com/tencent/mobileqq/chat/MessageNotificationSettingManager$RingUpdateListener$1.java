package com.tencent.mobileqq.chat;

import java.lang.ref.WeakReference;

class MessageNotificationSettingManager$RingUpdateListener$1
  implements Runnable
{
  MessageNotificationSettingManager$RingUpdateListener$1(MessageNotificationSettingManager.RingUpdateListener paramRingUpdateListener) {}
  
  public void run()
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = (MessageNotificationSettingManager)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localMessageNotificationSettingManager == null) {}
    while (MessageNotificationSettingManager.a(localMessageNotificationSettingManager) == null) {
      return;
    }
    MessageNotificationSettingManager.a(localMessageNotificationSettingManager).a(this.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.MessageNotificationSettingManager.RingUpdateListener.1
 * JD-Core Version:    0.7.0.1
 */