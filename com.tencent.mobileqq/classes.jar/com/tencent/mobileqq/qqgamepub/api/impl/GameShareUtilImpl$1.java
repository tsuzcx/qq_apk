package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import mqq.app.AppRuntime;

class GameShareUtilImpl$1
  implements Runnable
{
  GameShareUtilImpl$1(GameShareUtilImpl paramGameShareUtilImpl, AppRuntime paramAppRuntime, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    ((IMessageFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "")).updateMsgFieldByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.GameShareUtilImpl.1
 * JD-Core Version:    0.7.0.1
 */