package com.tencent.mobileqq.newfriend.poke;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

final class NewFriendNotifyPokeMsgHelper$1
  implements Runnable
{
  NewFriendNotifyPokeMsgHelper$1(long paramLong, structmsg.StructMsg paramStructMsg, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)) {
      try
      {
        ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, this.jdField_a_of_type_Long, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.toByteArray());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("NewFriendNotifyPokeMsgHelper", 1, "setLocalDataPokeClicked Exception!", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */