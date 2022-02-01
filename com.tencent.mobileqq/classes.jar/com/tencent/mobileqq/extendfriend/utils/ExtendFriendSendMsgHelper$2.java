package com.tencent.mobileqq.extendfriend.utils;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;

class ExtendFriendSendMsgHelper$2
  implements Runnable
{
  ExtendFriendSendMsgHelper$2(ExtendFriendSendMsgHelper paramExtendFriendSendMsgHelper, int paramInt, String paramString) {}
  
  public void run()
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)ExtendFriendSendMsgHelper.a(this.this$0).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", this.jdField_a_of_type_Int);
    localExtendFriendManager.a(this.jdField_a_of_type_JavaLangString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.2
 * JD-Core Version:    0.7.0.1
 */