package com.tencent.mobileqq.search;

import android.os.Message;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.util.MqqWeakReferenceHandler;

class HistorySearchEntryModel$2$1
  implements Runnable
{
  HistorySearchEntryModel$2$1(HistorySearchEntryModel.2 param2, SearchHistory paramSearchHistory, long paramLong) {}
  
  public void run()
  {
    if (HistorySearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchHistorySearchEntryModel$2.a, this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory))
    {
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqSearchHistorySearchEntryModel$2.a.a.obtainMessage();
      localMessage.what = 3;
      localMessage.obj = new Long(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqSearchHistorySearchEntryModel$2.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.2.1
 * JD-Core Version:    0.7.0.1
 */