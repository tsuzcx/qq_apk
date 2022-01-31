package com.tencent.mobileqq.teamwork.spread;

import ainj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public class TroopFileAIOMsgTips
  extends BaseTimAIOTipsProcessor
{
  public TroopFileAIOMsgTips(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ConfigSetting paramConfigSetting)
  {
    super(paramQQAppInterface, paramChatMessage, paramConfigSetting);
  }
  
  protected String a()
  {
    return ((MessageForTroopFile)this.a).fileName;
  }
  
  protected void a(BaseTimAIOTipsProcessor.ListResult paramListResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
    }
    ThreadManager.post(new ainj(this, paramListResult), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips
 * JD-Core Version:    0.7.0.1
 */