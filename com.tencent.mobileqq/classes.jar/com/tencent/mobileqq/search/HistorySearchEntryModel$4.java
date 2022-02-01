package com.tencent.mobileqq.search;

import android.os.Message;
import com.tencent.util.MqqWeakReferenceHandler;

class HistorySearchEntryModel$4
  implements Runnable
{
  HistorySearchEntryModel$4(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((HistorySearchEntryModel)localObject).jdField_a_of_type_JavaUtilList = HistorySearchEntryModel.a((HistorySearchEntryModel)localObject);
    localObject = this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage();
    ((Message)localObject).what = 1;
    this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
    this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */