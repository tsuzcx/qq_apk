package com.tencent.mobileqq.troop.data;

import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.observer.KeywordTipInfoObserver;
import java.util.List;

class TroopAioKeywordTipManager$4
  extends KeywordTipInfoObserver
{
  TroopAioKeywordTipManager$4(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, MessageRecord paramMessageRecord, TroopAioKeywordTipManager.Callback paramCallback) {}
  
  public void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        TroopAioKeywordTipManager.a(this.c, this.a, (TroopAioKeywordTipInfo)paramList.get(0), this.b);
        synchronized (this.c.e)
        {
          this.c.e.put(((TroopAioKeywordTipInfo)paramList.get(0)).ruleId, paramList.get(0));
          ThreadManager.post(new TroopAioKeywordTipManager.4.1(this, paramList), 2, null, true);
          return;
        }
      }
      TroopAioKeywordTipManager.a(this.c, this.a, null, this.b);
      return;
    }
    TroopAioKeywordTipManager.a(this.c, this.a, null, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.4
 * JD-Core Version:    0.7.0.1
 */