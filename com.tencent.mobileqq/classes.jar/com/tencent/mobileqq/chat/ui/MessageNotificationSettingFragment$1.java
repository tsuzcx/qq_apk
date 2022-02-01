package com.tencent.mobileqq.chat.ui;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class MessageNotificationSettingFragment$1
  extends FriendListObserver
{
  MessageNotificationSettingFragment$1(MessageNotificationSettingFragment paramMessageNotificationSettingFragment) {}
  
  protected void onSetMessageNotification(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" data: ");
    ((StringBuilder)localObject1).append(paramArrayOfObject);
    QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "onSetMessageNotification: invoked. ", " isSuccess: ", Boolean.valueOf(paramBoolean), ((StringBuilder)localObject1).toString() });
    if ((paramBoolean) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      Object localObject2 = (String[])paramArrayOfObject[0];
      localObject1 = (boolean[])paramArrayOfObject[1];
      if ((localObject2 != null) && (localObject2.length >= 1) && (localObject1 != null))
      {
        if (localObject1.length < 1) {
          return;
        }
        localObject2 = localObject2[0];
        paramBoolean = localObject1[0];
        ((Integer)paramArrayOfObject[2]).intValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */