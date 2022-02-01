package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;

class MatchingStateHandler$1
  implements Runnable
{
  MatchingStateHandler$1(MatchingStateHandler paramMatchingStateHandler) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine != null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a(100, null);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a != null)
      {
        String str;
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.d != null)) {
          str = this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.d;
        } else {
          str = "";
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a.a(0, this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo, str, "");
      }
      MatchingStateHandler.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.MatchingStateHandler.1
 * JD-Core Version:    0.7.0.1
 */