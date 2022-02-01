package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.model.QueryCallback;

class EmotionBatchForwardOption$2$1
  implements QueryCallback<Emoticon>
{
  EmotionBatchForwardOption$2$1(EmotionBatchForwardOption.2 param2, SessionInfo paramSessionInfo) {}
  
  public void a(Emoticon paramEmoticon)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqForwardEmotionBatchForwardOption$2.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqForwardEmotionBatchForwardOption$2.this$0.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramEmoticon, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.EmotionBatchForwardOption.2.1
 * JD-Core Version:    0.7.0.1
 */