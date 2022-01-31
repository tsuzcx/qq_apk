package com.tencent.mobileqq.mini.entry.search.data;

import java.util.List;

class MiniAppSearchDataManager$5
  implements Runnable
{
  MiniAppSearchDataManager$5(MiniAppSearchDataManager paramMiniAppSearchDataManager, List paramList) {}
  
  public void run()
  {
    MiniAppSearchDataManager.access$900(this.this$0).clear();
    MiniAppSearchDataManager.access$900(this.this$0).addAll(this.val$searchInfoList);
    if (MiniAppSearchDataManager.access$1000(this.this$0) != null) {
      MiniAppSearchDataManager.access$1000(this.this$0).onResultDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.5
 * JD-Core Version:    0.7.0.1
 */