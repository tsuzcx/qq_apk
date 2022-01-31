package com.tencent.mobileqq.mutualmark.oldlogic;

import agld;
import aloz;
import aupg;
import aupk;
import azmj;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;

public final class OldMutualMarkLogicHelper$1
  implements Runnable
{
  public OldMutualMarkLogicHelper$1(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, agld paramagld) {}
  
  public void run()
  {
    aloz localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo = localaloz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, false);
    if (localExtensionInfo == null) {}
    do
    {
      return;
      bool1 = localaloz.a(false);
    } while (bool1);
    int i = aupg.a(5, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localExtensionInfo, bool1);
    int j = aupg.a(4, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localExtensionInfo, bool1);
    long l1 = localExtensionInfo.lastChatTime;
    long l2 = localExtensionInfo.lastpraiseTime;
    int k = aupg.b();
    boolean bool2 = aupg.a(k, l1 * 1000L);
    boolean bool3 = aupg.a(k, l2 * 1000L);
    k = aupg.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localExtensionInfo, localaloz.a(false));
    l1 = localExtensionInfo.loverLastChatTime;
    boolean bool1 = aupg.a(aupg.b(), l1 * 1000L, localExtensionInfo.loverTransFlag);
    agld localagld = this.jdField_a_of_type_Agld;
    int n;
    if ((k != 0) && (bool1))
    {
      bool1 = true;
      localagld.V = bool1;
      if (this.jdField_a_of_type_Agld.V) {
        aupk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Agld);
      }
      k = localExtensionInfo.isGrayTipRemind;
      int m = localExtensionInfo.isGrayTipMultiRemind;
      n = localaloz.k;
      if (QLog.isColorLevel()) {
        QLog.d("reactivetip", 2, "checkReactiveGraytip isRemind=" + k + "isMultiRemind" + m + "praiseNeedRemind=" + bool3 + "chatNeedRemind=" + bool2 + "maxRemindTime=" + n);
      }
      if ((!bool3) || (!bool2) || (i == 0) || (j == 0)) {
        break label397;
      }
      if (!aupk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_priaseandchat_remind_times", Boolean.valueOf(true), m, 4096, true, localExtensionInfo, n)) {
        break label552;
      }
      i = 23;
    }
    for (;;)
    {
      localaloz.a(localExtensionInfo);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007779", "0X8007779", i, 0, "", "", "", "");
      return;
      bool1 = false;
      break;
      label397:
      if (bool3)
      {
        if (j == 2)
        {
          if (aupk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_priasedown_remind_times", Boolean.valueOf(false), k, 1, bool3, localExtensionInfo, n)) {
            i = 20;
          }
        }
        else if ((j == 1) && (aupk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_priasedis_remind_times", Boolean.valueOf(false), k, 16, bool3, localExtensionInfo, n))) {
          i = 19;
        }
      }
      else if (bool2) {
        if (i == 2)
        {
          if (aupk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_chatdown_remind_times", Boolean.valueOf(false), k, 256, bool2, localExtensionInfo, n)) {
            i = 18;
          }
        }
        else if ((i == 1) && (aupk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_friend_graytip_chatdis_remind_times", Boolean.valueOf(false), k, 4096, bool2, localExtensionInfo, n)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper.1
 * JD-Core Version:    0.7.0.1
 */