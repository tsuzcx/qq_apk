package com.tencent.mobileqq.mutualmark.oldlogic;

import agab;
import anvk;
import axlr;
import axms;
import axna;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public final class OldMutualMarkLogicHelper$1
  implements Runnable
{
  public OldMutualMarkLogicHelper$1(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, agab paramagab) {}
  
  public void run()
  {
    Object localObject = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (((anvk)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, false) == null) {
      break label29;
    }
    label29:
    while (((anvk)localObject).a(false)) {
      return;
    }
    localObject = axlr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 7L, false);
    agab localagab = this.jdField_a_of_type_Agab;
    if ((localObject != null) && (((axms)localObject).b > 0L) && (((axms)localObject).a())) {}
    for (boolean bool = true;; bool = false)
    {
      localagab.d = bool;
      if (!this.jdField_a_of_type_Agab.d) {
        break;
      }
      axna.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agab);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
 * JD-Core Version:    0.7.0.1
 */