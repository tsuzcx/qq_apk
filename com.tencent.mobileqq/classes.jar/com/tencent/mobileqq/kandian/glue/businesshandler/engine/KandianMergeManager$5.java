package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;

class KandianMergeManager$5
  implements Runnable
{
  KandianMergeManager$5(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    BaseApplicationImpl.getApplication().registerReceiver(this.this$0.a, new IntentFilter("com.tencent.readinjoy.kandianreport"));
    KandianMergeManager.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.5
 * JD-Core Version:    0.7.0.1
 */