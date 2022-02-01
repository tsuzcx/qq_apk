package com.tencent.mobileqq.search;

import android.os.Message;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.util.MqqWeakReferenceHandler;

class HistorySearchEntryModel$2$1
  implements Runnable
{
  HistorySearchEntryModel$2$1(HistorySearchEntryModel.2 param2, SearchHistory paramSearchHistory, long paramLong) {}
  
  public void run()
  {
    if (HistorySearchEntryModel.a(this.c.a, this.a))
    {
      Message localMessage = this.c.a.f.obtainMessage();
      localMessage.what = 3;
      localMessage.obj = new Long(this.b);
      this.c.a.f.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.2.1
 * JD-Core Version:    0.7.0.1
 */