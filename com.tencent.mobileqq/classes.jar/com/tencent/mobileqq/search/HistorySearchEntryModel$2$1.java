package com.tencent.mobileqq.search;

import android.os.Message;
import bbyf;
import bbyh;
import blha;
import com.tencent.mobileqq.data.SearchHistory;

public class HistorySearchEntryModel$2$1
  implements Runnable
{
  public HistorySearchEntryModel$2$1(bbyh parambbyh, SearchHistory paramSearchHistory, long paramLong) {}
  
  public void run()
  {
    if (bbyf.a(this.jdField_a_of_type_Bbyh.a, this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory))
    {
      Message localMessage = this.jdField_a_of_type_Bbyh.a.a.obtainMessage();
      localMessage.what = 3;
      localMessage.obj = new Long(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Bbyh.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.2.1
 * JD-Core Version:    0.7.0.1
 */