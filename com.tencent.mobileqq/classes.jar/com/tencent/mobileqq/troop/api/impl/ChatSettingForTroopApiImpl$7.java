package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.keyword.EntryStatus;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.widget.QFormSimpleItem;

class ChatSettingForTroopApiImpl$7
  implements QueryCallback<EntryStatus>
{
  ChatSettingForTroopApiImpl$7(ChatSettingForTroopApiImpl paramChatSettingForTroopApiImpl, boolean paramBoolean, Object paramObject, String paramString) {}
  
  public void a(EntryStatus paramEntryStatus)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QFormSimpleItem localQFormSimpleItem = (QFormSimpleItem)this.jdField_a_of_type_JavaLangObject;
    localQFormSimpleItem.setRightText(paramEntryStatus.jdField_a_of_type_JavaLangString);
    localQFormSimpleItem.setTag(2131374942, paramEntryStatus);
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "qq_vip", "0X800A8F7", paramEntryStatus.c, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.ChatSettingForTroopApiImpl.7
 * JD-Core Version:    0.7.0.1
 */