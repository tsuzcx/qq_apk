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
    ((HistorySearchEntryModel)localObject).e = HistorySearchEntryModel.b((HistorySearchEntryModel)localObject);
    localObject = this.this$0.f.obtainMessage();
    ((Message)localObject).what = 1;
    this.this$0.f.removeMessages(1);
    this.this$0.f.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */