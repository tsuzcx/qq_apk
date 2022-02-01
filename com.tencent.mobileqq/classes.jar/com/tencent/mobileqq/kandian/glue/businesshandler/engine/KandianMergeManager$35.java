package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo;

class KandianMergeManager$35
  implements Runnable
{
  KandianMergeManager$35(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if ((KandianMergeManager.a(this.this$0) != null) && (this.this$0.h()))
    {
      KandianMergeManager.a(this.this$0, null);
      Kandian210Msg0xeeInfo.removeKandian210Msg0xeeInfoFromSp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.35
 * JD-Core Version:    0.7.0.1
 */