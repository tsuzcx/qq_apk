package com.tencent.mobileqq.troop.data;

import beqn;
import com.tencent.mobileqq.data.MessageRecord;

class TroopAioKeywordTipManager$3$1
  implements Runnable
{
  TroopAioKeywordTipManager$3$1(TroopAioKeywordTipManager.3 param3, MessageRecord paramMessageRecord, Integer paramInteger) {}
  
  public void run()
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioKeywordTipManager$3.a.a(str, this.jdField_a_of_type_JavaLangInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.3.1
 * JD-Core Version:    0.7.0.1
 */