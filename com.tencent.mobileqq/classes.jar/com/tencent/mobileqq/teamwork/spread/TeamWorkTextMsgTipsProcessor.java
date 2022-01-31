package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class TeamWorkTextMsgTipsProcessor
  extends BaseTimAIOTipsProcessor
{
  public TeamWorkTextMsgTipsProcessor(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, ConfigSetting paramConfigSetting)
  {
    super(paramQQAppInterface, paramChatMessage, paramConfigSetting);
  }
  
  protected String a()
  {
    return this.a.msg;
  }
  
  protected void a(BaseTimAIOTipsProcessor.ListResult paramListResult) {}
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.TeamWorkTextMsgTipsProcessor
 * JD-Core Version:    0.7.0.1
 */