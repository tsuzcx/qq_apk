package com.tencent.mobileqq.mutualmark.oldlogic;

import aijm;
import anyw;
import axsi;
import axtj;
import axtr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public final class OldMutualMarkLogicHelper$1
  implements Runnable
{
  public OldMutualMarkLogicHelper$1(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aijm paramaijm) {}
  
  public void run()
  {
    Object localObject = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (((anyw)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, false) == null) {
      break label28;
    }
    label28:
    while (((anyw)localObject).a(false)) {
      return;
    }
    localObject = axsi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 7L, false);
    aijm localaijm = this.jdField_a_of_type_Aijm;
    if ((localObject != null) && (((axtj)localObject).b > 0L) && (((axtj)localObject).a())) {}
    for (boolean bool = true;; bool = false)
    {
      localaijm.U = bool;
      if (!this.jdField_a_of_type_Aijm.U) {
        break;
      }
      axtr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aijm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
 * JD-Core Version:    0.7.0.1
 */