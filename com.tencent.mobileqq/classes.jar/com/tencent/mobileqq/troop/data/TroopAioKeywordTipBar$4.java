package com.tencent.mobileqq.troop.data;

import acup;
import android.util.Pair;
import azmw;
import azna;
import aznc;
import azne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopAioKeywordTipBar$4
  implements Runnable
{
  public TroopAioKeywordTipBar$4(azmw paramazmw) {}
  
  public void run()
  {
    azmw.b(this.this$0, false);
    if (!azmw.c(this.this$0)) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "checkMsgForShow, mIsCanCheck = false");
      }
    }
    azne localazne;
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
          localazne = (azne)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(225);
        } while ((i < 0) || (j < 0));
        localArrayList1 = new ArrayList(10);
        localArrayList2 = new ArrayList(10);
        if (i <= j)
        {
          localObject = (MessageRecord)this.this$0.jdField_a_of_type_Acup.getItem(i);
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
      } while ((azmw.b(this.this$0) != null) && (azmw.b(this.this$0) == localArrayList2.get(0)));
      Object localObject = localazne.a(localArrayList2, azmw.a(this.this$0), 1);
      if ((azmw.a(this.this$0)) && ((((Pair)localObject).second == null) || ((azmw.a(this.this$0) != null) && (azmw.a(this.this$0).ruleId != ((Integer)((Pair)localObject).second).intValue())))) {
        azmw.a(this.this$0, false);
      }
      for (;;)
      {
        localazne.a(localArrayList2, azmw.a(this.this$0), 1, new azna(this, localArrayList1, localazne));
        return;
        azmw.b(this.this$0, (MessageRecord)localArrayList2.get(0));
      }
    } while ((localArrayList1.size() <= 0) || (azmw.a(this.this$0)));
    localazne.a(localArrayList1, null, 2, new aznc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4
 * JD-Core Version:    0.7.0.1
 */