package com.tencent.mobileqq.troop.data;

import afqz;
import android.util.Pair;
import bffw;
import bfga;
import bfgc;
import bfge;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopAioKeywordTipBar$4
  implements Runnable
{
  public TroopAioKeywordTipBar$4(bffw parambffw) {}
  
  public void run()
  {
    bffw.b(this.this$0, false);
    if (!bffw.c(this.this$0)) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "checkMsgForShow, mIsCanCheck = false");
      }
    }
    bfge localbfge;
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
          localbfge = (bfge)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER);
        } while ((i < 0) || (j < 0));
        localArrayList1 = new ArrayList(10);
        localArrayList2 = new ArrayList(10);
        if (i <= j)
        {
          localObject = (MessageRecord)this.this$0.jdField_a_of_type_Afqz.getItem(i);
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
      } while ((bffw.b(this.this$0) != null) && (bffw.b(this.this$0) == localArrayList2.get(0)));
      Object localObject = localbfge.a(localArrayList2, bffw.a(this.this$0), 1);
      if ((bffw.a(this.this$0)) && ((((Pair)localObject).second == null) || ((bffw.a(this.this$0) != null) && (bffw.a(this.this$0).ruleId != ((Integer)((Pair)localObject).second).intValue())))) {
        bffw.a(this.this$0, false);
      }
      for (;;)
      {
        localbfge.a(localArrayList2, bffw.a(this.this$0), 1, new bfga(this, localArrayList1, localbfge));
        return;
        bffw.b(this.this$0, (MessageRecord)localArrayList2.get(0));
      }
    } while ((localArrayList1.size() <= 0) || (bffw.a(this.this$0)));
    localbfge.a(localArrayList1, null, 2, new bfgc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.4
 * JD-Core Version:    0.7.0.1
 */