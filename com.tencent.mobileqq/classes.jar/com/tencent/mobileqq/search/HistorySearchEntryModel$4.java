package com.tencent.mobileqq.search;

import android.os.Message;
import com.tencent.util.MqqWeakReferenceHandler;

class HistorySearchEntryModel$4
  implements Runnable
{
  HistorySearchEntryModel$4(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = HistorySearchEntryModel.a(this.this$0);
    Message localMessage = this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage();
    localMessage.what = 1;
    this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
    this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */