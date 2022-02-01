package com.tencent.mobileqq.troop.data;

import android.util.SparseArray;
import com.tencent.mobileqq.app.TroopHandler.KeywordTipInfoObserver;
import java.util.Iterator;
import java.util.List;

class TroopAioKeywordTipManager$2$1
  extends TroopHandler.KeywordTipInfoObserver
{
  TroopAioKeywordTipManager$2$1(TroopAioKeywordTipManager.2 param2) {}
  
  public void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    SparseArray localSparseArray;
    if (paramBoolean)
    {
      localSparseArray = this.a.this$0.b;
      if (paramList != null) {
        try
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)paramList.next();
            this.a.this$0.b.put(localTroopAioKeywordTipInfo.ruleId, localTroopAioKeywordTipInfo);
          }
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2.1
 * JD-Core Version:    0.7.0.1
 */