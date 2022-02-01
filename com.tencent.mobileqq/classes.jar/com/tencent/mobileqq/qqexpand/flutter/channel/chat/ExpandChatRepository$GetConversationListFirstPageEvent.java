package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

class ExpandChatRepository$GetConversationListFirstPageEvent
{
  private final long b;
  private final int c;
  private final ExpandChatRepository.GetConversationListCallback d;
  
  public ExpandChatRepository$GetConversationListFirstPageEvent(ExpandChatRepository paramExpandChatRepository, long paramLong, int paramInt, ExpandChatRepository.GetConversationListCallback paramGetConversationListCallback)
  {
    this.b = paramLong;
    this.c = paramInt;
    this.d = paramGetConversationListCallback;
  }
  
  public void a()
  {
    ExpandChatRepository.a(this.a, 0, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.GetConversationListFirstPageEvent
 * JD-Core Version:    0.7.0.1
 */