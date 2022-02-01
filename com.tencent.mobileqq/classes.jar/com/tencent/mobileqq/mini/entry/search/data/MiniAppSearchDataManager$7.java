package com.tencent.mobileqq.mini.entry.search.data;

import java.util.List;

class MiniAppSearchDataManager$7
  implements Runnable
{
  MiniAppSearchDataManager$7(MiniAppSearchDataManager paramMiniAppSearchDataManager, List paramList) {}
  
  public void run()
  {
    if (this.val$resultList.isEmpty()) {
      return;
    }
    MiniAppSearchDataManager.access$900(this.this$0).clear();
    MiniAppSearchDataManager.access$900(this.this$0).addAll(this.val$resultList);
    if (MiniAppSearchDataManager.access$1000(this.this$0) != null) {
      MiniAppSearchDataManager.access$1000(this.this$0).onHotSearchDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.7
 * JD-Core Version:    0.7.0.1
 */