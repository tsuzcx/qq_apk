package com.tencent.mobileqq.troop.data;

import aggs;
import android.util.Pair;
import bfpj;
import bfpn;
import bfpp;
import bfpr;
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
  public TroopAioKeywordTipBar$4(bfpj parambfpj) {}
  
  public void run()
  {
    bfpj.b(this.this$0, false);
    if (!bfpj.c(this.this$0)) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "checkMsgForShow, mIsCanCheck = false");
      }
    }
    bfpr localbfpr;
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
          localbfpr = (bfpr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(225);
        } while ((i < 0) || (j < 0));
        localArrayList1 = new ArrayList(10);
        localArrayList2 = new ArrayList(10);
        if (i <= j)
        {
          localObject = (MessageRecord)this.this$0.jdField_a_of_type_Aggs.getItem(i);
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
      } while ((bfpj.b(this.this$0) != null) && (bfpj.b(this.this$0) == localArrayList2.get(0)));
      Object localObject = localbfpr.a(localArrayList2, bfpj.a(this.this$0), 1);
      if ((bfpj.a(this.this$0)) && ((((Pair)localObject).second == null) || ((bfpj.a(this.this$0) != null) && (bfpj.a(this.this$0).ruleId != ((Integer)((Pair)localObject).second).intValue())))) {
        bfpj.a(this.this$0, false);
      }
      for (;;)
      {
        localbfpr.a(localArrayList2, bfpj.a(this.this$0), 1, new bfpn(this, localArrayList1, localbfpr));
        return;
        bfpj.b(this.this$0, (MessageRecord)localArrayList2.get(0));
      }
    } while ((localArrayList1.size() <= 0) || (bfpj.a(this.this$0)));
    localbfpr.a(localArrayList1, null, 2, new bfpp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4
 * JD-Core Version:    0.7.0.1
 */