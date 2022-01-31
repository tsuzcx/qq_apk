package com.tencent.mobileqq.teamwork.spread;

import aine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.qphone.base.util.QLog;

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
    if (QLog.isColorLevel()) {
      QLog.i("BuddyFileAIOMsgTips", 1, "getWordsList by buddyFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.post(new aine(this, paramListResult), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips
 * JD-Core Version:    0.7.0.1
 */