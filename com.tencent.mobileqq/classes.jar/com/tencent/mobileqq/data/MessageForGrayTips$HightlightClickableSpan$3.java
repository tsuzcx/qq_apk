package com.tencent.mobileqq.data;

import akdt;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class MessageForGrayTips$HightlightClickableSpan$3
  implements Runnable
{
  MessageForGrayTips$HightlightClickableSpan$3(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan) {}
  
  public void run()
  {
    akdt.a((QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(this.this$0).get());
    try
    {
      MessageForGrayTips.HightlightClickableSpan.access$100(this.this$0).startActivity(akdt.a);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MessageForGrayTips", 2, "MsgNotifyPushDialog.pushOpenNotifyIntent==null " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan.3
 * JD-Core Version:    0.7.0.1
 */