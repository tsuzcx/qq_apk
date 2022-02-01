package com.tencent.mobileqq.tofumsg;

import afqy;
import bejc;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class AIOTofuMsgHelper$1
  implements Runnable
{
  public AIOTofuMsgHelper$1(bejc parambejc) {}
  
  public void run()
  {
    ((afqy)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.AIOTofuMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */