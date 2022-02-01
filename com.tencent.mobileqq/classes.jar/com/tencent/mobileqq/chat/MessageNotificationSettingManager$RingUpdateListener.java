package com.tencent.mobileqq.chat;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class MessageNotificationSettingManager$RingUpdateListener
  implements QuickUpdateListener
{
  final WeakReference<MessageNotificationSettingManager> a;
  final int b;
  
  public MessageNotificationSettingManager$RingUpdateListener(MessageNotificationSettingManager paramMessageNotificationSettingManager, int paramInt)
  {
    this.a = new WeakReference(paramMessageNotificationSettingManager);
    this.b = paramInt;
  }
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "onCompleted: invoked. ", " bid: ", Long.valueOf(paramLong), " ringId: ", Integer.valueOf(this.b) });
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