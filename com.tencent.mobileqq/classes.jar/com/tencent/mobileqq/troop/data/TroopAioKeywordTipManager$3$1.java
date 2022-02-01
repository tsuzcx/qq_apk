package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.MessageRecord;

class TroopAioKeywordTipManager$3$1
  implements Runnable
{
  TroopAioKeywordTipManager$3$1(TroopAioKeywordTipManager.3 param3, MessageRecord paramMessageRecord, Integer paramInteger) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((MessageRecord)localObject).getExtInfoFromExtStr("key_aio_keyword");
    } else {
      localObject = null;
    }
    this.c.d.a((String)localObject, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.3.1
 * JD-Core Version:    0.7.0.1
 */