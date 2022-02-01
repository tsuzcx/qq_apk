package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class TroopAioKeywordTipBar$4$1$1
  extends TroopAioKeywordTipManager.Callback
{
  TroopAioKeywordTipBar$4$1$1(TroopAioKeywordTipBar.4.1 param1) {}
  
  public void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo)
  {
    if (!this.a.a.this$0.a) {}
    do
    {
      return;
      if ((paramMessageRecord != null) && (paramTroopAioKeywordTipInfo != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAioKeywordTipBar", 2, "mCheckKeywordRunnable, messageRecord == null || keywordTipInfo == null");
    return;
    TroopAioKeywordTipBar.a(this.a.a.this$0, paramMessageRecord, paramTroopAioKeywordTipInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4.1.1
 * JD-Core Version:    0.7.0.1
 */