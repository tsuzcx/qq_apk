package com.tencent.mobileqq.troop.data;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

class TroopAioKeywordTipManager$3
  implements Runnable
{
  TroopAioKeywordTipManager$3(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, List paramList1, List paramList2, int paramInt, TroopAioKeywordTipManager.Callback paramCallback) {}
  
  public void run()
  {
    Object localObject3 = this.this$0.a(this.a, this.b, this.c);
    Integer localInteger1 = (Integer)((Pair)localObject3).second;
    localObject3 = (MessageRecord)((Pair)localObject3).first;
    if (this.d != null) {
      ThreadManager.getUIHandler().post(new TroopAioKeywordTipManager.3.1(this, (MessageRecord)localObject3, localInteger1));
    }
    if (localInteger1 != null)
    {
      ??? = (TroopAioKeywordRuleInfo)this.this$0.d.get(localInteger1.intValue());
      ??? = this.this$0.d;
      if (??? == null) {}
      try
      {
        TroopAioKeywordTipManager.a(this.this$0, (MessageRecord)localObject3, null, this.d);
        return;
      }
      finally {}
    }
    for (;;)
    {
      synchronized (this.this$0.e)
      {
        TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)this.this$0.e.get(localInteger1.intValue());
        int j = 1;
        if (localTroopAioKeywordTipInfo != null)
        {
          if (localTroopAioKeywordTipInfo.version != ((TroopAioKeywordRuleInfo)???).f)
          {
            i = j;
          }
          else
          {
            TroopAioKeywordTipManager.a(this.this$0, (MessageRecord)localObject3, localTroopAioKeywordTipInfo, this.d);
            break label345;
          }
        }
        else
        {
          ??? = TroopAioKeywordHelper.a(this.this$0.a, String.valueOf(localInteger1));
          i = j;
          if (??? != null) {
            if (((TroopAioKeywordRuleInfo)???).f != ((TroopAioKeywordTipInfo)???).version)
            {
              i = j;
            }
            else
            {
              TroopAioKeywordTipManager.a(this.this$0, (MessageRecord)localObject3, (TroopAioKeywordTipInfo)???, this.d);
              synchronized (this.this$0.e)
              {
                this.this$0.e.put(((TroopAioKeywordTipInfo)???).ruleId, ???);
              }
            }
          }
        }
        if (i == 0) {
          break label344;
        }
        TroopAioKeywordTipManager.a(this.this$0, localInteger2, (MessageRecord)localObject3, this.d);
        return;
      }
      TroopAioKeywordTipManager.a(this.this$0, null, null, this.d);
      label344:
      return;
      label345:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.3
 * JD-Core Version:    0.7.0.1
 */