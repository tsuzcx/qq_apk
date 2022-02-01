package com.tencent.mobileqq.troop.troopgame;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class TroopMemGradeLevelBuilder$1
  extends Handler
{
  TroopMemGradeLevelBuilder$1(TroopMemGradeLevelBuilder paramTroopMemGradeLevelBuilder, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (paramMessage.arg1 == 0)
      {
        paramMessage = TroopMemGradeLevelBuilder.a(this.a).a(NickNameChatItemLayoutProcessor.e);
        if (paramMessage != null) {
          paramMessage.setViewVisibility(8);
        }
        return;
      }
      TroopMemGradeLevelBuilder.TmiCallbackForMemberGradeLevel localTmiCallbackForMemberGradeLevel2 = (TroopMemGradeLevelBuilder.TmiCallbackForMemberGradeLevel)TroopMemGradeLevelBuilder.a(this.a).getTag(2131430617);
      TroopMemGradeLevelBuilder.TmiCallbackForMemberGradeLevel localTmiCallbackForMemberGradeLevel1 = localTmiCallbackForMemberGradeLevel2;
      if (localTmiCallbackForMemberGradeLevel2 == null)
      {
        localTmiCallbackForMemberGradeLevel1 = new TroopMemGradeLevelBuilder.TmiCallbackForMemberGradeLevel(this.a, null);
        TroopMemGradeLevelBuilder.a(this.a).setTag(2131430617, localTmiCallbackForMemberGradeLevel1);
      }
      int i = VipUtils.a(TroopMemGradeLevelBuilder.b(this.a).getExtInfoFromExtStr("game_card_id"), 0);
      localTmiCallbackForMemberGradeLevel1.a = TroopMemGradeLevelBuilder.a(this.a);
      localTmiCallbackForMemberGradeLevel1.b = TroopMemGradeLevelBuilder.b(this.a).senderuin;
      localTmiCallbackForMemberGradeLevel1.c = i;
      localTmiCallbackForMemberGradeLevel1.d = paramMessage.arg2;
      paramMessage = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (paramMessage == null) {
        return;
      }
      paramMessage = (ITroopGameCardService)paramMessage.getRuntimeService(ITroopGameCardService.class, "");
      if (paramMessage != null)
      {
        paramMessage.getMemberGradeLevelInfoAsync(TroopMemGradeLevelBuilder.b(this.a).senderuin, localTmiCallbackForMemberGradeLevel1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemGradeLevelBuilder", 2, "troopGameCardManager is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopMemGradeLevelBuilder.1
 * JD-Core Version:    0.7.0.1
 */