package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QueryTask.Query;
import com.tencent.mobileqq.troop.keyword.EntryStatus;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import mqq.app.AppRuntime;

class ChatSettingForTroopApiImpl$6
  implements QueryTask.Query<Void, EntryStatus>
{
  ChatSettingForTroopApiImpl$6(ChatSettingForTroopApiImpl paramChatSettingForTroopApiImpl, AppRuntime paramAppRuntime, String paramString) {}
  
  public EntryStatus a(Void paramVoid)
  {
    return TroopKeywordManager.a((QQAppInterface)this.a).b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.ChatSettingForTroopApiImpl.6
 * JD-Core Version:    0.7.0.1
 */