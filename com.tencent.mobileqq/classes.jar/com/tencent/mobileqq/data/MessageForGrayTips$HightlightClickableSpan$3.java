package com.tencent.mobileqq.data;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class MessageForGrayTips$HightlightClickableSpan$3
  implements Runnable
{
  MessageForGrayTips$HightlightClickableSpan$3(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan) {}
  
  public void run()
  {
    MsgNotifyPushDialog.a((QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(this.this$0).get());
    try
    {
      MessageForGrayTips.HightlightClickableSpan.access$100(this.this$0).startActivity(MsgNotifyPushDialog.n);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MsgNotifyPushDialog.pushOpenNotifyIntent==null ");
        localStringBuilder.append(localException.getMessage());
        QLog.d("MessageForGrayTips", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan.3
 * JD-Core Version:    0.7.0.1
 */