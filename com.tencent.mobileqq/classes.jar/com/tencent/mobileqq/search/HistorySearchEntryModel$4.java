package com.tencent.mobileqq.search;

import android.os.Message;
import avhw;
import beez;

public class HistorySearchEntryModel$4
  implements Runnable
{
  public HistorySearchEntryModel$4(avhw paramavhw) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilList = avhw.a(this.this$0);
    Message localMessage = this.this$0.jdField_a_of_type_Beez.obtainMessage();
    localMessage.what = 1;
    this.this$0.jdField_a_of_type_Beez.removeMessages(1);
    this.this$0.jdField_a_of_type_Beez.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */