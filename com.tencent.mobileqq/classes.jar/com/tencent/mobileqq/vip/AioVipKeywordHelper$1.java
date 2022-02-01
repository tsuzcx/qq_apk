package com.tencent.mobileqq.vip;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class AioVipKeywordHelper$1
  implements Runnable
{
  AioVipKeywordHelper$1(AioVipKeywordHelper paramAioVipKeywordHelper, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, String paramString, ChatMessage paramChatMessage, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 4, "keyword has been detected, message is ignored.");
      }
      return;
    }
    if (!this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      return;
    }
    Object localObject1 = this.this$0;
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = AioVipKeywordHelper.a((AioVipKeywordHelper)localObject1, (Context)localObject2, str, bool);
    if ((localObject1 != null) && (localObject1.length != 0))
    {
      localObject2 = this.jdField_a_of_type_JavaLangString.toLowerCase();
      AioVipKeywordHelper.a(this.this$0, (String[])localObject1, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    QLog.e("AioVipKeywordHelper", 1, "vipKeywords null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AioVipKeywordHelper.1
 * JD-Core Version:    0.7.0.1
 */