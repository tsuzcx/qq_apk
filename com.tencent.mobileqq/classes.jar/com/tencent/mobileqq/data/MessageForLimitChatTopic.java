package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class MessageForLimitChatTopic
  extends ChatMessage
{
  public static final String TAG = "MessageForLimitChatTopic";
  
  public MessageForLimitChatTopic()
  {
    this.msgtype = -4023;
    this.mNeedTimeStamp = false;
  }
  
  public void doParse()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForLimitChatTopic", 4, String.format(Locale.getDefault(), "doParse: %s", new Object[] { this.msg }));
    }
    if ((this.istroop == 1037) || (this.istroop == 1044)) {
      this.isread = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLimitChatTopic
 * JD-Core Version:    0.7.0.1
 */