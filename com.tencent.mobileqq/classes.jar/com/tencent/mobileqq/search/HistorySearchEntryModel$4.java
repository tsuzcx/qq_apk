package com.tencent.mobileqq.search;

import android.os.Message;
import aycv;
import bhoe;

public class HistorySearchEntryModel$4
  implements Runnable
{
  public HistorySearchEntryModel$4(aycv paramaycv) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = aycv.a(this.this$0);
    Message localMessage = this.this$0.jdField_a_of_type_Bhoe.obtainMessage();
    localMessage.what = 1;
    this.this$0.jdField_a_of_type_Bhoe.removeMessages(1);
    this.this$0.jdField_a_of_type_Bhoe.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */