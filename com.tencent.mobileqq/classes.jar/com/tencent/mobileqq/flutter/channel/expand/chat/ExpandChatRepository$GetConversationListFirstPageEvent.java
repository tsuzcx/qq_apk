package com.tencent.mobileqq.flutter.channel.expand.chat;

class ExpandChatRepository$GetConversationListFirstPageEvent
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ExpandChatRepository.GetConversationListCallback jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$GetConversationListCallback;
  
  public ExpandChatRepository$GetConversationListFirstPageEvent(ExpandChatRepository paramExpandChatRepository, long paramLong, int paramInt, ExpandChatRepository.GetConversationListCallback paramGetConversationListCallback)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$GetConversationListCallback = paramGetConversationListCallback;
  }
  
  public void a()
  {
    ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$GetConversationListCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository.GetConversationListFirstPageEvent
 * JD-Core Version:    0.7.0.1
 */