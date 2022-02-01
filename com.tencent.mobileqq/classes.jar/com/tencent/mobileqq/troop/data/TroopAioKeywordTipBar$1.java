package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class TroopAioKeywordTipBar$1
  extends MessageObserver
{
  TroopAioKeywordTipBar$1(TroopAioKeywordTipBar paramTroopAioKeywordTipBar) {}
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (TroopAioKeywordTipBar.a(this.a))
    {
      if (TroopAioKeywordTipBar.b(this.a) == null) {
        return;
      }
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipBar", 2, "msgList == null is true");
        }
        return;
      }
      int j = 0;
      paramList = paramList.iterator();
      do
      {
        i = j;
        if (!paramList.hasNext()) {
          break;
        }
      } while (((MessageRecord)paramList.next()).uniseq != TroopAioKeywordTipBar.b(this.a).uniseq);
      int i = 1;
      if (i != 0) {
        ThreadManager.getUIHandler().post(new TroopAioKeywordTipBar.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar.1
 * JD-Core Version:    0.7.0.1
 */