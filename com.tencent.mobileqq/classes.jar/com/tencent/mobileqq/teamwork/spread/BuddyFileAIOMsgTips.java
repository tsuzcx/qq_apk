package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class BuddyFileAIOMsgTips
  extends BaseTimAIOTipsProcessor
{
  public BuddyFileAIOMsgTips(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ConfigSetting paramConfigSetting)
  {
    super(paramQQAppInterface, paramChatMessage, paramConfigSetting);
  }
  
  protected String a()
  {
    return ((MessageForFile)this.a).fileName;
  }
  
  protected void a(BaseTimAIOTipsProcessor.ListResult paramListResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWordsList by buddyFile[");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("]");
      QLog.i("BuddyFileAIOMsgTips", 1, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new BuddyFileAIOMsgTips.1(this, paramListResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips
 * JD-Core Version:    0.7.0.1
 */