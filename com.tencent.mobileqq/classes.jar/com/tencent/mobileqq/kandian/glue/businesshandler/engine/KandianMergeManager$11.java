package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;

class KandianMergeManager$11
  implements Runnable
{
  KandianMergeManager$11(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    RIJKanDianFolderStatus.updateKandianFolderStatus(KandianMergeManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.11
 * JD-Core Version:    0.7.0.1
 */