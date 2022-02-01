package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

class ChatSettingForTroopApiImpl$4
  implements LongClickCopyAction.ICopyListener
{
  ChatSettingForTroopApiImpl$4(ChatSettingForTroopApiImpl paramChatSettingForTroopApiImpl, AppRuntime paramAppRuntime) {}
  
  public void onCopyContent(String paramString)
  {
    ReportController.b(this.a, "grp_set", "", "", "grp_data", "grp_set_copy", 0, 0, paramString, "", "", "");
  }
  
  public void onShowCopyMenu() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.ChatSettingForTroopApiImpl.4
 * JD-Core Version:    0.7.0.1
 */