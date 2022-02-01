package com.tencent.mobileqq.mini.entry.search.data;

import java.util.List;

class MiniAppSearchDataManager$8
  implements Runnable
{
  MiniAppSearchDataManager$8(MiniAppSearchDataManager paramMiniAppSearchDataManager, List paramList) {}
  
  public void run()
  {
    MiniAppSearchDataManager.access$1100(this.this$0).addAll(this.val$searchInfoList);
    if (MiniAppSearchDataManager.access$1200(this.this$0) != null) {
      MiniAppSearchDataManager.access$1200(this.this$0).onResultDataChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.8
 * JD-Core Version:    0.7.0.1
 */