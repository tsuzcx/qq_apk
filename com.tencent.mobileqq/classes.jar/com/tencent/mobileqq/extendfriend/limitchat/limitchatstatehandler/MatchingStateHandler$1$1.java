package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import com.tencent.mobileqq.extendfriend.bean.MatchInfo;

class MatchingStateHandler$1$1
  implements Runnable
{
  MatchingStateHandler$1$1(MatchingStateHandler.1 param1) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitchatstatehandlerLimitChatProtoStateMachine != null)
    {
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitchatstatehandlerLimitChatProtoStateMachine.a(100, null);
      if (this.a.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitchatstatehandlerLimitChatProtoStateMachine.a != null)
      {
        String str2 = "";
        String str1 = str2;
        if (this.a.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo != null)
        {
          str1 = str2;
          if (this.a.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.d != null) {
            str1 = this.a.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.d;
          }
        }
        this.a.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitchatstatehandlerLimitChatProtoStateMachine.a.a(0, this.a.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo, str1, "");
      }
      MatchingStateHandler.a(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1.1
 * JD-Core Version:    0.7.0.1
 */