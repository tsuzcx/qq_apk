package com.tencent.mobileqq.data;

public class MessageForTimDouFuGuide
  extends ChatMessage
{
  public AppGuideTipsConfig config;
  
  public MessageForTimDouFuGuide(AppGuideTipsConfig paramAppGuideTipsConfig)
  {
    this.msgtype = -3015;
    this.config = paramAppGuideTipsConfig;
  }
  
  protected void doParse() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTimDouFuGuide
 * JD-Core Version:    0.7.0.1
 */