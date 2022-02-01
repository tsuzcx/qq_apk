package com.tencent.mobileqq.mutualmark.oldlogic;

import afiw;
import amsw;
import awfp;
import awgq;
import awgy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public final class OldMutualMarkLogicHelper$1
  implements Runnable
{
  public OldMutualMarkLogicHelper$1(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, afiw paramafiw) {}
  
  public void run()
  {
    Object localObject = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (((amsw)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, false) == null) {
      break label28;
    }
    label28:
    while (((amsw)localObject).a(false)) {
      return;
    }
    localObject = awfp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 7L, false);
    afiw localafiw = this.jdField_a_of_type_Afiw;
    if ((localObject != null) && (((awgq)localObject).b > 0L) && (((awgq)localObject).a())) {}
    for (boolean bool = true;; bool = false)
    {
      localafiw.d = bool;
      if (!this.jdField_a_of_type_Afiw.d) {
        break;
      }
      awgy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Afiw);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
 * JD-Core Version:    0.7.0.1
 */