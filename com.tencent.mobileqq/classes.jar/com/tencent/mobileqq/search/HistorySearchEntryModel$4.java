package com.tencent.mobileqq.search;

import android.os.Message;
import bbyf;
import blha;

public class HistorySearchEntryModel$4
  implements Runnable
{
  public HistorySearchEntryModel$4(bbyf parambbyf) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = bbyf.a(this.this$0);
    Message localMessage = this.this$0.jdField_a_of_type_Blha.obtainMessage();
    localMessage.what = 1;
    this.this$0.jdField_a_of_type_Blha.removeMessages(1);
    this.this$0.jdField_a_of_type_Blha.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */