package com.tencent.mobileqq.richstatus;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AioFriendTitleHelper$1
  implements Runnable
{
  AioFriendTitleHelper$1(AioFriendTitleHelper paramAioFriendTitleHelper) {}
  
  public void run()
  {
    RichStatus localRichStatus = ((StatusManager)AioFriendTitleHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).a(AioFriendTitleHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
    AioFriendTitleHelper.a(this.this$0).jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new AioFriendTitleHelper.1.1(this, localRichStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.1
 * JD-Core Version:    0.7.0.1
 */