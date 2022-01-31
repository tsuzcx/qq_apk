package com.tencent.mobileqq.mutualmark.oldlogic;

import aedo;
import ajjj;
import ascd;
import asch;
import awqx;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;

public final class OldMutualMarkLogicHelper$1
  implements Runnable
{
  public OldMutualMarkLogicHelper$1(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aedo paramaedo) {}
  
  public void run()
  {
    ajjj localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo = localajjj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, false);
    if (localExtensionInfo == null) {}
    do
    {
      return;
      bool1 = localajjj.a(false);
    } while (bool1);
    int i = ascd.a(5, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localExtensionInfo, bool1);
    int j = ascd.a(4, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localExtensionInfo, bool1);
    long l1 = localExtensionInfo.lastChatTime;
    long l2 = localExtensionInfo.lastpraiseTime;
    int k = ascd.b();
    boolean bool2 = ascd.a(k, l1 * 1000L);
    boolean bool3 = ascd.a(k, l2 * 1000L);
    k = ascd.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localExtensionInfo, localajjj.a(false));
    l1 = localExtensionInfo.loverLastChatTime;
    boolean bool1 = ascd.a(ascd.b(), l1 * 1000L, localExtensionInfo.loverTransFlag);
    aedo localaedo = this.jdField_a_of_type_Aedo;
    int n;
    if ((k != 0) && (bool1))
    {
      bool1 = true;
      localaedo.V = bool1;
      if (this.jdField_a_of_type_Aedo.V) {
        asch.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aedo);
      }
      k = localExtensionInfo.isGrayTipRemind;
      int m = localExtensionInfo.isGrayTipMultiRemind;
      n = localajjj.k;
      if (QLog.isColorLevel()) {
        QLog.d("reactivetip", 2, "checkReactiveGraytip isRemind=" + k + "isMultiRemind" + m + "praiseNeedRemind=" + bool3 + "chatNeedRemind=" + bool2 + "maxRemindTime=" + n);
      }
      if ((!bool3) || (!bool2) || (i == 0) || (j == 0)) {
        break label397;
      }
      if (!asch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_priaseandchat_remind_times", Boolean.valueOf(true), m, 4096, true, localExtensionInfo, n)) {
        break label552;
      }
      i = 23;
    }
    for (;;)
    {
      localajjj.a(localExtensionInfo);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007779", "0X8007779", i, 0, "", "", "", "");
      return;
      bool1 = false;
      break;
      label397:
      if (bool3)
      {
        if (j == 2)
        {
          if (asch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_priasedown_remind_times", Boolean.valueOf(false), k, 1, bool3, localExtensionInfo, n)) {
            i = 20;
          }
        }
        else if ((j == 1) && (asch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_priasedis_remind_times", Boolean.valueOf(false), k, 16, bool3, localExtensionInfo, n))) {
          i = 19;
        }
      }
      else if (bool2) {
        if (i == 2)
        {
          if (asch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_chatdown_remind_times", Boolean.valueOf(false), k, 256, bool2, localExtensionInfo, n)) {
            i = 18;
          }
        }
        else if ((i == 1) && (asch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_chatdis_remind_times", Boolean.valueOf(false), k, 4096, bool2, localExtensionInfo, n)))
        {
          i = 17;
          continue;
        }
      }
      label552:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
 * JD-Core Version:    0.7.0.1
 */