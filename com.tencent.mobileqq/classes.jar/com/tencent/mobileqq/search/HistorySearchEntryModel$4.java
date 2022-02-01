package com.tencent.mobileqq.search;

import android.os.Message;
import basa;
import bjmp;

public class HistorySearchEntryModel$4
  implements Runnable
{
  public HistorySearchEntryModel$4(basa parambasa) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = basa.a(this.this$0);
    Message localMessage = this.this$0.jdField_a_of_type_Bjmp.obtainMessage();
    localMessage.what = 1;
    this.this$0.jdField_a_of_type_Bjmp.removeMessages(1);
    this.this$0.jdField_a_of_type_Bjmp.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */