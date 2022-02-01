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
    TroopAioKeywordTipBar.b(this.this$0, false);
    if (!TroopAioKeywordTipBar.c(this.this$0)) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "checkMsgForShow, mIsCanCheck = false");
      }
    }
    TroopAioKeywordTipManager localTroopAioKeywordTipManager;
    ArrayList localArrayList1;
    do
    {
      ArrayList localArrayList2;
      do
      {
        int i;
        int j;
        do
        {
          return;
          i = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition() - this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          j = this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() - this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          localTroopAioKeywordTipManager = (TroopAioKeywordTipManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER);
        } while ((i < 0) || (j < 0));
        localArrayList1 = new ArrayList(10);
        localArrayList2 = new ArrayList(10);
        if (i <= j)
        {
          localObject = (MessageRecord)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i);
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            if (!((MessageRecord)localObject).isSend()) {
              localArrayList1.add(localObject);
            } else if (((MessageRecord)localObject).time > NetConnInfoCenter.getServerTime() - 5L) {
              localArrayList2.add(0, localObject);
            }
          }
        }
        if (localArrayList2.size() <= 0) {
          break;
        }
      } while ((TroopAioKeywordTipBar.b(this.this$0) != null) && (TroopAioKeywordTipBar.b(this.this$0) == localArrayList2.get(0)));
      Object localObject = localTroopAioKeywordTipManager.a(localArrayList2, TroopAioKeywordTipBar.a(this.this$0), 1);
      if ((TroopAioKeywordTipBar.a(this.this$0)) && ((((Pair)localObject).second == null) || ((TroopAioKeywordTipBar.a(this.this$0) != null) && (TroopAioKeywordTipBar.a(this.this$0).ruleId != ((Integer)((Pair)localObject).second).intValue())))) {
        TroopAioKeywordTipBar.a(this.this$0, false);
      }
      for (;;)
      {
        localTroopAioKeywordTipManager.a(localArrayList2, TroopAioKeywordTipBar.a(this.this$0), 1, new TroopAioKeywordTipBar.4.1(this, localArrayList1, localTroopAioKeywordTipManager));
        return;
        TroopAioKeywordTipBar.b(this.this$0, (MessageRecord)localArrayList2.get(0));
      }
    } while ((localArrayList1.size() <= 0) || (TroopAioKeywordTipBar.a(this.this$0)));
    localTroopAioKeywordTipManager.a(localArrayList1, null, 2, new TroopAioKeywordTipBar.4.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4
 * JD-Core Version:    0.7.0.1
 */