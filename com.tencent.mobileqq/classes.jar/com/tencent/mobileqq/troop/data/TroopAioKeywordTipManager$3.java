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
    Object localObject3 = this.this$0.a(this.jdField_a_of_type_JavaUtilList, this.b, this.jdField_a_of_type_Int);
    Integer localInteger1 = (Integer)((Pair)localObject3).second;
    localObject3 = (MessageRecord)((Pair)localObject3).first;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback != null) {
      ThreadManager.getUIHandler().post(new TroopAioKeywordTipManager.3.1(this, (MessageRecord)localObject3, localInteger1));
    }
    if (localInteger1 != null)
    {
      ??? = (TroopAioKeywordRuleInfo)this.this$0.jdField_a_of_type_AndroidUtilSparseArray.get(localInteger1.intValue());
      ??? = this.this$0.jdField_a_of_type_AndroidUtilSparseArray;
      if (??? == null) {}
      try
      {
        TroopAioKeywordTipManager.a(this.this$0, (MessageRecord)localObject3, null, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback);
        return;
      }
      finally {}
    }
    for (;;)
    {
      synchronized (this.this$0.b)
      {
        TroopAioKeywordTipInfo localTroopAioKeywordTipInfo = (TroopAioKeywordTipInfo)this.this$0.b.get(localInteger1.intValue());
        int j = 1;
        if (localTroopAioKeywordTipInfo != null)
        {
          if (localTroopAioKeywordTipInfo.version != ((TroopAioKeywordRuleInfo)???).e)
          {
            i = j;
          }
          else
          {
            TroopAioKeywordTipManager.a(this.this$0, (MessageRecord)localObject3, localTroopAioKeywordTipInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback);
            break label345;
          }
        }
        else
        {
          ??? = TroopAioKeywordHelper.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localInteger1));
          i = j;
          if (??? != null) {
            if (((TroopAioKeywordRuleInfo)???).e != ((TroopAioKeywordTipInfo)???).version)
            {
              i = j;
            }
            else
            {
              TroopAioKeywordTipManager.a(this.this$0, (MessageRecord)localObject3, (TroopAioKeywordTipInfo)???, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback);
              synchronized (this.this$0.b)
              {
                this.this$0.b.put(((TroopAioKeywordTipInfo)???).ruleId, ???);
              }
            }
          }
        }
        if (i == 0) {
          break label344;
        }
        TroopAioKeywordTipManager.a(this.this$0, localInteger2, (MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback);
        return;
      }
      TroopAioKeywordTipManager.a(this.this$0, null, null, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$Callback);
      label344:
      return;
      label345:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.3
 * JD-Core Version:    0.7.0.1
 */