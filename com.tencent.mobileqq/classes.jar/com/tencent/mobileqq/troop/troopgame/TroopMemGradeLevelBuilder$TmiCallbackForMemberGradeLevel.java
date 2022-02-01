package com.tencent.mobileqq.troop.troopgame;

import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService.CallbackInMainThread;
import com.tencent.qphone.base.util.QLog;

class TroopMemGradeLevelBuilder$TmiCallbackForMemberGradeLevel
  implements ITroopGameCardService.CallbackInMainThread
{
  public BaseChatItemLayout a;
  public String b;
  public int c;
  public int d;
  
  private TroopMemGradeLevelBuilder$TmiCallbackForMemberGradeLevel(TroopMemGradeLevelBuilder paramTroopMemGradeLevelBuilder) {}
  
  public void a(Object paramObject)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((BaseChatItemLayout)localObject).a(NickNameChatItemLayoutProcessor.e);
    if (localObject == null) {
      return;
    }
    if (paramObject == null)
    {
      if (this.c > 0)
      {
        paramObject = new MemberGradeLevelInfo();
        paramObject.gameCardId = this.c;
        paramObject.gameCardSwitch = this.d;
        ((BaseChatItemLayoutViewBasicAbility)localObject).setData(new Object[] { paramObject });
        return;
      }
      ((BaseChatItemLayoutViewBasicAbility)localObject).setData(null);
      return;
    }
    if (!(paramObject instanceof MemberGradeLevelInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemGradeLevelBuilder", 2, "onResult object is not instanceof MemberGradeLevelInfo");
      }
      return;
    }
    ((BaseChatItemLayoutViewBasicAbility)localObject).setData(new Object[] { (MemberGradeLevelInfo)paramObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopMemGradeLevelBuilder.TmiCallbackForMemberGradeLevel
 * JD-Core Version:    0.7.0.1
 */