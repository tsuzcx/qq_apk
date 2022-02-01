package com.tencent.mobileqq.limitchat;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;

final class LimitChatUtil$5
  extends ExtendFriendObserver
{
  LimitChatUtil$5(QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      ExpandFriendChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramObject);
      return;
    }
    QLog.w("LimitChatUtil", 1, "showIcebreakerTopic network error, data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatUtil.5
 * JD-Core Version:    0.7.0.1
 */