package com.tencent.mobileqq.troop.troopgame;

import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService.CallbackInMainThread;
import com.tencent.qphone.base.util.QLog;

class TroopMemGradeLevelBuilder$TmiCallbackForMemberGradeLevel
  implements ITroopGameCardService.CallbackInMainThread
{
  public BaseChatItemLayout a;
  public String a;
  
  private TroopMemGradeLevelBuilder$TmiCallbackForMemberGradeLevel(TroopMemGradeLevelBuilder paramTroopMemGradeLevelBuilder) {}
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) {}
    NickNameExtenderViewBasicAbility localNickNameExtenderViewBasicAbility;
    do
    {
      do
      {
        return;
        localNickNameExtenderViewBasicAbility = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(NickNameLayoutProcessor.e);
      } while (localNickNameExtenderViewBasicAbility == null);
      if (paramObject == null) {
        localNickNameExtenderViewBasicAbility.setData(null);
      }
      if ((paramObject instanceof MemberGradeLevelInfo)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopMemGradeLevelBuilder", 2, "onResult object is not instanceof MemberGradeLevelInfo");
    return;
    localNickNameExtenderViewBasicAbility.setData(new Object[] { (MemberGradeLevelInfo)paramObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopMemGradeLevelBuilder.TmiCallbackForMemberGradeLevel
 * JD-Core Version:    0.7.0.1
 */