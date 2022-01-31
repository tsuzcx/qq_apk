package com.tencent.mobileqq.search;

import android.os.Message;
import avhw;
import avhy;
import beez;
import com.tencent.mobileqq.data.SearchHistory;

public class HistorySearchEntryModel$2$1
  implements Runnable
{
  public HistorySearchEntryModel$2$1(avhy paramavhy, SearchHistory paramSearchHistory, long paramLong) {}
  
  public void run()
  {
    if (avhw.a(this.jdField_a_of_type_Avhy.a, this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory))
    {
      Message localMessage = this.jdField_a_of_type_Avhy.a.a.obtainMessage();
      localMessage.what = 3;
      localMessage.obj = new Long(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Avhy.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.2.1
 * JD-Core Version:    0.7.0.1
 */