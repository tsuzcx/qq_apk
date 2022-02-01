package com.tencent.mobileqq.model;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ChatBackgroundManager$2
  implements Runnable
{
  ChatBackgroundManager$2(ChatBackgroundManager paramChatBackgroundManager, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatBackgroundManager.c = this.this$0.c(null);
    Message localMessage = ChatBackgroundManager.a.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface };
    if (QLog.isColorLevel())
    {
      QLog.d("ThemeDownloadTrace", 2, "bgin to report chat bg info");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initCurrChatBgNameForReport is:");
      localStringBuilder.append(ChatBackgroundManager.c);
      QLog.d("ThemeDownloadTrace", 2, localStringBuilder.toString());
    }
    ChatBackgroundManager.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager.2
 * JD-Core Version:    0.7.0.1
 */