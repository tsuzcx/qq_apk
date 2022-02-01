package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public class HotChatReadConfirmCallback
  implements IReadConfirmCallback
{
  public void a(AIOContext paramAIOContext)
  {
    if (paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      HotChatUtil.a(paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt) {}
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.HotChatReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */