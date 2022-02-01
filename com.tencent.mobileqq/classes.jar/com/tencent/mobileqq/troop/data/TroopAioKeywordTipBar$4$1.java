package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

class TroopAioKeywordTipBar$4$1
  extends TroopAioKeywordTipManager.Callback
{
  TroopAioKeywordTipBar$4$1(TroopAioKeywordTipBar.4 param4, List paramList, TroopAioKeywordTipManager paramTroopAioKeywordTipManager) {}
  
  public void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo)
  {
    if (!this.c.this$0.M) {
      return;
    }
    if ((paramMessageRecord != null) && (paramTroopAioKeywordTipInfo != null))
    {
      TroopAioKeywordTipBar.a(this.c.this$0, paramMessageRecord, paramTroopAioKeywordTipInfo);
      return;
    }
    if ((this.a.size() > 0) && (!TroopAioKeywordTipBar.a(this.c.this$0))) {
      this.b.a(this.a, null, 2, new TroopAioKeywordTipBar.4.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4.1
 * JD-Core Version:    0.7.0.1
 */