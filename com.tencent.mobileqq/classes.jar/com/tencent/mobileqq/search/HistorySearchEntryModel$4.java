package com.tencent.mobileqq.search;

import android.os.Message;
import bbyp;
import bkyc;

public class HistorySearchEntryModel$4
  implements Runnable
{
  public HistorySearchEntryModel$4(bbyp parambbyp) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = bbyp.a(this.this$0);
    Message localMessage = this.this$0.jdField_a_of_type_Bkyc.obtainMessage();
    localMessage.what = 1;
    this.this$0.jdField_a_of_type_Bkyc.removeMessages(1);
    this.this$0.jdField_a_of_type_Bkyc.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */