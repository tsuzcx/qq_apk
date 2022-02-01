package com.tencent.mobileqq.troop.troopgame;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
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
      if (paramMessage.arg1 != 0) {
        break label40;
      }
      paramMessage = TroopMemGradeLevelBuilder.a(this.a).a(NickNameLayoutProcessor.e);
      if (paramMessage != null) {
        paramMessage.setViewVisibility(8);
      }
    }
    return;
    label40:
    paramMessage = (TroopMemGradeLevelBuilder.TmiCallbackForMemberGradeLevel)TroopMemGradeLevelBuilder.a(this.a).getTag(2131364671);
    if (paramMessage == null)
    {
      paramMessage = new TroopMemGradeLevelBuilder.TmiCallbackForMemberGradeLevel(this.a, null);
      TroopMemGradeLevelBuilder.a(this.a).setTag(2131364671, paramMessage);
    }
    for (;;)
    {
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = TroopMemGradeLevelBuilder.a(this.a);
      paramMessage.jdField_a_of_type_JavaLangString = TroopMemGradeLevelBuilder.a(this.a).senderuin;
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject == null) {
        break;
      }
      localObject = (ITroopGameCardService)((AppRuntime)localObject).getRuntimeService(ITroopGameCardService.class, "");
      if (localObject != null)
      {
        ((ITroopGameCardService)localObject).getMemberGradeLevelInfoAsync(TroopMemGradeLevelBuilder.a(this.a).senderuin, paramMessage);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopMemGradeLevelBuilder", 2, "troopGameCardManager is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopMemGradeLevelBuilder.1
 * JD-Core Version:    0.7.0.1
 */