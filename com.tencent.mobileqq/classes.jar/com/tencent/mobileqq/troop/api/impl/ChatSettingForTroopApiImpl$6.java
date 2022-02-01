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
    return TroopKeywordManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.ChatSettingForTroopApiImpl.6
 * JD-Core Version:    0.7.0.1
 */