package com.tencent.mobileqq.qqexpand.chat;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;

class ExtendFriendSendMsgHelper$9
  implements Runnable
{
  ExtendFriendSendMsgHelper$9(ExtendFriendSendMsgHelper paramExtendFriendSendMsgHelper, int paramInt, String paramString) {}
  
  public void run()
  {
    IExpandManager localIExpandManager = (IExpandManager)ExtendFriendSendMsgHelper.b(this.this$0).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", this.a);
    localIExpandManager.a(this.b, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper.9
 * JD-Core Version:    0.7.0.1
 */