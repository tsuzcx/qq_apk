package com.tencent.mobileqq.data;

import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.TopGameInfo;

public class MessageForCmGameTips
  extends ChatMessage
{
  public CmGameTempSessionHandler.TopGameInfo gameInfo;
  public boolean needTopPadding = false;
  
  protected void doParse() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForCmGameTips
 * JD-Core Version:    0.7.0.1
 */