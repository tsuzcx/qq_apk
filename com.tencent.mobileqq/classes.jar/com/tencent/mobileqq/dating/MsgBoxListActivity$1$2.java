package com.tencent.mobileqq.dating;

import EncounterSvc.RespEncounterInfo;
import android.view.View;
import com.tencent.mobileqq.nearpeople.IChatPushCarrier;

class MsgBoxListActivity$1$2
  implements Runnable
{
  MsgBoxListActivity$1$2(MsgBoxListActivity.1 param1, View paramView, RespEncounterInfo paramRespEncounterInfo) {}
  
  public void run()
  {
    this.c.a.chatPushCarrierHelper.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.1.2
 * JD-Core Version:    0.7.0.1
 */