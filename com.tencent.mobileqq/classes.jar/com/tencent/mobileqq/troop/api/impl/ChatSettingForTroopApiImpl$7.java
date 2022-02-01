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
    if (this.a) {
      return;
    }
    QFormSimpleItem localQFormSimpleItem = (QFormSimpleItem)this.b;
    localQFormSimpleItem.setRightText(paramEntryStatus.a);
    localQFormSimpleItem.setTag(2131443127, paramEntryStatus);
    ReportController.b(null, "dc00898", "", this.c, "qq_vip", "0X800A8F7", paramEntryStatus.f, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.ChatSettingForTroopApiImpl.7
 * JD-Core Version:    0.7.0.1
 */