package com.tencent.mobileqq.search;

import android.os.Message;
import ayhe;
import bhsl;

public class HistorySearchEntryModel$4
  implements Runnable
{
  public HistorySearchEntryModel$4(ayhe paramayhe) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = ayhe.a(this.this$0);
    Message localMessage = this.this$0.jdField_a_of_type_Bhsl.obtainMessage();
    localMessage.what = 1;
    this.this$0.jdField_a_of_type_Bhsl.removeMessages(1);
    this.this$0.jdField_a_of_type_Bhsl.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */