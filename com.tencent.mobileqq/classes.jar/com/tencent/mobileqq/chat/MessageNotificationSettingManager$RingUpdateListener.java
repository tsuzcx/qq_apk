package com.tencent.mobileqq.chat;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class MessageNotificationSettingManager$RingUpdateListener
  implements QuickUpdateListener
{
  final int jdField_a_of_type_Int;
  final WeakReference<MessageNotificationSettingManager> jdField_a_of_type_JavaLangRefWeakReference;
  
  public MessageNotificationSettingManager$RingUpdateListener(MessageNotificationSettingManager paramMessageNotificationSettingManager, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMessageNotificationSettingManager);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "onCompleted: invoked. ", " bid: ", Long.valueOf(paramLong), " ringId: ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    paramString1 = new MessageNotificationSettingManager.RingUpdateListener.1(this);
    ThreadManagerV2.getUIHandlerV2().post(paramString1);
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.MessageNotificationSettingManager.RingUpdateListener
 * JD-Core Version:    0.7.0.1
 */