package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.qphone.base.util.QLog;

class KandianMergeManager$3
  implements Runnable
{
  KandianMergeManager$3(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    KandianMergeManager.a(this.this$0);
    QLog.d("KandianMergeManager", 1, "do method[someInitInSubThread] after syncMsg!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.3
 * JD-Core Version:    0.7.0.1
 */