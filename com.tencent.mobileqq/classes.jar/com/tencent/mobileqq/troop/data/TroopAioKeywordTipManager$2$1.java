package com.tencent.mobileqq.troop.data;

import android.util.SparseArray;
import com.tencent.mobileqq.troop.observer.KeywordTipInfoObserver;
import java.util.Iterator;
import java.util.List;

class TroopAioKeywordTipManager$2$1
  extends KeywordTipInfoObserver
{
  TroopAioKeywordTipManager$2$1(TroopAioKeywordTipManager.2 param2) {}
  
  public void a(boolean paramBoolean, List<TroopAioKeywordTipInfo> paramList)
  {
    if (paramBoolean)
    {
      SparseArray localSparseArray = this.a.this$0.e;
      if (paramList != null) {}
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)paramList.next();
          this.a.this$0.e.put(localTroopAioKeywordTipInfo.ruleId, localTroopAioKeywordTipInfo);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2.1
 * JD-Core Version:    0.7.0.1
 */