package com.tencent.mobileqq.troop.data;

import android.util.Pair;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class TroopAioKeywordTipBar$4
  implements Runnable
{
  TroopAioKeywordTipBar$4(TroopAioKeywordTipBar paramTroopAioKeywordTipBar) {}
  
  public void run()
  {
    TroopAioKeywordTipBar.c(this.this$0, false);
    if (!TroopAioKeywordTipBar.h(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "checkMsgForShow, mIsCanCheck = false");
      }
      return;
    }
    int i = this.this$0.J.getFirstVisiblePosition() - this.this$0.J.getHeaderViewsCount();
    int j = this.this$0.J.getLastVisiblePosition() - this.this$0.J.getHeaderViewsCount();
    TroopAioKeywordTipManager localTroopAioKeywordTipManager = (TroopAioKeywordTipManager)this.this$0.D.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER);
    if (i >= 0)
    {
      if (j < 0) {
        return;
      }
      ArrayList localArrayList1 = new ArrayList(10);
      ArrayList localArrayList2 = new ArrayList(10);
      Object localObject;
      while (i <= j)
      {
        localObject = (MessageRecord)this.this$0.I.getItem(i);
        if (localObject != null) {
          if (!((MessageRecord)localObject).isSend()) {
            localArrayList1.add(localObject);
          } else if (((MessageRecord)localObject).time > NetConnInfoCenter.getServerTime() - 5L) {
            localArrayList2.add(0, localObject);
          }
        }
        i += 1;
      }
      if (localArrayList2.size() > 0)
      {
        if ((TroopAioKeywordTipBar.i(this.this$0) != null) && (TroopAioKeywordTipBar.i(this.this$0) == localArrayList2.get(0))) {
          return;
        }
        localObject = localTroopAioKeywordTipManager.a(localArrayList2, TroopAioKeywordTipBar.j(this.this$0), 1);
        if ((TroopAioKeywordTipBar.a(this.this$0)) && ((((Pair)localObject).second == null) || ((TroopAioKeywordTipBar.e(this.this$0) != null) && (TroopAioKeywordTipBar.e(this.this$0).ruleId != ((Integer)((Pair)localObject).second).intValue())))) {
          TroopAioKeywordTipBar.a(this.this$0, false);
        } else {
          TroopAioKeywordTipBar.b(this.this$0, (MessageRecord)localArrayList2.get(0));
        }
        localTroopAioKeywordTipManager.a(localArrayList2, TroopAioKeywordTipBar.j(this.this$0), 1, new TroopAioKeywordTipBar.4.1(this, localArrayList1, localTroopAioKeywordTipManager));
        return;
      }
      if ((localArrayList1.size() > 0) && (!TroopAioKeywordTipBar.a(this.this$0))) {
        localTroopAioKeywordTipManager.a(localArrayList1, null, 2, new TroopAioKeywordTipBar.4.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4
 * JD-Core Version:    0.7.0.1
 */